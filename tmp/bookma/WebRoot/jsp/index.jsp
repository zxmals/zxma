<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>bookma-home</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <link rel="stylesheet" href="css/homepage.css">
        <script type="text/javascript" src="js/jquery.js" ></script>
    </head>
    <body>
        <div class="location">
            <div class="guide">
                <div class="focus" id="changeguide">
                    <a href="#">图书借阅管理</a><br><br><hr>
                </div>
                <div class="hideli">
                    <ul>
                        <li class="focus"><a href="jsp/book_type.jsp" target="showtimes" >类型设置</a></li>
                        <li class="focus"><a href="jsp/book_manage.jsp" target="showtimes" >图书档案</a></li>
                        <li class="focus"><a href="#" target="showtimes" >图书查询</a></li>
                        <li class="focus"><a href="#" target="showtimes" >图书统计</a></li>
                    </ul>
                </div>
            </div>
            <div class="showview">
                <iframe class="iframes"  name="showtimes"  src=""></iframe>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="js/homepage.js"></script>
</html>
