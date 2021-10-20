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

public class PlayerMentions implements Listener {
    EpicChat plugin;
    FileConfiguration config;

    public PlayerMentions(EpicChat plugin){
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        if (config.getBoolean("enablePlayerMentions", true)){
            for (Player player : event.getRecipients()) {
                if (event.getMessage().toLowerCase().contains(player.getName().toLowerCase())) {
                    String nameMessage = event.getMessage();
                    nameMessage = nameMessage.replace(player.getDisplayName(), ChatColor.YELLOW + player.getDisplayName() + ChatColor.RESET);

                    event.setMessage(nameMessage);

                    if (this.config.getBoolean("sendMentionTitle", true)){
                        player.sendTitle("§",ChatColor.YELLOW + event.getPlayer().getName() + " has mentioned you in chat!");
                    }
                }else{
                    String message = event.getMessage();
                    event.setMessage(message);
                }
            }
        }
    }
}
