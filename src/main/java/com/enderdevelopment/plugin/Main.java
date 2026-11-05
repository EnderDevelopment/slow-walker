package com.enderdevelopment.plugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new SlowWalkListener(this), this);
        getLogger().info("SlowWalk enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("SlowWalk disabled.");
    }
}
