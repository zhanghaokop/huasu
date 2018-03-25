$(document).ready(function(){
    $('select[name=drivingType] option').each(function () {
		if ($(this).html() === driving_type) {
			$(this).attr("selected",true);
		}

    });
	// $('select[name=drivingType]').val(driving_type);
    $('#showDatePicker').click(function(){
    	var date = $(this).html();
    });
});
function sub(){
	$('input').each(function(i){
		if($(this).attr('pattern')!=''){
			var pat = new RegExp($(this).attr('pattern'),'ig');
			if(!pat.test($(this).val())&&$(this).val()!=''){
				wxToast('输入格式不正确');
				$(this).focus();
				return;
			}else if(i==($('input').length-1)){
				$('form').submit();
			}	
		}
	});
}