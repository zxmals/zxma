<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
        "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>bookma-bookManage</title>
        <meta http-equiv="content-type" content="text/html;charset=utf-8">
        <link rel="stylesheet" href="../css/book_manage.css" />
        <link rel="stylesheet" href="../css/leanModalCss.css" />
        <link rel="stylesheet" href="../css/modaldialog.css" />
        <script type="text/javascript" src="../js/jquery.js" ></script>
        <script type="text/javascript" src="../js/jquery.leanModal.min.js"></script>
    </head>
    <body>
        <div class="mainloaction">
            <div class="search">
                <div class="decoration">
                    <table>
                        <tr>
                            <td>类型:</td>
                            <td><input type="text"></td>
                            <td>书名:</td>
                            <td><input type="text"></td>
                            <td>图书编码:</td>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <td>期刊号:</td>
                            <td><input type="text"></td>
                            <td>出版社:</td>
                            <td><input type="text"></td>
                            <td>作者:</td>
                            <td><input type="text"></td>
                        </tr>
                        <tr>
                            <td>出版起止时间:</td>
                            <td colspan="3"><input type="text">  -至- &nbsp;<input type="text"></td>
                            <td>架号:</td>
                            <td><input type="text"></td>
                        </tr>
                    </table>
                </div>
                <hr >
                <div class="outoperate">
                    <a href="#">查询</a>&nbsp;
                    <a href="#addORupdate" rel="leanModal">新增</a>
                </div>
                <hr >
            </div>
            <div class="result">
                <div>
                    <table>
                        <tr>
                            <th>类型</th>
                            <th>图书编码</th>
                            <th>书名</th>
                            <th>作者</th>
                            <th>期刊号</th>
                            <th>出版社</th>
                            <th>出版时间</th>
                            <th>架号</th>
                            <th>状态</th>
                            <th><a href="#">浏览</a>   <a href="#">编辑</a>   <a href="#">删除</a></th>
                        </tr>
                        <tr class="rowsmove">
                            <td>类型</td>
                            <td>图书编码</td>
                            <td>书名</td>
                            <td>作者</td>
                            <td>期刊号</td>
                            <td>出版社</td>
                            <td>出版时间</td>
                            <td>架号</td>
                            <td>状态</td>
                            <td><a href="#browse" rel="leanModal">浏览</a>   <a href="#addORupdate" rel="leanModal">编辑</a>   <a href="#">删除</a></td>
                        </tr>
                        <tr class="rowsmove">
                            <td>类型</td>
                            <td>图书编码</td>
                            <td>书名</td>
                            <td>作者</td>
                            <td>期刊号</td>
                            <td>出版社</td>
                            <td>出版时间</td>
                            <td>架号</td>
                            <td>状态</td>
                            <td><a href="#browse" rel="leanModal">浏览</a>   <a href="#addORupdate" rel="leanModal">编辑</a>   <a href="#">删除</a></td>
                        </tr>
                    </table>
                </div>
                <div class="numpage">
                    共XX页&nbsp;第X/X页&nbsp;<a href="#">首页</a>&nbsp;<a href="#">上一页</a>&nbsp;<a href="#">下一页</a>&nbsp;<input type="text"><a href="#">&nbsp;跳转</a>
                </div>
            </div>
        </div>
        <!--      leanModal-browse-bookINf       -->
    <div id="browse">
       <a href="#"><img class="close_modal" src="../img/back.png" alt=""></a>
        <div class="reptitle"><h4>图书档案信息</h4><hr></div>
        <div class="bookinf">
            <table>
                <tr>
                    <td>图书编码</td>
                    <td colspan="3"><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>类型</td>
                    <td><input type="text" class="fillin"></td>
                    <td>期刊号</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>书名</td>
                    <td><input type="text" class="fillin"></td>
                    <td>作者</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td><input type="text" class="fillin"></td>
                    <td>出版时间</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>架号</td>
                    <td><input type="text" class="fillin"></td>
                    <td>状态</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>标价</td>
                    <td><input type="text" class="fillprice">元</td>
                    <td>实际购买价</td>
                    <td><input type="text" class="fillprice">元</td>
                </tr>
                <tr>
                    <td>内容简介</td>
                    <td colspan="3"><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>登记人</td>
                    <td><input type="text" class="fillin"></td>
                    <td>登记时间</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
            </table>
        </div>
        <div class="reptitle"><h4>图书借阅情况明细</h4><hr></div>
        <div class="brrowinf">
            <table>
                <tr>
                    <th>序号</th>
                    <th>借阅人</th>
                    <th>借阅日期</th>
                    <th>续借情况</th>
                    <th>归还日期</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                    <td>1</td>
                </tr>
            </table>
        </div>
    </div>
        <!--           leanModal-addBookINF           -->
    <div id="addORupdate">
        <br><a href="#" style="margin-left: 80%;">新增</a>   <a href="#">保存</a>   <a href="#"><img class="close_modal" src="../img/back.png" alt=""></a>
        <div class="reptitle"><h4>图书档案信息</h4><hr></div>
        <div class="bookadd">
            <table>
                <tr>
                    <td>图书编码</td>
                    <td colspan="3"><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>类型</td>
                    <td><input type="text" class="fillin"></td>
                    <td>期刊号</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>书名</td>
                    <td><input type="text" class="fillin"></td>
                    <td>作者</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>出版社</td>
                    <td><input type="text" class="fillin"></td>
                    <td>出版时间</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>架号</td>
                    <td><input type="text" class="fillin"></td>
                    <td>状态</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>标价</td>
                    <td><input type="text" class="fillprice">元</td>
                    <td>实际购买价</td>
                    <td><input type="text" class="fillprice">元</td>
                </tr>
                <tr>
                    <td>内容简介</td>
                    <td colspan="3"><input type="text" class="fillin"></td>
                </tr>
                <tr>
                    <td>登记人</td>
                    <td><input type="text" class="fillin"></td>
                    <td>登记时间</td>
                    <td><input type="text" class="fillin"></td>
                </tr>
            </table>
        </div>
    </div>
    </body>
    <script type="text/javascript" src="../js/book_manage.js"></script>
</html>