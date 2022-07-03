let $appraisalListTable = new Tabulator("#appraisalListTable", {
    pagination: true,
    paginationMode: "remote", //enable remote pagination
    ajaxURL: "/appraisal/all", //set url for ajax request
    paginationSize: 10,
    dataReceiveParams: {
        "last_page": "totalPage", //change last_page parameter name to "max_pages"
    },
    layout: "fitColumns",
    height: "100%",
    columns: [
        {title: "감정 번호", field: "appraisalNumber"},
        {title: "수소 법원", field: "courtCategory.name"},
        {title: "재판부", field: "judgePanel"},
        {title: "사건 번호", field: "caseNumber"},
        {title: "사건명", field: "name"},
        {title: "감정 구분", field: "appraisalCategory.name"},
        {title: "감정 목적물", field: "objectAddress"},

    ],
});

$appraisalListTable.on("rowClick", function (e, row) {
    let data = row.getData();
    window.location.href = "/appraisal/" + data.id;
});

