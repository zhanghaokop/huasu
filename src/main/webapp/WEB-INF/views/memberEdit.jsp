<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0">
    <title>基本信息</title>
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
    <link rel="stylesheet" href="../styles/upload_portrait/page-common.css">
    <link rel="stylesheet" href="../styles/upload_portrait/upload.css">
    <link href="../styles/weui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../styles/responsive.css">
    <link rel="stylesheet" href="../styles/member_mainInfo.css">
    <style>
        .weui-cell__bd p {
            font-size: 1rem;
        }
        .weui-cell {
            padding: 0.625rem 0.9375rem;
            font-size: 1rem;
        }
        .weui-btn {
            font-size: 1.125rem;
        }
    </style>
</head>
<body>
<div id="wrap">
    <form action="/wxgzh/edit" method="post">
        <div class="page__bd">
            <div class="weui-cells" style="margin-top:10px">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>头像</p>
                    </div>
                    <div class="weui-cell__ft">
                        <div class="cd_portrait cd_portrait_border">
                            <p class="cd_text1 click1 cd_block">点击</p>
                            <p class="cd_text2 click2 cd_block">上传</p>
                            <input type="file" class="input_album upload-file" id="file" accept="image/*">
                            <input type="hidden" name="album" val="${Member.album}">
                        </div>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>姓名</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" class="" name="name" pattern="^[0-9a-z_\u4e00-\u9fa5]{1,10}$" value="${Member.name}">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>电话</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" class="" name="phone" pattern="^1(3|5|7|8|9)\d{9}$" value="${Member.phone}">
                    </div>
                </div>
            </div>
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>性别</p>
                    </div>
                    <div class="weui-cell__ft">
                        <select name="sex" class="">
                            <option <c:if test="Member.sex == '男'">selected="selected"</c:if>>男</option>
                            <option <c:if test="Member.sex == '女'">selected="selected"</c:if>>女</option>
                        </select>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>准驾车型</p><input id="hiddenDrivingType" type="hidden" value="${Member.drivingType}" />
                    </div>
                    <div class="weui-cell__ft">
                        <select name="drivingType" class="">
                            <option value="C1">C1</option>
                            <option value="A1">A1</option>
                            <option value="A2">A2</option>
                            <option value="A3">A3</option>
                            <option value="B1">B1</option>
                            <option value="B2">B2</option>
                            <option value="C2">C2</option>
                            <option value="C3">C3</option>
                            <option value="其它">其它</option>
                        </select>
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>出生日期</p>
                    </div>
                    <div class="weui-cell__ft">
                        <button id="showDatePicker" type="button"><fmt:formatDate value="${Member.birth}" type="date"></fmt:formatDate> </button>
                        <input type="hidden" name="birth" value="<fmt:formatDate value="${Member.birth}" type="date"></fmt:formatDate>">
                    </div>
                </div>        </div>
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>公司</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" class="" name="company" pattern="^[0-9a-z_\u4e00-\u9fa5]{1,30}$" value="${Member.company}">
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>通讯地址</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" class="" name="address" pattern="^[0-9a-z_\u4e00-\u9fa5]{1,30}$" value="${Member.address}">
                    </div>
                </div>
            </div>
        </div>
        <div class="btn-groups">
            <a href="javascript:;" class="weui-btn weui-btn_primary text btn-big" onclick="sub();">提交</a>
        </div>
    </form>
</div>
<div class="app" id="uploadPage" style="background: #000;">
    <div class="upload-loading">
        <span class="centerXY">
            <i class="fa fa-spinner fa-pulse fa-3x fa-fw"></i>
        </span>
    </div>
    <div class="bar">
        <a class="back pull-left" id="closeCrop" onclick="close();">
            取消
        </a>
        <a id="getFile" class="pull-right">确定</a>
    </div>
    <div class="main">
        <canvas class="upload-mask">

        </canvas>
        <div class="preview-box">
            <img id="preview"/>
        </div>
        <canvas class="photo-canvas">

        </canvas>
        <a id="rotateBtn">
            <i class="fa fa-rotate-right  fa-3x"></i>
            <div>旋转照片</div>
        </a>
    </div>
</div>
<!-- datePicker -->
<div style="display:none;" class="weui-mask weui-animate-fade-in"></div>
<div style="display:none;" class="weui-picker weui-animate-slide-up">
    <div class="weui-picker__hd">
        <a href="javascript:;" data-action="cancel" class="weui-picker__action">取消</a>
        <a href="javascript:;" data-action="select" class="weui-picker__action" id="weui-picker-confirm">确定</a>
    </div>
    <div class="weui-picker__bd">
        <div class="weui-picker__group">
            <div class="weui-picker__mask"></div>
            <div class="weui-picker__indicator"></div>
            <div class="weui-picker__content" style="transform: translate3d(0px, -374px, 0px);">
                <div class="weui-picker__item">1990年</div>
            </div>
        </div>
        <div class="weui-picker__group" style="display: block;">
            <div class="weui-picker__mask"></div>
            <div class="weui-picker__indicator"></div>
            <div class="weui-picker__content" style="transform: translate3d(0px, -102px, 0px);">
                <div class="weui-picker__item">1月</div>
            </div>
        </div>
        <div class="weui-picker__group" style="display: block;">
            <div class="weui-picker__mask"></div>
            <div class="weui-picker__indicator"></div>
            <div class="weui-picker__content" style="transform: translate3d(0px, -408px, 0px);">
                <div class="weui-picker__item">1日</div>
            </div>
        </div>
    </div>
</div>
</body>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<script src="https://res.wx.qq.com/open/libs/weuijs/1.0.0/weui.min.js"></script>
<script type="text/javascript" src="../js/upload_portrait/require.js"></script>
<script type="text/javascript" src="../js/upload_portrait/main.js"></script>
<script src="../js/upload_portrait/canvas-toBlob.js"></script>
<script type="text/javascript" src="../js/member_basic.js"></script>
<script type="text/javascript" src="../js/upload_portrait/upload_portrait.js"></script>
<script>
    var driving_type = $("#hiddenDrivingType").val();
    $('#showDatePicker').on('click', function () {
        var that = this;
        var text = $(this).html();
        if(text!=''){
            var y = text.split('-')[0];
            var m = text.split('-')[1];
            var d = text.split('-')[2];
            var defaultValue = [y,m,d];
        }else{
            var defaultValue = [new Date().getFullYear(), new Date().getMonth()+1, new Date().getDate()];
        }
        weui.datePicker({
            start: 1950,
            end: new Date().getFullYear(),
            defaultValue: defaultValue,
            onConfirm: function (result) {
                var yy = result[0];
                var mm = result[1]<10?'0'+result[1]:result[1];
                var dd = result[2]<10?'0'+result[2]:result[2];
                var m_str = yy+'-'+mm+'-'+dd;
                $(that).html(m_str);
                $('input[name=birth]').val(m_str);
            }
        });
    });
</script>
</html>
