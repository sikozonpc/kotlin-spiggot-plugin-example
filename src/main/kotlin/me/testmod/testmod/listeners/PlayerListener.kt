package me.testmod.testmod.listeners

import org.bukkit.DyeColor
import org.bukkit.entity.Sheep
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerShearEntityEvent

object PlayerListener : Listener {
    @EventHandler
    fun onPlayerShear(event: PlayerShearEntityEvent) {
        if (event.entity !is Sheep) return
        (event.entity as Sheep).color = DyeColor.LIGHT_BLUE
    }

    @EventHandler
    fun onPlayerJoin(event: PlayerJoinEvent) {
        val player = event.player
        event.joinMessage = "Welcome back ${player.name} !"
    }
}