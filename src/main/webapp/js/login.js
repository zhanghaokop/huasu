function login(){
	$.ajax({
		url:ROUTE('/ajax_admin/login'),
		type:'get',
		dataType:'json',
		timeout:30000,
		data:{
			userName: $('input[name=userName]').val(),
			password: md5($('input[name=password]').val())
		},
		success:function(res){
			if(res.code==200){
				window.location.href = ROUTE('/admin/index');
			}else{
				TOAST(res.msg,'err');
			}
		}
	});
}
$(document).ready(function(){
	$('input[name=password]').focus();
	$('input[name=password]').blur();
});