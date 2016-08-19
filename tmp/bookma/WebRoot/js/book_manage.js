/**
 * Created by zxmals on 2016/8/17 0017.
 */
$(document).ready(function () {
    var tab = $('.result table');
    var row = tab.find("tr");
    for(var i=0;i<tab[0].rows.length;i++){
        if ((i+1)%2==0){
            row[i].style.backgroundColor = "#36BEEC";
        }else{
            row[i].style.backgroundColor = "#c0c0c0";
        }
    }
    $('a[rel*=leanModal]').leanModal({ top: 200, closeButton: ".close_modal" });
});
$('.rowsmove').mouseover(function () {
    if(($(this)[0].rowIndex+1)%2==0){
        $(this).css("background-color","#556B2F");
        $(this).css("color","white");
    }else{
        $(this).css("background-color","#586CC4");
        $(this).css("color","white");
    }
});
$('.rowsmove').mouseout(function () {
    if(($(this)[0].rowIndex+1)%2==0){
        $(this).css("background-color","#36BEEC");
        $(this).css("color","black");
    }else{
        $(this).css("background-color","#c0c0c0");
        $(this).css("color","black");
    }
});