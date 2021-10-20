package me.arace863.epicchat;

import me.arace863.epicchat.Utils.StartupMethods;
import org.bukkit.plugin.java.JavaPlugin;

public final class EpicChat extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        StartupMethods methods = new StartupMethods(this);

        methods.startUpMessage();
        methods.registerEvents();

        this.saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
