var baseUrl = $("script[baseUrl]").attr('baseUrl');
var current_city = localStorage.current_city ? localStorage.current_city :'北京';
var current_city_code = localStorage.current_city_code ? localStorage.current_city_code :'bj';
$(function(){
    $('.choose_city .city_current').text(current_city);
    $('.tab>table tr>td').eq(0).click(function(){
        window.location = baseUrl+'/dingding/sort.shtml?type=0&&city='+current_city_code+'&&corpid='+localStorage.corpId;
    });
    $('.tab>table tr>td').eq(1).click(function(){
        window.location = baseUrl+'/dingding/sort.shtml?type=1&&city='+current_city_code+'&&corpid='+localStorage.corpId;
    });
    $('.tab>table tr>td').eq(2).click(function(){
        window.location = baseUrl+'/dingding/sort.shtml?type=2&&city='+current_city_code+'&&corpid='+localStorage.corpId;
    });

    var page = 0;

    function change_url(url) {
        $('.hot_project>ul>li ').each(function(i,item) {
            var btitem = $(item).find('.hot_btn>a');
            var imgiten =  $(item).find('.hot_pic>a')
            var current_url = btitem.attr('href');
            var url_array = current_url.split('/');
            url_array[url_array.length-1] = url;
            current_url = url_array.join('/');
            btitem.attr('href',current_url);
            imgiten.attr('href',current_url);
            console.log(item);
        })
    }

    var catalogurl = baseUrl+'/dingding/sort.shtml?type=0&&city='+current_city_code+'&&corpid='+localStorage.corpId;

    $('.hot_project').dropload({
        scrollArea : window,
        domDown : {
            domClass   : 'dropload-down',
            domRefresh : '<div class="dropload-refresh">↑上拉加载更多</div>',
            domLoad    : '<div class="weui-loadmore"><i class="weui-loading"></i><span class="weui-loadmore__tips">正在加载...</span></div>',
            domNoData  : '<div class="weui-loadmore weui-loadmore_line weui-loadmore_dot"><span class="weui-loadmore__tips"><a href="'+catalogurl+'"><span class="no-more">更多维修，请按分类查看哦</span></a></span></div>'
        },
        loadDownFn : function(me){
            page++;
            var result = '';
            var list = data['list'+page];
            if(list){
                for(var i = 0; i < list.length; i++) {
                    orderUrl = baseUrl + "/ulb/sku/" +list[i].id+"/"+current_city_code+".shtml?corpid="+localStorage.corpId+"&appid="+localStorage.appId;
                    result += '<li id='+list[i].id+'>' + '<div class="hot_pic">' + '<a href="'+orderUrl+'"> <img src="' + list[i].pic +'" alt="" >' + '</a></div>' +
                            '<div class="hot_price">' +
                            '<p>' + list[i].title + ' </p>' +
                            '<p>&yen;<span> '+ list[i].money +'</span></p>'+
                            '</div>'+'<div class="hot_btn"><a href="'+orderUrl+'">立即报修</a></div>'+
                            '</li>';
                }
            }
            else{
                me.lock();
                me.noData();
            }
            // 为了测试，延迟0.1秒加载
            setTimeout(function() {
                // $('.hot_project ul').html('');
                $('.hot_project ul').append(result);
                me.resetload();
            }, 100);
        }
    });
// 选择城市

    $('.city_current').click(function(){
        $('.city-wrap').show()
        $('.city-wrap').stop(true).animate({left:0},400,function(){

        })
    });
    $('.city').delegate('p', 'click', function(event) {
        current_city = $(this).text();
        current_city_code = $(this).attr('id');
        change_url(current_city_code+".shtml?corpid="+localStorage.corpId+"&appid="+localStorage.appId);
        localStorage.current_city = current_city;
        localStorage.current_city_code = current_city_code;

        console.log(current_city_code +":"+current_city);
        $('.choose_city .city_current').text(current_city);
        $('body,html').scrollTop(0);
        $('.city-wrap').stop(true).animate({left:'-100%'},400,function(){
           $('.city-wrap').hide()
        })
    })
    $('.city-wrap .back').click(function(){
        $('body,html').scrollTop(0);
        $('.city-wrap').stop(true).animate({left:'-100%'},400,function(){
           $('.city-wrap').hide()
        })
    })


})