package test;

public class Son extends Father {
    @Override
    public void eat() {
        System.out.println("儿子喜欢吃");
    }

    public static void main(String[] args) {
        Father a = new Son();
        a.eat();
    }
}
