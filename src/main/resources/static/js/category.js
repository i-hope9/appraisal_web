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
        success: function (fragment) {
            $('#categoryModal').modal('hide');
            $('#categoryTable').bootstrapTable('refresh');
        }
    })
}

function addCategoryItem() {


    let data = {
        name: $('#categoryItemName').val(),
        description: $('#categoryItemDescription').val(),
        status: 'ENABLE'
    }

}


