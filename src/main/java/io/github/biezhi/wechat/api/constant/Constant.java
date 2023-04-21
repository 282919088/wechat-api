package io.github.biezhi.wechat.api.constant;

import java.util.*;

/**
 * 常量
 *
 * @author biezhi
 * @date 2018/1/18
 */
public interface Constant {

    String VERSION           = "1.0.5";
    String BASE_URL          = "https://login.weixin.qq.com";
    String GET               = "GET";
    String GROUP_BR          = ":<br/>";
    String GROUP_IDENTIFY    = "@@";
    String LOCATION_IDENTIFY = "/cgi-bin/mmwebwx-bin/webwxgetpubliclinkimg?url=";

    String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36";

    String UOS_PATCH_CLIENT_VERSION = "2.0.0";

    String REFERER = "https://wx.qq.com/?&lang=zh_CN&target=t";

    String UOS_PATCH_EXTSPAM =
            "Go8FCIkFEokFCggwMDAwMDAwMRAGGvAESySibk50w5Wb3uTl2c2h64jVVrV7gNs06GFlWplHQbY/5FfiO++1yH4ykCyNPWKXmco+wfQzK5R98D3so7rJ5LmGFvBLjGceleySrc3SOf2Pc1gVehzJgODeS0lDL3/I/0S2SSE98YgKleq6Uqx6ndTy9yaL9qFxJL7eiA/R3SEfTaW1SBoSITIu+EEkXff+Pv8NHOk7N57rcGk1w0ZzRrQDkXTOXFN2iHYIzAAZPIOY45Lsh+A4slpgnDiaOvRtlQYCt97nmPLuTipOJ8Qc5pM7ZsOsAPPrCQL7nK0I7aPrFDF0q4ziUUKettzW8MrAaiVfmbD1/VkmLNVqqZVvBCtRblXb5FHmtS8FxnqCzYP4WFvz3T0TcrOqwLX1M/DQvcHaGGw0B0y4bZMs7lVScGBFxMj3vbFi2SRKbKhaitxHfYHAOAa0X7/MSS0RNAjdwoyGHeOepXOKY+h3iHeqCvgOH6LOifdHf/1aaZNwSkGotYnYScW8Yx63LnSwba7+hESrtPa/huRmB9KWvMCKbDThL/nne14hnL277EDCSocPu3rOSYjuB9gKSOdVmWsj9Dxb/iZIe+S6AiG29Esm+/eUacSba0k8wn5HhHg9d4tIcixrxveflc8vi2/wNQGVFNsGO6tB5WF0xf/plngOvQ1/ivGV/C1Qpdhzznh0ExAVJ6dwzNg7qIEBaw+BzTJTUuRcPk92Sn6QDn2Pu3mpONaEumacjW4w6ipPnPw+g2TfywJjeEcpSZaP4Q3YV5HG8D6UjWA4GSkBKculWpdCMadx0usMomsSS/74QgpYqcPkmamB4nVv1JxczYITIqItIKjD35IGKAUwAA==";

    /**
     * 特殊用户 须过滤
     */
    Set<String> API_SPECIAL_USER = new HashSet<>(
            Arrays.asList("newsapp", "filehelper", "weibo", "qqmail",
                    "fmessage", "tmessage", "qmessage", "qqsync",
                    "floatbottle", "lbsapp", "shakeapp", "medianote",
                    "qqfriend", "readerapp", "blogapp", "facebookapp",
                    "masssendapp", "meishiapp", "feedsapp", "voip",
                    "blogappweixin", "brandsessionholder", "weixin",
                    "weixinreminder", "officialaccounts", "wxitil",
                    "notification_messages", "wxid_novlwrv3lqwv11",
                    "gh_22b87fa7cb3c", "userexperience_alarm"));

    /**
     * index url
     */
    List<String> INDEX_URL = new ArrayList<>(
            Arrays.asList("wx2.qq.com", "wx8.qq.com",
                    "wx.qq.com", "web2.wechat.com", "wechat.com"));

    /**
     * file url
     */
    List<String> FILE_URL = new ArrayList<>(
            Arrays.asList("file.wx2.qq.com", "file.wx8.qq.com",
                    "file.wx.qq.com", "file.web2.wechat.com", "file.web.wechat.com"));

    /**
     * webpush url
     */
    List<String> WEB_PUSH_URL = new ArrayList<>(
            Arrays.asList("wx2.qq.com", "wx8.qq.com",
                    "wx.qq.com", "web2.wechat.com", "web.wechat.com"));

    enum UUIDPara {
        APP_ID("appid", "wx782c26e4c19acffb"),
        FUN("fun", "new"),
        LANG("lang", "zh_CN"),
        REDIRECT_URL("redirect_uri",
                "https://wx.qq.com/cgi-bin/mmwebwx-bin/webwxnewloginpage?mod=desktop"),
        _("_", "时间戳");

        private String key;
        private String value;

        UUIDPara(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String key() {
            return key;
        }

        public String value() {
            return value;
        }
    }
}