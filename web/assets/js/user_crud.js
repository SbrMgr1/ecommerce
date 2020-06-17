$(function () {

    function manageIndex(){
        var tbody = $('tbody');
        var sn = 1;
        tbody.find('tr').each(function(e){
            $(this).find("td:nth-child(1)").text(sn++);
        })
    }
    $("#my-form").submit(function (e) {
        e.preventDefault();

        let id = $('[name="id"]').val();
        let name = $('#username').val();
        let email = $('#userEmail').val();
        let password = $('#userPassword').val();

        let myJson = {name: name, email: email, password: password};

        if(id){
            myJson.id = id;
        }
        if(name=="" || email=="" || password ==""){
            alert("Fields should not be empty!!");
        } else if(!validateEmail(email)){
            alert("You have entered an invalid email address!");
        } else {
            $.post('/administration/user', {userdata: JSON.stringify(myJson)}, addUser,'json');
        }

    });

    function addUser(resp) {
        // let last_index = $('tbody tr').last().children().first().text();
        // var td0=$('<td>').text(parseInt(last_index)+1);

        if(resp.status==true) {

            if(!$('#my-form').find('[name="id"]').val()){
                var td0=$('<td>')
                var td1 = $('<td>').text(resp.data.name);
                var td2 = $('<td>').text(resp.data.email);
                var tr = $('<tr>').append(td0).append(td1).append(td2).append($('tbody tr td').last().clone());
                $('tbody').append(tr);
            } else {
                $(`tr[data-key="${resp.data.id}"]`).find("td:nth-child(2)").text(resp.data.name);
                $(`tr[data-key="${resp.data.id}"]`).find("td:nth-child(3)").text(resp.data.email);
            }
            alert(resp.message);

        } else {
            alert(resp.message);
        }
        manageIndex();
        $('#my-form')[0].reset();
        $('[name="id"]').val("");
    }

    $(document).on('click','.edit-btn',function (e) {
        var tr = $(this).parents('tr');
        $('#my-form').find('#username').val(tr.find("td:nth-child(2)").text());
        $('#my-form').find('#userEmail').val(tr.find("td:nth-child(3)").text());
        // $('#my-form').find('#userPassword').val(tr.find('td:nth-child(4)'))
        $('#my-form').find('[name="id"]').val(tr.attr("data-key"));

        if(!$('.add-edit-btn').attr('aria-expanded')){
            $('.add-edit-btn').click();
        }
    })

    $(document).on('click','.dlt-btn',function () {
        if (!(confirm('Are you sure you want to delete this user?'))) {
            return false;
        }
        var row = $(this).parents('tr');
        var email = row.children().eq(2).text();
        $.ajax({
            type:"post",
            url:'/administration/delete-user',
            data: {email:email}
        }).done(function (resp) {
            row.remove();
            manageIndex();
        });
    })

    function validateEmail(email) {
        if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email)) {
            return true;
        } else {
            return false;
        }
    }
});