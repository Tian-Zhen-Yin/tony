package observer;


public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void updata() {
        System.out.println("HexaObserver观察到的物体状态更新为：" + subject.getState());
    }
}
