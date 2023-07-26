package net.azisaba.rclib.utils;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Chat {
    /* Chatオブジェクトの実装クラス */

    public static String f(JavaPlugin plugin, String message) {
        /* メッセージをフォーマットする */
        return h(plugin) + message;
    }

    public static String h(JavaPlugin plugin) {
        /* メッセージのヘッダを作成する */
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ChatColor[] colors = {ChatColor.RED, ChatColor.BLUE, ChatColor.YELLOW, ChatColor.GREEN, ChatColor.AQUA, ChatColor.GOLD, ChatColor.DARK_RED, ChatColor.DARK_BLUE, ChatColor.DARK_GREEN, ChatColor.DARK_AQUA};
        String pluginName = plugin.getName();
        return colors[alphabet.indexOf(pluginName.charAt(0)) % colors.length].toString() + ChatColor.BOLD + pluginName + ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.RESET + ChatColor.WHITE;
    }
}
