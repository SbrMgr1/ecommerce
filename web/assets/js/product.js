$(function () {

    var manageSerialNumber = function(){
        var tbody = $('.product-table tbody');
        var sn = 1;
        tbody.find('tr').each(function(e){
            $(this).find("td:nth-child(1)").text(sn++);
        })
    }
    $('.product-form').submit(function (e) {


        var formData = new FormData();

        var text_inputs = {
            name: $(this).find('[name="name"]').val(),
            catId: $(this).find('[name="catId"]').val(),
            unitPrice: $(this).find('[name="unitPrice"]').val(),
            tax: $(this).find('[name="tax"]').val(),
            desc: $(this).find('[name="desc"]').val()
        };
        if ($(this).find('[name="id"]').val()){
            text_inputs.id = $(this).find('[name="id"]').val()
        }
        var file_input = $('[name="producImg"]')[0].files[0];
        formData.append("text_inputs",JSON.stringify(text_inputs));
        formData.append("file_input",file_input);

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
                  <td><img class="img-responsive" src="</assets/images/${product.producImg}"/></td>
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
            $('[name="id"]').val('');
        });
        e.preventDefault();
    })
    $(document).on('click','.edit-btn',function (e) {

        var tr = $(this).parents('tr');
        $('.product-form').find('[name="name"]').val(tr.find("td:nth-child(2)").text());
        $('.product-form').find('[name="catId"]').val(tr.find("td:nth-child(3)").text());
        $('.product-form').find('[name="unitPrice"]').val(tr.find("td:nth-child(4)").text());
        $('.product-form').find('[name="tax"]').val(tr.find("td:nth-child(5)").text());
        $('.product-form').find('[name="desc"]').val(tr.attr("data-desc"));
        $('.product-form').find('[name="id"]').val(tr.attr("data-key"));

        if(!$('.add-edit-btn').attr('aria-expanded')){
            $('.add-edit-btn').click();
        }
    });
    $(document).on('click','.delete-btn',function () {
        if (!confirm("Are you sure you want to delete this product?")){
            return false;
        }
        var row = $(this).parents('tr');
        var key = row.attr("data-key");
        $.ajax({
            type:"post",
            url:'/administration/product_delete',
            data: {id:key}
        }).done(function (resp) {
            row.remove();
            manageSerialNumber();
        });
    })
})