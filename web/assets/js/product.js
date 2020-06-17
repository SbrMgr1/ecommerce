$(function () {

    var manageSerialNumber = function(){
        var tbody = $('.product-table tbody');
        var sn = 1;
        tbody.find('tr').each(function(e){
            $(this).find("td:nth-child(1)").text(sn++);
        })
    }
    var catList = {};
    $('#product-category option').each(function (e) {
        if($(this).val()){
            catList[$(this).val()] = $(this).text();
        }
    })

    $('.product-form').submit(function (e) {



        var formData = new FormData();

        var text_inputs = {};
        if ($(this).find('[name="id"]').val()){
            text_inputs.id = $(this).find('[name="id"]').val()
        }
        if($(this).find('[name="name"]').val()){
            text_inputs.name = $(this).find('[name="name"]').val();
        }
        if ($(this).find('[name="catId"]').val()){
            text_inputs.catId = $(this).find('[name="catId"]').val();
        }
        if ($(this).find('[name="unitPrice"]').val()){
            text_inputs.unitPrice = $(this).find('[name="unitPrice"]').val();
        }
        if ($(this).find('[name="tax"]').val()){
            text_inputs.tax = $(this).find('[name="tax"]').val();
        }
        if ($(this).find('[name="desc"]').val()){
            text_inputs.desc = $(this).find('[name="desc"]').val();
        }

        var file_input = $('[name="producImg"]')[0].files[0];
        formData.append("text_inputs",JSON.stringify(text_inputs));
        formData.append("file_input",file_input);
        $('.error-container').html("");
        $.ajax({
            url:"/administration/product",
            type:'post',
            dataType:'json',
            cache: false,
            contentType: false,
            processData: false,
            data:formData
        }).done(function (resp) {
            var product = resp.data;
            if(resp.status == false){
                    $('.error-container').html(resp.message);
                    return true;
            }else{
                $('.error-container').html(`<div class="alert alert-success">
                    ${resp.message}
                </div>`)

            }

            var catName = '';
            if(catList[product.catId]){
                catName = catList[product.catId];
            }
            if($('.product-form').find('[name="id"]').val()){

                $(`tr[data-key="${product.id}"]`).find("td:nth-child(2)").text(product.name);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(3)").find("img").attr("src","/assets/images/"+product.producImg);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(4)").attr("data-cat",product.catId).text(catName);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(5)").text(product.unitPrice);
                $(`tr[data-key="${product.id}"]`).find("td:nth-child(6)").text(product.tax);

            }else{

                var html = `<tr data-key="${product.id}" data-desc="${product.desc}">
                  <td></td>
                  <td>${product.name}</td>
                  <td><img alt="${product.name}" class="img-responsive" src="/assets/images/${product.producImg}"/></td>
                  <td data-cat="${product.catId}">${catName}</td>
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
        $('.product-form').find('[name="catId"]').val(tr.find("td:nth-child(4)").attr("data-cat"));
        $('.product-form').find('[name="unitPrice"]').val(tr.find("td:nth-child(5)").text());
        $('.product-form').find('[name="tax"]').val(tr.find("td:nth-child(6)").text());
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