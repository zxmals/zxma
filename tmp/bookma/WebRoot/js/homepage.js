/**
 * Created by zxmals on 2016/8/17 0017.
 */
$('#changeguide').click(function () {
    if($('.hideli').css("display")=="none"){
        $('.hideli').slideDown();
    }else{
        $('.hideli').slideUp();
    }
});
$('.focus').mouseover(function () {
    $(this).css('background-color','#33A6D1');
    $(this).find("a").css('color','#FAE22E');
});
$('.focus').mouseout(function () {
    $(this).css('background-color','#36beec');
    $(this).find("a").css('color','#efec73');
});
$(".hideli .focus").click(function () {
    $(".hideli .focus").find("hr").remove();
    $(this).append("<hr style='border: thin solid #33A6D1;width: 60%'>");
});