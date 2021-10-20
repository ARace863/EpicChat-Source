/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicchat.Chat;

import me.arace863.epicchat.EpicChat;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEmoji implements Listener {
    EpicChat plugin;
    FileConfiguration config;

    public ChatEmoji(EpicChat plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (config.getBoolean("enableEmojis", true)){
            if (player.hasPermission("epicchat.emojis")) {
                String message = event.getMessage();
                message = message.replace("<3", ChatColor.RED + "❤");
                message = message.replace(":)", ChatColor.YELLOW + "☺");
                message = message.replace("(:", ChatColor.YELLOW + "☺");
                message = message.replace(":(", ChatColor.YELLOW + "☹");
                message = message.replace("):", ChatColor.YELLOW + "☹");
                event.setMessage(message);
            }
        }
    }
}
