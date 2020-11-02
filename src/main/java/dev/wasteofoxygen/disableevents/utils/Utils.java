package dev.wasteofoxygen.disableevents.utils;

import org.bukkit.ChatColor;

public class Utils {

    // Color strings using ChatColor
    public String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }
}
