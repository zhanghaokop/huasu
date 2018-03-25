<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>${code.errorCode}</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link href="/styles/weui.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/styles/responsive.css">
</head>
<body>
<div class="weui-panel__hd">${code.errorCode}</div>
<div class="weui-panel__bd">
    <div class="weui-media-box weui-media-box_text">
        <h4 class="weui-media-box__title">车型</h4>
        <p class="weui-media-box__desc">${code.type}</p>
    </div>
    <div class="weui-media-box weui-media-box_text">
        <h4 class="weui-media-box__title">故障分析</h4>
        <p class="weui-media-box__desc">${code.analysis}</p>
    </div>
    <div class="weui-media-box weui-media-box_text">
        <h4 class="weui-media-box__title">解决方案</h4>
        <p class="weui-media-box__desc">${code.plan}</p>
    </div>
</div>
</body>
</html>
