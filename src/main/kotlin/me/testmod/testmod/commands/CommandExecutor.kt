package me.testmod.testmod.commands

import org.bukkit.command.CommandExecutor

interface PluginCommandExecutor : CommandExecutor {
    val commandName: String
}