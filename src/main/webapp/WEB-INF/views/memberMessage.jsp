<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>消息</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link href="../styles/weui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="../styles/responsive.css">
    <style>
        .weui-panel {
            margin: 0.625rem 0.625rem 0 0.625rem;
        }
        .weui-media-box__desc {
            margin-top: 0.625rem;
            -webkit-line-clamp: 10;
        }
        .weui-media-box {
            padding: 0.9375rem;
        }
        .weui-media-box__title {
            font-size: 1.0625rem;
        }
        .weui-media-box__desc {
            font-size: 0.8125rem;
        }
        .msg {
            margin-top: 0.625rem;
            text-indent: 1.625rem;
        }
        .icon-star {
            color: #BBB;
            position: relative;
            left: 0.5rem;
            top: -0.05rem;
            font-size: 1.2rem;
        }
        .mark {
            color: #FFD94A;
        }
    </style>
</head>
<body style="background-color: #efeeee;" data-scroll="0">
</body>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<script src="../js/message_render_template.js"></script>
<script src="../js/member_message.js"></script>
</html>