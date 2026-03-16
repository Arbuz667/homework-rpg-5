package com.narxoz.rpg.decorator;

public class FireRuneDecorator extends ActionDecorator {
    public FireRuneDecorator(AttackAction wrappedAction) {
        super(wrappedAction);
    }

    @Override
    public String getActionName() {
        return super.getActionName() + " [Fire Rune]";
    }

    @Override
    public int getDamage() {
        return (int) Math.round(super.getDamage() * 1.3);
    }

    @Override
    public String getEffectSummary() {
        return super.getEffectSummary() + " + Fire(+30%)";
    }
}
