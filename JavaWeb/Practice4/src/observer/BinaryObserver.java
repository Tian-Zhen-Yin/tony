package observer;



public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void updata() {
        System.out.println("BinaryObserver观察到的物体状态更新为：" + subject.getState());
    }
}

