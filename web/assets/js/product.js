$(function () {

    var manageSerialNumber = function(){
        var tbody = $('.product-table tbody');
        var sn = 1;
        tbody.find('tr').each(function(e){
            $(this).find("td:nth-child(1)").text(sn++);
        })
    }
    $('.product-form').submit(function (e) {

        var formData = new FormData($(this)[0]);

        $.ajax({
            url:"/administration/product",
            type:'post',
            dataType:'json',
            cache: false,
            contentType: false,
            processData: false,
            data:formData
        }).done(function (product) {

            if($('.product-form').find('[name="id"]').val()){

                $(`tr[data-key="${product.id}"]`).find("td:nth-child(2)").text(product.name);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(3)").text(product.catId);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(4)").text(product.unitPrice);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(5)").text(product.tax);

            }else{
                var html = `<tr data-key="${product.id}" data-desc="${product.desc}">
                  <td></td>
                  <td>${product.name}</td>
                  <td>${product.catId}</td>
                  <td class="text-right">${product.unitPrice}</td>
                  <td class="text-right">${product.tax}</td>
                  <td>
                    <a class="btn btn-primary btn-xs edit-btn"><i class="fa fa-edit"></i></a>
                    <a class="btn btn-danger btn-xs delete-btn"><i class="fa fa-trash-o"></i></a>
                  </td>
                </tr>`;
                $('.product-table tbody').append(html);
            }

            manageSerialNumber();

            $('.product-form')[0].reset();
        });
        e.preventDefault();
    })
    $('.edit-btn').on('click',function (e) {
        var tr = $(this).parents('tr');
        $('.product-form').find('[name="name"]').val(tr.find("td:nth-child(2)").text());
        $('.product-form').find('[name="catId"]').val(tr.find("td:nth-child(3)").text());
        $('.product-form').find('[name="unitPrice"]').val(tr.find("td:nth-child(4)").text());
        $('.product-form').find('[name="tax"]').val(tr.find("td:nth-child(5)").text());
        $('.product-form').find('[name="desc"]').val(tr.attr("data-desc"));
        $('.product-form').find('[name="id"]').val(tr.attr("data-key"));
    })
})