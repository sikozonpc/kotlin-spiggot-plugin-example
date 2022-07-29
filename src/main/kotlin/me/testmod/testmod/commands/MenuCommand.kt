package me.testmod.testmod.commands

import me.testmod.testmod.api.player.PlayerController
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack


object MenuCommand : PluginCommandExecutor {
    override val commandName = "menu"

    val MenuInventoryID = "${ChatColor.BLUE} Potato Menu"
    val MenuBookID = "${ChatColor.BLUE} Menu Book"


    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val menuBook = ItemStack(Material.ENCHANTED_BOOK, 1)
        val menuBookMeta = menuBook.itemMeta
        if (menuBookMeta !== null) {
            menuBookMeta.setDisplayName(MenuBookID)
            menuBookMeta.lore = arrayListOf("The one true book")
        }
        menuBook.itemMeta = menuBookMeta
        sender.inventory.addItem(menuBook)
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