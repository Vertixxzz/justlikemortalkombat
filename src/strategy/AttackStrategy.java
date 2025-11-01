package strategy;

import hero.Hero;

public interface AttackStrategy {
    void attack(Hero attacker, Hero target);
}
