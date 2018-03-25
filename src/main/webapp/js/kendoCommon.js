var img_src = 'foo';
$(document).on('dblclick','tr',function(e){
    var tr = $(e.target).closest('tr');
    $(tr).find('.k-grid-edit').trigger('click');
});
$(document).on('click','.dialog-upload',function(e){
    $('input[type=file]').click();
});
function photo(obj){
    var src = $(obj).attr('src');
    window.top.open(src);
}
function initDialog(option){
    var str = '<div id="dialog" style="font-size: 14px;"></div>';
    $('body').append(str);
    $('#dialog').kendoDialog({
        width: "400px",
        title: option.title,
        closable: false,
        modal: true,
        content: option.content,
        actions: option.actions
    });
}
function cancel(){
    $('.k-dialog,.k-overlay').remove();
}
function kendoUploadImg(option,cb){
    var data = new FormData();  
    var ele = document.getElementById('f');
    data.append("img", ele.files[0]);
    $.ajax({
        url: ROUTE(option.url),
        type: 'POST',
        data: data,
        dataType:"json",
        cache: false,
        contentType: false, //不可缺参数
        processData: false, //不可缺参数
        success: function(res) {
            $('input[type=file]').val('');
            TOAST(res.msg);
            if(res.code==200){
                cb(res);
            }
        }
    });
}
function delIcon(obj){
    var data = upload_data;
    album = data.album?data.album:data.icon;
    if(album==''||album==null) return;
    var album_arr = album.split(',');
    var content = '';
    album_arr.forEach(function(items,index){
        content += '<label style="margin-left: 10px;">'+
                        '<input type="checkbox" name="album" value="'+items+'"/>'+
                        '<span><img src="../img/'+img_src+'/'+items+'" title="'+items+'" class="displayAlbum" onclick="photo(this);" /></span>'+
                    '<label>';
    });
    initDialog({
        title: "删除图标",
        content: content,
        actions: [
            { text: '确定', primary: true , action: function(){
                del();
            } },
            { text: '取消', action: cancel }
        ]
    });
}
function del(){
    var album_arr = [];
    $('input[name=album]').not(':checked').each(function(){
        album_arr.push($(this).val());
    });
    for (var i = 0; i < album_arr.length; i++) {
        if(album_arr[i]==''){
            album_arr.splice(i,1);
            i--;
        }
    };
    cancel();
    upload_data.dirty = true;
    var str = '';
    album_arr.forEach(function(items,index){
        str += items+',';
    });
    str = str.slice(0,str.length-1);
    upload_data.album = str;
    var temp_str = '';
    for (var i = 0; i < album_arr.length; i++) {
        temp_str += '<img src="../img/'+img_src+'/'+album_arr[i]+'" title="'+album_arr[i]+'" class="displayAlbum" onclick="photo(this);" />';
    };
    $(upload_e).find('.k-edit-label>label').each(function(){
        if($(this).attr('for')=='album'){
            $(this).parent().next().html(temp_str);
        }
    });
}
function reload(){
    setTimeout(function(){
        window.location.reload();
    },1500);
}
function regDate(container, options){
    var required = 'required';
    if(options.field=='birth'){
        required = '';
    }
    $('<input '+required+' name="' + options.field + '"/>')
        .appendTo(container)
        .kendoDatePicker({
            format: "yyyy-MM-dd",
            parseFormats: ["yyyy-MM-dd"]
        });
}
function dataSource (option) {
    var dataSource = new kendo.data.DataSource({
        transport: {
            read:  {
                url: ROUTE(option.url.read),
                type: 'post',
                dataType: "json"
            },
            update: {
                url: ROUTE(option.url.update),
                type: 'put',
                dataType: "json"
            },
            destroy: {
                url: ROUTE(option.url.destroy),
                type: 'delete',
                dataType: "json"
            },
            create: {
                url: ROUTE(option.url.create),
                type: 'post',
                dataType: "json"
            },
            parameterMap: function(options, operation) {
                 if (operation == "read") {
                    var parameter = {
                        page: options.page,
                        pageSize: options.pageSize,
                        keywords: $('#search').val()
                    };
                    return {models: kendo.stringify(parameter)};
                }else{
                    return {models: kendo.stringify(options.models)};
                }
            }
        },
        batch: true,
        pageSize: 30,
        serverPaging: true,
        schema: {
            model: {
                id: "id",
                fields: option.fields
            },
            data: function (response) {
                return response.data;
            },
            total: function (response) {
                return response.total;
            }
        },
        requestEnd: function (e) {  
            var res = e.response;  
            if(res.code==2000){
                TOAST('提交成功');
                $('#grid').data("kendoGrid").dataSource.read();
            }else if(res.code!=200){
                TOAST(res.msg,'err');
                reload();
            }
        }
    });
    return dataSource;
}
function kendoInit(option){
    var height = $('body').height()-2;
    $("#grid").kendoGrid({
        dataSource: dataSource,
        pageable: true,
        height: height,
        toolbar: option.toolbar,
        pageable: {
            refresh: true,
            buttonCount: 5,
            page: 1,
            pageSize: 30,
            pageSizes: [10,30,50,100],
            messages: {
                display: "当前 {0} - {1}，共 {2} 条",
                empty: "没有数据",
                page: "页",
                of: "/ {0}",
                itemsPerPage: "条/页",
                first: "第一页",
                previous: "前一页",
                next: "下一页",
                last: "最后一页",
                refresh: "刷新"
            }
        },
        columns: option.columns,
        editable: {
            mode: "popup",
            window: {
                height: "70%"
            }
        },
        edit: function(e){
            upload_data = e.model;
            upload_e = e.container;
            if(img_src=='insurance'||img_src=='supplier'||img_src=='lib'){
                var title = '<span>详细信息</span><span class="dialog-upload">上传图片</span><span class="dialog-delImg" onclick="delIcon(this);">删除图片</span>';
            }else{
                var title = '<span>详细信息</span>';
            }
            e.container.data("kendoWindow").title(title);
        }
    });
}
function search(){
    $('#grid').data("kendoGrid").dataSource.options.page = 1;
    $('#grid').data("kendoGrid").dataSource.read();
}