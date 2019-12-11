package observer;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject =new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexaObserver(subject);
        System.out.println("把状态更改10后:");
        subject.setState(10);
    }
}