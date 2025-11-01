package strategy;

import hero.Hero;
import java.util.Random;

public class CriticalAttack extends AttackDecorator {
    public CriticalAttack(AttackStrategy decorated) { super(decorated); }
    public void attack(Hero attacker, Hero target) {
        decorated.attack(attacker, target);
        if (new Random().nextBoolean()) {
            target.takeDamage(10);
            attacker.notifyObservers(attacker.getName() + " landed a critical hit!");
        }
    }
}
