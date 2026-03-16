package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();
        int rounds = 0;

        while (hero.isAlive() && boss.isAlive()) {
            rounds++;
            result.addLine("=== Round " + rounds + " ===");

            // Hero attacks boss
            int heroDmg = action.getDamage();
            boss.takeDamage(heroDmg);
            result.addLine(hero.getName() + " uses " + action.getActionName()
                    + " for " + heroDmg + " dmg. Boss HP: " + boss.getHealth());

            if (!boss.isAlive()) break;

            // Boss attacks hero
            int bossDmg = boss.getAttackPower();
            hero.takeDamage(bossDmg);
            result.addLine(boss.getName() + " attacks for " + bossDmg
                    + " dmg. Hero HP: " + hero.getHealth());
        }

        result.setRounds(rounds);
        result.setWinner(hero.isAlive() ? hero.getName() : boss.getName());
        return result;
    }
}
