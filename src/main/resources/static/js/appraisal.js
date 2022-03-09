let $partiesTable = $('#partiesTable')
let $feeTable = $('#feeTable');

function addParties() {
    let parties = {
        partiesCategory: $('#mPartiesCategory option:selected').val(),
        partiesCategoryText: $('#mPartiesCategory option:selected').text(),
        partiesName: $('#mPartiesName').val(),
        partiesTel: $('#mPartiesTel').val(),
        affiliation: $('#mAffiliation').val(),
        affiliationTel: $('#mAffiliationTel').val()
    };

    $partiesTable.bootstrapTable('append', parties);
    $('#partiesModal').modal('hide');
}

function addFee() {
    let fee = {
        feePartiesCategory: $('#mFeePartiesCategory option:selected').val(),
        feePartiesText: $('#mFeePartiesCategory option:selected').text(),
        feeCategory: $('#mFeeCategory option:selected').val(),
        feeCategoryText: $('#mFeeCategory option:selected').text(),
        feeDate: $('#mFeeDate').val(),
        feeAmount: $('#mFeeAmount').val()
    };

    $feeTable.bootstrapTable('append', fee);
    $('#feeModal').modal('hide');
}

