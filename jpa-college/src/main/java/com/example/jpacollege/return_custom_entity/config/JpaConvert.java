package com.example.jpacollege.return_custom_entity.config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.example.jpacollege.return_custom_entity.model.UserNameInterface;
import lombok.val;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * 自定义的Jpa转换器，用于在Repo中返回自定义对象
 */
public final class JpaConvert implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        return Collections.singleton(new ConvertiblePair(Map.class, UserNameInterface.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        return map2Pojo(source, targetType.getObjectType());
    }

    public static <T> T map2Pojo(Object entity, Class<T> tClass) {
        val copyOptions = CopyOptions.create()
                .setIgnoreCase(true)
                .setIgnoreError(true)
                .setIgnoreNullValue(true)
                .setFieldNameEditor(StrUtil::toUnderlineCase);
        return BeanUtil.toBean(entity, tClass, copyOptions);
    }
}
