function layer_tip(form_tip,fun){
    var isLayer = $('.layer_box').length;
    if(!isLayer){
      var layer_box = $('<div class = "layer_box"></div>');
          $('body').append(layer_box);
          $('.layer_box').css({
                  "font-size":'14px',
                  "color":"#fff",
                  "position":"fixed",
                  'left':'0',
                  'right':'0',
                  'top':'25%',
                  'margin':'auto',
                  'width':'180px',
                  'height':'auto',
                  'padding':'10px 15px',
                  'text-align':'center',
                  'background':'rgba(0,0,0,0.5)',
                  'line-height':'22px',
                  'letter-spacing':'1px',
                  'border-radius':'4px',
                  'z-index':'100000'

          });
          $('.layer_box').text(form_tip);
          setTimeout(function(){
              $('.layer_box').remove();
              if(fun){
                fun();
              }
          },2000)
    }
    
}

function layer_confirm(tip,sure,cancel) {
    var confirm_box = $('<div class="wrapper"><div class = "confirm_box"><h2>提示</h2><p></p ><div class="btn_box"><button class="sure">确定</button><button class="cancel">我再想想</button></div></div></div>')
    $('body').append(confirm_box);
    $('.wrapper').css({
                          "position":"fixed",
                          "top":0,
                          "bottom":0,
                          "left":0,
                          "right":0,
                          "background":"rgba(0,0,0,0.7)"
                      })
    $('.confirm_box').css({
                              "font-size":'14px',
                              "color":"#333",
                              "position":"fixed",
                              'left':'0',
                              'right':'0',
                              'top':'35%',
                              'margin':'auto',
                              'width':'70%',
                              'height':'auto',
                              'text-align':'center',
                              'background':'#f5f5f5',
                              'line-height':'25px',
                              'letter-spacing':'1px',
                              'border-radius':'8px',
                              'z-index':'100000',

                          });
    $('.confirm_box h2').css({
                                 "font-size":"16px",
                                 "color":"#333",
                                 "padding-top":"16px"
                             })
    $('.confirm_box p').css({
                                "padding":"0 20px",
                                "margin-top":"8px",
                                "line-height":"22px"
                            })
    $('.btn_box').css({
                          "width":"100%",
                          "border-top":"#e8e8e8 solid 1px",
                          "height":"40px",
                          "margin-top":"14px"
                      });
    $('.btn_box button').css({
                                 "width":"50%",
                                 "height":"40px",
                                 "background":"transparent",
                                 "border":"none",
                                 "color":"#ff943e",
                                 "font-size":"16px",
                                 "outline":"none"
                             })
    $('.sure').css({
                       "border-right":"#e8e8e8 solid 1px",
                       "color":"#999"
                   })
    $('.confirm_box p').text(tip);
    $('.sure').click(function(){
        if(sure){
            sure()
        }
        $('.wrapper').remove();
    })
    $('.cancel').click(function(){
        if(cancel){
            cancel()
        }
        $('.wrapper').remove();
    })
}

function layer_promot(opts) {
    var _default = {
      'tip':'不通过理由？',
      'callback':function(reason){

      }
    }
    var settings = $.extend({},_default,opts)
    var promot_box = $('<div class="wrapper"><div class = "promot_box"><h2>'+settings.tip+'</h2><input type="text"  /><div class="btn_box"><button class="sure">确定</button><button class="cancel">我再想想</button></div></div></div>')
    $('body').append(promot_box);
    $('.wrapper').css({
                          "position":"fixed",
                          "top":0,
                          "bottom":0,
                          "left":0,
                          "right":0,
                          "background":"rgba(0,0,0,0.7)"
                      })
    $('.promot_box').css({
                              "font-size":'14px',
                              "color":"#333",
                              "position":"fixed",
                              'left':'0',
                              'right':'0',
                              'top':'30%',
                              'margin':'auto',
                              'width':'70%',
                              'height':'auto',
                              'text-align':'center',
                              'background':'#f5f5f5',
                              'line-height':'25px',
                              'letter-spacing':'1px',
                              'border-radius':'8px',
                              'z-index':'100000',

                          });
    $('.promot_box h2').css({
                                 "font-size":"16px",
                                 "color":"#333",
                                 "padding-top":"16px",
                                 'font-weight':'400'
                             })
    $('.promot_box input').css({
                                "display":"block",
                                "padding":"0 5px",
                                "width":"80%",
                                "background":"#fff",
                                "line-height":"30px",
                                "margin":"0 auto",
                                "margin-top":"18px",
                                "margin-bottom":"23px",
                                "border":"#e8e8e8 solid 1px",
                                "font-size":"14px"
                            })
    $('.promot_box .btn_box').css({
                          "width":"100%",
                          "border-top":"#e8e8e8 solid 1px",
                          "height":"40px",
                          "margin-top":"14px"
                      });
    $('.promot_box .btn_box button').css({
                                 "width":"50%",
                                 "height":"40px",
                                 "background":"transparent",
                                 "border":"none",
                                 "color":"#ff943e",
                                 "font-size":"16px",
                                 "outline":"none"
                             })
    $('.promot_box .sure').css({
                       "border-right":"#e8e8e8 solid 1px",
                       "color":"#999"
                   })
    $('.promot_box .sure').click(function(){
        var reason = $('.promot_box input').val();
        if(settings.callback){
            settings.callback(reason)
        }
        $('.wrapper').remove();
    })
    $('.promot_box .cancel').click(function(){
        
        $('.wrapper').remove();
    })
}