package me.overlight.auth;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Objects;

public class events
        implements Listener {
    @EventHandler
    public void event(PlayerJoinEvent e){
        if(PassManager.check(e.getPlayer().getName())){
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("loginMSG"))));
        } else{
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("registerMSG"))));
        }
    }
}
