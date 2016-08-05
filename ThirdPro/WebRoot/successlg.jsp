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
        <link rel="stylesheet" type="text/css" href="CSS/div.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
        <script type="text/javascript">
            function change(obj) {
                obj.style.background = '#adff2f';
            }
            function out(obj) {
                obj.style.background = '#87CEEB';
            }
            function onloads() {
//                alert("in");
                var tab = document.getElementById("tab22");
                var row = tab.getElementsByTagName("tr");
                for(var i=0;i<row.length;i++){
                    if((i+1)%2==0){
                        row[i].className = "trblack";
                    }
                }
            }
            
            $(document).ready(function(){    	              
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
                 onloads();
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
                    <form action=""  method="post">
                        账号/姓名:<input name="userid" type="text">
                        <input type="submit" value="查询">
                        <input type="button" value="新增" onclick="window.location.replace('Second.html')">
                        <span style="margin-left: 300px;margin-bottom: 20px">欢迎${login_inf.YHXM }登录 : 测试  <a href="logout"  style="color: green;text-decoration: none">注销</a></span>
                    </form>                    
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
                    		<td><a href="#" onclick="dosth()" style="text-decoration:none;">【查看】</a></td>
	                        <td><a href="#" onclick="dosth()" style="text-decoration:none;">【修改】</a></td>
	                        <td><a href="#" style="text-decoration:none;" onclick="deleterow('1')">【删除】</a></td>
	                        <td>${sing.YHXM }</td>
	                        <td>${sing.BMMC }</td>
                    	</tr>
                    </c:forEach>                    
                </table>
            </div>
        </div>
    </body>
</html>