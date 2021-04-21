package io.github.deusseos.spellsystem;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Utils {

    public static List<String> soulList(List<Component> lore) {
        List<String> soulLore = new ArrayList<>();
        for (Component s : lore) {
            TextComponent textComponent = (TextComponent) s;
            String content = textComponent.content().toLowerCase(Locale.ROOT);
            if(content.matches("- +[A|a]ccumulates+ +\\d+ +(ice|dragon|fire|bone) +soul")){
                soulLore.add(content);
            }
        }
        return soulLore;
    }

    public static void removeSoul(){

    }

    public static void addSoul(){

    }

    public static boolean hasSoul(){

        return true;
    }

}
