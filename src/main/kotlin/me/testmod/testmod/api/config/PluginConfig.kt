package me.testmod.testmod.api.config

import me.testmod.testmod.TestMod
import org.bukkit.configuration.file.FileConfiguration

object PluginConfig {
    val config: FileConfiguration
        get() {
            val configInstance = TestMod.instance?.config
            if (configInstance === null) throw Error("Plugin config file not found")
            return configInstance
        }
}