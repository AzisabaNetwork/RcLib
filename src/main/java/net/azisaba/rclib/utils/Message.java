package net.azisaba.rclib.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Message {
    /* Messageオブジェクトの実装クラス */

    public static String generate(JavaPlugin plugin, String message) {
        /* メッセージを生成する: plugin, message */
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        ChatColor[] colors = {ChatColor.DARK_BLUE, ChatColor.DARK_GREEN, ChatColor.DARK_RED, ChatColor.DARK_PURPLE, ChatColor.GOLD, ChatColor.BLUE, ChatColor.GREEN, ChatColor.RED, ChatColor.LIGHT_PURPLE, ChatColor.YELLOW, ChatColor.GOLD};
        String pluginName = plugin.getName();
        return colors[alphabet.indexOf(pluginName.charAt(0)) % colors.length].toString() + ChatColor.BOLD + pluginName + ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.RESET + ChatColor.WHITE + message;
    }

    public static String generate(JavaPlugin plugin) {
        /* メッセージを生成する: plugin */
        String pluginName = plugin.getName();
        return ChatColor.valueOf("RED") + pluginName + ChatColor.RESET + ChatColor.GRAY + ": " + ChatColor.RESET + ChatColor.WHITE;
    }

    public static void send(JavaPlugin plugin, String message) {
        /* メッセージを送信する */
        Bukkit.broadcastMessage(generate(plugin, message));
    }

    public static void sendPlayer(Player player, JavaPlugin plugin, String message) {
        /* プレイヤーにメッセージを送信する */
        player.sendMessage(generate(plugin, message));
    }

    public static void sendConsole(JavaPlugin plugin, String message) {
        /* コンソールにメッセージを送信する */
        plugin.getLogger().info(message);
    }

    public static void sendCommandSender(CommandSender sender, JavaPlugin plugin, String message) {
        /* コマンド送信者にメッセージを送信する */
        sender.sendMessage(generate(plugin, message));
    }

    public static void sendPermission(String permission, JavaPlugin plugin, String message) {
        /* 権限にメッセージに送信する */
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission(permission)) player.sendMessage(generate(plugin, message));
        }
    }

    public static void sendScoreboardTag(String scoreboardTag, JavaPlugin plugin, String message) {
        /* スコアボードタグに送信する */
        for (Player player : Bukkit.getOnlinePlayers()) {
            String[] tags = player.getScoreboardTags().toArray(new String[0]);
            for (String tag : tags) {
                if (tag.equals(scoreboardTag)) player.sendMessage(generate(plugin, message));
            }
        }
    }
}
