let $appraisalListTable = $('#appraisalListTable');

$appraisalListTable.bootstrapTable({
    onClickRow: function (row, $element, field) {
        window.location.href = "/appraisal/info/" + row.id;
    }
})
