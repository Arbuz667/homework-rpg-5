package com.narxoz.rpg.decorator;

public class BasicAttack implements AttackAction {
    private final String actionName;
    private final int baseDamage;

    public BasicAttack(String actionName, int baseDamage) {
        this.actionName = actionName;
        this.baseDamage = baseDamage;
    }

    @Override
    public String getActionName() {
        // TODO: Return the base name of the action.
        return actionName;
    }

    @Override
    public int getDamage() {
        // TODO: Return the base damage before decorators modify it.
        return baseDamage;
    }

    @Override
    public String getEffectSummary() {
        return "Basic attack";
    }
}
