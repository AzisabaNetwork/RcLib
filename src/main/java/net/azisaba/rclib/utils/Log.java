package net.azisaba.rclib.utils;

import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class Log {
    /* LogFileオブジェクトの実装クラス */
    private final String logId;
    private final JavaPlugin plugin;

    public Log(String logId, JavaPlugin plugin) {
        /* コンストラクタ */
        this.logId = logId;
        this.plugin = plugin;
    }

    public void write(String log) {
        /* ログを書き込む */
        try {
            // 書き込みを試みる
            FileWriter fileWriter = new FileWriter(plugin.getDataFolder() + "/" + this.logId + ".log", true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(new Date() + ": " + log);
            printWriter.flush();
            printWriter.close();
        }catch (IOException e) {
            // 書き込みに失敗したなら
        }
    }

    @Deprecated
    public void clear() {
        /* ログを初期化する */
        try {
            // 書き込みを試みる
            FileWriter fileWriter = new FileWriter(plugin.getDataFolder() + this.logId + ".log");
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e) {
            // 書き込みに失敗したなら
        }
    }
}
