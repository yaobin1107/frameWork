package cn.yb.subscriber;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer1 {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = null;//连接工厂
        Connection connection = null;//连接
        Session session = null;//会话
        Destination destination = null;//消息目的地
        MessageConsumer messageConsumer = null;//消息消费者

        try {
            //1.连接MQ
            System.out.println("username:" + USERNAME);
            System.out.println("password:" + PASSWORD);
            System.out.println("brokeURl::" + BROKEURL);
            //创建连接工厂
            connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
            //创建连接
            connection = connectionFactory.createConnection();
            //启动连接
            connection.start();
            //获取session
            //监听器模式下为false
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            //创建队列（目的地）Queue 继承了 destination
            destination = session.createTopic("发送短信_T");
            //创建消息接收（消费）者
            messageConsumer = session.createConsumer(destination);
            //2.设置MQ监听器
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    TextMessage textMessage = (TextMessage) message;
                    if (message != null) {
                        try {
                            System.out.println("Consumer1获取的消息：" + textMessage.getText());
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

