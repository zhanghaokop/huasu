<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>用户注册</title>
    <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
    <link rel="stylesheet" href="../styles/responsive.css">
    <!-- <link href="../styles/main.css" rel="stylesheet" /> -->
    <link rel="stylesheet" href="../styles/weui.min.css"/>
    <style>
        .weui-cells {
            font-size: 1.0625rem;
        }
        .weui-cells_radio .weui-check:checked+.weui-icon-checked:before {
            font-size: 1rem;
        }
        .weui-btn {
            font-size: 1.125rem;
        }
        .weui-select {
            height: 1.5rem;
            line-height: 1.5rem;
            padding-left: 0px;
        }
        .weui-vcode-btn {
            line-height: 22px;
            height: 22px;
        }
    </style>
</head>
<body>

<form action="register" method="post">
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">姓名：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" name="name" pattern="^[0-9a-z_\u4e00-\u9fa5]{1,10}$" placeholder="请输入真实姓名">
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">手机号：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="number" name="phone" pattern="^1(3|5|7|8|9)\d{9}$" placeholder="请输入手机号">
        </div>
        <div class="weui-cell__ft">
            <button type="button" class="weui-vcode-btn" style="position: relative;left: 0.75rem;font-size:0.9375rem;" onclick="getCode();">获取验证码</button>
        </div>
    </div>
    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">验证码：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" id="cd-code" placeholder="请输入验证码">
        </div>
    </div>

    <div class="weui-cell">
        <div class="weui-cell__hd"><label class="weui-label">公司名：</label></div>
        <div class="weui-cell__bd">
            <input class="weui-input" type="text" name="company" pattern="^[0-9a-z_\u4e00-\u9fa5]{1,30}$" placeholder="请输入所在公司">
        </div>
    </div>
<div style="display:none;">
    <input type="hidden" value="${openId}" name="openId" id="openId"/>
</div>
    <div class="weui-cells weui-cells_radio" style="margin-top:0">
        <label class="weui-cell weui-check__label" for="x11">
            <div class="weui-cell__bd">
                <p>男</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" class="weui-check" name="sex" value="男" id="x11" checked="checked">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
        <label class="weui-cell weui-check__label" for="x12">
            <div class="weui-cell__bd">
                <p>女</p>
            </div>
            <div class="weui-cell__ft">
                <input type="radio" name="sex" value="女" class="weui-check" id="x12">
                <span class="weui-icon-checked"></span>
            </div>
        </label>
    </div>
</form>
<div class="weui-btn-area" style="position:absolute;width: 92%;top:88%">
    <a class="weui-btn weui-btn_primary"  id="showTooltips" onclick="cd_submit()">确定</a>
</div>

<script src="../js/common.js" type="text/javascript"></script>
<script src="../js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script>
    var code,phone;
    function getCode(){
        var t;
        phone = $("input[name=phone]").val();
        if(!/^1(3|5|7|8|9)\d{9}$/.test(phone)){
            wxToast("手机号不正确");
            return;
        }
        $('.weui-vcode-btn').html('<span>60</span>秒后重新获取');
        t = setInterval(function(){
            var sec = parseInt($('.weui-vcode-btn span').html());
            if(sec==1){
                $('.weui-vcode-btn').attr('onclick','getCode();');
                $('.weui-vcode-btn').html('获取验证码');
                clearInterval(t);
            }else{
                sec--;
                $('.weui-vcode-btn span').html(sec);
                $('.weui-vcode-btn').removeAttr('onclick');
            }
        },1000);
        createCode();
    }
    function createCode() {
        $.ajax({
            url:"sms/" + phone,
            type:"get",
            success:function(res){
                if(res === 416){
                    wxToast("操作过于频繁");
                } else {
                    code = res;
                }
            }
        });
    }
    function cd_submit(){
        var _code = $('#cd-code').val();
        if(code!=_code){
            wxToast('验证码不正确');
            return;
        }
        for (var i = 0; i < $('input').length; i++) {
            if($('input').eq(i).attr('pattern')!=''){
                var pat = new RegExp($('input').eq(i).attr('pattern'),'ig');
                if(!pat.test($('input').eq(i).val())){
                    wxToast('输入格式不正确');
                    $('input').eq(i).focus();
                    break;
                    return;
                }else if(i==($('input').length-2)){
                    if($('input[name=phone]').val()!=phone){
                        wxToast('手机号码不一致');
                    }else{
                        $('form').submit();
                    }
                }
            }
        };
    }
</script>
</body>
</html>
