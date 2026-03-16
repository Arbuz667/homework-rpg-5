package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        // --- Decorator Demo ---
        AttackAction basic = new BasicAttack("Strike", 20);
        AttackAction fireOnly = new FireRuneDecorator(basic);
        AttackAction poisonOnly = new PoisonCoatingDecorator(basic);
        AttackAction critOnly = new CriticalFocusDecorator(basic);
        AttackAction fireCrit = new CriticalFocusDecorator(new FireRuneDecorator(basic));
        AttackAction fullStack = new FireRuneDecorator(
                new PoisonCoatingDecorator(
                        new CriticalFocusDecorator(basic)));

        System.out.println("--- Decorator Combinations ---");
        printAction(basic);
        printAction(fireOnly);
        printAction(poisonOnly);
        printAction(critOnly);
        printAction(fireCrit);
        printAction(fullStack);

        // --- Facade Demo ---
        System.out.println("\n--- Full Dungeon Run ---");
        HeroProfile hero = new HeroProfile("Arthas", 150);
        BossEnemy boss = new BossEnemy("Dragon Boss", 200, 18);

        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, fullStack);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        System.out.println("\n--- Battle Log ---");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }

    private static void printAction(AttackAction action) {
        System.out.println("  " + action.getActionName()
                + " | dmg=" + action.getDamage()
                + " | " + action.getEffectSummary());
    }
}