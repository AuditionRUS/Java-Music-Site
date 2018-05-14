$(document).ready(function(){

    //For Good

    $('.nBtn, .eBtn').on('click',function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        var text=$(this).text();
        var d = new Date();
        if(text=='Edit'){
            $.get(href,function (audio,status) {
                $('.formSaveAudio #id').val(audio.id);
                $('.formSaveAudio #author').val(audio.author);
                $('.formSaveAudio #music').val(audio.music);
                $('.formSaveAudio #name').val(audio.name);
                $('.formSaveAudio #dateAdd').val(audio.dateAdd);
                $('.formSaveAudio #type').val(audio.type_id);

            });
            $('.formSaveAudio #exampleModalAudio').modal();
        }else{
            $('.formSaveAudio #id').val('');
            $('.formSaveAudio #author').val('');
            $('.formSaveAudio #music').val('');
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



$(document).ready(function(){

//For Order

$('.nBtnOrder, .eBtnOrder').on('click',function (event) {
    event.preventDefault();
    var href=$(this).attr('href');
    var text=$(this).text();
    if(text=='Edit'){
        $.get(href,function (order,status) {
            $('.formSaveOrder #idOrder').val(order.id);
            $('.formSaveOrder #clientOrder').val(order.client);
            $('.formSaveOrder #dateOrder').val(order.date);
            $('.formSaveOrder #addressOrder').val(order.address);
        });
        $('.formSaveOrder #exampleModalOrder').modal();
    }else{
        $('.formSaveOrder #idOrder').val('');
        $('.formSaveOrder #clientOrder').val('');
        $('.formSaveOrder #dateOrder').val('');
        $('.formSaveOrder #addressOrder').val('');
        $('.formSaveOrder #exampleModalOrder').modal();
    }




});

$('.delBtnOrder').on('click', function (event) {
    event.preventDefault();
    var href=$(this).attr('href');
    $('#modalDeleteOrder #delOrder').attr('href', href);
    $('#modalDeleteOrder').modal();
});

});

//Inner Форма для вывода OrderLine
function createOrderLineForm() {
    if(document.getElementById('innerBlock').style.visibility=="visible"){
        document.getElementById('innerBlock').style.visibility="hidden";
    }else {
        document.getElementById('innerBlock').style.visibility = "visible";
    }
}
