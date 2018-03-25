<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>我的维修</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link href="../styles/weui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../styles/responsive.css">
    <style>
        .none {
            display: none;
        }
        .weui-form-preview__hd .weui-form-preview__value {
            font-size: 1.1rem;
        }
    </style>
</head>
<body style="background-color: #efeeee;" data-scroll="0">
<c:forEach items="${list}" var="repair" >
    <div class="weui-form-preview">
        <div class="weui-form-preview__hd">
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">维修进度</label>
                <span class="weui-form-preview__value">${repair.status}</span>
            </div>
        </div>
        <div class="weui-form-preview__bd">
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">维修车牌号</label>
                <span class="weui-form-preview__value">${repair.plateNo}</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">维修单号</label>
                <span class="weui-form-preview__value">${repair.repairNo}</span>
            </div>
            <div class="weui-form-preview__item">
                <label class="weui-form-preview__label">故障描述</label>
                <span class="weui-form-preview__value">${repair.description}</span>
            </div>
            <div class="weui-form-preview__item none">
                <label class="weui-form-preview__label">公司名</label>
                <span class="weui-form-preview__value">${repair.subCompany}</span>
            </div>
            <div class="weui-form-preview__item none">
                <label class="weui-form-preview__label">提交时间</label>
                <span class="weui-form-preview__value"><fmt:formatDate value="${repair.submitTime}" type="both"/></span>
            </div>
            <div class="weui-form-preview__item none">
                <label class="weui-form-preview__label">指定维修点</label>
                <span class="weui-form-preview__value">${repair.assignstation}</span>
            </div>
            <div class="weui-form-preview__item none">
                <label class="weui-form-preview__label">实际维修点</label>
                <span class="weui-form-preview__value">${repair.actualstation}</span>
            </div>
            <div class="weui-form-preview__item none">
                <label class="weui-form-preview__label">维修结果</label>
                <span class="weui-form-preview__value">${repair.repairSolution}</span>
            </div>
        </div>
        <div class="weui-form-preview__ft">
            <a class="weui-form-preview__btn weui-form-preview__btn_primary" href="javascript:" onclick="repairHistoryInfo(this);">展开</a>
        </div>
    </div>
    </br>

</c:forEach>
</body>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<script>
    function repairHistoryInfo(obj){
        if($(obj).parent().prev().find('.none').css('display')=='none'){
            $(obj).parent().prev().find('.none').show();
            $(obj).html('收起');
        }else{
            $(obj).parent().prev().find('.none').hide();
            $(obj).html('展开');
        }
    }
</script>
</html>