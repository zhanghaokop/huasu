<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>常见问题列表</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link href="../styles/weui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../styles/responsive.css">
    <style>

    </style>
</head>
<body style="background-color: #efeeee;" data-scroll="0">
<div class="weui-search-bar" id="searchBar">
    <form class="weui-search-bar__form">
        <div class="weui-search-bar__box">
            <i class="weui-icon-search"></i>
            <input type="search" class="weui-search-bar__input" id="searchInput" placeholder="搜索" required="">
            <a href="javascript:" class="weui-icon-clear" id="searchClear"></a>
        </div>
        <label class="weui-search-bar__label" id="searchText">
            <i class="weui-icon-search"></i>
            <span>搜索</span>
        </label>
    </form>
    <a href="javascript:" class="weui-search-bar__cancel-btn" id="searchCancel">取消</a>
</div>
<div class="weui-cells__title">常见问题列表</div>
<div class="weui-cells">
    <c:forEach var="know" items="${list}">
        <a class="weui-cell weui-cell_access" href="javascript:;" data-id="${know.id}" onclick="errInfo(this);">
            <div class="weui-cell__bd">
                <p>${know.code} ${know.errorCode}</p>
            </div>
            <div class="weui-cell__ft">
            </div>
        </a>
    </c:forEach>
</div>
</body>
<script src="../js/common.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/base.js"></script>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/knowledge.js"></script>
</html>
