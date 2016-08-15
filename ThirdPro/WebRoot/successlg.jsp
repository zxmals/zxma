<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Zxmals's Test</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
		<link rel="stylesheet"  type="text/css" href="CSS/leanModalCss.css">
		<link rel="stylesheet" type="text/css"  href="CSS/modaldialog.css">
        <link rel="stylesheet" type="text/css" href="CSS/div.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
        <script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
        <script type="text/javascript">
            function change(obj) {
                obj.style.background = '#b7e0f2';
            }
            function out(obj) {
                obj.style.background = '#87CEEB';
            }
            function onloads() {
//                alert("in");
				layouttable();
             	var updatestatus = "${udstatus }";
            	if(updatestatus!=""){
            		alert(updatestatus);          
            	}
            }
            function layouttable() {
				 var tab = document.getElementById("tab22");
                var row = tab.getElementsByTagName("tr");
                for(var i=0;i<row.length;i++){
                    if((i+1)%2==0){
                        row[i].className = "trblack";
                    }else{
                    	row[i].className = "trwhite";
                    }
                }
			}
			/*       引入摸态框       */
            $(document).ready(function(){
            	$('a[rel*=leanModal]').leanModal({ top: 200, closeButton: ".close_modal" });            	
            });
            function clickchange(id) {
				var tab = document.getElementById("tab22");
                var row = tab.getElementsByTagName("tr");
                 for(var i=1;i<tab.rows.length;i++){
                 		if(row[i].id==id)
                 				row[i].style.display = "";
                 		else
                 			row[i].style.display = "none";
                 }
                 layouttable();
			}
			
            function deleterow(numid) {
                var tab = document.getElementById("tab22");
                var row = tab.getElementsByTagName("tr");
                for(var i=0;i<tab.rows.length;i++)
                    for(var j=0;j<6;j++)
                        if(row[i].cells[j].innerText==numid)
                            tab.deleteRow(i);
            }
        </script>
    </head>
    <body onload="onloads()">
        <div style="width: 1400px;margin-top: 50px;margin-left: 100px;">
            <div id="d1">
                <div style="padding: 15px;margin-left: 50px">
                  
                        账号/姓名:<input name="userid" type="text"   id="search" >
                        <input type="submit" value="查询"  id="searchs">
                        <input type="button" value="新增" onclick="window.location.replace('<%=basePath %>AddUser.jsp')">
                        <span style="margin-left: 300px;margin-bottom: 20px">欢迎${login_inf.YHXM }登录 : 测试  <a href="logout"  style="color: green;text-decoration: none">注销</a></span>
                                       
                </div>
            </div>
            <div id="d2">
                <table class="tab">
                	<c:forEach items="${depart }" var="li">
                		 <tr>
                        	<td id="${li.BMDM }" onmouseover="change(this)" onmouseout="out(this)" onclick="clickchange(this.id)"><a href="#" style="text-decoration:none;">${li.BMMC }</a></td>
                    	</tr>
                	</c:forEach>                    
                </table>
            </div>
            <div id="d3">
                <table class="tab2" id="tab22">
                    <tr>
                        <th>查看</th>
                        <th>修改</th>
                        <th>删除</th>
                        <th>姓名</th>
                        <th>部门</th>
                    </tr>
                    <c:forEach  var="sing"  items="${user }">
                    	<tr id="${sing.YHBM }"  style="display: none">
                    		<td><a href="#lookin" rel="leanModal"  style="text-decoration:none;" class="deliverlk" >【查看】</a></td>
	                        <td><a href="#example" rel="leanModal"  style="text-decoration:none;" class="deliver"  >【修改】</a></td>
	                        <c:if test="${login_inf.YHXM==sing.YHXM }"><td><a href="#" style="text-decoration:none;"  class="" >【删除】</a></td></c:if>
	                        <c:if test="${login_inf.YHXM!=sing.YHXM }"><td><a href="javascript:void(0)" style="text-decoration:none;"  class="delete" >【删除】</a></td></c:if>
	                        <td>${sing.YHXM }</td>
	                        <td style="display: none">${sing.YHID }</td>
	                        <td>${sing.BMMC }</td>
                    	</tr>
                    </c:forEach>                    
                </table>
            </div>
        </div>
        <!-- leanModal-dialog -->
         <div id="example"  class = "modal_out_look">
            <div id="title">
                <label>修改用户信息</label>
            </div>
            <a class="modal_close" href="#"></a>
            <form  action="updateuser"   method="post" name="uduser">
            	<div class="mainbody">
                	<span>用户ID:&nbsp;</span><input type="text" name="userid" id="userid"  readonly="readonly">
           		 </div>
	            <div class="mainbody">
	                <span>用户姓名:</span><input type="text" name="username" id="username">
	            </div>
	            <div  class="mainbody">
	                <span>用户部门:</span><select name="userdepart"  id="userdepart">	                    
	                    <c:forEach  var="dep"  items="${depart }">	                    
	                    	<option value="${dep.BMDM }">${dep.BMMC }</option>
	                    </c:forEach>
	                </select>
	            </div>
	          </form>
	            <div id="operate">
	                <button class="modal_submit btn"  id="subchange">提交</button>
	                <button class="btn modal_close close_modal">关闭</button>
	            </div>            
        </div>
        <div id="lookin"  class = "modal_out_look">
            <div id="title">
                <label>查看用户信息</label>
            </div>
            <a class="modal_close" href="#"></a>
            	<div class="mainbody">
                	<span>用户ID:&nbsp;</span><input type="text" name="useridlk" id="useridlk"  readonly="readonly">
           		 </div>
	            <div class="mainbody">
	                <span>用户姓名:</span><input type="text" name="usernamelk" id="usernamelk"  readonly="readonly">
	            </div>
	            <div  class="mainbody">
	                <span>用户部门:</span><select name="userdepartlk"  id="userdepartlk"  disabled="disabled">
	                    <c:forEach  var="dep"  items="${depart }">
	                    	<option value="${dep.BMDM }">${dep.BMMC }</option>
	                    </c:forEach>
	                </select>
	            </div>
	            <div id="operate">
	                <button class="btn modal_close close_modal">关闭</button>
	            </div>    
        </div>
    </body>
    <script type="text/javascript">
    	/*    查询     */
//     	$('#search').bind({
//     		keypress:function(e){
//     			var key = e.which;
//     			if(key==13){
//     				var tval = $('#search').val().trim();
// 		    		var tab = document.getElementById("tab22");
// 		    		var row = tab.getElementsByTagName("tr");
// 		    		var calnum = 0;
// 		    		if(tval!=""){
// 		    			for(var i=1;i<tab.rows.length;i++){
// 		    			//str1.indexOf(str2)>=0  :str1 C str2
// 			    			if(row[i].cells[3].innerHTML.trim().indexOf(tval)>=0||row[i].cells[4].innerHTML.trim().indexOf(tval)>=0||row[i].cells[5].innerHTML.trim().indexOf(tval)>=0){
// 			    				row[i].style.display = "";
// 			    				row[i].className="trsearchresult";
// 			    			}else{
// 			    				row[i].style.display = "none";
// 			    				calnum++;
// 			    			}
// 			    		}
// 		    		}else{
// 		    			alert("查询值为空！");
// 		    			$('#search').attr("value","");
// 		    			return;
//     				}
// 		    		if(calnum==tab.rows.length-1)
// 		    			alert("查无此人!");	
// 	    		}
//     		},
//     		keyup:function(){
//     				var tval = $('#search').val().trim();
// 		    		var tab = document.getElementById("tab22");
// 		    		var row = tab.getElementsByTagName("tr");
// 		    		var calnum = 0;
// 		    		if(tval!=""){
// 		    			for(var i=1;i<tab.rows.length;i++){
// 		    			//str1.indexOf(str2)>=0  :str1 C str2
// 			    			if(row[i].cells[3].innerHTML.trim().indexOf(tval)>=0||row[i].cells[4].innerHTML.trim().indexOf(tval)>=0||row[i].cells[5].innerHTML.trim().indexOf(tval)>=0){
// 			    				row[i].style.display = "";
// 			    				row[i].className="trsearchresult";
// 			    			}else{
// 			    				row[i].style.display = "none";
// 			    				calnum++;
// 			    			}
// 			    		}
// 		    		}
//     		}
//     	});
    	$('#search').bind(
    		"keyup",function(){
    			 	var tval = $('#search').val().trim();
		    		var tab = document.getElementById("tab22");
		    		var row = tab.getElementsByTagName("tr");
		    		var calnum = 0;
		    		if(tval!=""){
		    			for(var i=1;i<tab.rows.length;i++){
		    			//str1.indexOf(str2)>=0  :str1 C str2
			    			if(row[i].cells[3].innerHTML.trim().indexOf(tval)>=0||row[i].cells[4].innerHTML.trim().indexOf(tval)>=0||row[i].cells[5].innerHTML.trim().indexOf(tval)>=0){
			    				row[i].style.display = "";
			    				row[i].className="trsearchresult";
			    			}else{
			    				row[i].style.display = "none";
			    				calnum++;
			    			}
			    		}
		    		}
    		}
    	);
    	$('#search').bind("keypress",function(e){
    			var key = e.which;
    			if(key==13){
    				var tval = $('#search').val().trim();
		    		var tab = document.getElementById("tab22");
		    		var row = tab.getElementsByTagName("tr");
		    		var calnum = 0;
		    		if(tval!=""){
		    			for(var i=1;i<tab.rows.length;i++){
		    			//str1.indexOf(str2)>=0  :str1 C str2
			    			if(row[i].cells[3].innerHTML.trim().indexOf(tval)>=0||row[i].cells[4].innerHTML.trim().indexOf(tval)>=0||row[i].cells[5].innerHTML.trim().indexOf(tval)>=0){
			    				row[i].style.display = "";
			    				row[i].className="trsearchresult";
			    			}else{
			    				row[i].style.display = "none";
			    				calnum++;
			    			}
			    		}
		    		}else{
		    			alert("查询值为空！");
		    			$('#search').attr("value","");
		    			return;
    				}
		    		if(calnum==tab.rows.length-1)
		    			alert("查无此人!");	
	    		}
    		});
    	$('#searchs').click(function(){
    		var tval = $('#search').val().trim();
    		var tab = document.getElementById("tab22");
    		var row = tab.getElementsByTagName("tr");
    		var calnum = 0;
    		if(tval!=""){
    			for(var i=1;i<tab.rows.length;i++){
	    			if(row[i].cells[3].innerHTML.trim().indexOf(tval)>=0||row[i].cells[4].innerHTML.trim().indexOf(tval)>=0){
	    				row[i].style.display = "";
	    				row[i].className="trsearchresult";
	    			}else{
	    				row[i].style.display = "none";
	    				calnum++;
	    			}
	    		}
    		}else{
    			alert("查询值为空！");
    			$('#search').attr("value","");
    			return;
    		}
    		if(calnum==tab.rows.length-1)
    			alert("查无此人!");	
    	});
    	/*     删除一个用户     */
		$('.delete').click(function(){
			var x = confirm("确定删除？！");
			var intd = $(this);
			var userids = $(this).parent().parent()[0].cells[4].innerHTML;
			if(x){
				$.post("<%=basePath %>DeleteUser",{userid:userids},
					function(data){
						if(data=="succ"){
							intd.parent().parent().remove();
							alert("删除成功!");	
							//window.location.reload();
						}
						if(data=="fail")
							alert("删除失败");
					}
				);
			}
		});
    	/*    修改用户信息传值    */
        $('.deliver').click(function () {
            var row = $(this).parent().parent();
            $('#userid').attr("value",row[0].cells[4].innerHTML);
            $('#username').attr("value",row[0].cells[3].innerHTML);
            $('#userdepart').find("option[value='"+row[0].id+"']").attr("selected",true);
        });
        /*    查看用户信息传值    */
         $('.deliverlk').click(function () {
            var row = $(this).parent().parent();
            $('#useridlk').attr("value",row[0].cells[4].innerHTML);
            $('#usernamelk').attr("value",row[0].cells[3].innerHTML);
            $('#userdepartlk').find("option[value='"+row[0].id+"']").attr("selected",true);
        });
        /*    提交检查    */
        $('#subchange').click(function(){
        	if($('#username').val().trim()==""){
        		alert("用户名不能为空");
        		$('#username').attr("value","");
        		return;
        	}
        	document.uduser.submit();
        });
    </script>
</html>