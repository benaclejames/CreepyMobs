package com.benaclejames.CreepyMobs;

import org.bukkit.plugin.java.JavaPlugin;

public class CreepyMobs extends JavaPlugin {

    public static CreepyMobs instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new MobSpawnListener(), this);
        getLogger().info("CreepyMobs Enabled!");
    }
}
