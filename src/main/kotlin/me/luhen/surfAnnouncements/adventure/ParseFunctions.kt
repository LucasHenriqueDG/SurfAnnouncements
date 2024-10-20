package me.luhen.surfAnnouncements.adventure

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.ChatColor

object ParseFunctions {

    fun parseLegacyComponents(string: String): Component{

        return LegacyComponentSerializer.legacyAmpersand().deserialize(string)

    }

    fun parseComponents(string: String): Component{

        return MiniMessage.miniMessage().deserialize(string)

    }

    fun parseLegacySpigot(string: String): String{

        return ChatColor.translateAlternateColorCodes('&', string)

    }


}