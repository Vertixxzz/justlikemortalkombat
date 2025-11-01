package strategy;

import hero.Hero;

public class MeleeAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(15);
        attacker.notifyObservers(attacker.getName() + " hits " + target.getName() + " with melee attack!");
    }
}
