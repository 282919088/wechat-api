package io.github.biezhi.wechat.api.constant;

import io.github.biezhi.wechat.exception.WeChatException;

import java.io.InputStream;
import java.util.Properties;

import static io.github.biezhi.wechat.api.constant.Constant.*;

/**
 * 微信API配置
 *
 * @author biezhi
 * @date 2018/1/18
 */
public class Config {
    public static final String REFERER = "https://wx.qq.com/?&lang=zh_CN&target=t";
    public static final String USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36";
    public static final String UOS_PATCH_CLIENT_VERSION = "2.0.0";
    public static final String UOS_PATCH_EXTSPAM =
            "Go8FCIkFEokFCggwMDAwMDAwMRAGGvAESySibk50w5Wb3uTl2c2h64jVVrV7gNs06GFlWplHQbY/5FfiO++1yH4ykCyNPWKXmco+wfQzK5R98D3so7rJ5LmGFvBLjGceleySrc3SOf2Pc1gVehzJgODeS0lDL3/I/0S2SSE98YgKleq6Uqx6ndTy9yaL9qFxJL7eiA/R3SEfTaW1SBoSITIu+EEkXff+Pv8NHOk7N57rcGk1w0ZzRrQDkXTOXFN2iHYIzAAZPIOY45Lsh+A4slpgnDiaOvRtlQYCt97nmPLuTipOJ8Qc5pM7ZsOsAPPrCQL7nK0I7aPrFDF0q4ziUUKettzW8MrAaiVfmbD1/VkmLNVqqZVvBCtRblXb5FHmtS8FxnqCzYP4WFvz3T0TcrOqwLX1M/DQvcHaGGw0B0y4bZMs7lVScGBFxMj3vbFi2SRKbKhaitxHfYHAOAa0X7/MSS0RNAjdwoyGHeOepXOKY+h3iHeqCvgOH6LOifdHf/1aaZNwSkGotYnYScW8Yx63LnSwba7+hESrtPa/huRmB9KWvMCKbDThL/nne14hnL277EDCSocPu3rOSYjuB9gKSOdVmWsj9Dxb/iZIe+S6AiG29Esm+/eUacSba0k8wn5HhHg9d4tIcixrxveflc8vi2/wNQGVFNsGO6tB5WF0xf/plngOvQ1/ivGV/C1Qpdhzznh0ExAVJ6dwzNg7qIEBaw+BzTJTUuRcPk92Sn6QDn2Pu3mpONaEumacjW4w6ipPnPw+g2TfywJjeEcpSZaP4Q3YV5HG8D6UjWA4GSkBKculWpdCMadx0usMomsSS/74QgpYqcPkmamB4nVv1JxczYITIqItIKjD35IGKAUwAA==";


    /**
     * 资源存储的文件夹，包括图片、视频、音频
     */
    private static final String CONF_ASSETS_DIR         = "wechat.assets-path";
    private static final String CONF_ASSETS_DIR_DEFAULT = "assets";

    /**
     * 是否输出二维码到终端
     */
    private static final String CONF_PRINT_TERMINAL         = "wechat.print-terminal";
    private static final String CONF_PRINT_TERMINAL_DEFAULT = "false";

    /**
     * 自动回复消息，测试时用
     */
    private static final String CONF_AUTO_REPLY         = "wechat.auto-reply";
    private static final String CONF_AUTO_REPLY_DEFAULT = "false";

    /**
     * 自动登录
     */
    private static final String CONF_AUTO_LOGIN         = "wechat.auto-login";
    private static final String CONF_AUTO_LOGIN_DEFAULT = "false";

    /**
     * 自动添加好友请求
     */
    private static final String CONF_AUTO_ADDFRIEND         = "wechat.auto-addfriend";
    private static final String CONF_AUTO_ADDFRIEND_DEFAULT = "false";

    private Properties props = new Properties();

    public static Config me() {
        return new Config();
    }

    /**
     * 加载 ClassPath 下的配置文件
     *
     * @param filePath
     * @return
     */
    public static Config load(String filePath) {
        Config config = new Config();
        try (final InputStream stream = Config.class.getResourceAsStream(filePath)) {
            config.props.load(stream);
        } catch (Exception e) {
            throw new WeChatException("加载配置文件出错", e);
        }
        return config;
    }

    public String get(String key) {
        return props.getProperty(key);
    }

    public String get(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
    }

    public String assetsDir() {
        return props.getProperty(CONF_ASSETS_DIR, CONF_ASSETS_DIR_DEFAULT);
    }

    public Config assetsDir(String dir) {
        props.setProperty(CONF_ASSETS_DIR, dir);
        return this;
    }

    public boolean showTerminal() {
        return Boolean.valueOf(props.getProperty(CONF_PRINT_TERMINAL, CONF_PRINT_TERMINAL_DEFAULT));
    }

    public Config showTerminal(boolean show) {
        props.setProperty(CONF_PRINT_TERMINAL, String.valueOf(show));
        return this;
    }

    public boolean autoReply() {
        return Boolean.valueOf(props.getProperty(CONF_AUTO_REPLY, CONF_AUTO_REPLY_DEFAULT));
    }

    public Config autoReply(boolean autoReply) {
        props.setProperty(CONF_AUTO_REPLY, String.valueOf(autoReply));
        return this;
    }

    public Config autoLogin(boolean autoLogin) {
        props.setProperty(CONF_AUTO_LOGIN, String.valueOf(autoLogin));
        return this;
    }

    public Config autoAddFriend(boolean autoAddFriend) {
        props.setProperty(CONF_AUTO_ADDFRIEND, String.valueOf(autoAddFriend));
        return this;
    }

    public boolean autoAddFriend() {
        return Boolean.valueOf(props.getProperty(CONF_AUTO_ADDFRIEND, CONF_AUTO_ADDFRIEND_DEFAULT));
    }

    public boolean autoLogin() {
        return Boolean.valueOf(props.getProperty(CONF_AUTO_LOGIN, CONF_AUTO_LOGIN_DEFAULT));
    }

}
