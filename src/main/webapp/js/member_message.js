var page = function(){
	var page = 1;
	return function(){
		page++;
		return page;
	}
}
var p = page();
$(document).ready(function(){
    $.get("msgList", function(res){
        render(res.pageData);
    })
	var height = window.innerHeight;
	window.onscroll = function(){
		var b = $('body').height();
		var s = $('body').scrollTop();
		var scroll = $('body').attr('data-scroll');
		if(b-height-s<20&&scroll==0){
			$('body').attr('data-scroll',1);
			wxloadmore('body');
			getList();
		}
	}
	sessionStorage.setItem("need-refresh", true);
});
function render(render_data){
	var str = '';
	for (var i = 0; i < render_data.length; i++) {
		var temp = render_data[i].model;
		str += renderTemp(temp,render_data[i]);
	};
	$('body').append(str);
}
function getList(){
	var page = p();
	$.ajax({
		url:"msgList",
		type:'get',
		dataType:'json',
		timeout:30000,
		data:{
			'pageIndxe':page
		},
		success:function(res){
			$('body').attr('data-scroll', 0);
			$('.weui-loadmore').remove();
			addList(res.pageData);
		}
	});
}
function addList(data){
	if(data==''){
		$('body').attr('data-scroll',1);
		wxToast('没有更多了');
		return;
	}
	render(data);
}