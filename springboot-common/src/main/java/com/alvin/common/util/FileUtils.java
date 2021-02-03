package com.alvin.common.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 常用文件工具类
 * 1、读取所有行请使用common-io工具类
 * 2、读取单行数据可以使用
 *
 * @author tianyunperfect
 * @date 2021/01/15
 */
public class FileUtils {
    /**
     * 获取到 BF，一定要手动关闭
     *
     * @param filePath 文件路径
     * @param encode   编码
     * @return {@link BufferedReader}* @throws FileNotFoundException 文件未发现异常
     */
    public static BufferedReader getBufferedReader(String filePath, String encode) throws FileNotFoundException, UnsupportedEncodingException {
        return new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), encode));
    }

    /**
     * 获取到 BF，一定要手动关闭，默认UTF-8
     *
     * @param filePath 文件路径
     * @return {@link BufferedReader}* @throws FileNotFoundException 文件未发现异常
     * @throws UnsupportedEncodingException 不支持的编码异常
     */
    public static BufferedReader getBufferedReader(String filePath) throws FileNotFoundException, UnsupportedEncodingException {
        return getBufferedReader(filePath, StandardCharsets.UTF_8.name());
    }
}
