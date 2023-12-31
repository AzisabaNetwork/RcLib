package net.azisaba.rclib.utils;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Yaml {
    /* Yamlオブジェクトの実装クラス */
    private final String yamlId;
    private final JavaPlugin plugin;

    public Yaml(String yamlId, JavaPlugin plugin) {
        /* コンストラクタ */
        this.yamlId = yamlId;
        this.plugin = plugin;
    }

    public YamlConfiguration get() {
        /* YamlConfigurationを取得する */
        File yamlFile = new File(this.plugin.getDataFolder(), this.yamlId + ".yml");
        YamlConfiguration yamlConfig = YamlConfiguration.loadConfiguration(yamlFile);
        set(yamlConfig);
        return yamlConfig;
    }

    public void set(YamlConfiguration yamlConfig) {
        /* YamlConfigurationを設定する */
        File yamlFile = new File(this.plugin.getDataFolder(), this.yamlId + ".yml");
        try {
            yamlConfig.save(yamlFile);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
