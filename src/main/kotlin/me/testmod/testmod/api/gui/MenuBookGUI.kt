package me.testmod.testmod.api.gui

import me.testmod.testmod.commands.MenuCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class MenuBookGUI(val player: Player) : GUI {
    override fun open() {
        val spawnSheepItem = ItemStack(Material.SHEEP_SPAWN_EGG, 1)

        val spawnSheepItemMeta = spawnSheepItem.itemMeta
        if (spawnSheepItemMeta != null) {
            spawnSheepItemMeta.setDisplayName("${ChatColor.GREEN} Spawn a beautiful sheep")
            spawnSheepItemMeta.lore = arrayListOf("It's said to spawn a sheep")
            spawnSheepItemMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true)
        }
        spawnSheepItem.itemMeta = spawnSheepItemMeta

        val menuInventory = Bukkit.createInventory(player, 9, MenuCommand.MenuInventoryID)
        menuInventory.setItem(0, spawnSheepItem)

        player.openInventory(menuInventory)
        player.playSound(player, Sound.ITEM_BOOK_PAGE_TURN, 3.0f, 1.0f)
    }
}