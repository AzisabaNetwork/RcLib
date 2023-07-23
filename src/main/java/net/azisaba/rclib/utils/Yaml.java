package net.azisaba.rclib.utils;

import net.azisaba.rclib.RcLib;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Yaml {
    /* Yamlオブジェクトの実装クラス */
    private final String yamlId;

    public Yaml(String yamlId) {
        /* コンストラクタ */
        this.yamlId = yamlId;
    }

    public YamlConfiguration get() {
        /* YamlConfigurationを取得する */
        File yamlFile = new File(RcLib.getPlugin().getDataFolder().getParent(), yamlId);
        YamlConfiguration yamlConfig = YamlConfiguration.loadConfiguration(yamlFile);
        set(yamlConfig);
        return yamlConfig;
    }

    public void set(YamlConfiguration yamlConfig) {
        /* YamlConfigurationを設定する */
        File yamlFile = new File(RcLib.getPlugin().getDataFolder().getParent(), yamlId);
        try {
            // ファイルへ上書きを試みる
            yamlConfig.save(yamlFile);
        }catch (IOException e) {
            // ファイルへの上書きに失敗したなら
        }
    }
}
