var scrollPage,timer=null;
$(function(){
    var $searchBar = $('#searchBar'),
        $searchResult = $('#searchResult'),
        $searchText = $('#searchText'),
        $searchInput = $('#searchInput'),
        $searchClear = $('#searchClear'),
        $searchCancel = $('#searchCancel');

    function hideSearchResult(){
        $searchResult.hide();
        $searchInput.val('');
    }
    function cancelSearch(){
        hideSearchResult();
        $searchBar.removeClass('weui-search-bar_focusing');
        $searchText.show();
    }

    $searchText.on('click', function(){
        $searchBar.addClass('weui-search-bar_focusing');
        $searchInput.focus();
    });
    $searchInput
        .on('blur', function () {
            if(!this.value.length) {
                cancelSearch();
            }
        })
        .on('input', function(){
            if(this.value.length) {
                $searchResult.show();
            } else {
                $searchResult.hide();
            }
            clearTimeout(timer);
            var v = this.value;
            timer = setTimeout(function(){
                search(v);
            },500);
        })
    ;
    $searchClear.on('click', function(){
        hideSearchResult();
        $searchInput.focus();
    });
    $searchCancel.on('click', function(){
        cancelSearch();
        $searchInput.blur();
    });

    scrollPage = new ScrollPage({
        url: '/wxgzh/pageKnowledgeList'
    });
    scrollPage.page = 2;
    window.onscroll = function(){
        var h_window = window.innerHeight;
        var h_body = $('body').height();
        var h_scroll = $('body').scrollTop();
        if(h_body-h_window-h_scroll<20){
            scrollPage.getData(function(result){
                scrollPage.render(result.data);
            });
        }
    }
});
function errInfo(obj){
    var id = $(obj).attr('data-id');
    window.location.href = '/wxgzh/errorCode/'+id;
}
function search(val){
    scrollPage = new ScrollPage({
        url: '/wxgzh/pageKnowledgeList',
        keywords: val
    });
    scrollPage.page = 1;
    scrollPage.getData(function(result){
        scrollPage.render(result.data);
    });
}