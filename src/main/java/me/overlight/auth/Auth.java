package me.overlight.auth;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public final class Auth extends JavaPlugin {

    static FileConfiguration config;
    public static List<String> loggedPlayers = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new events(), this);
        getServer().getPluginCommand("register").setExecutor(new commands());
        getServer().getPluginCommand("login").setExecutor(new commands());
        saveDefaultConfig();
        config = getConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
