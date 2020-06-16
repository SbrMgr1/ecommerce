$(function () {

    var manageSerialNumber = function () {
        var tbody = $('tbody');
        var sn = 1;
        tbody.find('tr').each(function (e) {
            $(this).find("td:nth-child(1)").text(sn++);
        })
    }


    $("#catSubmit").submit(function (e) {
        // alert("hello");
        var catName = $('#catName').val();
        var descrip = $('#descrip').val();
        var productCategory = {
            catName: catName,
            descrip: descrip
        }
        $.post('/administration/product-cat', {productCategory: JSON.stringify(productCategory)}, addCatgory, 'json')
        e.preventDefault();
        return false;
    })

    function addCatgory(data) {
        // alert('here');
        console.log(data);
        var tr = `<tr><td>${data.catName}</td>
                 <td>${data.descrip}</td>
                 <td><button class="btn btn-primary btn-xs edit-btn" value="${data.id}">
                 <i class="fa fa-edit"></i></button>
              <button class="btn btn-danger btn-xs delete-btn" value="$(data.id)">
              <i class="fa fa-trash-o"></i></button></td></tr>`;
        $('#prod-cat-table>tbody').append(tr);
        manageSerialNumber();

    }

    $(document).on('click', '.delete-btn', function (e) {
        var cat_id = $(this).val();
        $.post('/administrator/deleteCat', {id: cat_id}, delCat, 'json');
        $(this).parents('tr').remove();
        manageSerialNumber();

    })

    function delCat(data) {
        var ptable = $('#prod-cat-table');
        var lastRow = ptable.rows.length;
        if (lastRow > 2) {
            ptable.deleteRow(lastRow - 1);
        }
        if ($('#psize').val() > 1) {
            // $('#psize').val()=$('#psize').val()-1;
            document.getElementById("psize").value = $('#psize').val() - 1;

        }


    }

    $(document).on('click', '.btn-edit', function (e) {

        row = $(this).parents('tr').index();
        var catName = $(this).parents('tr').find('td:nth-child(2)').text();
        var desc = $(this).parents('tr').find('td:nth-child(3)').text();


        $('#catName').val(catName);
        $('#descrip').val(desc);



        e.preventDefault();
    })

});