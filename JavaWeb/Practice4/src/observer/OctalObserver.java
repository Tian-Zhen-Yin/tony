package observer;



public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }
    @Override
    public void updata() {
        System.out.println("OctalObserver观察到的物体状态更新为：" + subject.getState());
    }
}