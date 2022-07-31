package me.testmod.testmod.listeners

import me.testmod.testmod.api.gui.MenuBookGUI
import me.testmod.testmod.api.items.MenuBook
import me.testmod.testmod.commands.MenuCommand
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.Action.RIGHT_CLICK_AIR
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.player.PlayerInteractEvent

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
        val hasRightClicked = arrayOf(RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK).contains(event.action)
        when {
            hasRightClicked -> handleRightClickBook(event)
        }
    }

    private fun handleRightClickBook(event: PlayerInteractEvent) {
        val item = event.item
        if (item === null) return

        val hasClickedOnMenuBook = item.itemMeta?.displayName.equals(MenuBook.displayName)
        when {
            hasClickedOnMenuBook -> MenuBookGUI(event.player).open()
        }
    }
}