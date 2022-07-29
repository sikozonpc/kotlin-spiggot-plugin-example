package me.testmod.testmod.commands

import me.testmod.testmod.api.player.PlayerController
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack


object MenuCommand : PluginCommandExecutor {
    override val commandName = "menu"

    val MenuInventoryId = "${ChatColor.BLUE} Potato Menu"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) return false

        val spawnSheepItem = ItemStack(Material.SHEEP_SPAWN_EGG, 1)

        val spawnSheepItemMeta = spawnSheepItem.itemMeta
        if (spawnSheepItemMeta != null) {
            spawnSheepItemMeta.setDisplayName("${ChatColor.GREEN} Spawn a beautiful sheep")
            spawnSheepItemMeta.lore = arrayListOf("It's said to spawn a sheep")
            spawnSheepItemMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true)
        }
        spawnSheepItem.itemMeta = spawnSheepItemMeta

        val menuInventory = Bukkit.createInventory(sender, 9, MenuInventoryId)
        menuInventory.setItem(0, spawnSheepItem)

        sender.openInventory(menuInventory)
        sender.playSound(sender, Sound.ITEM_BOOK_PAGE_TURN, 3.0f, 1.0f)
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