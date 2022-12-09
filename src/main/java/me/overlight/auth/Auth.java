package me.overlight.auth;

import org.bukkit.plugin.java.JavaPlugin;

public final class Auth extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new events(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
