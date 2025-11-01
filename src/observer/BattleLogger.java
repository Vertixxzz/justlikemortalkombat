package observer;

public class BattleLogger implements Observer {
    public void update(String event) {
        System.out.println("[LOG] " + event);
    }
}
