package com.ulb.web.rest;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.MyService;
import com.ulb.service.SKUService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.FeedbackDTO;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QydOrderRecordDTO;
import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.UserDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by wangpeng on 03/08/2017.
 */

@Controller
@Scope(value="prototype")
@RequestMapping("dingding")
public class MyResource {

    public static final Logger LOGGER = LoggerFactory.getLogger(MyResource.class);

    @Resource
    private MyService myService;

    @Resource
    private TimeService timeService;

    @RequestMapping(value="my/{dingdingUId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getMy(@PathVariable String dingdingUId,@PathVariable String cityCode){

        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(dingdingUId);
        userDTO.setCityCode(cityCode);
        return new ModelAndView("dingding/my","my",userDTO);

    }

    @RequestMapping(value="my_order/{dingdingUId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable String dingdingUId,@PathVariable String cityCode){

        List<OrderRecordDTO> list = null;
        try {
            list = myService.getSKUOrderRecord(dingdingUId,cityCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_order","orders",list);

    }

    @RequestMapping(value="my_qyd_lists",method=RequestMethod.GET)
    public ModelAndView getQydLists(HttpServletRequest request){
        String corpId = request.getParameter("corpId");
        List<QydOrderRecordDTO> list = null;
        try {
            list = myService.getQydOrderRecord(corpId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_qyd_lists","qydOrders",list);

    }

    @RequestMapping(value="help",method=RequestMethod.GET)
    public ModelAndView getHelp(){
        return new ModelAndView("dingding/help");
    }

    @RequestMapping(value="help/FAQ",method=RequestMethod.GET)
    public ModelAndView getHelpFAQ(){
        return new ModelAndView("dingding/FAQ");
    }

    @RequestMapping(value="help/newbie_guide",method=RequestMethod.GET)
    public ModelAndView getHelpNoviceBoot(){
        return new ModelAndView("dingding/newbie_guide");
    }

    @RequestMapping(value="help/user_feedback",method=RequestMethod.GET)
    public ModelAndView getHelpUserFeedback(){
        return new ModelAndView("dingding/user_feedback");
    }

    @RequestMapping(value="help/about_wnxg",method=RequestMethod.GET)
    public ModelAndView getHelpAbout(){
        return new ModelAndView("dingding/about_wnxg");
    }


    @RequestMapping(value = "my/feedback.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@RequestBody FeedbackDTO feedbackDTO){
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        myService.insert(feedbackDTO);
        resultMap.put("message", "注册成功！");
        resultMap.put("status", 200);
        return new ResponseEntity<>(resultMap,HttpStatus.OK);
    }

}
