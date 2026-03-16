package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult result) {
        if (result == null) return "No reward.";
        if (result.getRounds() <= 3) return "Legendary Chest (speed bonus)";
        if (result.getRounds() <= 6) return "Gold Chest";
        return "Basic Reward";
    }
}
