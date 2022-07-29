package me.testmod.testmod.commands

import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object PlayerExplodeCommand : PluginCommandExecutor {
    override val commandName = "explode"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        sender.playSound(sender, Sound.ENTITY_GENERIC_EXPLODE, 3.0f, 1.0f)
        return true
    }
}