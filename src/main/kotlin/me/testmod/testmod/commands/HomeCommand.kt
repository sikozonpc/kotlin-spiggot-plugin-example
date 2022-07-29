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

        playerTeleportHome(sender)
        sender.sendMessage("Teleported home!")
        return true
    }

    private fun getPlayerHomeLocation(playerName: String): Location? {
        val config = TestMod.instance?.config
        if (config === null) throw Error("Plugin config file not found")

        return config.get("${playerName}.home") as Location?
    }

    fun playerTeleportHome(player: Player) {
        val homeLocation = getPlayerHomeLocation(player.name)
        if (homeLocation === null) {
            player.sendMessage("You do not have a home in this world, do /setHome to set one")
            return;
        }

        player.teleport(homeLocation)
    }
}