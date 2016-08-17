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
            row[i].style.backgroundColor = "#D1D5DF";
        }
    }
});
$('.rowsmove').mouseover(function () {
    if(($(this)[0].rowIndex+1)%2==0){
        $(this).css("background-color","#3CCAFF");
    }else{
        $(this).css("background-color","#FFFFFF");
    }
});
$('.rowsmove').mouseout(function () {
    if(($(this)[0].rowIndex+1)%2==0){
        $(this).css("background-color","#36BEEC");
    }else{
        $(this).css("background-color","#D1D5DF");
    }
});