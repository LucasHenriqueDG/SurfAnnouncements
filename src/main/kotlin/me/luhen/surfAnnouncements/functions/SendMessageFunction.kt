package me.luhen.surfAnnouncements.functions

import me.luhen.surfAnnouncements.adventure.ParseFunctions
import org.bukkit.Bukkit

object SendMessageFunction {

    fun sendTheMessage(message: String, isComponent: Boolean){

        val msg = if(isComponent) ParseFunctions.parseComponents(message)
            else ParseFunctions.parseLegacyComponents(message)

        Bukkit.getOnlinePlayers().forEach {

            it.sendMessage(msg)

        }

    }

    fun sendTheMessage(message: String){

        val msg = ParseFunctions.parseLegacySpigot(message)

        Bukkit.getOnlinePlayers().forEach {

            it.sendMessage(msg)

        }

    }

}