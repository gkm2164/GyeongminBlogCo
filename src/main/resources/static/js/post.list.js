$(function () {
    var target = $('table tfoot#post-list');
    $.get('/post.do', function (result) {
        var obj = result;
        var tr = $('<tr></tr>');

        var td_title = $('<td></td>').append(obj.title);
        var td_user = $('<td></td>').append('User');
        var td_createdTime = $('<td></td>').append(obj.createdTime);

        tr.append(td_title).append(td_user).append(td_createdTime);

        target.append(tr);
    });
});