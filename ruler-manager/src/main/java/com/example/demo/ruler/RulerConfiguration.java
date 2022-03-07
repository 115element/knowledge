package com.example.demo.ruler;

import com.example.demo.hook.BizUtils;
import com.example.demo.hook.DFT;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;


/**
 * 该类用来定义项目中业务要使用的规则
 */

@Configuration
@RequiredArgsConstructor
public class RulerConfiguration {

    @Bean // 用户是政企用户
    public Ruler isCustTypeZQ() {
        return Rulers.newRuler("is_cust_type_zq", BizUtils::isCustTypeZQ);
    }

    @Bean // 用户是否在主套餐配置表中 ，是否可以升级5G
    public Ruler inG5RootPkgConfig() {
        return Rulers.newRuler("in_g5_root_pkg_config", BizUtils::isInG5RootPkgConfig);
    }

    @Bean // 用户offerId列表包含参数中任何一个offerId
    public Ruler offerIdContainsOneOf() {
        return Rulers.newRuler("offer_id_contains_one_of", BizUtils::isOfferIdContainsOneOf);
    }

    @Bean // 用户标签列表包含参数中任意一个标签
    public Ruler hasTagOneOf() {
        return Rulers.newRuler("has_tag_one_of", BizUtils::isHasTagOneOf);
    }

    @Bean // 用户月租费用大于等于参数
    public Ruler monthFeeGe() {
        return Rulers.newRuler("month_fee_ge", BizUtils::isMonthFeeGe);
    }

    @Bean // 是否是当日的第一次登录
    public Ruler dailyFirstLogin() {
        return Rulers.newRuler("daily_first_login", BizUtils::isFirstLoginDaily);
    }

    @Bean // 月租费用等于参数中任意一个值
    public Ruler monthFeeEqOneOf() {
        return Rulers.newRuler("month_fee_eq_one_of", BizUtils::isMonthFeeEqOneOf);
    }

    @Bean // 当前时间在参数时间闭区间内
    public Ruler dateBetween() {
        return Rulers.newRuler("date_between", dateRange -> {
            System.out.println("Function入参："+dateRange);
            val now = DFT.yyyyMMddHHmmss.format(LocalDateTime.now());
            val rangeArray = dateRange.split(",");
            return now.compareTo(rangeArray[0]) >= 0 && now.compareTo(rangeArray[1]) <= 0;
        });
    }
}
