package io.github.deusseos.spellsystem;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;


public class LeaveJoin implements Listener {

    SpellSystem main = SpellSystem.getPlugin(SpellSystem.class);

    @EventHandler
    public void playerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        ItemStack[] armor = event.getPlayer().getInventory().getArmorContents();
        for (ItemStack armorPiece:armor) {
            Soul soul = Utils.toSoul(armorPiece.lore());
            int slot = ArmorType.matchType(armorPiece).getSlot();
            soul.setSlot(slot);
            Utils.addSoul(main.souls, soul, player.getUniqueId());
        }
    }
    @EventHandler
    public void playerLeave(PlayerQuitEvent event){
        Player player = event.getPlayer();
        main.souls.remove(player.getUniqueId());
    }

}
