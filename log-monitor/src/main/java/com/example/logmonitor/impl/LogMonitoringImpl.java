package com.example.logmonitor.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.logmonitor.dao.DomainDao;
import com.example.logmonitor.daoaccess.AccessKeyDao;
import com.example.logmonitor.entity.ResultltFlow;
import com.example.logmonitor.entityaccess.AccessKey;
import com.example.logmonitor.service.LogMonitoringService;
import com.example.logmonitor.util.CdnFlow;
import com.example.logmonitor.util.HttpUtils;
import com.example.logmonitor.util.LogApi;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.GZIPInputStream;


@Service
public class LogMonitoringImpl implements LogMonitoringService {
    private static final Logger logger = LoggerFactory.getLogger(LogMonitoringService.class);

    @Autowired
    DomainDao domainDao;
    @Autowired
    LogApi logApi;
    @Autowired
    CdnFlow cdnFlow;
    @Autowired
    HttpUtils httpUtils;
    @Autowired
    AccessKeyDao accessKeyDao;

    public void findname() throws Exception {
//        List domain = domainDao.findAllDomain();
//        System.out.println(domain);
//        System.out.println("域名总数" + domain.size());
//
//        List<ResultltFlow> result = new LinkedList<>();
//
//        for (int i = 0; i < domain.size() && i < 10; i++) {
//            ResultltFlow resultltFlow = new ResultltFlow();
//            AccessKey accessKey = accessKeyDao.finByAccess(domain.get(i).toString());
//            if (null != accessKey) {
//                String domains = domain.get(i).toString();
//
//                BigDecimal cdnflow = cdnFlow.queryFlow(domains, accessKey.getAccess_key_id(), accessKey.getAccess_key_secret());
//
////                    System.out.println("域名:"+domains+"流量:"+flow);
//                BigDecimal ApiFlow = logApi.queryLog(domains, accessKey.getAccess_key_id(), accessKey.getAccess_key_secret());
//                System.out.println("域名:" + domains + "流量:" + cdnflow + "Api流量：" + ApiFlow);
//                resultltFlow.setDomain(domains);
//                resultltFlow.setCdnflow(cdnflow);
//                resultltFlow.setApiFlow(ApiFlow);
//                result.add(resultltFlow);
//            } else {
//                logger.error("该域名没有AK.SK,{}", domain.get(i));
//            }
//        }
//
//
////        System.out.println(result);
//        for (int i = 0; i < result.size(); i++) {
//            String domains = result.get(i).getDomain();
//            BigDecimal cdnflow = result.get(i).getCdnflow();
//            BigDecimal apiflow = result.get(i).getApiFlow();
//            //partal减去API流量
//            BigDecimal subtract = cdnflow.subtract(apiflow);
//            System.out.println(subtract);
////            if (cdnflow.compareTo()) {
////
////                BigDecimal b = cdnflow.divide(apiflow, 5, RoundingMode.HALF_UP);
////                System.out.println(b);
////            }
//        }

        BigDecimal flow = logApi.queryLog("grasma-static.neshpub.com", "bl0iwnCIPYal9HDoef9dee968f6e7100", "61939aa0c0d387e7c80fb1454b12bfec");

        //System.out.println(flow);
    }


}
