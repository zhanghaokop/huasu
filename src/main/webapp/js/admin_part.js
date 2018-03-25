$(document).on('mouseover','.dropdown>a,.dropdown-menu',function(){
	$('.dropdown-menu').show();
});
$(document).on('mouseout','.dropdown>a,.dropdown-menu',function(){
	$('.dropdown-menu').hide();
});
$(document).ready(function(){
	var height = window.innerHeight;
	var nav = $('.navbar ').height();
	$('.content,.content iframe,.sidebar-nav').height(height-nav-3);
}); 
function main(obj){
	if($('.dashboard-menu').hasClass('in')){
		$('.dashboard-menu').removeClass('in').addClass('out');
		$(obj).addClass('collapsed');
	}else{
		$('.dashboard-menu').removeClass('out').addClass('in');
		$(obj).removeClass('collapsed');
	}
}
function customer(obj){
	if($('.dd-menu').hasClass('in')){
		$('.dd-menu').removeClass('in').addClass('out');
		$(obj).addClass('collapsed');
	}else{
		$('.dd-menu').removeClass('out').addClass('in');
		$(obj).removeClass('collapsed');
	}
}
function adminInfo(obj){
	if($('.admin-menu').hasClass('in')){
		$('.admin-menu').removeClass('in').addClass('out');
		$(obj).addClass('collapsed');
	}else{
		$('.admin-menu').removeClass('out').addClass('in');
		$(obj).removeClass('collapsed');
	}
}
function check(obj){
	$('.sidebar-nav li').removeClass('active');
	$(obj).addClass('active');
	var name = $(obj).attr('data-iframe');
	window.frames["content"].location.href = ROUTE('/html/'+name+'.html');
}
function changePwd(){
	$('.admin-menu').removeClass('out').addClass('in');
	$('.admin-menu').prev().find('.collapsed').removeClass('collapsed');
	$('li[data-iframe=changePwd]').trigger('click');
}
function logout(){
	var r = confirm("确定离开此页");
	if(r==true){
		$.ajax({
            url:ROUTE('/ajax_part/logout'),
            type:"post",
            dataType:"json",
            success:function(res){
                window.location.reload();
            }
        });
	}
}