$(function () {
    $("[type=submit]").on('click', function (e) {
        e.preventDefault();

        let name = $('#username').val();
        let email = $('#userEmail').val();
        let password = $('#userPassword').val();

        let myJson = {name: name, email: email, password: password};

        $.post('/administration/user', {userdata: JSON.stringify(myJson)}, addUser,'json')
    });

    function addUser(data) {
        var td0=$('<td>').text($('tbody').children());
        var td1 = $('<td>').text(data.name);
        var td2 = $('<td>').text(data.price);
        var tr = $('<tr>').append(td0).append(td1).append(td2);
        $('#tbl_products>tbody').append(tr);
    }
});