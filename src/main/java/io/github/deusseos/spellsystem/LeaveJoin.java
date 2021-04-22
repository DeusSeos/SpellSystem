package io.github.deusseos.spellsystem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.List;


public class LeaveJoin implements Listener {

    SpellSystem main = SpellSystem.getPlugin(SpellSystem.class);

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        List<Soul> soulList = new ArrayList<>();
        soulList.add(0, new IceSoul());
        soulList.add(1, new FireSoul());
        soulList.add(2, new ShadowSoul());
        soulList.add(3, new DragonSoul());
        soulList.add(4, new ZordSoul());
        main.souls.putIfAbsent(player.getUniqueId(), soulList);
    }
    @EventHandler
    public void playerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        main.souls.remove(player.getUniqueId());
    }

}
