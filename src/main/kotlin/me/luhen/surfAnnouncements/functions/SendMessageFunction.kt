package me.luhen.surfAnnouncements.functions

import me.luhen.surfAnnouncements.SurfAnnouncements
import me.luhen.surfAnnouncements.adventure.ParseFunctions
import org.bukkit.Bukkit

object SendMessageFunction {

    fun sendTheMessage(message: String, isComponent: Boolean){

        Bukkit.getOnlinePlayers().forEach {

        val msg = if(isComponent) ParseFunctions.parseComponents(message, it)
            else ParseFunctions.parseLegacyComponents(message, it)



            SurfAnnouncements.instance.adventure?.player(it)?.sendMessage(msg)

        }

    }

}