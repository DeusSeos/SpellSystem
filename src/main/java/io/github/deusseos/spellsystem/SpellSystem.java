package io.github.deusseos.spellsystem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class SpellSystem extends JavaPlugin {

    public HashMap<UUID, List<Soul>> souls = new HashMap<>();

    @Override
    public void onEnable() {
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
        try {
            //Better way to check for this? Only in 1.13.1+?
            Class.forName("org.bukkit.event.block.BlockDispenseArmorEvent");
            getServer().getPluginManager().registerEvents(new DispenserArmorListener(), this);
        } catch (Exception ignored) {}

        CooldownSystem cooldownSystem = new CooldownSystem();
        cooldownSystem.runSoulCharger();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new LeaveJoin(), this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
