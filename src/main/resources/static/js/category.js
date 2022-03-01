function clickRow(txt) {
    alert(txt);
}

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
        success: function (response) {
            console.log(response);
        }
    })
}
