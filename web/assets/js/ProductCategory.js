$(function(){
    alert("Here");

   $("#catSubmit").submit(function(){
       alert("hello");
       var catName=$('#catName').val();
       var descrip=$('#descrip').val();
       var productCategory={
           catName:catName,
           descrip:descrip
       }
       $.post('/administration/product-cat',{productCategory:JSON.stringify(productCategory)},returnedValue,'json')
   })

    function returnedValue(data) {
        alert('here');
        console.log(data);
        var tr=`<tr><td>${data.catName}</td><td>${data.descrip}</td><td><a class="btn btn-primary btn-xs"><i class="fa fa-edit"></i></a>
              <a class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i></a></td></tr>`;
        $('#prod-cat-table>tbody').append(tr);

    }

});