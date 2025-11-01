package observer;

public class Announcer implements Observer {
    public void update(String event) {
        System.out.println("[ANNOUNCER] " + event);
    }
}
