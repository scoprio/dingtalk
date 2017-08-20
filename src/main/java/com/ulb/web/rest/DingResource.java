package com.ulb.web.rest;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.dingtalk.open.client.api.model.corp.CorpUserDetail;
import com.ulb.web.demo.auth.AuthHelper;
import com.ulb.web.demo.user.UserHelper;
import com.ulb.web.dto.DingDingConfigDTO;
import com.ulb.web.dto.MyOrderInfoDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangpeng on 03/08/2017.
 */

@RestController
@Scope(value="prototype")
@RequestMapping("dingding")
public class DingResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(DingResource.class);

    public static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    @RequestMapping(value="index",method=RequestMethod.GET)
    public ModelAndView userIndex(HttpServletRequest request){
        DingDingConfigDTO dto = ConfigGetter.getConfig(request);
        return new ModelAndView("dingding/index","_config",dto);
    }


    @RequestMapping(value="authCode.shtml",method=RequestMethod.GET)
    public ResponseEntity<String> getAuthCode(HttpServletRequest request){


        String code = request.getParameter("code");
        String corpId = request.getParameter("corpid");
        LOGGER.info("code:"+code+" corpid:"+corpId);

        String accessToken = "";
        CorpUserDetail user = null;

        try {
            accessToken = AuthHelper.getAccessToken(corpId);
            LOGGER.info("access token:"+accessToken);
            user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getUserid());
        } catch (Exception e) {
            e.printStackTrace();
        }
        String userJson = JSON.toJSONString(user);
        LOGGER.info("access user:"+userJson);
        return new ResponseEntity<>(userJson, HttpStatus.OK);

//        String code = request.getParameter("code");
//        String corpId = request.getParameter("corpid");
//        LOGGER.info("code:"+code+" corpid:"+corpId);
//
//        String accessToken;
//        CorpUserDetail user = null;
//
//        try {
//            accessToken = AuthHelper.getAccessToken(corpId);
//            LOGGER.info("access token:"+accessToken);
////            CorpUserDetail user2 = UserHelper.getUserInfo(accessToken, code);
//            user = UserHelper.getUser(accessToken, UserHelper.getUserInfo(accessToken, code).getUserid());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String userJson = JSON.toJSONString(user);
//        LOGGER.info("access user:"+userJson);
//        return new ResponseEntity<>(userJson, HttpStatus.OK);
    }

    @RequestMapping(value="my",method=RequestMethod.GET)
    public ModelAndView getUserInfo(HttpServletRequest request){

        String uuid = request.getParameter("uuid");
        String corpId = request.getParameter("corpid");

        MyOrderInfoDTO dto = new MyOrderInfoDTO();

        return new ModelAndView("dingding/my","_my",dto);
    }


    @RequestMapping(value="city",method=RequestMethod.GET)
    public ModelAndView city(){
        return new ModelAndView("dingding/choose_city");
    }

    @RequestMapping(value="sort",method=RequestMethod.GET)
    public ModelAndView sort(){
        return new ModelAndView("dingding/all_sort");
    }


}