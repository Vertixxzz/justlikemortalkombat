package strategy;

import hero.Hero;

public class RangedAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(10);
        attacker.notifyObservers(attacker.getName() + " shoots " + target.getName() + " with arrows!");
    }
}
