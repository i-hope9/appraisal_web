let deleteIcon = function (cell, formatterParams) {
    return "<i class='fas fa-trash'></i>";
}

const DATA_TYPE = {
    INSERT: "insert",
    UPDATE: "update"
}
let tempCell;

let $overviewTable1 = new Tabulator("#overviewTable1", {
    data: appraisal,
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
            title: "수소법원", field: "courtCategory.id", validator: "required", editor: "autocomplete", editorParams: {
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
    data: appraisal,
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
            title: "감정구분", field: "appraisalCategory.id", validator: "required", editor: "autocomplete", editorParams: {
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
    data: parties,
    layout: "fitColumns",
    height: "100%",
    columns: [
        {
            title: "구분", field: "partiesCategory.id", validator: "required", editor: "autocomplete", editorParams: {
                values: partiesOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: partiesOptions
        },
        {title: "이름", field: "name", validator: "required", editor: "input"},
        {title: "연락처", field: "tel", editor: "input", validator: "numeric"},
        {title: "소속 기관", field: "affiliation", editor: "input"},
        {title: "소속 기관 연락처", field: "affiliationTel", editor: "input", validator: "numeric"},
        {
            formatter: deleteIcon, width: 40, hozAlign: "center", cellClick: function (e, cell) {
                cell.getRow().delete()
            }
        }
    ]
});

let $progressTable = new Tabulator("#progressTable", {
    data: progresses,
    layout: "fitColumns",
    height: "100%",
    columns: [
        {
            title: "구분", field: "progressCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: progressOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: progressOptions
        },
        {title: "날짜", field: "progressDate", sorter: "date", mutator: dateMutator, editor: dateEditor},
        {title: "비고", field: "description", validator: "required", editor: "input"},
        {
            formatter: deleteIcon, width: 40, hozAlign: "center", cellClick: function (e, cell) {
                cell.getRow().delete()
            }
        }
    ]
});

let $feeTable = new Tabulator("#feeTable", {
    data: fees,
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
            title: "구분", field: "feeCategory.id", validator: "required", editor: "autocomplete", editorParams: {
                values: feeOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: feeOptions
        },
        {title: "날짜", field: "depositDate", sorter: "date", mutator: dateMutator, editor: dateEditor},
        {
            title: "금액", field: "amount", editor: "number", formatter: "money", formatterParams: {
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

let $feeProgressTable = new Tabulator("#feeProgressTable", {
    data: feeProgresses,
    layout: "fitColumns",
    height: "100%",
    //groupBy: "feePartiesCategoryId",
    // groupHeader: function (value, count, data, group) {
    //     return partiesOptions[value];
    // },
    // groupUpdateOnCellEdit: true,
    columns: [
        {
            title: "당사자", field: "feePartiesCategoryId", validator: "required", editor: "autocomplete", editorParams: {
                values: partiesOptions,
                showListOnEmpty: true,
                emptyPlaceholder: "(일치 정보 없음)"
            }, formatter: "lookup", formatterParams: partiesOptions
        },
        {title: "날짜", field: "depositDate", sorter: "date", mutator: dateMutator, editor: dateEditor},
        {
            title: "금액", field: "amount", editor: "number", formatter: "money", formatterParams: {
                symbol: "₩",
                precision: false
            }, bottomCalc: "sum", bottomCalcFormatter: "money", bottomCalcFormatterParams: {
                symbol: "₩",
                precision: false
            }
        },
        {
            title: "잔금", field: "remainder", editor: "number", formatter: "money", formatterParams: {
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

$overviewTable1.on("dataChanged", function (data) {
    updateAppraisal(data);
})

$overviewTable2.on("dataChanged", function (data) {
    updateAppraisal(data);
})

$partiesTable.on("rowAdded", function (row) {

})

$partiesTable.on("dataChanged", function (data) {
    console.log(data);
    // updateParties(data);
})

$partiesTable.on("cellEdited", function (cell) {
    console.log("$partiesTable cellEdited");
    console.log(cell);
    tempCell = cell;

})

$progressTable.on("dataChanged", function (data) {
    if (data[0]['flag'] === undefined)
        data[0]['flag'] = DATA_TYPE.UPDATE;
    updateProgress(data);
})

function updateAppraisal(data) {
    data = data[0];
    let id = data['id'];
    data['courtCategoryId'] = data['courtCategory']['id'];
    data['appraisalCategoryId'] = data['appraisalCategory']['id'];

    $.ajax({
        url: "/appraisal/" + id,
        type: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function (data) {
            console.log(data);
        },
        error: function (request, status, error) {
            alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
        }
    })
}

function updateParties(data) {
    data = data[0];
    let id = data['id'];
    data['partiesCategoryId'] = data['partiesCategory']['id'];

    $.ajax({
        url: "/appraisal/detail/parties/" + id,
        type: "PUT",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function (data) {
            console.log(data);
        },
        error: function (request, status, error) {
            alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
        }
    })
}

function updateProgress(data) {
    data = data[0];
    let flag = data['flag'];
    switch (flag) {
        case DATA_TYPE.INSERT:

            data['flag'] = DATA_TYPE.UPDATE;

    }
    // let id = data['id'] === undefined ? null : data['id'];
    console.log(flag);
    // data['partiesCategoryId'] = data['partiesCategory']['id'];
    //
    // $.ajax({
    //     url: "/appraisal/detail/parties/" + id,
    //     type: "PUT",
    //     data: JSON.stringify(data),
    //     contentType: "application/json",
    //     success: function (data) {
    //         console.log(data);
    //     },
    //     error: function (request, status, error) {
    //         alert("code: " + request.status + "\n" + "message: " + request.responseText + "\n" + "error: " + error);
    //     }
    // })
}

function addPartiesRow() {
    $partiesTable.addRow({});
}

function addFeeRow() {
    $feeTable.addRow({feePartiesCategoryId: 56, feeDate: DateTime.now().toISODate()});
}

function addProgressRow() {
    $progressTable.addRow({progressDate: DateTime.now().toISODate(), flag: DATA_TYPE.INSERT});
}

function addFeeProgressRow() {
    $feeProgressTable.addRow({feePartiesCategoryId: 56, depositDate: DateTime.now().toISODate()});
}
