package io.github.deusseos.spellsystem;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


public class CooldownSystem extends BukkitRunnable {

    private SpellSystem plugin;

    public CooldownSystem(SpellSystem plugin){
        this.plugin = plugin;
    }

    SpellSystem main = SpellSystem.getPlugin(SpellSystem.class);

    public void rechargeNotify(Player player, Soul soul) {
        Location location = player.getLocation();
        player.sendMessage("Sending sound?");
        location.getWorld().playSound(location, soul.getChargeSound(), soul.getVolume(), soul.getPitch());
    }

//    public void runSoulCharger() {
//        Bukkit.getConsoleSender().sendMessage("SpellSystem: Enabling soul charger.");
//        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
//        scheduler.scheduleSyncRepeatingTask(main, () -> {
//            for (UUID key:main.souls.keySet()) {
//                List<Soul> soulList = main.souls.get(key);
//                Bukkit.getConsoleSender().sendMessage(soulList.toString());
//                for (Soul soul: soulList){
//                    if (!soul.isCharged())
//                        soul.tickDown();
//                    if(soul.getSoulTicks() == 0){
//                        Player player = Bukkit.getPlayer(key);
//                        Bukkit.broadcastMessage(soul.toString());
//                        rechargeNotify(player, soul);
//
//                    }
//                }
//            }
//        }, 0L, 1L);
//        // Plugin startup logic
//    }

    @Override
    public void run() {

    }
}



