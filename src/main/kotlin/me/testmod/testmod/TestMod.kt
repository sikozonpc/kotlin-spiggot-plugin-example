package me.testmod.testmod

import me.testmod.testmod.listeners.PlayerListener
import me.testmod.testmod.listeners.TeleportBowListener
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin


class TestMod : JavaPlugin() {
    override fun onEnable() {
        // Register events
        server.pluginManager.registerEvents(PlayerListener, this)
        server.pluginManager.registerEvents(TeleportBowListener, this)

        Bukkit.getLogger().info("Enabled!")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}