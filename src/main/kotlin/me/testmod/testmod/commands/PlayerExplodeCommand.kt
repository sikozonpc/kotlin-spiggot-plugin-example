package me.testmod.testmod.commands

import me.testmod.testmod.commands.base.CommandCooldown
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import java.util.*

object PlayerExplodeCommand : PluginCommandExecutor, CommandCooldown() {
    override val commandName = "explode"

    override val cooldowns: MutableMap<UUID, Long> = mutableMapOf()
    override val cooldownTimeInMilliseconds = 10000

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false
        if (isOnCooldown(sender)) return true


        sender.playSound(sender, Sound.ENTITY_GENERIC_EXPLODE, 3.0f, 1.0f)
        return true
    }
}