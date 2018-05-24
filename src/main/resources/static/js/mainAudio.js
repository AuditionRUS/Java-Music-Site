$(document).ready(function(){

    //For User

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


    //For Audio


    $('.nAudioBtn').on('click',function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        var text=$(this).text();
        var d = new Date();
        if(text=='Edit'){
            $.get(href,function (audio,status) {
                $('.formSaveAudio #idAudio').val(audio.id);
                $('.formSaveAudio #author').val(audio.author);
                $('.formSaveAudio #music').val(audio.music);
                $('.formSaveAudio #name').val(audio.name);
                $('.formSaveAudio #dateAdd').val(audio.dateAdd);
                $('.formSaveAudio #type').val(audio.type_id);

            });
            $('.formSaveAudio #exampleModalAudio').modal();
        }else{
            $('.formSaveAudio #idAudio').val('');
            $('.formSaveAudio #name').val('');
            $('.formSaveAudio #dateAdd').val(d.getFullYear() + "-" + (d.getMonth()+1) + "-" + d.getDate());
            $('.formSaveAudio #type').val('');
            $('.formSaveAudio #exampleModalAudio').modal();
        }




    });

    $('.table .delBtn').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        $('#modalDeleteAudio #delRef').attr('href', href);
        $('#modalDeleteAudio').modal();
    });


});
