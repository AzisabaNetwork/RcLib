package net.azisaba.rclib.commands;

import net.azisaba.rclib.RcLib;
import net.azisaba.rclib.entitys.User;
import net.azisaba.rclib.utils.Message;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Lib implements CommandExecutor {
    /* libコマンドの処理クラス */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        /* コマンドが実行されたとき */
        if (! sender.isOp()) {
            /* 送信者が管理者ではないなら */
            Message.send(RcLib.getPlugin(), ChatColor.RED + "You are not authorized to run this command!");
            return true;
        }
        String pluginVersion = RcLib.getPlugin().getDescription().getVersion();
        String apiVersion = RcLib.getPlugin().getDescription().getAPIVersion();
        Message.sendCommandSender(sender ,RcLib.getPlugin(), "plugin:" + pluginVersion + ", spigot:" + apiVersion);
        User user = new User("d7e5b662-531d-487d-bb30-0c829140e639");
        Bukkit.broadcastMessage(user.getMoney() + "");
        return true;
    }
}
