$(function()
{

    $('#cmsSubmit').click(function (e) {
    var title=$('#title').val();
    var slug=$('#slug').val();
    var description=$('#description').val();
    var cms={
        title:title,
        slug:slug,
        description:description
    }

    $.post('/administration/cms-managent',{cms:JSON.stringify(cms)},returnedValue,'json')
        e.preventDefault();
    })

    function returnedValue(data) {
    var tr=`<tr><td>${data.title}</td><td>${data.slug}</td><td><button class="btn btn-primary btn-xs edit-btn" value="${data.id}" ><i class="fa fa-edit"></i></button>
              <button class="btn btn-danger btn-xs delete-btn" value="${data.id}"><i class="fa fa-trash-o"></i></button></td></tr>`;
    $('#cms-table>tbody').append(tr);

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

})