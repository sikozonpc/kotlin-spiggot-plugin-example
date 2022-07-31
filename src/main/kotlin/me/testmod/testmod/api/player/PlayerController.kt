package me.testmod.testmod.api.player

import me.testmod.testmod.api.config.PluginConfig
import org.bukkit.Location
import org.bukkit.entity.Player

object PlayerController {
    private fun getPlayerHomeLocation(playerName: String): Location? = PluginConfig.config.get("${playerName}.home") as Location?

    fun teleportHome(player: Player) {
        val homeLocation = getPlayerHomeLocation(player.name)
        if (homeLocation === null) {
            player.sendMessage("You do not have a home in this world, do /setHome to set one")
            return
        }

        player.teleport(homeLocation)
    }
}