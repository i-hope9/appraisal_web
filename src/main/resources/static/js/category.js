let $categoryTable = new Tabulator('#categoryTable', {
    ajaxURL: "/admin/category/all",
    placeholder: "등록된 카테고리가 없습니다.",
    layout: "fitColumns",
    columns: [
        {title: "고유 번호", field: "id", sorter: "number", width: 100},
        {title: "카테고리 이름", field: "name", sorter: "string"},
        {title: "설명", field: "description", widthGrow: 4},
        {
            title: "사용 여부",
            field: "status",
            hozAlign: "center",
            width: 100,
            formatter: function (cell, formatterParams, onRendered) {
                let value = cell.getValue();
                let icon = value === 'ENABLE' ? 'fa-circle-check' : 'fa-circle-minus';
                let color = value === 'ENABLE' ? 'text-success' : 'text-secondary';
                return '<i class="fa ' + icon + ' ' + color + '"></i>';
            }
        }
    ]
});

let $categoryItemTable = new Tabulator('#categoryItemTable', {
    placeholder: "등록된 카테고리 항목이 없습니다.",
    layout: "fitColumns",
    pagination: "local",
    paginationSize: 10,
    columns: [
        {title: "고유 번호", field: "id", sorter: "number", width: 100},
        {title: "항목 이름", field: "name", sorter: "string"},
        {title: "설명", field: "description", widthGrow: 4},
        {
            title: "사용 여부",
            field: "status",
            hozAlign: "center",
            width: 100,
            formatter: function (cell, formatterParams, onRendered) {
                let value = cell.getValue();
                let icon = value === 'ENABLE' ? 'fa-circle-check' : 'fa-circle-minus';
                let color = value === 'ENABLE' ? 'text-success' : 'text-secondary';
                return '<i class="fa ' + icon + ' ' + color + '"></i>';
            }
        }
    ]
});

let $categoryModal = $('#categoryModal');
let $categoryItemModal = $('#categoryItemModal');

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
            $categoryModal.modal('hide');
            $categoryModal.children().find('input, select').each(function () {
                $(this).is('input') ? $(this).val('') : this.selectedIndex = 0;
            })
            $categoryTable.setData();
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
            $categoryItemModal.modal('hide');
            $categoryItemModal.children().find('input, select').each(function () {
                $(this).is('input') ? $(this).val('') : this.selectedIndex = 0;
            })
            let url = "/admin/category/" + categoryId + "/items";
            $categoryItemTable.setData(url);
        }
    })
}

$categoryTable.on("rowClick", function (e, row) {
    let data = row.getData();
    $('#categoryNameForItem').text(data.name);
    $('#categoryIdForItem').val(data.id);
    let url = "/admin/category/" + data.id + "/items";
    $categoryItemTable.setData(url);
    $('#categoryItemDiv').removeClass('d-none').show();
});
