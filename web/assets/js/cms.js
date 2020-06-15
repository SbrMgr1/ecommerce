$(function()
{
    alert('here');
    $('#cmsSubmit').click(function () {
    var title=$('#title').val();
    var slug=$('#slug').val();
    var description=$('#description').val();
    var cms={
        title:title,
        slug:slug,
        description:description
    }
    $.post('/administration/cms-managent',{cms:JSON.stringify(cms)},returnedValue,'json')

    })
    function returnedValue(data) {
        alert('here');
        console.log(data);
    var tr=`<tr><td>${data.title}</td><td>${data.slug}</td><td><a class="btn btn-primary btn-xs" href="/edit?id=${data.id}"><i class="fa fa-edit"></i></a>
              <a class="btn btn-danger btn-xs" href="/delete?id=${data.id}"><i class="fa fa-trash-o"></i></a></td></tr>`;
    $('#cms-table>tbody').append(tr);

    }
})