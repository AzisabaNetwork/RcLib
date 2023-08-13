package net.azisaba.rclib.utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class CraftPlayer {
    /* CraftPlayerオブジェクトの実装クラス */

    public static boolean isOnline(@NotNull String name) {
        /* オンラインかを判定する: name */
        for (Player player : Bukkit.getOnlinePlayers()) if (player.getName().equals(name)) return true;
        return false;
    }

    public static boolean isOnline(@NotNull UUID uuid) {
        /* オンラインかを判定する: uuid */
        for (Player player : Bukkit.getOnlinePlayers()) if (player.getUniqueId().equals(uuid)) return true;
        return false;
    }

    public static boolean hasScoreboardTag(@NotNull Player player, @NotNull String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: player */
        return player.getScoreboardTags().contains(scoreboardTag);
    }

    public static boolean hasScoreboardTag(@NotNull String name, @NotNull String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: name */
        if (! isOnline(name)) return false;
        Player player = Bukkit.getPlayer(name);
        return hasScoreboardTag(player, scoreboardTag);
    }

    public static boolean hasScoreboardTag(@NotNull UUID uuid, @NotNull String scoreboardTag) {
        /* scoreboardTagを持つかを判定する: uuid */
        if (! isOnline(uuid)) return false;
        Player player = Bukkit.getPlayer(uuid);
        return hasScoreboardTag(player, scoreboardTag);
    }

    public static ItemStack getHead(@NotNull Player player) {
        /* Headを取得する: player */
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(player);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getHead(@NotNull String name) {
        /* Headを取得する: name */
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(name));
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack getHead(@NotNull UUID uuid) {
        /* Headを取得する: name */
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwningPlayer(Bukkit.getOfflinePlayer(uuid));
        item.setItemMeta(meta);
        return item;
    }
}
