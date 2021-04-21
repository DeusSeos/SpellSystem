package io.github.deusseos.spellsystem;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.List;
import java.util.UUID;


public class CooldownSystem {

    SpellSystem main = SpellSystem.getPlugin(SpellSystem.class);

    public void rechargeNotify(Player player, Soul soul) {
        Location location = player.getLocation();
        location.getWorld().playSound(location, soul.getChargeSound(), soul.getVolume(), soul.getPitch());
    }

    public void runSoulCharger() {
        Bukkit.getConsoleSender().sendMessage("SpellSystem: Enabling soul charger.");
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(main, () -> {
            for (UUID key:main.souls.keySet()) {
                List<Soul> soulList = main.souls.get(key);
                for (Soul soul: soulList){
                    if (!soul.isCharged())
                        soul.tickDown();
                    if(soul.getSoulTicks() == 0){
                        Player player = Bukkit.getPlayer(key);
                        rechargeNotify(player, soul);

                    }
                }
            }
        }, 0L, 1L);
        // Plugin startup logic
    }

}



