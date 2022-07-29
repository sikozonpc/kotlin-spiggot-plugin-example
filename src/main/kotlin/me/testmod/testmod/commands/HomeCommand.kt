package me.testmod.testmod.commands

import me.testmod.testmod.TestMod
import me.testmod.testmod.api.player.PlayerController
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object HomeCommand : PluginCommandExecutor {
    override val commandName = "home"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        PlayerController.teleportHome(sender)
        sender.sendMessage("Teleported home!")
        return true
    }
}