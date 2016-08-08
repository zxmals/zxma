<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>login-zxma</title>
        <link href="CSS/zxma.css" rel="stylesheet">
        <script type="text/javascript">
            function downlog() {
                var btn = document.getElementById("btn");
                btn.style.border = "2px inset";
            }
            function uplog() {
                var btn = document.getElementById("btn");
                btn.style.border = "thin outset";
            }
            function checkf() {
				var name = document.getElementById("userid").value;
				var pwd = document.getElementById("password").value;
				if(name==""||name==null){
					alert("请输~账号 ! ");
					return;
				}
				if(pwd==""||pwd==null){
					alert("请输入密码 ! ");
					return;
				}
				document.ls.submit();
			}
			function loads() {
				var lgstatus = "${lgstatus }"; 
				if(lgstatus!=null&&lgstatus!="")
					alert(lgstatus);
			}
        </script>
    </head>
    <body onload="loads()">
        <div class="loginc">           
	            	<div id="outd">
	                	<div id="dtitle"></div>
	                	 <form action="login" method="post"  name="ls" >
			                <div id="uid">
			                    <label>账号:</label><input type="text" name="userid"  id="userid">
			                </div>
			                <div id="pwd">
			                    <label>密码:</label><input type="password" name="password"  id="password">
			                </div>
		                </form>
		                <div id="sub">
		                    <button id="btn" onmousedown="downlog()" onmouseup="uplog()" onclick="checkf()">登&nbsp;&nbsp;&nbsp;录</button>
		                </div>
	            	</div>            
        </div>
    </body>
</html>