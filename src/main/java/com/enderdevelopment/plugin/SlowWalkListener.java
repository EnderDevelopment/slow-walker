package com.enderdevelopment.plugin;

import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SlowWalkListener implements Listener {

    private final Main plugin;
    private static final double SLOW_SPEED = 0.05;

    public SlowWalkListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        setSlowWalk(event.getPlayer());
    }

    private void setSlowWalk(Player player) {
        Attribute attribute = Registry.ATTRIBUTE.get(NamespacedKey.minecraft("movement_speed"));
        if (attribute == null) {
            return;
        }
        AttributeInstance instance = player.getAttribute(attribute);
        if (instance != null) {
            instance.setBaseValue(SLOW_SPEED);
        }
    }
}
