var map;		//百度地图实例
var pool = [];	//数据池
$(document).ready(function(){
	getData();
	initMap();
});
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
 * 车列表
 */
function getData(){
	$.ajax({
        url:ROUTE('/cus/position/list'),
        type:"get",
        dataType:"json",
        success:function(res){
            var data = res.data;
            pool = data;
            renderCar(data);
        }
    });
}
function renderCar(data){
    var str = '';
    for (var i = 0; i < data.length; i++) {
        str +=  '<a href="#" class="list-group-item" data-imei="'+data[i].imei+'" onclick="listenChange(this);">'+
                    '<input type="checkbox" checked class="second_check" style="display:none"/>'+   
                    '<span class="_plate_no" style="margin-left: 10px;width:75px;">'+data[i].plate_no+'</span>'+
                    '<span class="speed" style="margin-left: 20px;">'+data[i].speed+'</span>'+
                    '<span style="margin-left: 10px;">km/h</span>'+
                    '</br>'+
                    '<span style="margin-left: 10px;position: relative;top: 7px;">总里程：'+data[i].total_mile/1000+' km</span>'+
                '</a>';   
    };
    $('.list ul').append(str);
    showPosition(data);
    // updateInfo();
}
//添加指定点
function showPosition(data){
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
        map.openInfoWindow(infoWindow, point);
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
//添加点或移除点
function listenChange(obj){
    var imei = $(obj).attr('data-imei');
    if($(obj).find('input[type=checkbox]').prop('checked')){
        $(obj).find('input[type=checkbox]').prop('checked',false);
        removePoint(imei);
    }else{
        $(obj).find('input[type=checkbox]').prop('checked',true);
        pool.forEach(function(items,index){
            if(items.imei==imei){
                showPosition([pool[index]]);
            }
        });
    }
}

//开启轮询
// function updateInfo(){
//     if($('.time').css('display')=='none'){
//         $('.time').show();
//         setInterval(function(){
//             var num = parseInt($('.t_num').text());
//             if(num==0){
//                 requestInfo();
//                 num = 10;
//             }else{
//                 num--;
//             }
//             $('.t_num').text(num);
//         },1000);
//     }
// }
//更新数据  
// function requestInfo(){
//     var imei_arr = [];
//     pool.forEach(function(items,index){
//         imei_arr.push(items.imei);
//     });
//     $.ajax({
//         url:ROUTE('/position/updateInfo'),
//         type:"post",
//         dataType:"json",
//         data: {
//             imei_arr: JSON.stringify(imei_arr)
//         },
//         success:function(res){
//             pool = res.data;
//             pool.forEach(function(items,index){
//                 $('.list-group-item').each(function(){
//                     if(items.imei==$(this).attr('data-imei')){
//                         $(this).find('.speed').text(items.speed);
//                     }
//                 });
//             });
//         }
//     });
// }