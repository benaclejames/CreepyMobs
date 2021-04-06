package com.benaclejames.CreepyMobs;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

public class StackTask extends BukkitRunnable {
    private final Entity stackTarget;
    private final LivingEntity stackRider;

    public StackTask(Entity stackTarget, LivingEntity stackRider) {
        this.stackTarget = stackTarget;
        this.stackRider = stackRider;
    }

    @Override
    public void run() {
        stackTarget.addPassenger(stackRider);
        stackRider.setInvisible(true);
    }
}
