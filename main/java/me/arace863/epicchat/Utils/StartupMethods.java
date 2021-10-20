/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicchat.Utils;

import me.arace863.epicchat.Chat.ChatCensor;
import me.arace863.epicchat.Chat.ChatEmoji;
import me.arace863.epicchat.Chat.PlayerMentions;
import me.arace863.epicchat.EpicChat;
import me.arace863.epicchat.GameEvents.PlayerKill;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class StartupMethods {
    EpicChat plugin;

    public StartupMethods(EpicChat plugin) {
        this.plugin = plugin;
    }

    public void startUpMessage() {
        System.out.println(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "---------------[ EpicChat ]---------------");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "         Started up successfully");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "                  v" + plugin.getDescription().getVersion());
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "            Made by ARace863");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + "            Server Version:");
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_GRAY + " " + Bukkit.getVersion());
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "-------------------------------------------");
        Bukkit.getConsoleSender().sendMessage(" ");
    }

    public void registerEvents() {
        plugin.getServer().getPluginManager().registerEvents(new ChatCensor(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new ChatEmoji(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerMentions(plugin), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerKill(plugin), plugin);
    }
}
