package com.ulb.web.rest;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.ulb.service.MyService;
import com.ulb.service.TimeService;
import com.ulb.web.dto.FeedbackDTO;
import com.ulb.web.dto.MyOrderRecordDTO;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.QydOrderRecordDTO;
import com.ulb.web.dto.QydWithConfigDTO;
import com.ulb.web.dto.UserDTO;
import com.ulb.web.util.ConfigGetter;
import com.ulb.web.util.StatueUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
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

    @RequestMapping(value="my",method=RequestMethod.GET)
    public ModelAndView getMy(HttpServletRequest request){
        String userId = request.getParameter("uuid");
        String cityCode = request.getParameter("cityCode");
        String corpId = request.getParameter("corpid");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setCityCode(cityCode);
        userDTO.setCorpId(corpId);
        return new ModelAndView("dingding/my","my",userDTO);

    }


    @RequestMapping(value="my_admin",method=RequestMethod.GET)
    public ModelAndView getMyAdmin(HttpServletRequest request){
        String userId = request.getParameter("uuid");
        String cityCode = request.getParameter("cityCode");
        String corpId = request.getParameter("corpid");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userId);
        userDTO.setCityCode(cityCode);
        userDTO.setCorpId(corpId);
        return new ModelAndView("dingding/my_admin","my",userDTO);

    }

    @RequestMapping(value="my_order/{dingdingUId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getOrders(@PathVariable String dingdingUId,@PathVariable String cityCode,HttpServletRequest request){

        MyOrderRecordDTO myOrderRecordDTO = new MyOrderRecordDTO();

        List<OrderRecordDTO> list = null;
        List<OrderRecordDTO> list1 = new ArrayList<>();
        List<OrderRecordDTO> list2 = new ArrayList<>();
        myOrderRecordDTO.setTitle("我的订单");
        myOrderRecordDTO.setFlag("0");
        myOrderRecordDTO.setConfig(ConfigGetter.getConfig(request));
        try {
            list = myService.getSKUOrderRecord(dingdingUId,cityCode);
            for(OrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
                dto.setStatusName(StatueUtil.getStatueName(dto.getPid().toString()));
                dto.setOnum("wnxg"+dto.getOnum());
                if(dto.getPid() == 1 ||dto.getPid() ==2 ||dto.getPid()==3){
                    dto.setDisplay("inline-block");
                }else{
                    dto.setDisplay("none");
                }

                if(dto.getPid() == 7){
                    dto.setCommentDisplay("inline-block");
                }else{
                    dto.setCommentDisplay("none");
                }


                if(dto.getPid() == 1 || dto.getPid() == 2 || dto.getPid() == 3 ||dto.getPid() == 4 ||dto.getPid() == 5 ){
                    list1.add(dto);
                } else if(dto.getPid() == 7 || dto.getPid() == 8 ||dto.getPid() == 18|| dto.getPid() == 22){
                    list2.add(dto);
                }else{
                    list1.add(dto);
                }

                if(dto.getPid() == 27){
                    dto.setPayDisplay("inline-block");
                }else{
                    dto.setPayDisplay("none");
                }
                dto.setAuditDisplay("none");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        myOrderRecordDTO.setList(list);
        myOrderRecordDTO.setList1(list1);
        myOrderRecordDTO.setList2(list2);
        return new ModelAndView("dingding/my_order","orders",myOrderRecordDTO);

    }

    @RequestMapping(value="my_company_order/{corpId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getCropOrders(@PathVariable String corpId,@PathVariable String cityCode,HttpServletRequest request){

        MyOrderRecordDTO myOrderRecordDTO = new MyOrderRecordDTO();

        List<OrderRecordDTO> list = null;
        List<OrderRecordDTO> list1 = new ArrayList<>();
        List<OrderRecordDTO> list2 = new ArrayList<>();
        myOrderRecordDTO.setTitle("公司的订单");
        myOrderRecordDTO.setFlag("1");
        myOrderRecordDTO.setConfig(ConfigGetter.getConfig(request));
        try {
            list = myService.getCropSKUOrderRecord(corpId,cityCode);
            for(OrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
                dto.setStatusName(StatueUtil.getStatueName(dto.getPid().toString()));
                dto.setOnum("wnxg"+dto.getOnum());

                if(dto.getPid() == -1){
                    dto.setAuditDisplay("inline-block");
                }else{
                    dto.setAuditDisplay("none");
                }


                if(dto.getPid() == 7){
                    dto.setCommentDisplay("inline-block");
                }else{
                    dto.setCommentDisplay("none");
                }

                if(dto.getPid() == 1 ||dto.getPid() ==2 ||dto.getPid()==3){
                    dto.setDisplay("inline-block");
                }else{
                    dto.setDisplay("none");
                }

                if(dto.getPid() == 27){
                    dto.setPayDisplay("inline-block");
                }else{
                    dto.setPayDisplay("none");
                }


                if(dto.getPid() == 1 || dto.getPid() == 2 || dto.getPid() == 3 ||dto.getPid() == 4 ||dto.getPid() == 5 ){
                    list1.add(dto);
                } else if(dto.getPid() == 8 || dto.getPid() == 7 ||dto.getPid() == 18|| dto.getPid() == 22){
                    list2.add(dto);
                }else{
                    list1.add(dto);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        myOrderRecordDTO.setList(list);
        myOrderRecordDTO.setList1(list1);
        myOrderRecordDTO.setList2(list2);
        return new ModelAndView("dingding/my_order","orders",myOrderRecordDTO);

    }


    @RequestMapping(value="my_admin_order/{corpId}/{cityCode}",method=RequestMethod.GET)
    public ModelAndView getCropAdminOrders(@PathVariable String corpId,@PathVariable String cityCode,HttpServletRequest request){

        MyOrderRecordDTO myOrderRecordDTO = new MyOrderRecordDTO();

        myOrderRecordDTO.setTitle("公司的订单");
        myOrderRecordDTO.setFlag("1");
        myOrderRecordDTO.setConfig(ConfigGetter.getConfig(request));

        List<OrderRecordDTO> list = null;
        List<OrderRecordDTO> list1 = new ArrayList<>();
        List<OrderRecordDTO> list2 = new ArrayList<>();

        try {
            list = myService.getCropSKUOrderRecord(corpId,cityCode);
            for(OrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
                dto.setStatusName(StatueUtil.getStatueName(dto.getPid().toString()));
                dto.setOnum("wnxg"+dto.getOnum());



                if(dto.getPid() == 7){
                    dto.setCommentDisplay("inline-block");
                }else{
                    dto.setCommentDisplay("none");
                }

                if(dto.getPid() == -1){
                    dto.setAuditDisplay("inline-block");
                }else{
                    dto.setAuditDisplay("none");
                }


                if(dto.getPid() == 1 ||dto.getPid() ==2 ||dto.getPid()==3){
                    dto.setDisplay("inline-block");
                }else{
                    dto.setDisplay("none");
                }

                if(dto.getPid() == 27){
                    dto.setPayDisplay("inline-block");
                }else{
                    dto.setPayDisplay("none");
                }


                if(dto.getPid() == -1){
                    list1.add(dto);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        myOrderRecordDTO.setList(list);
        myOrderRecordDTO.setList1(list1);
        myOrderRecordDTO.setList2(list2);
        return new ModelAndView("dingding/my_admin_order","orders",myOrderRecordDTO);

    }

    @RequestMapping(value="my_qyd_lists",method=RequestMethod.GET)
    public ModelAndView getQydLists(HttpServletRequest request){

        QydWithConfigDTO qydWithConfigDTO = new QydWithConfigDTO();
        String corpId = request.getParameter("corpId");
        String cityCode = request.getParameter("cityCode");
        List<QydOrderRecordDTO> list = null;

        qydWithConfigDTO.setConfig(ConfigGetter.getConfig(request));
        try {
            list = myService.getQydOrderRecord(corpId);
            for(QydOrderRecordDTO dto:list){
                dto.setCityCode(cityCode);
//                String orderNum = StringUtils.leftPad(dto.getId().toString(),10,'0');
                dto.setOrderNum("WNXG"+dto.getCreateTime());
                dto.setMoneyString(dto.getMoney().toString());
                if(dto.getBeginTime() == null || dto.getEndTime() == null){
                    dto.setPeriod("未开通");
                }else{

                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
                    Date beginDate = new Date(Long.valueOf(dto.getBeginTime()));
                    Date endDate = new Date(Long.valueOf(dto.getEndTime()));
                    dto.setPeriod(sdf.format(beginDate) +" 到 "+ sdf.format(endDate));
                }
                switch (dto.getState()){
                    case 0:
                        dto.setStateName("待支付");
                        dto.setCommentDisplay("none");
                        dto.setPayDisplay("inline-block");
                        dto.setStateImage("weishengxiao.png");
                        break;
                    case 1:
                        dto.setStateName("支付成功,未生效");
                        dto.setCommentDisplay("inline-block");
                        dto.setPayDisplay("none");
                        dto.setStateImage("weishengxiao.png");
                        break;
                    case 2:
                        dto.setStateName("取消订单");
                        dto.setCommentDisplay("none");
                        dto.setPayDisplay("none");
                        dto.setStateImage("weishengxiao.png");
                        break;
                    case 4:
                        dto.setStateName("支付成功，已生效");
                        dto.setCommentDisplay("inline-block");
                        dto.setPayDisplay("none");
                        dto.setStateImage("yishengxiao.png");
                        if(dto.getIsOverdue() == 2){
                            dto.setStateName("已过期");
                            dto.setCommentDisplay("none");
                            dto.setPayDisplay("none");
                            dto.setStateImage("yiguoqi.png");
                        }
                        break;
                    case 5:
                        dto.setStateName("已退款");
                        dto.setCommentDisplay("inline-block");
                        dto.setPayDisplay("none");
                        dto.setStateImage("yituikuan.png");
                        break;
                    default:
                        dto.setStateName("已失效");
                        dto.setCommentDisplay("none");
                        dto.setPayDisplay("none");
                        dto.setStateImage("yiguoqi.png");
                }
            }
            qydWithConfigDTO.setList(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView("dingding/my_qyd_lists","qyd",qydWithConfigDTO);

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


    @RequestMapping(value="help/pay",method=RequestMethod.GET)
    public ModelAndView pay(HttpServletRequest request){

        return new ModelAndView("dingding/FAQ");
    }

    @RequestMapping(value = "my/feedback.shtml",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>>  save(@RequestBody FeedbackDTO feedbackDTO){
        Map<String, Object> resultMap = new LinkedHashMap<>();
        feedbackDTO.setCommit(StatueUtil.filterEmoji(feedbackDTO.getCommit(),""));
        myService.insert(feedbackDTO);
        resultMap.put("message", "提交成功！");
        resultMap.put("status", 200);
        return new ResponseEntity(resultMap,HttpStatus.OK);
    }


}
