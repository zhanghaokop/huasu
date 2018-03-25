var map;		//百度地图实例
var pool = [];	//数据池
var t=null;		//轨迹定时器
var polyline_arr = [];//轨迹数组点
var trace_maker;//轨迹红点
var trace_label;//轨迹label
$(document).ready(function(){
	getData();
	initMap();
	initDatePicker();
    if(isIE()){
    	$('.keywords').css('top','-25px');
    }
});
//一级checkbox监听
$(document).on('change','.cpy>label>input[type=checkbox]',function(){
	var ele_cpy = $(this).parent();
	var ele_car = $(this).parent().parent();
	if($(this).prop('checked')==true){
		if(ele_car.next().hasClass('list-group')){
			//添加所有checked
			ele_car.next().find('.second_check').prop('checked',true).change();
		}else{
			ele_cpy.next().trigger('click');
		}
	}else{
		//移除所有checked
		ele_car.next().find('.second_check').prop('checked',false).change();
	}
});
$(document).on('change','.second_check',function(){
	if($(this).prop('checked')==true){
		$(this).parent().addClass('checked');
		$(this).parent().removeClass('not_checked');
	}else{
		$(this).parent().addClass('not_checked');
		$(this).parent().removeClass('checked');
	}
	listenChange(this);
});
$(document).on('click','.list-group-item',function(e){
	//清除轨迹
	clearInterval(t);
	map.removeOverlay(trace_label);
	map.removeOverlay(trace_maker);

	polyline_arr.forEach(function(items,index){
		map.removeOverlay(items);
	});
	//判断是否显示点
	if($(this).find('.second_check').prop('checked')){
		$(this).find('.second_check').prop('checked',false).change();
	}else{
		$(this).find('.second_check').prop('checked',true).change();
	}
	e.stopPropagation();
});
$(document).on('click','.more',function(e){
	e.stopPropagation();
	$('#menu').show();
	$('.input_car').val($(this).parent().attr('data-imei'));
	$('#map').height('86%');
	$('#menu').height('14%');
	var width = $('body').width();
	$('#content').css('width',width-320);
});
/**
 * [initDatePicker]
 */
function startChange() {
    var startDate = start.value(),
    endDate = end.value();

    if (startDate) {
        startDate = new Date(startDate);
        startDate.setDate(startDate.getDate());
        end.min(startDate);
    } else if (endDate) {
        start.max(new Date(endDate));
    } else {
        endDate = new Date();
        start.max(endDate);
        end.min(endDate);
    }
}
function endChange() {
    var endDate = end.value(),
    startDate = start.value();

    if (endDate) {
        endDate = new Date(endDate);
        endDate.setDate(endDate.getDate());
        start.max(endDate);
    } else if (startDate) {
        end.min(new Date(startDate));
    } else {
        endDate = new Date();
        start.max(endDate);
        end.min(endDate);
    }
}
function initDatePicker(){
	var today = new Date();
    var stamp = Date.parse(new Date())-3600*24*1000;
    var yesterday = new Date(stamp);
    var start = $("#datetimestart").kendoDateTimePicker({
        value: yesterday,
        change: startChange,
        parseFormats: ["MM/dd/yyyy"]
    }).data("kendoDateTimePicker");

    var end = $("#datetimeend").kendoDateTimePicker({
        value: today,
        change: endChange,
        parseFormats: ["MM/dd/yyyy"]
    }).data("kendoDateTimePicker");

    start.max(end.value());
    end.min(start.value());
}
/**
 * [initMap]
 * 获取当前坐标，显示地图
 */
function initMap(){
	map = new BMap.Map("map_content");
    map.enableScrollWheelZoom(true);
    map.addControl(new BMap.NavigationControl());
    map.centerAndZoom();
    var geolocation = new BMap.Geolocation();
	geolocation.getCurrentPosition(function(r){
			var marker = new BMap.Marker(r.point);
			map.addOverlay(marker);
			map.centerAndZoom(r.point, 15);
	},{enableHighAccuracy: true});
}
/**
 * [getData]
 * 公司名和IMEI数量
 */
function getData(){
	$.ajax({
        url:ROUTE('/position/list'),
        type:"get",
        dataType:"json",
        success:function(res){
            renderCompany(res.data);
        }
    });
}
function renderCompany(data){
	var str = '';
	for (var i = 0; i < data.length; i++) {
		str += '<li class="cpy">'+
			        '<label class="weui-switch-cp">'+
			            '<input class="weui-switch-cp__input" type="checkbox">'+
			            '<p class="weui-switch-cp__box"></p>'+
			        '</label>'+
			        '<p class="company" onclick="toggleShow(this);">'+data[i].company+'</p>'+
			        '<p class="num" onclick="toggleShow(this);">（'+data[i].num+'）</p>'+
			        '<p class="show iconfont icon-sanjiaoxing toggle_show" onclick="toggleShow(this);"></p>'+
			    '</li>';
	};
	$('.list>ul').append(str);
}
/**
 * [toggleShow]
 * 点击公司，获取gps点信息，加入数据池
 */
function toggleShow(obj){
	var ele = $(obj).parent();
	if(!ele.attr('data-list')){
		//加载
		var company = $(obj).parent().find('.company').text();
		$.ajax({
	        url:ROUTE('/position/list_car'),
	        type:"get",
	        dataType:"json",
	        data: {
	        	company: company
	        },
	        success:function(res){
	        	ele.attr('data-list',true);
	        	res.data.forEach(function(items,index){
	        		pool.push(items);
	        	});
	            renderCar(obj,res.data);
	        }
	    });
	}else{
		var style = $(obj).parent().next().css('display');
		if(style=='none'){
			$(obj).parent().find('.show').removeClass('toggle_show');
			$(obj).parent().next().slideDown();
		}else{
			$(obj).parent().find('.show').addClass('toggle_show');
			$(obj).parent().next().slideUp();
		}
	}
}
function renderCar(obj,data){
	// console.log(JSON.stringify(data));
	var str = '<li class="list-group" style="display:none;">';
	for (var i = 0; i < data.length; i++) {
		str +=  '<a href="#" class="list-group-item" data-imei="'+data[i].imei+'">'+
					// '<label>'+	
						'<input type="checkbox" class="second_check" style="display:none"/>'+	
						'<span class="_plate_no" style="margin-left: 10px;width:75px;">'+data[i].plate_no+'</span>'+
					// '</label>'+
					'<span class="speed" style="margin-left: 20px;">'+data[i].speed+'</span>'+
					'<span style="margin-left: 10px;">km/h</span>'+
					'<span style="margin-left: 20px;" class="more">查看轨迹</span>'+
					'</br>'+
					'<span style="margin-left: 10px;position: relative;top: 7px;">总里程：'+data[i].total_mile/1000+' km</span>'+
				'</a>';    
	};
	str += '</li>';
	$(obj).parent().after(str);
	$(obj).parent().find('.show').removeClass('toggle_show');
	$(obj).parent().next().slideDown();
	//一级checkbox为true,addClass(checked),显示所有点
	//只执行一次
	if($(obj).parent().find('input[type=checkbox]').prop('checked')){
		$(obj).parent().next().find('.second_check').prop('checked',true).change();
	}
	updateInfo();
}
//开启轮询
function updateInfo(){
	if($('.time').css('display')=='none'){
		$('.time').show();
		setInterval(function(){
			var num = parseInt($('.t_num').text());
			if(num==0){
				requestInfo();
				num = 10;
			}else{
				num--;
			}
			$('.t_num').text(num);
		},1000);
	}
}
//更新数据					//---------------------------
function requestInfo(){
	var imei_arr = [];
	pool.forEach(function(items,index){
		imei_arr.push(items.imei);
	});
	$.ajax({
        url:ROUTE('/position/updateInfo'),
        type:"post",
        dataType:"json",
        data: {
        	imei_arr: JSON.stringify(imei_arr)
        },
        success:function(res){
            pool = res.data;
            // console.log(JSON.stringify(pool));
        	pool.forEach(function(items,index){
            	$('.list-group-item').each(function(){
            		if(items.imei==$(this).attr('data-imei')){
            			$(this).find('.speed').text(items.speed);
            		}
            	});
            });
            if(t==null){
	        	map.clearOverlays();
	        	var m_pool = pool.slice(0);
	        	$('.list-group-item').each(function(){
	        		var checked = $(this).hasClass('checked');
	        		if(!checked){
	        			var imei = $(this).attr('data-imei');
	        			m_pool.forEach(function(items,index){
	        				if(items.imei==imei){
	        					m_pool.splice(index,1);
	        				}
	        			});
	        		}
	        	});
	        	showPointStatic(m_pool);
	        }
        }
    });
}
//添加指定点
function showPoint(data){
	data.forEach(function(items,index){
        var point = new BMap.Point(items.lng,items.lat);
        var marker = new BMap.Marker(point);
        map.addOverlay(marker); 
        map.centerAndZoom(point, 15);

        var label = new BMap.Label(items.plate_no, {
        	position: point,
        	offset: new BMap.Size(-32, -60) 
        });
        label.setStyle({
			"color": "#fff",
			"background": '#f00',
			"height" : "30px",
			"padding": '4px',
			"border-radius": '3px',
			"opacity": 0.9
		 });
        map.addOverlay(label); 

        var text = '<table>'+
    					'<tr><td>IEME：</td><td>'+items.imei+'</td></tr>'+
    					'<tr><td>车牌：</td><td>'+items.plate_no+'</td></tr>'+
    					'<tr><td>电压：</td><td>'+items.powerValue+' V</td></tr>'+
    					'<tr><td>速度：</td><td>'+items.speed+' km/h</td></tr>'+
    					'<tr><td>定位时间：</td><td>'+items.gpsTime+'</td></tr>'+
    					'<tr><td>通讯时间：</td><td>'+items.hbTime+'</td></tr>'+
    				'</table>';
        var infoWindow = new BMap.InfoWindow(text,{
            width : 250,
            height: 140,
        });
        // map.openInfoWindow(infoWindow, point);
        marker.addEventListener("click", function(){
            map.openInfoWindow(infoWindow, point);
        });
    });
}
//添加指定点（10s更新用）
function showPointStatic(data){
	data.forEach(function(items,index){
        var point = new BMap.Point(items.lng,items.lat);
        var marker = new BMap.Marker(point);
        map.addOverlay(marker); 

        var label = new BMap.Label(items.plate_no, {
        	position: point,
        	offset: new BMap.Size(-32, -60) 
        });
        label.setStyle({
			"color": "#fff",
			"background": '#f00',
			"height" : "30px",
			"padding": '4px',
			"border-radius": '3px',
			"opacity": 0.9
		 });
        map.addOverlay(label); 

        var text = '<table>'+
    					'<tr><td>IEME：</td><td>'+items.imei+'</td></tr>'+
    					'<tr><td>车牌：</td><td>'+items.plate_no+'</td></tr>'+
    					'<tr><td>电压：</td><td>'+items.powerValue+' V</td></tr>'+
    					'<tr><td>速度：</td><td>'+items.speed+' km/h</td></tr>'+
    					'<tr><td>定位时间：</td><td>'+items.gpsTime+'</td></tr>'+
    					'<tr><td>通讯时间：</td><td>'+items.hbTime+'</td></tr>'+
    				'</table>';
        var infoWindow = new BMap.InfoWindow(text,{
            width : 250,
            height: 140,
        });
        // map.openInfoWindow(infoWindow, point);
        marker.addEventListener("click", function(){
            map.openInfoWindow(infoWindow, point);
        });
    });
}
//移除指定点
function removePoint(imei){
	var allOverlay = map.getOverlays();
	var lng;
	pool.forEach(function(items,index){
		if(items.imei==imei){
			lng = items.lng;
		}
	});
	for (var i = 0; i < allOverlay.length ; i++){
		try{
			if(allOverlay[i].point.lng == lng ){
                map.removeOverlay(allOverlay[i]);
            }
		}catch(e){}
	}
}
//二级监听，跟document中的监听结合
//添加点或移除点
function listenChange(obj){
	var imei = $(obj).parent().attr('data-imei');
	if($(obj).prop('checked')){
		pool.forEach(function(items,index){
			if(items.imei==imei){
				showPoint([pool[index]]);
			}
		});
	}else{
		removePoint(imei);
	}
}
//请求轨迹数据
function sub(){
	clearInterval(t);
	var imei = $('.input_car').val();
	var start_time = DATETIME($('#datetimestart').val());
	var end_time = DATETIME($('#datetimeend').val());
	if(start_time>DATETIME()||end_time>DATETIME()){
		TOAST('请勿超过当前时间');
		return;
	}
	$.ajax({
        url:ROUTE('/position/trace'),
        type:"get",
        dataType:"json",
        data:{
        	imei: imei,
        	start_time: start_time,
        	end_time: end_time
        },
        success:function(res){
            if(res.data.code==0){
            	initTrace(res.data.result);
            }else{
            	TOAST(res.data.message);
            }
        }
    });
}
//画轨迹图
function initTrace(arr){
	if(arr.length<5) {
		TOAST('暂无该时间段的数据');
		return;
	}
	var point_arr = [];
	arr.forEach(function(items,index){
		var point = new BMap.Point(items.lng, items.lat);
		point_arr.push(point);
	});
	var count = 0;
	map.clearOverlays();

	t = setInterval(function(){
		var allOverlay = map.getOverlays();
        for (var i = 0; i < allOverlay.length ; i++){
			try{
				if(allOverlay[i].point.lng == arr[count].lng ){
	                 map.removeOverlay(allOverlay[i]);
	            }
			}catch(e){}
        }

		polyline_arr[count] = new BMap.Polyline([point_arr[count],point_arr[count+1]], {
			strokeColor:"#00f",	//设置颜色 
	    	strokeWeight:5, 	//宽度
	    	strokeOpacity:1     //透明度
		});	
		map.addOverlay(polyline_arr[count]);
		trace_maker = new BMap.Marker(point_arr[count+1]);
        map.addOverlay(trace_maker);
        map.centerAndZoom(point_arr[count+1], 15);

        var text = '<table>'+
						'<tr><td>速度：</td><td>'+arr[count+1].gpsSpeed+' km/h</td></tr>'+
						'<tr><td>定位时间：</td><td>'+arr[count+1].gpsTime+'</td></tr>'+
					'</table>';
	     trace_label = new BMap.Label(text, {
	        	position: point_arr[count+1],
	        	offset: new BMap.Size(-32, -60) 
	        });
	        trace_label.setStyle({
				"color": "#fff",
				"background": '#f00',
				"height" : "45px",
				"padding": '4px',
				"border-radius": '3px',
				"opacity": 0.9
			 });
	        map.addOverlay(trace_label); 

		count++;
		if(count==point_arr.length-1) {
			clearInterval(t);
			t==null;
		}
	},200);
}
// function btnStatus(obj){
// 	$('#sort .btn-group button').css('background','#fff');
// 	$(obj).css('background','#d2d2dd');
// 	var status = $(obj).val();
// 	var cpy_arr = [];
// 	$('.company').each(function(){
// 		var text = $(this).text();
// 		cpy_arr.push(text);
// 	});
// 	$.ajax({
//         url:ROUTE('/position/status'),
//         type:"get",
//         dataType:"json",
//         data:{
//         	status: status,
//         	cpy_arr: JSON.stringify(cpy_arr)
//         },
//         success:function(res){
//             console.log(res);
//         }
//     });
// }
function search(){
	var val = $('#search').val().replace(/\s/g,"");
	var mark = 0;
	$('.list-group-item').each(function(){
		if($(this).attr('data-imei')==val){
			mark = 1;
			if($(this).hasClass('checked')){
				$(this).trigger('click');
				$(this).trigger('click');
			}else{
				$(this).trigger('click');
			}
		}
		if($(this).find('._plate_no').text()==val){
			mark = 1;
			if($(this).hasClass('checked')){
				$(this).trigger('click');
				$(this).trigger('click');
			}else{
				$(this).trigger('click');
			}
		}
	});
	// $('.company').each(function(){
	// 	if($(this).text()==val){
	// 		mark = 1;
	// 		if($(this).prev().find('input[type=checkbox]').prop('checked')){
	// 			$(this).prev().trigger('click');
	// 			$(this).prev().trigger('click');
	// 		}else{
	// 			$(this).prev().trigger('click');
	// 		}
	// 	}
	// });
	if(!mark){
		$.ajax({
	        url:ROUTE('/position/search'),
	        type:"get",
	        dataType:"json",
	        data:{
	        	val: val,
	        },
	        success:function(res){
	            if(res.code==200){
	            	$('.company').each(function(){
	            		if($(this).text()==res.data[0].cn_abb){
	            			$(this).trigger('click');
	            			var that = this;
	            			var _t = setInterval(function(){
	            				if($(that).parent().next().hasClass('list-group')){
	            					$(that).parent().next().find('a[data-imei="'+res.data[0].imei+'"]').trigger('click');
	            					clearInterval(_t);
	            				}
	            			},500);
	            		}
	            	});
	            }else if(res.code==100){
	            	$('.company').each(function(){
	            		if($(this).text()==res.data[0].cn_abb){
	            			$(this).prev().trigger('click');
	            		}
	            	});
	            }else{
	            	TOAST(res.msg);
	            }
	        }
	    });
	}
}
