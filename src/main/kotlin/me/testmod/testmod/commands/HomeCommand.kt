package me.testmod.testmod.commands

import me.testmod.testmod.TestMod
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object HomeCommand : PluginCommandExecutor {
    override val commandName = "home"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val config = TestMod.instance?.config
        if (config === null) throw Error("Plugin config file not found")

        val homeLocation = config.get("${sender.name}.home")
        if (homeLocation === null || homeLocation !is Location) {
            sender.sendMessage("You do not have a home in this world, do /setHome to set one")
            return true
        }

        sender.teleport(homeLocation)
        sender.sendMessage("Teleported home!")
        return true
    }
}