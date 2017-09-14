package com.ulb.service.remote;



import java.util.List;

import com.ulb.web.dto.Comment2DTO;
import com.ulb.web.dto.Comment2InfoDTO;
import com.ulb.web.dto.OperaterDTO;
import com.ulb.web.dto.OperaterOrderDTO;
import com.ulb.web.dto.OrderRecordDTO;
import com.ulb.web.dto.PayStateDTO;
import com.ulb.web.dto.QFOrderRecordDTO;
import com.ulb.web.dto.QFRecordDetailDTO;
import com.ulb.web.dto.QFRepairPostDTO;
import com.ulb.web.dto.ResultDTO;
import com.ulb.web.dto.ResultWithQFDTO;
import com.ulb.web.dto.SKUOrderStateDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteQFService {

    @GET("/WNXG/ulb/api/new_enter_prise_my_company/myDetails/{qifuId}")
    Call<QFRecordDetailDTO> getQFRecordDetail(@Path("qifuId") String qifuId);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/enterprise")
    Call<ResultWithQFDTO> postOrder(@Body QFOrderRecordDTO qfOrderRecordDTO);


    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/addedOrder")
    Call<ResultDTO> postRepair(@Body QFRepairPostDTO qfRepairPostDTO);


    @Headers({"Content-type:application/json;charset=UTF-8"})
    @POST("/WNXG/ulb/api/new_enter_prise_my_company/companyComment")
    Call<ResultDTO> comment(@Body Comment2DTO comment2DTO);


    @GET("/WNXG/ulb/api/new_enter_prise_my_company/orderList/{serviceId}")
    Call<List<Comment2InfoDTO>> getComments(@Path("serviceId") String serviceId);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise_my_company/afterOnline/{qfId}")
    Call<ResultDTO> payOrder(@Path("qfId")String qfId,@Body PayStateDTO payStateDTO);


    @Headers({"Content-type:application/json;charset=UTF-8"})
    @PUT("/WNXG/ulb/api/new_enter_prise_my_company/companyOrder/{orderId}")
    Call<ResultDTO> confirmOrder(@Path("orderId")String orderId,@Body OperaterDTO operaterDTO);

}
