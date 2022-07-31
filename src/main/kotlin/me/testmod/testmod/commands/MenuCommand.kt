package me.testmod.testmod.commands

import me.testmod.testmod.api.items.MenuBook
import me.testmod.testmod.api.player.PlayerController
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent


object MenuCommand : PluginCommandExecutor {
    override val commandName = "menu"

    val MenuInventoryID = "${ChatColor.BLUE} Potato Menu"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        sender.inventory.addItem(MenuBook.create())
        return true
    }

    fun onMenuItemClick(event: InventoryClickEvent) {
        val currentItem = event.currentItem
        if (currentItem === null) return

        val player = event.whoClicked
        if (player !is Player) return

        when (currentItem.type) {
            Material.SHEEP_SPAWN_EGG -> PlayerController.teleportHome(player)
            else -> return
        }

        // avoid moving of items
        event.isCancelled = true
    }
}