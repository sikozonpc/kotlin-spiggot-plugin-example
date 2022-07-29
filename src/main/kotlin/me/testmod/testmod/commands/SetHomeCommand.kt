package me.testmod.testmod.commands

import me.testmod.testmod.TestMod
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object SetHomeCommand : PluginCommandExecutor {
    override val commandName = "setHome"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val config = TestMod.instance?.config
        if (config === null) throw Error("Plugin config file not found")

        config.set("${sender.name}.home", sender.location)
        TestMod.instance?.saveConfig();

        sender.sendMessage("Home location has been set!")

        return true
    }
}