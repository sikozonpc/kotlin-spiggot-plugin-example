package me.testmod.testmod.listeners

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ProjectileHitEvent

object TeleportBowListener : Listener {
    @EventHandler
    fun onArrowLand(event: ProjectileHitEvent) {
        val shooter = event.entity.shooter
        if (shooter !is Player) return

        val itemInMainHand = shooter.inventory.itemInMainHand

        val location = event.entity.location

        shooter.teleport(location)

        event.entity.remove()

        shooter.sendMessage(
            ChatColor.translateAlternateColorCodes(
                '&',
                "BOOOOMM"
            )
        )
        shooter.playSound(shooter, Sound.ENTITY_DRAGON_FIREBALL_EXPLODE, 1.0f, 1.0f)
    }
}