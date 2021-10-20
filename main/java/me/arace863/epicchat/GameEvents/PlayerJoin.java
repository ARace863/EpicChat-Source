/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicchat.GameEvents;

import me.arace863.epicchat.EpicChat;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    EpicChat plugin;
    FileConfiguration config;

    public PlayerJoin(EpicChat plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        if (this.config.getBoolean("enableCustomJoinMessages", true)){
            event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', this.config.getString("preMessageName") + event.getPlayer().getName() + this.config.getString("customJoinMessage")));
        }
    }
}
