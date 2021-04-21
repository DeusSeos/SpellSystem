package io.github.deusseos.spellsystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

import java.util.*;

public class Utils {

    public static List<String> soulList(List<Component> lore) {
        List<String> soulLore = new ArrayList<>();
        for (Component s : lore) {
            TextComponent textComponent = (TextComponent) s;
            String content = textComponent.content().toLowerCase(Locale.ROOT);
            if (content.matches("- +[A|a]ccumulates+ +\\d+ +(ice|dragon|fire|bone) +soul")) {
                soulLore.add(content);
            }
        }
        return soulLore;
    }


    public static void removeSoul(HashMap<UUID, List<Soul>> mapping, int slotNumber, UUID playerID) {
        if (mapping.containsKey(playerID)) {
            List<Soul> soulList = mapping.get(playerID);
            soulList.removeIf(soul -> soul.getSlot() == slotNumber);
            mapping.replace(playerID, soulList);
        }
    }

    public static void addSoul(HashMap<UUID, List<Soul>> mapping, Soul soul, UUID playerID) {
        List<Soul> soulList = null;
        if (mapping.containsKey(playerID)) {
            soulList = mapping.get(playerID);
            soulList.add(soul);
        }
        mapping.replace(playerID, soulList);

    }

    public static boolean hasSoul(HashMap<UUID, List<Soul>> mapping, int soulID, UUID playerID) {
        if (mapping.containsKey(playerID)) {
            List<Soul> soulList = mapping.get(playerID);
            for (Soul soul : soulList) {
                if (soul.getSoulID() == soulID) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Soul toSoul(List<Component> lore) {
        List<String> soulList = soulList(lore);
        for (String soulLore : soulList) {
            if (soulLore.contains("dragon"))
                return new DragonSoul();
            else if (soulLore.contains("bone"))
                return new ShadowSoul();
            else if (soulLore.contains("ice"))
                return new IceSoul();
            else if (soulLore.contains("fire"))
                return new FireSoul();
        }
        return null;
    }
}
