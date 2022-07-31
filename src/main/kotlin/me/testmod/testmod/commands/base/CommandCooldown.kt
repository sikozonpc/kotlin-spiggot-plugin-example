package me.testmod.testmod.commands.base

import org.bukkit.entity.Player
import java.util.UUID

abstract class CommandCooldown {
    abstract val cooldowns: MutableMap<UUID, Long>
    abstract val cooldownTimeInMilliseconds: Int

    private fun getPlayerTimeElapsed(player: Player): Long =
        System.currentTimeMillis() - cooldowns[player.uniqueId]!!

    fun isOnCooldown(player: Player): Boolean {
        val playerCooldown = cooldowns[player.uniqueId]
        if (playerCooldown === null) {
            cooldowns[player.uniqueId] = System.currentTimeMillis()
            return false
        }

        val timeElapsed = getPlayerTimeElapsed(player)
        return if (timeElapsed >= cooldownTimeInMilliseconds) {
            cooldowns[player.uniqueId] = System.currentTimeMillis()
            false
        } else {
            val timeUntilCommand = cooldownTimeInMilliseconds - timeElapsed
            val timeInSeconds = timeUntilCommand/1000
            player.sendMessage("Command is on cooldown, try again in $timeInSeconds seconds")
            true
        }
    }
}