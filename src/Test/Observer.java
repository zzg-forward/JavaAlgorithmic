package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 */

//for test
public class Observer {
    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer1 userZhang = new User("ZhangSan");
        Observer1 userLi = new User("LiSi");
        Observer1 userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInfomation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInfomation("JAVA是世界上最好用的语言！");

    }
}

/***
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 *
 */

interface Observerable {
    public void registerObserver(Observer1 observer);
    public void removeObserver(Observer1 observer);
    public void notifyObserver();
}

/***
 * 抽象观察者
 * 定义了一个update()方法，当被观察者调用notifyObservers()方法时，观察者的update()方法会被回调。
 *
 */
interface Observer1 {
    public void update(String message);
}

/**
 * 被观察者，也就是微信公众号服务
 * 实现了Observerable接口，对Observerable接口的三个方法进行了具体实现
 *
 */
class WechatServer implements Observerable {

    //注意到这个List集合的泛型参数为Observer接口，设计原则：面向接口编程而不是面向实现编程
    private List<Observer1> list;
    private String message;

    public WechatServer() {
        list = new ArrayList<Observer1>();
    }

    @Override
    public void registerObserver(Observer1 observer) {
        list.add(observer);
    }

    @Override
    public void removeObserver(Observer1 observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(int i = 0; i < list.size(); i++) {
            Observer1 oserver = list.get(i);
            oserver.update(message);
        }
    }

    public void setInfomation(String s) {
        this.message = s;
        System.out.println("微信服务更新消息： " + s);
        //消息更新，通知所有观察者
        notifyObserver();
    }

}

/**
 * 观察者
 * 实现了update方法
 *
 */
class User implements Observer1 {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }

}


