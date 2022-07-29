package me.testmod.testmod

import me.testmod.testmod.commands.*
import me.testmod.testmod.listeners.*
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin


class TestMod : JavaPlugin() {
    companion object {
        var instance: TestMod? = null
            private set;
    }

    private fun registerCommands(commands: Array<PluginCommandExecutor>) {
        commands.forEach {
            val cmd = getCommand(it.commandName)
            if (cmd === null) throw Error("Command $name is not yet registered in the plugin.yml file")

            cmd.setExecutor(it)
        }
        logger.info("Plugin commands successfully registered ")
    }

    private fun registerEvents(events: Array<Listener>) {
        events.forEach { server.pluginManager.registerEvents(it, this) }
        logger.info("Plugin Events successfully registered")
    }

    override fun onEnable() {
        config.options().copyDefaults()
        saveConfig()

        registerEvents(arrayOf(
            PlayerListener,
            TeleportBowListener
        ))
        registerCommands(arrayOf(
            PlayerExplodeCommand,
            PlayerFeedCommand,
            HomeCommand,
            SetHomeCommand,
        ))

        instance = this

        logger.info("Plugin Enabled")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

}