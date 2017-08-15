package com.ulb.service.remote;


import com.ulb.web.dto.SKUOrderRecordDTO;
import com.ulb.web.dto.SKURecordDTO;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * 调用服务端
 *
 * Created by wangpeng on 25/07/2017.
 */
public interface RemoteSKUService {

    @GET("/WNXG/ulb/api/new_enter_prise_my_order/repairDetails/{skuId}/{cityCode}")
    Call<SKURecordDTO> getSKU(@Path("skuId") String skuId, @Path("cityCode") String cityCode);

    @Headers({"Content-type:application/json;charset=UTF-8"})
    @FormUrlEncoded
    @POST("/WNXG/ulb/api/new_enter_prise/order")
    Call<?> postOrder(@Body SKUOrderRecordDTO skuOrderRecordDTO);

}
