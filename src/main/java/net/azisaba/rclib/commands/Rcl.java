package net.azisaba.rclib.commands;

import net.azisaba.rclib.RcLib;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Rcl implements CommandExecutor {
    /* rclコマンドの処理クラス */

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        /* コマンドが実行されたとき */
        if (! sender.isOp()) {
            /* 送信者が管理者ではないなら */
            sender.sendMessage(ChatColor.RED + "管理者権限で実行してください！");
            return true;
        }
        String version = RcLib.getPlugin().getDescription().getVersion();
        sender.sendMessage("バージョン " + version + "のRcLibが動作しています。");
        return true;
    }
}
