removeAD();
function ROUTE(url){
	return 'http://www.hsxnyqc.com'+url;
}
function TOAST(str,type,n){
	if(type=='info'||!type){
		var icon = 'icon-gou';
		var color = '#3e4a61';
	}else if(type=='err'){
		var icon = 'icon-cha';
		var color = '#3e4a61';
	}
    var html = '<div id="my-toast" class="k-overlay" style="display: block; z-index: 99; opacity: 0.4;"></div>'+
    			'<div id="hs_modal" style="width: 100%;height: 100%;position: fixed;top:0;z-index: 100;">'+
	        		'<div style="display:flex;color:white;width:auto;height: auto;min-width: 250px;max-width: 500px;min-height: 125px;border-radius:7px;padding: 18px 30px;position: absolute;top:50%;left: 50%;box-shadow: 0 2px 2px 0 rgba(0,0,0,.3);transform: translate(-50%,-50%);background: '+color+';">'+
	                    '<div class="iconfont '+icon+'" style="display:flex;align-items: center;font-size:45px;margin-right: 20px;"></div>'+
	                    '<div style="letter-spacing: 1px;display:flex;align-items:center;font-size:20px;word-wrap: break-word;">'+str+'</div>'+
	                '</div>'+
	        	'</div>';
    window.top.$("body").append(html);
    if(!n){
    	setTimeout(function(){
	        CANCEL();
	    },1500);
    }
}
function CANCEL(){
	window.top.$('#my-toast,#hs_modal').remove();
}
function wxLoadToast(text){
	var str = '<div id="loadingToast">'+
			        '<div class="weui-mask_transparent"></div>'+
			        '<div class="weui-toast">'+
			            '<i class="weui-loading weui-icon_toast"></i>'+
			            '<p class="weui-toast__content">'+text+'</p>'+
			        '</div>'+
			    '</div>';
	$('body').append(str);
}
function wxToast(text){
  if($('#toast').length>0){
      return;
  }
	var str = '<div id="toast">'+
		        '<div class="weui-mask_transparent"></div>'+
		        '<div class="weui-toast">'+
		            '<i class="weui-icon-success-no-circle weui-icon_toast"></i>'+
		            '<p class="weui-toast__content">'+text+'</p>'+
		        '</div>'+
		    '</div>';
	$('body').append(str);
	setTimeout(function(){
		$('#toast').remove();
	},2000);
}
var DATE = function(t){
  if(t){
    var date = new Date(t);
  }else{
    var date = new Date();
  }
  var yy = date.getFullYear();
  var MM = date.getMonth()+1;
  var dd = date.getDate();
  if(MM<10) MM ='0'+MM;
  if(dd<10) dd ='0'+dd;
  var time = yy + '-' + MM + '-' + dd;
  return time;
}
var KENDODATE = function(t){
  if(t){
    var date = new Date(t);
  }else{
    var date = new Date();
  }
  var yy = date.getFullYear();
  var MM = date.getMonth()+1;
  var dd = date.getDate();
  if(MM<10) MM ='0'+MM;
  if(dd<10) dd ='0'+dd;
  // var time = yy + '-' + MM + '-' + dd;
  var time = MM + '/' + dd + '/' + yy;
  return time;
}
var DATETIME = function(t){
  if(t){
    var date = new Date(t);
  }else{
    var date = new Date();
  }
  var yy = date.getFullYear();
  var MM = date.getMonth()+1;
  var dd = date.getDate();
  if(date.getHours()<10){
    var HH = '0'+date.getHours();
  }else{
    var HH = date.getHours();
  }
  if(date.getMinutes()<10){
    var mm = '0'+date.getMinutes();
  }else{
    var mm = date.getMinutes();
  }
  if(date.getSeconds()<10){
    var ss = '0'+date.getSeconds();
  }else{
    var ss = date.getSeconds();
  }
  var time = yy + '-' + MM + '-' + dd +' '+HH+':'+mm+':'+ss;
  return time;
}
function wxloadmore(el){
  var str = '<div class="weui-loadmore">'+
            '<i class="weui-loading"></i>'+
            '<span class="weui-loadmore__tips">正在加载</span>'+
        '</div>';
  $(el).append(str);
}
function reload(msg){
  wxToast(msg);
  setTimeout(function(){
    window.location.reload();
  },2000);
}
function isIE(){
  if(window.navigator.userAgent.indexOf("MSIE")>=1){
      return 1;
  }else{
      if(window.navigator.userAgent.toLowerCase().indexOf("trident") > -1 && window.navigator.userAgent.indexOf("rv") > -1){
          return 1;
      }else{
          return 0;
      }
  }
}
function removeAD(){
    setTimeout(function(){
        $("div[id^='ad']").remove();
    },2000);
}