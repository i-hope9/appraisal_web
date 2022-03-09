let $partiesTable = $('#partiesTable')
let $feeTable = $('#feeTable');

function addAppraisal() {
    let data = {
        year: $('#year option:selected').val(),
        appraisalNumber: $('#appraisalNumber').val(),
        courtCategoryId: $('#courtCategoryId option:selected').val(),
        judgePanel: $('#judgePanel').val(),
        judgeTel: $('#judgeTel').val(),
        judgeFax: $('#judgeFax').val(),
        caseType: $('#caseType').val(),
        caseNumber: $('#caseNumber').val(),
        appraisalCategoryId: $('#appraisalCategoryId option:selected').val(),
        name: $('#name').val(),
        objectAddress: $('#objectAddress').val(),
        objectRemarks: $('#objectRemarks').val(),
        status: 'ENABLE'
    }

    data["partiesList"] = $partiesTable.bootstrapTable('getData');
    data["appraisalFeeList"] = $feeTable.bootstrapTable('getData');

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

function addParties() {
    let $partiesModal = $('#partiesModal');
    let parties = {
        partiesCategoryId: $('#mPartiesCategory option:selected').val(),
        partiesCategoryText: $('#mPartiesCategory option:selected').text(),
        partiesName: $('#mPartiesName').val(),
        partiesTel: $('#mPartiesTel').val(),
        affiliation: $('#mAffiliation').val(),
        affiliationTel: $('#mAffiliationTel').val()
    };

    $partiesTable.bootstrapTable('append', parties);
    $partiesModal.modal('hide');
    $partiesModal.children().find('input, select').each(function () {
        $(this).is('input') ? $(this).val('') : this.selectedIndex = 0;
    })

}

function addFee() {
    let $feeModal = $('#feeModal');
    let fee = {
        feePartiesCategoryId: $('#mFeePartiesCategory option:selected').val(),
        feePartiesCategoryText: $('#mFeePartiesCategory option:selected').text(),
        feeCategoryId: $('#mFeeCategory option:selected').val(),
        feeCategoryText: $('#mFeeCategory option:selected').text(),
        feeDate: $('#mFeeDate').val(),
        feeAmount: $('#mFeeAmount').val()
    };

    $feeTable.bootstrapTable('append', fee);
    $feeModal.modal('hide');
    $feeModal.children().find('input, select').each(function () {
        $(this).is('input') ? $(this).val('') : this.selectedIndex = 0;
    })
}

