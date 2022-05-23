const DateTime = luxon.DateTime;

let deleteIcon = function (cell, formatterParams) {
    return "<i class='fas fa-trash'></i>";
}

let dateEditor = function (cell, onRendered, success, cancel) {
    let cellValue = luxon.DateTime.fromFormat(cell.getValue(), "yyyy-MM-dd").toFormat("yyyy-MM-dd"),
        input = document.createElement("input");

    input.setAttribute("type", "date");

    input.style.padding = "4px";
    input.style.width = "100%";
    input.style.boxSizing = "border-box";

    input.value = cellValue;

    onRendered(function () {
        input.focus();
        input.style.height = "100%";
    });

    function onChange() {
        if (input.value !== cellValue) {
            success(luxon.DateTime.fromFormat(input.value, "yyyy-MM-dd").toFormat("yyyy-MM-dd"));
        } else {
            cancel();
        }
    }

    input.addEventListener("blur", onChange);

    input.addEventListener("keydown", function (e) {
        if (KeyboardEvent.code === 13) {
            onChange();
        }
        if (KeyboardEvent.code === 27) {
            cancel();
        }
    });

    return input;
}

let $overviewTable1 = new Tabulator("#overviewTable1", {
    data: [{
        year: 2022,
        appraisalNumber: "(예시. K220122)",
        judgePanel: "(예시. 민사5단독)",
        judgeTel: "(숫자만 입력하세요.)",
        judgeFax: "(숫자만 입력하세요.)"
    }],
    layout: "fitColumns",
    height: "100%",
    columns: [
        {
            title: "감정연도", field: "year", width: 100, validator: "required", editor: "autocomplete", editorParams: {
                values: yearOptions,
                sortValuesList: "desc",
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }
        },
        {title: "감정번호", field: "appraisalNumber", width: 150, validator: "required", editor: "input"},
        {
            title: "수소법원", field: "courtCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: courtOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: courtOptions
        },
        {title: "재판부", field: "judgePanel", editor: "input"},
        {title: "전화번호", field: "judgeTel", editor: "input", validator: "numeric"},
        {title: "팩스번호", field: "judgeFax", editor: "input", validator: "numeric"}
    ],
});

let $overviewTable2 = new Tabulator("#overviewTable2", {
    data: [{caseType: "(예시. 2022가합)", caseNumber: "(예시. 123456)"}],
    layout: "fitColumns",
    height: "100%",
    columns: [
        {
            title: "사건번호", width: 300,
            columns: [
                {title: "구분", field: "caseType", editor: "input"},
                {title: "번호", field: "caseNumber", editor: "input", validator: "numeric"}
            ]
        },
        {
            title: "감정구분", field: "appraisalCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: appraisalCategoryOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: appraisalCategoryOptions
        },
        {title: "사건명", field: "name", editor: "input"},
        {title: "감정목적물", field: "objectAddress", widthGrow: 2, editor: "input"},
        {title: "감정목적물 비고", field: "objectRemarks", widthGrow: 2, editor: "input"}
    ]
});

let $partiesTable = new Tabulator("#partiesTable", {
    data: [{partiesCategoryId: 56}, {partiesCategoryId: 57}],
    layout: "fitColumns",
    height: "100%",
    columns: [
        {
            title: "구분", field: "partiesCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: partiesOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: partiesOptions
        },
        {title: "이름", field: "partiesName", validator: "required", editor: "input"},
        {title: "연락처", field: "partiesTel", editor: "input", validator: "numeric"},
        {title: "소속 기관", field: "affiliation", editor: "input"},
        {title: "소속 기관 연락처", field: "affiliationTel", editor: "input", validator: "numeric"},
        {
            formatter: deleteIcon, width: 40, hozAlign: "center", cellClick: function (e, cell) {
                cell.getRow().delete()
            }
        }
    ]
});

let $feeTable = new Tabulator("#feeTable", {
    data: [{feePartiesCategoryId: 56, feeDate: DateTime.now().toISODate()},
        {feePartiesCategoryId: 57, feeDate: DateTime.now().toISODate()}],
    layout: "fitColumns",
    height: "100%",
    groupBy: "feePartiesCategoryId",
    groupHeader: function (value, count, data, group) {
        return partiesOptions[value];
    },
    groupUpdateOnCellEdit: true,
    columns: [
        {
            title: "당사자", field: "feePartiesCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: partiesOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: partiesOptions
        },
        {
            title: "구분", field: "feeCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: feeOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: feeOptions
        },
        {title: "날짜", field: "feeDate", sorter: "date", editor: dateEditor},
        {
            title: "금액", field: "feeAmount", editor: "number", formatter: "money", formatterParams: {
                symbol: "₩",
                precision: false
            }, bottomCalc: "sum", bottomCalcFormatter: "money", bottomCalcFormatterParams: {
                symbol: "₩",
                precision: false
            }
        },
        {
            formatter: deleteIcon, width: 40, hozAlign: "center", cellClick: function (e, cell) {
                cell.getRow().delete()
            }
        }
    ]
});

function addAppraisal() {
    let data = $overviewTable1.getData()[0];
    let data2 = $overviewTable2.getData()[0];
    for (let key in data2) {
        data[key] = data2[key];
    }
    data["status"] = "ENABLE";
    data["partiesList"] = $partiesTable.getData();
    data["appraisalFeeList"] = $feeTable.getData();

    $.ajax({
        url: "/appraisal/info",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            console.log("success");
        },
        error: function (request, status, error) {
            alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
        }
    })

}

function addPartiesRow() {
    $partiesTable.addRow({});
}

function addFeeRow() {
    $feeTable.addRow({feePartiesCategoryId: 56, feeDate: DateTime.now().toISODate()});
}
