package me.testmod.testmod.api.player

import me.testmod.testmod.TestMod
import org.bukkit.Location
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

object PlayerController {
    private val config: FileConfiguration
        get() {
            val config = TestMod.instance?.config
            if (config === null) throw Error("Plugin config file not found")
            return config;
        }

    private fun getPlayerHomeLocation(playerName: String): Location? = config.get("${playerName}.home") as Location?

    fun teleportHome(player: Player) {
        val homeLocation = getPlayerHomeLocation(player.name)
        if (homeLocation === null) {
            player.sendMessage("You do not have a home in this world, do /setHome to set one")
            return;
        }

        player.teleport(homeLocation)
    }
}