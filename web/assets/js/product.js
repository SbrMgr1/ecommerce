$(function () {
    $('.product-form').submit(function (e) {

        // var formData = new FormData();
        // formData.append('name',$(this).find('[name="name"]').val());
        // formData.append('name',$(this).find('[name="catId"]').val());
        // formData.append('name',$(this).find('[name="producImg"]')[0].files);
        // formData.append('name',$(this).find('[name="unitPrice"]').val());
        // formData.append('name',$(this).find('[name="tax"]').val());
        // formData.append('name',$(this).find('[name="desc"]').val());
        // formData.append('name',$(this).find('[name="id"]').val());
        var formData = new FormData($(this)[0]);

        $.ajax({
            url:"/administration/product",
            type:'post',
            cache: false,
            contentType: false,
            processData: false,
            data:formData
        }).done(function (resp) {

        });
        e.preventDefault();
    })
})