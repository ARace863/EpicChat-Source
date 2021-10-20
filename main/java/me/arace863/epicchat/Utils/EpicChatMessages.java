/*
  Made by ARace863

  This plugin is protected by the Apache 2.0 License
  You may not repost this plugin or sell it by any means.
 */

package me.arace863.epicchat.Utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class EpicChatMessages {

    public void noPermission(Player player){
        player.sendMessage(ChatColor.AQUA + "[EpicChat] " + ChatColor.RED + "You do not have permission to do this!");
    }
}
