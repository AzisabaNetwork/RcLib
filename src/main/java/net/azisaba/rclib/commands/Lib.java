package net.azisaba.rclib.commands;

import net.azisaba.rclib.RcLib;
import net.azisaba.rclib.utils.Chat;
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
            sender.sendMessage(Chat.f(RcLib.getPlugin(), ChatColor.RED + "コマンドを実行する権限が不足しています。"));
            return true;
        }
        String pluginVersion = RcLib.getPlugin().getDescription().getVersion();
        sender.sendMessage(Chat.f(RcLib.getPlugin(), "このRcLibはver" + pluginVersion + "です。"));
        return true;
    }
}
