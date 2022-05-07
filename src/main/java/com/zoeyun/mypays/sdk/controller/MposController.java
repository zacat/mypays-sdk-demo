package com.zoeyun.mypays.sdk.controller;

import com.zoeyun.mypays.sdk.bean.request.MposCreateRequest;
import com.zoeyun.mypays.sdk.bean.request.MposGetRequest;
import com.zoeyun.mypays.sdk.bean.result.MposCreateResult;
import com.zoeyun.mypays.sdk.bean.result.MposGetResult;
import com.zoeyun.mypays.sdk.configuration.MypaysPropeties;
import com.zoeyun.mypays.sdk.service.MypaysService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("mpos")
public class MposController {

    @Autowired
    MypaysService mypaysService;

    @Autowired
    MypaysPropeties propeties;

    @SneakyThrows
    @RequestMapping("createOrder")
    public MposCreateResult createOrder() {
        MposCreateRequest request = MposCreateRequest
                .newBuilder()
                .clientOrderId(String.valueOf(new Date().getTime()))
                .txnType("MPOS")
                .sceneType("WX")
                .tradeType("JSAPI")
                .body("积分兑换订单")
                .expireTime("5")
                .limitPay(0)
                .subAppid("wx65bfa79bcbc253c7")
                .isMinipg("1")
                .transAmount(1)
                .payAmount(1)
                .channelCode(propeties.getChannelCode())
                .merchantCode(propeties.getMerchantCode())
                .openId("o_2_U4n3xPewwtMFG-JZmnoKPhwg")
                .attach("积分商品")
                .build();
        MposCreateResult result = mypaysService.getMposService().create(request);
        return result;
    }

    @SneakyThrows
    @RequestMapping("queryOrder")
    public MposQueryResult queryOrder() {
        MposQueryResult request = MposQueryResult
                .newBuilder()
                .clientOrderId(String.valueOf(new Date().getTime()))
                .build();
        MposQueryResult result = mypaysService.getMposService().query(request);
        return result;
    }
}
