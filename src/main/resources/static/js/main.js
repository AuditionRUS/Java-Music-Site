$(document).ready(function(){

    //For Good

    $('.nBtn, .eBtn').on('click',function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        var text=$(this).text();
        if(text=='Edit'){
            $.get(href,function (good,status) {
                $('.formSaveGood #id').val(good.id);
                $('.formSaveGood #name').val(good.name);
                $('.formSaveGood #price').val(good.price);
            });
            $('.formSaveGood #exampleModalGood').modal();
        }else{
            $('.formSaveGood #id').val('');
            $('.formSaveGood #name').val('');
            $('.formSaveGood #price').val('');
            $('.formSaveGood #exampleModalGood').modal();
        }




    });

    $('.delBtn').on('click', function (event) {
        event.preventDefault();
        var href=$(this).attr('href');
        $('#modalDeleteGood #delRef').attr('href', href);
        $('#modalDeleteGood').modal();
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

//Inner Форма длявывода OrderLine
function createOrderLineForm() {
    if(document.getElementById('innerBlock').style.visibility=="visible"){
        document.getElementById('innerBlock').style.visibility="hidden";
    }else {
        document.getElementById('innerBlock').style.visibility = "visible";
    }
}
