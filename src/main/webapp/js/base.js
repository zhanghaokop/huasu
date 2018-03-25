//移动端动态加载
function ScrollPage(opt){
	this.mark = 0;
	this.page = 1;
	this.url = opt.url;
	this.keywords = opt.keywords?opt.keywords:'';
	this.appendEle = opt.appendEle?opt.appendEle:'.weui-cells';
}
ScrollPage.prototype.getData = function(cb){
	if(this.mark==0){
		this.mark = 1;
	}else{
		return false;
	}
	if(this.page==1){
		$(this.appendEle).html('');
	}else{
		wxloadmore(this.appendEle);
	}
	var that = this;
	$.ajax({
		url:that.url,
		type:'get',
		dataType:'json',
		timeout:30000,
		data:{
			pageIndex: that.page,
			pageSize: 15,
			errorCode: that.keywords
		},
		success:function(res){
			$('.weui-loadmore,#loadingToast').remove();
			that.mark = 0;
			that.page++;
			cb(res);
		}
	});
}
ScrollPage.prototype.render = function(res){
	var that = this;
	var m_str = '';

	if(res.pageData && res.pageData.length > 0){

        for (var i = 0; i < res.pageData.length; i++) {
            try{
                var code = res.pageData[i].code?res.pageData[i].code:'';
                m_str += '<a class="weui-cell weui-cell_access" href="javascript:;" onclick="errInfo(this);" data-id="'+res.pageData[i].id+'">'+
                    '<div class="weui-cell__bd">'+
                    '<p>'+code+' '+res.pageData[i].errorCode+'</p>'+
                    '</div>'+
                    '<div class="weui-cell__ft">'+
                    '</div>'+
                    '</a>';
            }catch(e){

            }
        }

	} else {
        var msg = res.msg?res.msg:'没有更多了';
        wxToast(msg);
        that.mark = 1;
	}
	$(that.appendEle).append(m_str);
}