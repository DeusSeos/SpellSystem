package io.github.deusseos.spellsystem;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;

public class ArmorWear implements Listener {

    @EventHandler
    public void armorEquip(ArmorEquipEvent e){
        Player player = e.getPlayer();
        List<String> soulLore = null;
        if (!ArmorListener.isAirOrNull(e.getOldArmorPiece())) {
            if (e.getOldArmorPiece().hasItemMeta()) {
                try {
                    if (e.getOldArmorPiece().getItemMeta().hasLore()) {
                        soulLore.addAll(Utils.soulList(e.getOldArmorPiece().lore()));
                        int slot = e.getType().getSlot();

                    }
                } catch (NullPointerException exception) {
                    Bukkit.getConsoleSender().sendMessage("Old Armor");
                    Bukkit.getConsoleSender().sendMessage(e.getOldArmorPiece().toString());
                    Bukkit.getConsoleSender().sendMessage(exception.getMessage());
                }
            }
        }
        if (!ArmorListener.isAirOrNull(e.getNewArmorPiece())) {
            if (e.getNewArmorPiece().hasItemMeta()) {
                try {
                    if (e.getNewArmorPiece().getItemMeta().hasLore()) {
                        soulLore.addAll(Utils.soulList(e.getNewArmorPiece().lore()));
                    }
                } catch (NullPointerException exception) {
                    Bukkit.getConsoleSender().sendMessage("New Armor");
                    Bukkit.getConsoleSender().sendMessage(e.getNewArmorPiece().toString());
                    Bukkit.getConsoleSender().sendMessage(exception.getMessage());
                }
            }
        }
    }

}
