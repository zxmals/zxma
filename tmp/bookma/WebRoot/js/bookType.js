/**
 * Created by zxmal on 2016/8/17 0017.
 */
/* first div-slide control */
$('.ghead').click(function() {
	$('.adiv').slideToggle("slow");
	/*
	 * if ($('.adiv').css("display")=="none"){ $('.adiv').slideDown(); }else{
	 * $('.adiv').slideUp(); }
	 */
});
/* second div-slide control */
$('.hthird').click(function() {
	var x = $(this).next();
	x.slideToggle();
	/*
	 * if (x[0].style.display=="none"|x[0].style.display==""){ x.slideDown();
	 * }else{ x.slideUp(); }
	 */
});
/* change image-arrow */
$('.expand').click(function() {
	if ($(this).find("img").attr("src") == "../img/larrow.png")
		$(this).find("img").attr("src", "../img/darrow.png");
	else
		$(this).find("img").attr("src", "../img/larrow.png");

});
$(".bdiv li").click(function() {
	$(".bdiv li").find(".rimg").remove();
	$(this).append(" <img  class='rimg' src='../img/rarrow.png' alt=''>");
});
$('.addalow').click(function() {
	if ($('.add').css("display") == "none") {
		$('.add').css("display", "");
	}
});
$('.banadd').click(function() {
	$('.add').css("display", "none");
});
$('.carry').click(function() {
	var id = $(this).attr("id");
	var t = 0;
	for (var i = 0; i < jso.length; i++) {
		if (id == jso[i].lbdm) {
			t++;
			$('#flbdm').attr("value", jso[i].flbdm);
			$('#flbmc').attr("value", jso[i].flbmc);
			$('#lbdm').attr("value", jso[i].lbdm);
			$('#lbmc').attr("value", jso[i].lbmc);
			$('#pxh').attr("value", jso[i].pxh);
			if(jso[i].sfjy=="1")
				$('#sfjy').attr("checked", "true");
		}
	}
	if (t == 0) {
		$('#flbdm').attr("value", "");
		$('#flbmc').attr("value", "");
		$('#lbdm').attr("value", "");
		$('#lbmc').attr("value", "");
		$('#pxh').attr("value", "");
		$('#sfjy').attr("checked", "false");
	}
});