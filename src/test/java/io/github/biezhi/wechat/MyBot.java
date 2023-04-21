package io.github.biezhi.wechat;

import io.github.biezhi.wechat.api.annotation.Bind;
import io.github.biezhi.wechat.api.constant.Config;
import io.github.biezhi.wechat.api.enums.AccountType;
import io.github.biezhi.wechat.api.enums.MsgType;
import io.github.biezhi.wechat.api.model.WeChatMessage;
import io.github.biezhi.wechat.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * 我的小机器人
 *
 * @author biezhi
 * @date 2018/1/19
 */
@Slf4j
public class MyBot extends WeChatBot {

    public MyBot(Config config) {
        super(config);
    }

    public static void main(String[] args) {
        new MyBot(Config.me().autoLogin(true).showTerminal(true)).start();
    }

    /**
     * 绑定群聊信息
     *
     * @param message
     */
    @Bind(msgType = MsgType.ALL, accountType = AccountType.TYPE_GROUP)
    public void groupMessage(WeChatMessage message) {
        log.info("接收到群 [{}] 的消息: {}", message.getName(), message.getText());
        this.api().sendText(message.getFromUserName(), "自动回复: " + message.getText());
    }

    /**
     * 绑定私聊消息
     *
     * @param message
     */
    @Bind(msgType = {MsgType.TEXT}, accountType = AccountType.TYPE_FRIEND)
    public void friendMessage(WeChatMessage message) {
        log.info("TEXT:接收到好友 [{}] 的消息: {}", message.getName(), message.getText());
        if (StringUtils.isNotEmpty(message.getName()) && message.getText().lastIndexOf("ai") == 0) {
            this.api().sendText(message.getFromUserName(), "自动回复: " + message.getText());
        }
    }

    /**
     * 绑定私聊消息
     *
     * @param message
     */
    @Bind(msgType = {MsgType.IMAGE}, accountType = AccountType.TYPE_FRIEND)
    public void friendMessageImage(WeChatMessage message) {
        log.info("IMAGE：接收到好友 [{}] 的消息: {}", message.getName(), message.getText());
        if (StringUtils.isNotEmpty(message.getName())) {
            this.api().sendImg(message.getFromUserName(), message.getImagePath());
        }
    }



    /**
     * 绑定私聊消息
     *
     * @param message
     */
    @Bind(msgType = {MsgType.EMOTICONS}, accountType = AccountType.TYPE_FRIEND)
    public void friendMessageEmoticons(WeChatMessage message) {
        log.info("EMOTICONS:接收到好友 [{}] 的消息: {}", message.getName(), message.getText());
        if (StringUtils.isNotEmpty(message.getName())) {
            this.api().sendText(message.getFromUserName(), message.getText());
        }
    }

    /**
     * 好友验证消息
     *
     * @param message
     */
    @Bind(msgType = MsgType.ADD_FRIEND)
    public void addFriend(WeChatMessage message) {
        log.info("收到好友验证消息: {}", message.getText());
        if (message.getText().contains("java")) {
            this.api().verify(message.getRaw().getRecommend());
        }
    }

}
