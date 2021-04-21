package io.github.deusseos.spellsystem;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;


import java.util.List;

import java.util.UUID;


public class CooldownSystem {

    SpellSystem spellSystemPlugin = SpellSystem.getPlugin(SpellSystem.class);

    public void runSoulCharger() {
        Bukkit.getConsoleSender().sendMessage("SpellSystem: Enabling soul charger.");
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(spellSystemPlugin, () -> {
            for (UUID key:spellSystemPlugin.souls.keySet()) {
                List<Soul> soulList = spellSystemPlugin.souls.get(key);
                for (Soul soul: soulList){
                    soul.tickDown();
                }
            }
        }, 0L, 1L);
        // Plugin startup logic
    }

}



