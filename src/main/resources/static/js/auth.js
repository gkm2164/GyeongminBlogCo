var doLogin = function () {
    var sendString = $('form#auth').serialize();

    $.post('/auth.do/login', sendString, function(result) {
        if (result.success == true) {
            alert ("Login Success!");
        } else {
            alert ("Login fail!");
        }
    });
};