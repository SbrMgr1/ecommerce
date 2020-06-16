$(function()
{
    $('#cmsSubmit').click(function (e) {
        var id=$('#c_id').val();

            var title = $('#title').val();
            var slug = $('#slug').val();
            var description = $('#description').val();
            console.log(description);
            var cms = {
                title: title,
                slug: slug,
                description: description
            }
            if(id){
                cms.id = id;
            }

            $.post('/administration/cms-managent', {cms: JSON.stringify(cms)}, returnedValue, 'json');

        e.preventDefault();
    })

    function returnedValue(data) {
        var id=data.id;
        if(!$('#cms-form').find('[name="id"]').val()) {
            var tr = `<tr id="${data.id}"><td>${data.title}</td><td>${data.slug}</td><td>${data.description}</td><td><button class="btn btn-primary btn-xs edit-btn" value="${data.id}" ><i class="fa fa-edit"></i></button>
              <button class="btn btn-danger btn-xs delete-btn" value="${data.id}"><i class="fa fa-trash-o"></i></button></td></tr>`;
            $('#cms-table>tbody').append(tr);
        }
        else
        {
            $(`tr[id="${data.id}"]`).find("td:nth-child(1)").text(data.title);
            $(`tr[id="${data.id}"]`).find("td:nth-child(2)").text(data.slug);
            $(`tr[id="${data.id}"]`).find("td:nth-child(3)").text(data.description);
            alert(" Value Updated Sucessfully!!!");
        }

    }

    $(document).on('click','.delete-btn',function(e){
       var c_id=$(this).val();
       $.post('/administration/delete',{id:c_id},returnedDel,'json');
       $(this).parents('tr').remove();
    })


    function returnedDel(data)
    {
        alert(data);
        // console.log(data);
        // for (let val in data)
        // {
        //     alert(data[val][id]);
        //     var tr=`<tr><td>${data[val][title]}</td><td>${data[val][slug]}</td><td><button class="btn btn-primary btn-xs edit-btn" value="${data[val][id]}" onclick="edit(${data[val][id]})"><i class="fa fa-edit"></i></button>
        //       <button class="btn btn-danger btn-xs delete-brn" value="${data[val][id]}"><i class="fa fa-trash-o"></i></button></td></tr>`;
        //     $('#cms-table>tbody').append(tr);
        // }
    }
    $(document).on('click','.edit-btn',function (e) {
        var id=$(this).val();
        var tr = $(this).parents('tr');
        $('#cms-form').find('[name="id"]').val(id);
        $('#cms-form').find('[name="title"]').val(tr.find("td:nth-child(1)").text());
        $('#cms-form').find('[name="slug"]').val(tr.find("td:nth-child(2)").text());
        $('#cms-form').find('[name="description"]').val(tr.find("td:nth-child(3)").text());


    })

})