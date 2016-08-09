<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>add-Pro</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <link rel="stylesheet" type="text/css" href="CSS/div.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
        <script type="text/javascript">
            function checkpwd() {
                var p1 = document.getElementById("pwd1").value;
                var p2 = $.trim(document.getElementById("pwd2").value);
                if(p1!=p2){
                    alert("两次密码输入不一致");
                    document.getElementById("pwd2").value = "";
                }
            }

			function loads() {
				var addstatus = "${addstatus }";
				if(addstatus != "")
					alert(addstatus);
			}
            function checknull() {
                var id = $.trim(document.getElementById("userid").value);
                var name = $.trim(document.getElementById("username").value);
                var p1 = $.trim(document.getElementById("pwd1").value);
                var p2 = $.trim(document.getElementById("pwd2").value);
                if(id==""){
                    alert("用户ID不能为空/空格");
                    return;
                }
                if(name==""){
                    alert("用户姓名不能为空/空格");
                    return;
                }
                if(p1==""){
                    alert("口令不能为空/空格");
                    return;
                }
                if(p2==""){
                    alert("确认口令不能为空/空格");
                    return;
                }
                document.f.submit();
            }
        </script>
    </head>
    <body onload="loads()">
        <div style="margin-top: 60px;margin-left: 320px">
                <form action="AddUser" method="post" name="f">
                    <table class="stab">
                        <tr>
                            <td class="tdtype"><span>*</span>用户ID</td>
                            <td><input type="text" name="YHID" id="userid"></td>
                            <td class="tdtype"><span>*</span>口令</td>
                            <td><input type="password" name="YHKL" id="pwd1"></td>
                            <td class="tdtype"><span>*</span>确认口令</td>
                            <td><input type="password" name="pwd2" id="pwd2" onchange="checkpwd()"></td>
                        </tr>
                        <tr>
                            <td class="tdtype"><span>*</span>姓名</td>
                            <td><input type="text" name="YHXM" id="username" ></td>
                            <td class="tdtype">性别</td>
                            <td>
                                <select name="YHXB">
                                    <option value="male">男</option>
                                    <option value="female">女</option>                                    
                                    <option value="other" selected="selected"></option>
                                </select>
                            </td>
                            <td class="tdtype">部门</td>
                            <td>
                                <select name="YHBM">                                 
                                    <option value="" selected="selected"></option>
                                    <c:forEach  items="${depart }"  var="dep">
                                    	<option value="${dep.BMDM }">${dep.BMMC }</option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="tdtype">出生日期</td>
                            <td><input type="text" name="CSRQ"></td>
                            <td class="tdtype">排序号</td>
                            <td><input type="text" name="PXH"></td>
                            <td class="tdtype">禁用</td>
                            <td><input type="checkbox" name="SFJY"></td>
                        </tr>
                    </table>
                </form>
            <input style="margin-left: 350px" type="submit" value="保存" onclick="checknull()">
            <input type="button" value="返回" onclick="window.location.replace('First.html')">
        </div>
    </body>
</html>
