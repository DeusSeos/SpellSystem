package io.github.deusseos.spellsystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

import java.util.*;

public class Utils {

    public static List<String> soulList(List<Component> lores) {
        List<String> soulLore = new ArrayList<>();
        for (Component s : lores) {
            TextComponent textComponent = (TextComponent) s;
            String content = textComponent.content().toLowerCase(Locale.ROOT);
            if (content.matches("- +[A|a]ccumulates+ +\\d+ +(ice|dragon|fire|shadow) +soul.")) {
                soulLore.add(content);
            }
        }
        return soulLore;
    }

    public static void removeCharge(HashMap<UUID, List<Soul>> mapping, List<Component> lores, UUID playerID) {
        List<String> soulList = soulList(lores);
        if (!lores.isEmpty()) {
            if (mapping.containsKey(playerID)) {
                List<Soul> souls = mapping.get(playerID);
                for (String lore: soulList){
                    int soulID = getID(lore);
                    Soul soul = souls.get(soulID);
                    soul.setCharges(-Integer.parseInt(lore.replaceAll("[\\D]", "")));
                }
            }
        }
    }

    public static void addCharge(HashMap<UUID, List<Soul>> mapping, List<Component> lores, UUID playerID) {
        List<String> soulList = soulList(lores);
        if (!lores.isEmpty()) {
            if (mapping.containsKey(playerID)) {
                List<Soul> souls = mapping.get(playerID);
                for (String lore: soulList){
                    int soulID = getID(lore);
                    Soul soul = souls.get(soulID);
                    soul.setCharges(Integer.parseInt(lore.replaceAll("[\\D]", "")));
                }
            }
        }
    }

//    public static boolean hasSoul(HashMap<UUID, List<Soul>> mapping, int soulID, UUID playerID) {
//        if (mapping.containsKey(playerID)) {
//            List<Soul> soulList = mapping.get(playerID);
//            for (Soul soul : soulList) {
//                if (soul.getSoulID() == soulID) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public static int getID(String lore) {
        if (lore.contains("dragon"))
            return 3;
        else if (lore.contains("shadow"))
            return 2;
        else if (lore.contains("ice"))
            return 0;
        else if (lore.contains("fire"))
            return 1;
        else return -1;
    }
}
