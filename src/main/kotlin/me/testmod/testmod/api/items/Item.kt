package me.testmod.testmod.api.items

import org.bukkit.inventory.ItemStack

interface Item {
    fun create(): ItemStack
}