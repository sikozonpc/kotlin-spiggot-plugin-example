package me.testmod.testmod.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta


object MenuCommand : PluginCommandExecutor {
    override val commandName = "menu"

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

        val menuInventory = Bukkit.createInventory(sender, 9, "${ChatColor.BLUE} Potato Menu")
        menuInventory.setItem(0, spawnSheepItem)

        sender.openInventory(menuInventory)

        sender.playSound(sender, Sound.ITEM_BOOK_PAGE_TURN, 3.0f, 1.0f)
        return true
    }

}