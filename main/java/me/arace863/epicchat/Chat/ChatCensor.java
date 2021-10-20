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

import java.util.List;

public class ChatCensor implements Listener {
    EpicChat plugin;
    FileConfiguration config;

    public ChatCensor(EpicChat plugin) {
        this.plugin = plugin;
        this.config = plugin.getConfig();
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        if (config.getBoolean("censorWords", true)){
            String[] arrayOfString;
            int j = (arrayOfString = e.getMessage().split(" ")).length;
            for (int i = 0; i < j; i++) {
                String words = arrayOfString[i];
                List<String> cursewordslist = config.getStringList("censoredWords");
                if (cursewordslist.contains(words.toLowerCase())) {
                    String newMessage = e.getMessage();
                    for (String bannedwords : cursewordslist) newMessage = newMessage.replace(bannedwords, ChatColor.RED + "****" + ChatColor.RESET);
                    e.setMessage(newMessage);
                }
            }
        }
    }
}