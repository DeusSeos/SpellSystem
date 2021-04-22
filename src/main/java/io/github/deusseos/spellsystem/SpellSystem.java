package io.github.deusseos.spellsystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class SpellSystem extends JavaPlugin {

    public HashMap<UUID, List<Soul>> souls = new HashMap<>();

    public void addPlayers() {
        for (Player player : getServer().getOnlinePlayers()) {
            List<Soul> soulList = new ArrayList<>();
            soulList.add(new IceSoul());
            soulList.add(new FireSoul());
            soulList.add(new DragonSoul());
            soulList.add(new ShadowSoul());
            soulList.add(new ZordSoul());
            souls.putIfAbsent(player.getUniqueId(), soulList);

        }
    }

    public void rechargeNotify(Player player, Soul soul) {
        Location location = player.getLocation();
//        player.sendMessage("Sending sound?");
        location.getWorld().playSound(location, soul.getChargeSound(), soul.getVolume(), soul.getPitch());
    }

    public void runSoulCharger() {
        Bukkit.getConsoleSender().sendMessage("SpellSystem: Enabling soul charger.");
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(this, () -> {
//            Bukkit.getConsoleSender().sendMessage("Hi");
//            Bukkit.getConsoleSender().sendMessage(souls.toString());
            for (UUID key : souls.keySet()) {
                List<Soul> soulList = souls.get(key);
//                Bukkit.getConsoleSender().sendMessage("soulList: " + soulList.toString());
                for (Soul soul : soulList) {
                    if (!soul.isFullyCharged()){
                        soul.tickDown();
                    }

                    if (soul.getSoulTicks() == 0) {
                        Player player = Bukkit.getPlayer(key);
//                        Bukkit.broadcastMessage(soul.toString());
                        rechargeNotify(player, soul);

                    }
                }
            }
        }, 0L, 1L);
        // Plugin startup logic
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();


        getServer().getPluginManager().registerEvents(new ArmorListener(getConfig().getStringList("blocked")), this);
        try {
            //Better way to check for this? Only in 1.13.1+?
            Class.forName("org.bukkit.event.block.BlockDispenseArmorEvent");
            getServer().getPluginManager().registerEvents(new DispenserArmorListener(), this);
        } catch (Exception ignored) {
        }
        addPlayers();
        runSoulCharger();
//        CooldownSystem cooldownSystem = new CooldownSystem();
//        cooldownSystem.runSoulCharger();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new LeaveJoin(), this);
        manager.registerEvents(new ArmorWear(), this);
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
