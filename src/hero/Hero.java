package hero;

import java.util.List;
import java.util.ArrayList;
import observer.Observable;
import observer.Observer;
import strategy.AttackStrategy;

public abstract class Hero implements Observable {
    protected String name;
    protected int health = 100;
    protected AttackStrategy attackStrategy;
    private List<Observer> observers = new ArrayList<>();

    public Hero(String name) { this.name = name; }
    public String getName() { return name; }

    public void setAttackStrategy(AttackStrategy strategy) {
        this.attackStrategy = strategy;
        notifyObservers(name + " switched attack strategy.");
    }

    public void attack(Hero target) {
        if (attackStrategy != null) attackStrategy.attack(this, target);
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health <= 0) {
            health = 0;
            notifyObservers(name + " has been defeated!");
        } else notifyObservers(name + " has " + health + " HP left.");
    }

    public void registerObserver(Observer o) { observers.add(o); }
    public void removeObserver(Observer o) { observers.remove(o); }
    public void notifyObservers(String event) { for (Observer o : observers) o.update(event); }
}
