package me.overlight.auth;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class commands
        implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;
        if(Auth.loggedPlayers.contains(sender.getName())){
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("alreadyLoggedIn"))));
            return true;
        }
        if(label == "l" || label == "login"){
            if(args.length > 1) return false;
            if(PassManager.check(sender.getName(), args[0])){
                Auth.loggedPlayers.add(sender.getName());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("successLogin"))));
            } else{
                if(Auth.config.getString("failedLogin").startsWith("KICK:")) ((Player) sender).kickPlayer(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("failedLogin").substring(5))));
                else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("failedLogin"))));
            }
        } else if(label == "r" || label == "register"){
            if(args.length > 2) return false;
            if(!Objects.equals(args[0], args[1])){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("registerDifferentPassword"))));
            } else{
                Auth.loggedPlayers.add(sender.getName());
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Auth.config.getString("successLogin"))));
            }
        }
        return true;
    }
}
