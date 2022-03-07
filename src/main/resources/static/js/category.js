let $categoryTable = $('#categoryTable');
let $categoryItemTable = $('#categoryItemTable');

function addCategory() {
    let data = {
        name: $('#categoryName').val(),
        description: $('#categoryDescription').val(),
        status: 'ENABLE'
    }

    $.ajax({
        url: "/admin/category",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $('#categoryModal').modal('hide');
            $('#categoryTable').bootstrapTable('refresh');
        }
    })
}

function addCategoryItem() {
    let categoryId = $('#categoryIdForItem').val();
    let data = {
        categoryId: categoryId,
        name: $('#categoryItemName').val(),
        description: $('#categoryItemDescription').val(),
        status: 'ENABLE',
    }

    $.ajax({
        url: "/admin/category/" + categoryId + "/item",
        type: "POST",
        data: JSON.stringify(data),
        contentType: "application/json",
        success: function () {
            $('#categoryItemModal').modal('hide');
            let categoryItems = getCategoryItems(categoryId);
            $categoryItemTable.bootstrapTable('load', categoryItems);
        }
    })
}

function getCategoryItems(categoryId) {
    let items;
    $.ajax({
        url: "/admin/category/" + categoryId + "/items",
        type: "GET",
        contentType: "application/json",
        async: false,
        success: function (fragment) {
            items = fragment;
        },
        error: function (e) {
            alert("잠시 후 재시도하십시오.");
        }
    })
    console.log(items);
    return items;
}

function statusFormatter(value) {
    let icon = value === 'ENABLE' ? 'fa-circle-check' : 'fa-circle-minus';
    let color = value === 'ENABLE' ? 'text-success' : 'text-secondary';
    let text = value === 'ENABLE' ? '사용' : '미사용';
    return '<i class="fa ' + icon + ' ' + color + '"></i>';
}

$categoryTable.bootstrapTable({
    onClickRow: function (row, $element, field) {
        $('#categoryNameForItem').text(row.name);
        $('#categoryIdForItem').val(row.id);
        let items = getCategoryItems(row.id);
        $categoryItemTable.bootstrapTable('load', items);
        $('#categoryItemDiv').removeClass('d-none').show();
    }
})
