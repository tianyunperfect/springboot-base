package com.alvin.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.gson.Gson;


/**
 * json工具类
 * https://www.yuque.com/tianyunperfect/ygzsw4/bv1mlg
 * <p>
 * JsonUtil.toObject(str,JsonHello.class)
 * JSON.parseObject(str2, new TypeReference<List<MyDay>>(){})
 * JSON.parseObject(str2, new TypeReference<JsonHello<Hello>>(){})
 *
 * @author tianyunperfect
 * @date 2020/05/20
 */
public class JsonUtil {

    /**
     * 转换为json字符串
     *
     * @param object 对象
     * @return {@link String}
     */
    public static String toJsonStr(Object object) {
        return new Gson().toJson(object);
    }


    /**
     * 将json字符串 转换为 普通类
     *
     * @param jsonStr json str
     * @param clazz   clazz
     * @return {@link T}
     */
    public static <T> T toObject(String jsonStr, Class<T> clazz) {
        return JSON.parseObject(jsonStr, clazz);
    }

    /**
     * 将json字符串 转换为 泛型类、集合等
     *
     * @param jsonStr        json str
     * @param tTypeReference t型参考
     * @return {@link T}
     */
    public static <T> T toObject(String jsonStr, TypeReference<T> tTypeReference) {
        return JSON.parseObject(jsonStr, tTypeReference);
    }
}