package me.testmod.testmod.commands

import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player


object PlayerFeedCommand : PluginCommandExecutor {
    override val commandName = "feed"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        sender.foodLevel = 20
        sender.playSound(sender, Sound.ENTITY_DONKEY_EAT, 3.0f, 1.0f)
        return true
    }

}