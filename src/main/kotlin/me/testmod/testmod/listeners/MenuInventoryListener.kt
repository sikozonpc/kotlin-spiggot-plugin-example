package me.testmod.testmod.listeners

import me.testmod.testmod.commands.MenuCommand
import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

object MenuInventoryListener : Listener {
    /**
     * Makes the Menu Inventory items not draggable and adds
     * click behaviour
     */
    @EventHandler
    fun onPlayerMenuClick(event: InventoryClickEvent) {
        val isMenuInventoryView = event.view.title.equals(MenuCommand.MenuInventoryId, true)
        when {
            isMenuInventoryView -> MenuCommand.onMenuItemClick(event)
        }
    }
}