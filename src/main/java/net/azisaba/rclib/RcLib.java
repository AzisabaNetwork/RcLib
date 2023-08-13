package net.azisaba.rclib;

import net.azisaba.rclib.commands.Rcl;
import org.bukkit.plugin.java.JavaPlugin;

public final class RcLib extends JavaPlugin {
    /* RcLibのプラグインクラス */
    private static JavaPlugin plugin;
    public static JavaPlugin getPlugin() {return plugin;}

    @Override
    public void onEnable() {
        /* プラグインの起動ロジック */
        // ロジックの定義
        super.onEnable();
        plugin = this;
        // コンフィグファイルの定義
        saveDefaultConfig();
        // プラグインコマンドの定義
        getCommand("rcl").setExecutor(new Rcl());
    }

    @Override
    public void onDisable() {
        /* プラグインの終了ロジック */
        // ロジックの定義
        super.onDisable();
    }
}
