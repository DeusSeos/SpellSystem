package io.github.deusseos.spellsystem;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class SpellSystem extends JavaPlugin {

    public HashMap<UUID, List<Soul>> souls = new HashMap<>();

    @Override
    public void onEnable() {
        CooldownSystem cooldownSystem = new CooldownSystem();
        cooldownSystem.runSoulCharger();
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
