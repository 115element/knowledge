package com.example.demo.hook;


import com.google.common.collect.BiMap;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import java.util.Objects;

@Slf4j
@UtilityClass
public class BizUtils {

    @SuppressWarnings("unchecked")
    public static BiMap<String, String> getSessionForwardDictionary() {
        Object map = CtlUtils.session().getAttribute("forwardDictionary");
        if (Objects.isNull(map)) return null;
        return (BiMap<String, String>) map;
    }

    @SuppressWarnings("unchecked")
    public static BiMap<String, String> getSessionReverseDictionary() {
        Object map = CtlUtils.session().getAttribute("reverseDictionary");
        if (Objects.isNull(map)) return null;
        return (BiMap<String, String>) map;
    }

    public static String getRealityMobile(String cdKey) {
        BiMap<String, String> map = getSessionForwardDictionary();
        if (Objects.isNull(map)) return null;
        log.info("会话数据:{},cdKey:{}", map, cdKey);
        var realityMobile = map.get(cdKey);
        if (Objects.isNull(realityMobile)) return null;
        return realityMobile;
    }

    public static Boolean isCustTypeZQ() {
        //TODO 这里可以写你的业务处理，多复杂都可以
        return true;
    }

    public static Boolean g5RootPkg() {
        //TODO 这里可以写你的业务处理，多复杂都可以
        return false;
    }

    public static Boolean isOfferIdContainsOneOf() {
        return true;
    }

    public static Boolean isInG5RootPkgConfig() {
        return true;
    }

    public static Boolean isHasTagOneOf() {
        return true;
    }

    public static Boolean isMonthFeeGe() {
        return true;
    }

    public static Boolean isFirstLoginDaily() {
        return true;
    }

    public static Boolean isMonthFeeEqOneOf() {
        return true;
    }

}
