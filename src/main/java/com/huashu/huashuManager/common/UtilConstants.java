package com.huashu.huashuManager.common;

public interface UtilConstants {
    /**
     *
     * 公共常量
     *
     */

    /**
     * 内部常量
     */
    public static class UserConstants {
        public static final String DEFAULT_FOLRID = "1";
        public static final String PASSWORD = "123456";
    }
    public static class SmsConstants {
        public static final String APPKEY = "c9d05fc412ae5352b2c765e299285886";
        public static final String APPSECRET = "a7eefc19482e";
        public static final String CODEMESSAGEURL="https://api.netease.im/sms/sendtemplate.action?";
        public static final String TEMPLENTID_REGCODE="3142326";
        public static final String TEMPLENTID_REPAIRSUB="4012125";
        public static final String TEMPLENTID_REPAIRFINSH="4082100";
    }
    public static class JIMIAPI {
        public static final String JIMIAPPKEY="8FB345B8693CCD003FCB7F5C57CB51A4";
        public static final String JIMIAPPSECRET="e8103d4c19634d6899a66d7b16321c99";
        public static final String JIMIGETTOKENMETHOD="jimi.oauth.token.get";
        public static final String JIMIURL="http://open.aichezaixian.com/route/rest";
    }
}
