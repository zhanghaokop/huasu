package com.huashu.huashuManager.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.huashu.huashuManager.common.UtilConstants;
import com.huashu.huashuManager.model.RepairInfo;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 系统名称: U-OBS-web
 * 系统版本：V5.0.2.0
 * 模块名称:
 * 类  名  称: SmsService.java
 * 功能说明：
 * 开发人员: kky
 * 开发时间: 2018/3/10 15:15
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期 修改人员 修改说明
 */
public class SmsService {

    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * Takes the raw bytes from the digest and formats them correct.
     *
     * @param bytes the raw bytes from the digest.
     * @return the formatted bytes.
     */
    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static HashMap<String, String> getDefaultInfoParams() {
        HashMap<String, String> info = new HashMap<String, String>();
        String CurTime = (System.currentTimeMillis() / 1000) + ""; //当前时间秒数
        String Nonce = encode(CurTime); //加密
        info.put("appkey", UtilConstants.SmsConstants.APPKEY);
        info.put("CurTime", CurTime);
        info.put("Nonce", Nonce);
        info.put("CheckSum", encode(UtilConstants.SmsConstants.APPSECRET + Nonce + CurTime));
        return info;
    }

    /**
     * 获取短信验证码
     *
     * @param mobliles
     * @return
     */
    public static int getCodeMessage(List<String> mobliles) {
//        mobliles.add("13588304181");
        if (CollectionUtils.isEmpty(mobliles)) {
            return 1;//todo 抛异常
        }
        String templateid = UtilConstants.SmsConstants.TEMPLENTID_REGCODE;
        int ran = (int) (Math.random() * 9000) + 1000;
        StringBuffer buffer = new StringBuffer();//拼接url后面的参数
        buffer.append("templateid=" + templateid + "&params=[" + ran + "]&mobiles=[");
        for (String phone : mobliles) {
            buffer.append(phone + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1).append("]");
        String jsonResult = RestClientUtil.exchangeCodeMessage(UtilConstants.SmsConstants.CODEMESSAGEURL, buffer.toString(), getDefaultInfoParams());
        JSONObject result = JSONObject.parseObject(jsonResult);
        if (!(result.containsKey("code") && "200".equalsIgnoreCase(result.get("code").toString()))) {
            System.out.print("12222222222222222" + result.get("code"));
            //todo 抛异常
        }
        return ran;
    }

    /**
     * 维修短息提醒
     *
     * @param repairInfo
     * @param mobliles   通知人
     * @param name
     * @param tel        保修人的号码
     * @return
     */
    public static int sendRepairMessage(RepairInfo repairInfo, List<String> mobliles, String name, String tel) {
        mobliles.add("13588304181");
        if (CollectionUtils.isEmpty(mobliles)) {
            return 1;//todo 抛异常
        }
        if (StringUtils.isEmpty(repairInfo.getPlateNo()) || StringUtils.isEmpty(repairInfo.getSubCompany())
                || StringUtils.isEmpty(repairInfo.getDescription())) {
            return 1;//todo 抛异常
        }
        String templateid = UtilConstants.SmsConstants.TEMPLENTID_REPAIRSUB;
        StringBuffer buffer = new StringBuffer();//拼接url后面的参数
//        repairInfo.setPlateNo("111");
//        repairInfo.setSubCompany("2222");
//        repairInfo.setDescription("11111");
        buffer.append("templateid=" + templateid + "&params=[" + repairInfo.getPlateNo() + "," + repairInfo.getSubCompany() + "," +
                repairInfo.getDescription() + "," + name + "," + tel + "]&mobiles=[");
        for (String phone : mobliles) {
            buffer.append(phone + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1).append("]");
        String jsonResult = RestClientUtil.exchangeCodeMessage(UtilConstants.SmsConstants.CODEMESSAGEURL, buffer.toString(), getDefaultInfoParams());
        JSONObject result = JSONObject.parseObject(jsonResult);
        if (!(result.containsKey("code") && "200".equalsIgnoreCase(result.get("code").toString()))) {
            System.out.print("12222222222222222" + result.get("code"));
            //todo 抛异常
        }
        return 0;
    }

    /**
     * 维修完成短息
     *
     * @param repairInfo
     * @param mobliles   通知人
     * @return
     */
    public static int sendRepairFinshMessage(RepairInfo repairInfo, List<String> mobliles) {
        if (CollectionUtils.isEmpty(mobliles)) {
            return 1;//todo 抛异常
        }
        String templateid = UtilConstants.SmsConstants.TEMPLENTID_REPAIRSUB;
        StringBuffer buffer = new StringBuffer();//拼接url后面的参数
        buffer.append("templateid=" + templateid + "&params=[" + repairInfo.getPlateNo() + "," +
                repairInfo.getRepairSolution() + "]&mobiles=[");
        for (String phone : mobliles) {
            buffer.append(phone + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1).append("]");
        String jsonResult = RestClientUtil.exchangeCodeMessage(UtilConstants.SmsConstants.CODEMESSAGEURL, buffer.toString(), getDefaultInfoParams());
        JSONObject result = JSONObject.parseObject(jsonResult);
        if (!(result.containsKey("code") && "200".equalsIgnoreCase(result.get("code").toString()))) {
            System.out.print("12222222222222222" + result.get("code"));
            //todo 抛异常
        }
        return 0;
    }

    public static void main(String[] args) {
        int a = sendRepairMessage(new RepairInfo(), new ArrayList<String>(), "11", "11");
        System.out.print(a);
    }
}
