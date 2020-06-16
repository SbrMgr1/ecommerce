$(function () {

    var manageSerialNumber = function(){
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

        let myJson = {id: id, name: name, email: email, password: password};

        $.post('/administration/user', {userdata: JSON.stringify(myJson)}, addUser,'json')
    });

    function addUser(data) {
        // let last_index = $('tbody tr').last().children().first().text();
        // var td0=$('<td>').text(parseInt(last_index)+1);
        var td0=$('<td>')
        var td1 = $('<td>').text(data.name);
        var td2 = $('<td>').text(data.email);
        var tr = $('<tr>').append(td0).append(td1).append(td2).append($('tbody tr td').last().clone());
        $('tbody').append(tr);
        manageSerialNumber();
        $('#my-form')[0].reset();
        $('[name="id"]').val(" ");
    }

    $(document).on('click','.edit-btn',function (e) {
        var tr = $(this).parents('tr');
        $('#my-form').find('#username').val(tr.find("td:nth-child(2)").text());
        $('#my-form').find('#userEmail').val(tr.find("td:nth-child(3)").text());
        // $('#my-form').find('#userPassword').val(tr.find('td:nth-child(4)'))
        $('#my-form').find('[name="id"]').val(tr.attr("data-key"));
    })

});