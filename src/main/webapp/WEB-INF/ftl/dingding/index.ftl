<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="format-detection" content="email=no" />
        <meta name="format-detection" content="address=no;">
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="black" />
        <title>万能小哥</title>
        <#--<link href="${basePath}/js/common/bootstrap/3.3.5/css/bootstrap.min.css?${_v}" rel="stylesheet"/>-->
        <#--<link href="${basePath}/css/common/base.css?${_v}" rel="stylesheet"/>-->
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/reset_h5.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/index.css" />
		<link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/dropload.css"/>
        <link rel="stylesheet" type="text/css" href="${basePath}/css/qifu/choose_city.css" />

        <script>
            <#--var _config = {"agentId":'${_config.agentId}',-->
                <#--"corpId":'${_config.corpId}',-->
                <#--"timeStamp":'${_config.timeStamp}',-->
                <#--"nonceStr":'${_config.nonceStr}',-->
                <#--"signature":'${_config.signature}'-->
            <#--}-->

            localStorage.appId ='${_config.appid}';
            localStorage.agentId ='${_config.agentId}';
            localStorage.corpId ='${_config.corpId}';
            localStorage.timeStamp ='${_config.timeStamp}';
            localStorage.nonceStr = '${_config.nonceStr}';
            localStorage.signature = '${_config.signature}';

        </script>

        <script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
        <script src="${basePath}/js/qifu/jquery-1.11.3.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/dropload.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/index_data.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>
        <script src="${basePath}/js/qifu/choose_citydata.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/city.js" type="text/javascript" charset="utf-8"></script>
        <script src="${basePath}/js/qifu/index.js" type="text/javascript" charset="utf-8" baseUrl="${basePath}"></script>

        <script src="${basePath}/js/dingding.demo.js" baseUrl="${basePath}"></script>
        <script src="${basePath}/js/config.js"></script>
	</head>



	<body>


    <div class="choose_city">
        <a href="javascript:void(0);" class="city_current" id="citychoose" >北京</a>
        <a href="" class="person_center"></a>
    </div>
    <div class="banner"><a class="zhifudiaoyong"><img src="/images/banner.png"/></a></div>
    <div class="tab">
        <table border="0" cellspacing="0" cellpadding="0">

            <tr>
                <td>
                    <a href="javascript:void(0);">
                        <div><img src="${basePath}/images/2.png" /></div>
                        <p>办公设备维护</p>
                    </a>
                </td>
                <td>
                    <a href="javascript:void(0);">
                        <div><img src="${basePath}/images/6.png" /></div>
                        <p>办公电器保养</p>
                    </a>
                </td>
                <td>
                    <a href="javascript:void(0);">
                        <div><img src="${basePath}/images/3.png" /></div>
                        <p>办公环境维修</p>
                    </a>
                </td>
                <td class="monthly">
                    <a href="javascript:void(0);" class="wnqyd">
                        <div><img src="${basePath}/images/4.png" /></div>
                        <p>万能企业盾</p>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div class="hot_project">
        <p class="hot_title">热门维修项目</p>
        <ul></ul>
    </div>
    <div class="city-wrap">
        <div class="city-wrap-tit border_bottom">
            <p class="back"></p>
            城市列表
        </div>
        <!--显示点击的是哪一个字母-->
        <div id="showLetter" class="showLetter"><span>A</span></div>
        <!--城市索引查询-->
        <div class="letter">
            <ul>

            </ul>
        </div>
        <!--城市列表-->
        <div class="box">

            <div class="container tab1">
                <div class="city">
                </div>
            </div>
        </div>
    </div>


		
	</body>

</html>