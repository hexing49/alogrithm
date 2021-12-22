package designPartten.chainOfResponsiblity;


/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/17 14:17
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        HandlerChain chain = new HandlerChain();
        chain.addHandler(new HandlerA());
        chain.addHandler(new HandlerB());
        chain.handler();
        Integer integer = new Integer(1);
        Byte aByte = new Byte("1");
        System.out.println(integer.byteValue() == aByte);
    }
}

