var start,end,t;
$(document).ready(function(){
    initMap();
	initDatePicker();
	getData();
});
function getData(){
	$.ajax({
        url:ROUTE('/cus/trace/list'),
        type:"get",
        dataType:"json",
        success:function(res){
        	renderList(res.data);        
        }
    });
}
function renderList(data){
	var str = '<li class="list-group">';
	for (var i = 0; i < data.length; i++) {
		str +=  '<a href="#" class="list-group-item" data-imei="'+data[i].IMEI+'" onclick="getTrace(this);">'+
					// '<label>'+	
						'<input type="checkbox" class="second_check" style="display:none"/>'+	
						'<span class="_plate_no" style="width:75px;">'+data[i].plate_no+'</span>'+
					// '</label>'+
					'<span style="margin-left: 20px;" class="more">总里程：'+parseInt(data[i].total_mile_age/1000)+' km</span>'+
					'</br>'+
				'</a>';    
	};
	str += '</li>';
	$('.list ul').append(str);
}
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
    start = $("#datetimestart").kendoDateTimePicker({
        value: yesterday,
        change: startChange,
        format: "yyyy-MM-dd HH:mm",
        parseFormats: ["yyyy-MM-dd HH:mm"]
    }).data("kendoDateTimePicker");

    end = $("#datetimeend").kendoDateTimePicker({
        value: today,
        change: endChange,
        format: "yyyy-MM-dd HH:mm",
        parseFormats: ["yyyy-MM-dd HH:mm"]
    }).data("kendoDateTimePicker");

    start.max(end.value());
    end.min(start.value());
}

function getTrace(obj){
    var imei = $(obj).attr('data-imei');
    var start_time = $("#datetimestart").val();
    var end_time = $("#datetimeend").val();
    $.ajax({
        url: ROUTE('/cus/trace/content'),
        type: "get",
        dataType: "json",
        data: {
            imei: imei,
            start_time: start_time,
            end_time: end_time
        },
        success:function(res){
            renderTrace(res.data);
        }
    });
}
function renderTrace(arr){
    if(arr[0]==null){
        TOAST('当前时段暂无数据！');
        return;
    }
    var polyline_arr = [];
    //画轨迹图
    if(t!=null) clearInterval(t);
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
            strokeColor:"#00f", //设置颜色 
            strokeWeight:5,     //宽度
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
    },300);
}