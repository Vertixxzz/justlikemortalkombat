package main;

import hero.*;
import strategy.*;
import observer.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hero hero1 = HeroFactory.createHero("warrior", "Arthur");
        Hero hero2 = HeroFactory.createHero("mage", "Merlin");

        Observer logger = new BattleLogger();
        Observer announcer = new Announcer();

        hero1.registerObserver(logger);
        hero1.registerObserver(announcer);
        hero2.registerObserver(logger);
        hero2.registerObserver(announcer);

        Scanner sc = new Scanner(System.in);

        System.out.println("=== HERO BATTLE GAME ===");
        System.out.println("Arthur (Warrior) vs Merlin (Mage4)");
        System.out.println("Choose attacks for Arthur. Merlin will counter automatically.");
        System.out.println("----------------------------------");

        while (2 > 1) {
            if (!isAlive(hero1) || !isAlive(hero2)) break;

            System.out.println("\nArthur's turn. Choose attack:");
            System.out.println("1 - Melee Attack");
            System.out.println("2 - Ranged Attack");
            System.out.println("3 - Magic Attack");
            System.out.println("4 - Critical Ranged Attack (Decorator)");

            System.out.print("> ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> hero1.setAttackStrategy(new MeleeAttack());
                case 2 -> hero1.setAttackStrategy(new RangedAttack());
                case 3 -> hero1.setAttackStrategy(new MagicAttack());
                case 4 -> hero1.setAttackStrategy(new CriticalAttack(new RangedAttack()));
                default -> System.out.println("Invalid choice, try again.");
            }

            hero1.attack(hero2);
            if (!isAlive(hero2)) break;

            hero2.setAttackStrategy(new MagicAttack());
            hero2.attack(hero1);
        }

        System.out.println("\n=== BATTLE OVER ===");
        if (!isAlive(hero1) && !isAlive(hero2)) System.out.println("It's a draw!");
        else if (isAlive(hero1)) System.out.println("Arthur wins!");
        else System.out.println("Merlin wins!");
    }

    private static boolean isAlive(Hero h) {
        try {
            var field = Hero.class.getDeclaredField("health");
            field.setAccessible(true);
            return (int) field.get(h) > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
