 var myCrop;
    require.config({
        urlArgs:"bust="+new Date
    })
    require(["jquery",'hammer','tomPlugin',"tomLib",'hammer.fake','hammer.showtouch'],function($,hammer,plugin,T){
        document.addEventListener("touchmove",function(e){
            e.preventDefault();
        })
        //初始化图片大小300*300

        var opts={cropWidth:200,cropHeight:200},
                $file=$("#file"),
                previewStyle={x:0,y:0,scale:1,rotate:0,ratio:1},
                transform= T.prefixStyle("transform"),
                $previewBox=$(".preview-box"),
                $rotateBtn=$("#rotateBtn"),
                $getFile=$("#getFile"),
                $preview=$("#preview"),
                $uploadPage=$("#uploadPage"),
                $mask=$(".upload-mask"),
                $loading=$(".upload-loading"),
                maskCtx=$mask[0].getContext("2d"),
        //这是插件调用主体
        myCrop=T.cropImage({
            bindFile:$file,//绑定Input file
//            bindFile:$needCropImg[0],//绑定一个图片
            enableRatio:false,//是否启用高清,高清得到的图片会比较大
            canvas:$(".photo-canvas")[0],  //放一个canvas对象
            cropWidth:opts.cropWidth,       //剪切大小
            cropHeight:opts.cropHeight,
            bindPreview:$preview,      //绑定一个预览的img标签
            useHammer:true,            //是否使用hammer手势，否的话将不支持缩放
            oninit:function(){

            },
            onChange:function(){
                $loading.show();
                resetUserOpts();
            },
            onLoad:function(data){
                //用户每次选择图片后执行回调
                previewStyle.ratio=data.ratio;
                $preview.attr("src",data.originSrc).css({width:data.width,height:data.height}).css(transform,'scale('+1/previewStyle.ratio+')');
                myCrop.setCropStyle(previewStyle)
                $loading.hide();

            }
        });
        function resetUserOpts(){
            $(".photo-canvas").hammer('reset');
            previewStyle={scale:1,x:0,y:0,rotate:0};
            $preview.attr("src",'')
        }
        $('#fileChooseButton').on('click',function(){
            setTimeout(function(){
                resetUserOpts();
            })
        })
        $(".photo-canvas").hammer({
            gestureCb:function(o){
                //每次缩放拖拽的回调
                $.extend(previewStyle,o);
//                console.log("用户修改图片",previewStyle)
                $preview.css(transform,"translate3d("+ previewStyle.x+'px,'+ previewStyle.y+"px,0) rotate("+previewStyle.rotate+"deg) scale("+(previewStyle.scale/previewStyle.ratio)+")")
            }
        })
        //选择图片
        $rotateBtn.on("click",function(){
            previewStyle.rotate+=90;
            if(previewStyle.rotate>=360){
                previewStyle.rotate-=360;
            }
            $(".photo-canvas").hammer('setRotate',previewStyle.rotate)
            myCrop.setCropStyle(previewStyle)
            $preview.css(transform,"translate3d("+ previewStyle.x+'px,'+ previewStyle.y+"px,0) rotate("+previewStyle.rotate+"deg) scale("+(previewStyle.scale/previewStyle.ratio)+")")
        })
        //获取图片并关闭弹窗返回到表单界面
        $getFile.on("click",function(){
            var cropInfo;
            $uploadPage.hide();
            myCrop.setCropStyle(previewStyle)
            cropInfo=myCrop.getCropFile({});  //里面有data
            cropInfo.dfd.done(function(blob){
                var formData=new FormData;
                if(blob){
                    blob.name='file';
                    formData.append("file",blob);
                    wxLoadToast('正在上传');
                    $.ajax({
                        url:ROUTE('/huasu/wxgzh/file/upload'),
                        type:"post",
                        data:formData,
                        processData:false,
                        contentType: false,
                        dataType:"json",
                        success:function(data){
                            $('#loadingToast').remove();
                            wxToast('上传成功');
                            $('input[name=album]').val(data.data[0]);
                            $('.cd_block').remove();
                            $('.cd_portrait').css({
                                'background-image': 'url(/huasu/wxgzh/file/render?fileName='+data.data[0]+')',
                                'background-size': '100% 100%'
                            });
                            $('.cd_portrait_border').css({
                                'border': 'none'
                            });
                        }
                    });
                }
            });
        })
        //上传文件按钮&&关闭弹窗按钮
        $(document).delegate("#file","click",function(){
            var c=document.getElementById("file")
            c.value='';
            $uploadPage.show();
        }).delegate("#closeCrop","click",function(){
            $uploadPage.hide();
            resetUserOpts();
            myCrop.setCropStyle(previewStyle)
        })
        $file.one("click",showCropModal);

        function showCropModal(){
            setTimeout(function(){
                $uploadPage.show();
                $mask.prop({width:$mask.width(),height:$mask.height()})
                maskCtx.fillStyle="rgba(0,0,0,0.7)";
                maskCtx.fillRect(0,0,$mask.width(),$mask.height());
                maskCtx.strokeStyle='white';
                maskCtx.lineWidth='2'
                maskCtx.clearRect(($mask.width()-opts.cropWidth)/2,($mask.height()-opts.cropHeight)/2,opts.cropWidth,opts.cropHeight)
                maskCtx.strokeRect(($mask.width()-opts.cropWidth)/2-1,($mask.height()-opts.cropHeight)/2-1,opts.cropWidth+2,opts.cropHeight+2);//Add a subpath with four points
            })
        }
        function close(){
            $uploadPage.hide();
        }
    })
