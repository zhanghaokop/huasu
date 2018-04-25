$(document).ready(function(){
	var uploading = false;
	$('#uploaderInput').change(function(e){
		if(uploading){
			e.preventDefault();
			wxToast('请等待上传完毕');
			return;
		}
		var len = e.target.files.length;
		var str = '';
		var formData = new FormData();
		for (var i = 0; i < len; i++) {
			str += '<li class="weui-uploader__file weui-uploader__file_status up" style="background-image:url(../img/wx_pic.png)"><div class="weui-uploader__file-content"><i class="weui-loading"></i></div></li>';
	        formData.append("file", e.target.files[i]);
		};
		$('#uploaderFiles').append(str);
		uploading = true;
		$.ajax({
            url: "/huasu/wxgzh/file/upload",
            type: 'POST',
            data: formData,
			dataType:"json",
            cache: false,
            contentType: false, //不可缺参数
            processData: false, //不可缺参数
            success: function(data) {
            	uploading = false;
            	var album;
				data.data.forEach(function(items,index){
					items = items.replace('\\','/');
					$('#uploaderFiles .up').eq(index).css({
						'background-image': 'url(/huasu/wxgzh/file/render?fileName='+items+')'
					});
					album += items + ",";
				});

				if (album) {
                    $('form').append('<input type="hidden" name="album" value="'+ album +'" />');
				}
				$('#uploaderFiles .up .weui-uploader__file-content').remove();
				$('.up').removeClass('up');
            }
        });
	});
	getLocation();
});
function sub(){
	var $ele = $('input,textarea');
	for (var i = 0; i < $ele.length; i++) {
		var pat = new RegExp($ele.eq(i).attr('pattern'),'ig');
		var v = $ele.eq(i).val();
		if(!pat.test(v)){
			wxToast('输入不合法');
			$ele.eq(i).focus();
			break;
		}else if(i==$ele.length-1){
			$('form').submit();
		}
	};
}
function getLocation(){
	var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
		var lng = r.point.lng;
		var lat = r.point.lat;
		$('form').append('<input type=hidden name="lng" value="'+lng+'" >');
		$('form').append('<input type=hidden name="lat" value="'+lat+'" >');
	});
}