package strategy;

import hero.Hero;

public class MagicAttack implements AttackStrategy {
    public void attack(Hero attacker, Hero target) {
        target.takeDamage(20);
        attacker.notifyObservers(attacker.getName() + " casts spell on " + target.getName() + "!");
    }
}
