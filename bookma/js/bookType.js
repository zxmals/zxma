/**
 * Created by zxmal on 2016/8/17 0017.
 */
/*  first div-slide control  */
$('.ghead').click(function () {
    $('.adiv').slideToggle("slow");
/*
 if ($('.adiv').css("display")=="none"){
 $('.adiv').slideDown();
 }else{
 $('.adiv').slideUp();
 }
 */
});
/*  second div-slide control  */
$('.hthird').click(function () {
    var x = $(this).next();
    x.slideToggle();
/*
if (x[0].style.display=="none"|x[0].style.display==""){
 x.slideDown();
 }else{
 x.slideUp();
 }
 */
});
/*  change image-arrow  */
$('.expand').click(function () {
    if( $(this).find("img").attr("src")=="../img/larrow.png")
        $(this).find("img").attr("src","../img/darrow.png");
    else
        $(this).find("img").attr("src","../img/larrow.png");
});
$(".bdiv li").click(function () {
    $(".bdiv li").find(".rimg").remove();
    $(this).append(" <img  class='rimg' src='../img/rarrow.png' alt=''>");
});
/*  check -null  */
$("#save").click(function () {
    var iput = $('.regular_tab input');
    var count = 0;
    for(var i=3;i<iput.length;i++){
        if (iput[i].value.trim()==""|iput[i].value.trim()==null){
            iput[i].style.backgroundColor = "#FF9191";
            iput[i].value = "";
            count++;
        }else{
            iput[i].style.backgroundColor = "#DEF6FF";
        }
    }
    if (count!=0){
        $('body').append("<span  class='warning' style='color: red;position: absolute;top: 15%;left: 45%;font-weight: bold'>请补充红色框内的内容后再提交！</span>");
        return;
    }else{
        var wx = $('.warning');
        if (wx.length==1){
            $('.warning').remove();
        }
        else{
            for(var i=0;i<wx.length;i++){
                wx[i].remove();
            }
        }
    }
});
