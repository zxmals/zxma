<%@page import="TreeStore.GenerateTree"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="model.TS_LX" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	Map<String, Object> map = GenerateTree.getTree();
	List<TS_LX> li = (List)map.get("first");
	List<TS_LX> tmp = null;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>bookma-bookType</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <link rel="stylesheet" href="../css/book_type.css">
        <script type="text/javascript" src="../js/jquery.js" ></script>        
    </head>
    <body>
        <div class="total">
            <div class="guide">
                <div class="ghead expand carry addalow"   id="clearin"><a href="#">图书类型</a> <img src="../img/larrow.png" alt=""></div>
                <div class="adiv">
                    <ul>
                    <%
                    	if(li!=null)
                    		for (int i=0;i<li.size();i++){%>
                        <li class="expand hthird carry addalow"   id="<%=li.get(i).getLbdm() %>"><a href="#"><%=li.get(i).getLbmc() %></a> <img src="../img/larrow.png" alt=""></li>
                        <ul class="bdiv">
                        <% tmp = (List)map.get(li.get(i).getLbdm());
                         if(tmp!=null)
                         		for(int j=0;j<tmp.size();j++){ %>
                            <li  class="carry banadd"  id="<%=tmp.get(j).getLbdm() %>"><a href="#"><%=tmp.get(j).getLbmc() %></a></li>
                            <%} %>
                        </ul>
                        <%} %>
                    </ul>
                </div>
            </div>
            <div class="typeset">
                <div class="operate">
                    <a href="#" class="add">新增子类</a>&nbsp;<a href="#" id="delete">删除</a>&nbsp;<a href="#"  id="save">保存</a>
                </div>
                <span class="tabhead">图书类型设置</span><br><br><br><br><hr style="border: thin solid #36beec">
                <div class="pretend_table">
                    <div class="regular_tab">
                        <label>上级类别代码：</label><input type="text" id="flbdm" readonly><br>
                    </div>
                    <div class="regular_tab">
                        <label>上级类别名称：</label><input type="text" id="flbmc" readonly><br>
                     </div>
                    <div class="regular_tab">
                        <label>&nbsp;类别代码<span style="color: red;">*</span>：</label><input type="text" id="lbdm" readonly><br>
                    </div>
                    <div class="regular_tab">
                        <label>&nbsp;类别名称<span style="color: red;">*</span>：</label><input type="text" id="lbmc"><br>
                    </div>
                    <div class="regular_tab">
                        <label>&nbsp;&nbsp;排序号：</label><input type="text" id="pxh">
                    </div>
                    <div class="regular_tab">
                        <label>&nbsp;是否禁用：</label><input type="checkbox"    value="1"    id="sfjy"><br>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="../js/bookType.js"></script>
    <script type="text/javascript">
    	 	var jso = [
    	 		<%  
	    	if(li!=null)
	    	 	for(int i=0;i<li.size();i++){  %>
    	 		{"flbdm":"",
    	 		  "flbmc":"",
    	 		  "lbdm":"<%=li.get(i).getLbdm() %>",
    	 		  "lbmc":"<%=li.get(i).getLbmc() %>",
    	 		  "pxh":"<%=li.get(i).getPxh() %>",
    	 		   "sfjy":"<%=li.get(i).getSfjy() %>"
    	 		},
    	 		<% 
    	 	tmp = (List)map.get(li.get(i).getLbdm());
	    	 if(tmp!=null)
                       for(int j=0;j<tmp.size();j++){ %>
                    		{"flbdm":"<%=li.get(i).getLbdm() %>",
			    	 		  "flbmc":"<%=li.get(i).getLbmc() %>",
			    	 		  "lbdm":"<%=tmp.get(j).getLbdm() %>",
			    	 		  "lbmc":"<%=tmp.get(j).getLbmc() %>",
			    	 		   "pxh":"<%=tmp.get(j).getPxh() %>",
			    	 		    "sfjy":"<%=li.get(i).getSfjy() %>"
			    	 		 },     		
                    <%}
    	 			}%>
    	 		];
    	 		
				$('.add').click(function() {
    	 			if($('#lbdm').val()==""){
    	 				$.post("<%=basePath %>/deep",{child:'32000000',method:'getchildId'},
    	 				function(data,status){
		    	 				if(status=="success"){
		    	 					$('#lbdm').attr("value",data);
		    	 				}else{
		    	 					$('#lbdm').attr("value","error");
		    	 				}
    	 				});
    	 			}else{
    	 				$('#flbdm').attr("value",$('#lbdm').val());
    	 				$('#flbmc').attr("value",$('#lbmc').val());
    	 				var str = "320000"+$('#lbdm').val().substring($('#lbdm').val().length-2,$('#lbdm').val().length);
    	 				$('#lbdm').attr("value","");
    	 				$.post("<%=basePath %>deep",{child:str,method:'getchildId'},
    	 				function(data,status){
		    	 				if(status=="success"){
		    	 					$('#lbdm').attr("value",data);
		    	 				}else{
		    	 					$('#lbdm').attr("value","error");
		    	 				}
    	 				});
    	 				$('#lbmc').attr("value","");
    	 				$('#pxh').attr("value","");
    	 			}
				});
				
    	 	/* check -null */
			$("#save").click(function() {
						var iput = $('.regular_tab input');
						var count = 0;
						for (var i = 3; i < iput.length; i++) {
							if (iput[i].value.trim() == ""
									| iput[i].value.trim() == null) {
								iput[i].style.backgroundColor = "#FF9191";
								iput[i].value = "";
								count++;
							} else {
								iput[i].style.backgroundColor = "#DEF6FF";
							}
						}
						if (count != 0) {
							$('body').append("<span  class='warning' style='color: red;position: absolute;top: 15%;left: 45%;font-weight: bold'>请补充红色框内的内容后再提交！</span>");
							return;
						} else {
							var wx = $('.warning');
							if (wx.length == 1) {
								$('.warning').remove();
							} else {
								for (var i = 0; i < wx.length; i++) {
									wx[i].remove();
								}
							}
						}
						var jy = 0;
						if($('#sfjy').attr("checked")==true)
							jy = 1;
					  $.post("<%=basePath %>deep",
					  {method:'saveorupdate',
					  flbdm:$('#flbdm').val(),
					  flbmc:$('#flbmc').val(),
					  lbdm:$('#lbdm').val(),
					  lbmc:$('#lbmc').val(),
					  pxh:$('#pxh').val(),
					  sfjy:jy},
					  function(data,status) {
						if(status=="success"){
							if(data=="succ"){
								alert("操作成功");
								window.location.reload();
							}else{
								alert("操作失败");
							}
						}else{
							alert("请求失败");
						}
					});
				});
				$('#delete').click(function() {
					var x = confirm("确定删除？");
					if(x){
						$.post("<%=basePath %>deep",
						{lbdm:$('#lbdm').val(),
						method:"checkhavechild"},
						function(data,status){
							if(status=="success"){
								if(data=="have"){
									alert("尚有子类,无法删除");
								}else{
									if(data=="delsuc"){
										alert("已删除");
										window.location.reload();
									}
								}
							}else{
								alert("请求失败");
							}
						});
					}
				});
    </script>
</html>