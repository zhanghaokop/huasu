<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/19
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../styles/weui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../styles/responsive.css">
    <link rel="stylesheet" href="../styles/member_mainInfo.css">
    <style>
        .weui-cell__bd p {
            font-size: 1rem;
        }
        .weui-cell {
            padding: 0.625rem 0.9375rem;
        }
        .click3 {
            width: 4.375rem;
        }
        .weui-cell__ft span {
            font-size: 1rem;
        }
        .weui-btn {
            font-size: 1.125rem;
        }
    </style>
</head>
<body>
<div id="wrap">
    <div class="page__bd">
        <div class="weui-cells" style="margin-top:10px">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>头像</p>
                </div>
                <div class="weui-cell__ft">
                    <div class="cd_portrait">
                        <c:choose>
                            <c:when test="${Member.album}">
                                <img src="../img/member/${Member.album}" class="click3">
                            </c:when>
                            <c:otherwise>
                                <img src="../img/default_member2.jpg" class="click3">
                            </c:otherwise>
                        </c:choose>
                        <%--<c:if test="${Member.album}">--%>
                            <%--<img src="../img/member/<%= result.album %>" class="click3">--%>
                        <%--</c:if>--%>
                        <%--<% if(${Member.album}{ %>--%>
                        <%--<img src="../img/member/<%= result.album %>" class="click3">--%>
                        <%--<% }else{ %>--%>
                        <%--<img src="../img/default_member2.jpg" class="click3">--%>
                        <%--<% } %>--%>
                    </div>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>姓名</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.name}</span>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>电话</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.phone}</span>
                </div>
            </div>
        </div>
        <div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>性别</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.sex}</span>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>准驾车型</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.driving_type}</span>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>出生日期</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.birth}</span>
                </div>
            </div>
        </div>
        <div class="weui-cells">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>公司</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.company}</span>
                </div>
            </div>
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <p>通讯地址</p>
                </div>
                <div class="weui-cell__ft">
                    <span class="text">${Member.address}</span>
                </div>
            </div>
        </div>
    </div>
    <div class="btn-groups">
        <a href="javascript:;" class="weui-btn weui-btn_primary text btn-big" onclick="edit();">编辑</a>
    </div>
</div>
</body>
<%--加入其他<%- include("../includes/scripts.ejs") %>--%>
<script>
    function edit(){
        window.location.href = ROUTE('/member/info_edit');
    }
</script>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
</body>
</html>
