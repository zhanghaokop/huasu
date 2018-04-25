<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="maximum-scale=1.0,minimum-scale=1.0,user-scalable=0,width=device-width,initial-scale=1.0">
    <title>基本信息</title>
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
        textarea {
            width: 100%;
            border: none;
            font-size: 1rem;
            resize: none;
        }
    </style>
</head>
<body>
<div id="wrap">
    <form action="" method="post">
        <div class="weui-cells weui-cells_form">
            <div class="weui-cell">
                <div class="weui-cell__bd">
                    <div class="weui-uploader">
                        <div class="weui-uploader__hd">
                            <p class="weui-uploader__title">请上传行驶证，驾驶证，故障照片。</p>
                        </div>
                        <div class="weui-uploader__bd">
                            <ul class="weui-uploader__files weui-uploader__file_status" id="uploaderFiles">
                            </ul>
                            <div class="weui-uploader__input-box">
                                <input id="uploaderInput" class="weui-uploader__input" type="file" accept="image/*" multiple="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>




        <div class="page__bd">
            <div class="weui-cells">
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>车牌号</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" name="plateNo" pattern="^[0-9a-zA-Z\u4e00-\u9fa5]{1,10}$" placeholder="请输入车牌号" >
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>单位名称</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" name="subCompany" pattern="^[0-9a-zA-Z\u4e00-\u9fa5]{1,10}$" placeholder="请输入所在单位" >
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <p>故障代码</p>
                    </div>
                    <div class="weui-cell__ft">
                        <input type="text" name="errorCode" pattern="^[0-9a-zA-Z]{0,10}$" placeholder="请输入故障代码" >
                    </div>
                </div>
                <div class="weui-cell">
                    <div class="weui-cell__bd">
                        <textarea name="description" placeholder="请描述故障现象" rows="5"></textarea>
                    </div>
                </div>
            </div>
        </div>
        <div class="btn-groups">
            <a href="javascript:;" class="weui-btn weui-btn_primary text btn-big" onclick="sub();">提交</a>
        </div>
    </form>
</div>
</body>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="../js/common.js" type="text/javascript"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=5pMjYGfmzv0AlkNkwxyRTWWCNwpHeqlc"></script>
<script src="../js/repair.js" type="text/javascript"></script>
</html>
