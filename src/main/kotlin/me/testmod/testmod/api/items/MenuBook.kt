package me.testmod.testmod.api.items

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

object MenuBook : Item {
    val displayName = "${ChatColor.BLUE} Menu Book"
    var lore = arrayListOf("The one true book")

    override fun create(): ItemStack {
        val menuBook = ItemStack(Material.ENCHANTED_BOOK, 1)
        val menuBookMeta = menuBook.itemMeta
        if (menuBookMeta !== null) {
            menuBookMeta.setDisplayName(displayName)
            menuBookMeta.lore = lore
        }
        menuBook.itemMeta = menuBookMeta

        return menuBook
    }
}