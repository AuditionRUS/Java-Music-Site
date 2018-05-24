$(document).ready(function(){

    //For Audio

    $('.nBtn, .eBtn').on('click',function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        var text=$(this).text();
        if(text=='Edit'){
            $.get(href,function (user,status) {
                $('.formRegistration #id').val(user.id);
                $('.formRegistration #username').val(user.username);
                $('.formRegistration #password').val(user.password);
                $('.formRegistration #role').val('USER');
            });
            $('.formRegistration #exampleModalReg').modal();
        }else{
            $('.formRegistration #username').val('');
            $('.formRegistration #password').val('');
            $('.formRegistration #exampleModalReg').modal();
        }




    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        $('#modalDeleteReg #delRef').attr('href', href);
        $('#modalDeleteReg').modal();
    });


});
