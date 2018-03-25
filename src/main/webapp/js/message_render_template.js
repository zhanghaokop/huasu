var template = {
	singleMsg: function(params){
		// if(params.mark){
		// 	var mark = '<span class="iconfont icon-star mark" onclick="star()" data-id="'+params.id+'"></span>';
		// }else{
		// 	var mark = '<span class="iconfont icon-star" onclick="star()" data-id="'+params.id+'"></span>';			
		// }
		var str = '<div class="weui-panel">'+
		            '<div class="weui-panel__bd">'+
		                '<div class="weui-media-box weui-media-box_text">'+
		                    '<h4 class="weui-media-box__title">'+params.title+'</h4>'+
		                    '<p class="weui-media-box__desc">'+params.postTime+'</p>'+
		                    '<p class="weui-media-box__desc" style="line-height:1.6">'+params.message+'</p>'+
		                '</div>'+
		            '</div>'+
		        '</div>';
		return str;
	},
	linkMsg: function(params){
		// if(params.mark){
		// 	var mark = '<span class="iconfont icon-star mark" onclick="star()" data-id="'+params.id+'"></span>';
		// }else{
		// 	var mark = '<span class="iconfont icon-star" onclick="star()" data-id="'+params.id+'"></span>';			
		// }
		var str = '<div class="weui-panel weui-panel_access">'+
		            '<a class="weui-panel__bd" href="'+params.url+'" style="color: black">'+
		                '<div class="weui-media-box weui-media-box_text">'+
		                    '<h4 class="weui-media-box__title">'+params.title+'</h4>'+
		                    '<p class="weui-media-box__desc">'+params.postTime+'</p>'+
		                    '<p class="weui-media-box__desc" style="line-height:1.6">'+params.message+'</p>'+
		                '</div>'+
		            '</a>'+
		            '<div class="weui-panel__ft">'+
		                '<a href="'+params.url+'" class="weui-cell weui-cell_access weui-cell_link">'+
		                    '<div class="weui-cell__bd">查看详情</div>'+
		                    '<span class="weui-cell__ft"></span>'+
		                '</a>'+
		            '</div>'+
		        '</div>';
		return str;
	},
	text: function(params){
		var str = '<div class="weui-panel">'+
		            '<div class="weui-panel__bd">'+
		                '<div class="weui-media-box weui-media-box_text">'+
		                    '<p class="weui-media-box__desc">'+JSON.stringify(params)+'</p>'+
		                '</div>'+
		            '</div>'+
		        '</div>';
		return str;
	},
}

var renderTemp = function(temp,params){
	try{
		return template[temp](params);
	}catch(e){
		return template['text'](params);
	}
}