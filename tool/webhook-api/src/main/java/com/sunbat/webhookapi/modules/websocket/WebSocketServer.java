package com.sunbat.webhookapi.modules.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * websocket服务
 * @author: SunYb
 * @date: 2024/6/12 15:41
 * @version: 1.0
 */
@ServerEndpoint(value = "/websocket")
@Component
public class WebSocketServer implements MessageListener {

    private static Logger log = LoggerFactory.getLogger(WebSocketServer.class);

    /**
     *     concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<>();

    /**
     * 用户id，一开始使用前端传入的方式，但是有安全隐患，后来换成后端从security中获取
     */
    private Long sid = null;
    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;


    /**
     * @Description：连接建立成功调用的方法
     * @Date：2018/12/13 下午3:16
     * @Author：Mujiutian
     * @UpdateRemark:
     * @Version:1.0
     */
    @OnOpen
    public void onOpen(Session session) {
        log.debug("来自客户端的URL:" + session.getRequestURI());
        session.setMaxIdleTimeout(0);
        this.session = session;
        log.debug("有新窗口开始监听：用戶ID为新连接加入！");
        //如果存在就先删除一个，防止重复推送消息
        for (WebSocketServer webSocket : webSocketSet) {

        }
        webSocketSet.clear();
        webSocketSet.add(this);
        try {
            sendMessage("连接成功");
        } catch (IOException e) {
            log.error("websocket IO异常");
        } catch (IllegalStateException stateException) {
            log.error("websocket state异常");
        }
    }

    /**
     * @Description：连接关闭调用的方法
     * @Date：2018/12/13 下午3:15
     * @Author：Mujiutian
     * @UpdateRemark:
     * @Version:1.0
     */
    @OnClose
    public void onClose(Session session) {
        webSocketSet.remove(this);
    }

    /**
     * @Description：收到客户端消息后调用的方法,message:客户端发送过来的消息
     * @Date：2018/12/13 下午3:16
     * @Author：ChengJian
     * @UpdateRemark:
     * @Version:1.0
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        sendInfo(message, null);
    }


    @OnError
    public void onError(Session session, Throwable error) {
        webSocketSet.remove(this);

        if (!(error instanceof EOFException)) {
            log.error("websocket发生错误:" + session.getId(), error);
        }
    }

    /**
     * 判断是否有链接
     *
     * @return
     */
    public static boolean isConn(Long userId) {
        for (WebSocketServer item : webSocketSet) {
            if (item.sid.equals(userId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description：实现服务器主动推送
     * @Date：2018/12/13 下午3:17
     * @Author：ChengJian
     * @UpdateRemark:
     * @Version:1.0
     */
    public synchronized void sendMessage(String message) throws IOException, IllegalStateException {
        if (this.session.isOpen()) {
            this.session.getBasicRemote().sendText(message);
        }
    }


    /**
     * 群发自定义消息
     */
    public void sendInfo(String msg, Long sid) {
        log.debug("推送消息,推送消息内容:" + msg);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if (sid == null || sid == 0L) {
                    item.sendMessage(msg);
                } else if (item.sid.equals(sid)) {
                    item.sendMessage(msg);
                }
            } catch (IOException ignored) {
                continue;
            } catch (IllegalStateException stateException) {
                continue;
            }
        }
    }

    @Override
    public void onMessage(Message message, byte[] bytes) {
        String msg = new String(message.getBody());
        sendInfo(msg, null);
    }
}
