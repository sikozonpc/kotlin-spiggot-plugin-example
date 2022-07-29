package me.testmod.testmod.listeners

import me.testmod.testmod.api.gui.MenuBookGUI
import me.testmod.testmod.commands.MenuCommand
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.ItemStack

object MenuInventoryListener : Listener {
    /**
     * Makes the Menu Inventory items not draggable and adds
     * click behaviour
     */
    @EventHandler
    fun onPlayerItemClick(event: InventoryClickEvent) {
        val isMenuInventoryView = event.view.title.equals(MenuCommand.MenuInventoryID, true)
        when {
            isMenuInventoryView -> MenuCommand.onMenuItemClick(event)
        }
    }

    @EventHandler
    fun onPlayerItemInteract(event: PlayerInteractEvent) {
        val item = event.item
        if (item === null) return

        val hasClickedOnMenuBook = item.itemMeta?.displayName.equals(MenuCommand.MenuBookID)
        when {
            hasClickedOnMenuBook -> MenuBookGUI(event.player).open()
        }
    }

}