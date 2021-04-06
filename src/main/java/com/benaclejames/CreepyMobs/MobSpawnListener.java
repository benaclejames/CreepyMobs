package com.benaclejames.CreepyMobs;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.world.ChunkLoadEvent;

public class MobSpawnListener implements Listener {

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent event) { // Thanks for the help, Gongo!
        if (!event.isNewChunk()) return;
        for (Entity entity: event.getChunk().getEntities())
            if (entity instanceof Monster || entity instanceof Animals)
                CreateRider(entity);
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.isCancelled()) return;
        CreateRider(event.getEntity());
    }

    private void CreateRider(Entity entity) {
        if (entity instanceof Creeper) return;  // Remove this for hell

        LivingEntity newCreeper = (LivingEntity) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.CREEPER);
        new StackTask(entity, newCreeper).runTaskLater(CreepyMobs.instance, 1L);    // Give metadata a chance to finish setting
    }
}
