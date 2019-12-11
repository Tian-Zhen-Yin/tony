package adapter;

public class Adapter extends Adaptee implements Target {
    public void request() {
        super.doSomething();
    }
}