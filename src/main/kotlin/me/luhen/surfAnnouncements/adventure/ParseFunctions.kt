package me.luhen.surfAnnouncements.adventure

import me.luhen.surfAnnouncements.functions.PlaceholderParserFunctions
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer
import org.bukkit.entity.Player

object ParseFunctions {

    fun parseLegacyComponents(string: String, player: Player): Component{

        val newMsg = PlaceholderParserFunctions.replacePlaceholders("%player%", player.name, string)

        return LegacyComponentSerializer.legacyAmpersand().deserialize(newMsg)

    }

    fun parseComponents(string: String, player: Player): Component{

        val newMsg = PlaceholderParserFunctions.replacePlaceholders("%player%", player.name, string)

        return MiniMessage.miniMessage().deserialize(newMsg)

    }


}