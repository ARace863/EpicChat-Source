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
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {
    EpicChat plugin;
    FileConfiguration config;

    public PlayerLeave(EpicChat plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onJoin(PlayerQuitEvent event){
        if (this.config.getBoolean("enableCustomLeaveMessages", true)){
            event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', this.config.getString("preMessageLeaveName") + event.getPlayer().getName() + this.config.getString("customLeaveMessage")));
        }
    }
}
