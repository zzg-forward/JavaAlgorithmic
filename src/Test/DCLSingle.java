package Test;

/**
 * 懒汉式
 * 饿汉式
 * 双重检查单例模式
 * 类级内部类单例模式
 */

public class DCLSingle {
    private DCLSingle(){

    }

    private static DCLSingle dclSingle;
    public static DCLSingle getInstance(){
        if (dclSingle == null) {
            synchronized(DCLSingle.class) {
                if (dclSingle == null) {
                    dclSingle = new DCLSingle();
                }
            }

        }
        return dclSingle;
    }
}
