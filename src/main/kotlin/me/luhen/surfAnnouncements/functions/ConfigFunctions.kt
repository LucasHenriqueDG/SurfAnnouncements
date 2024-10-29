package me.luhen.surfAnnouncements.functions

import me.luhen.surfAnnouncements.SurfAnnouncements
import me.luhen.surfAnnouncements.schedulers.MessagesScheduler

object ConfigFunctions {

    val plugin = SurfAnnouncements.instance

    fun reloadFunction(){

        plugin.reloadConfig()

        plugin.messages.clear()

        updateMessages()

        updateValues()

    }

    fun setupDefaults(){

        val config = plugin.config

        config.addDefault("random-message", "false")
        config.addDefault("component", "true")
        config.addDefault("time", "60")
        config.addDefault("messages", listOf("<gradient:#47e7ff:#2fab24>[Surf Announcements]</gradient> <red>This message require paper and component = true.</red>", "&b[Surf Announcements] &6This message does not require paper, but requires component = false."))

        config.options().copyDefaults(true)
        plugin.saveConfig()

    }

    fun updateMessages(){

        val plugin = SurfAnnouncements.instance

        plugin.config.getStringList("messages").forEach {

            plugin.messages.add(it)

        }

    }

    fun updateValues(){

        plugin.time = plugin.config.getInt("time")
        plugin.isRandom = plugin.config.getBoolean("random-message")
        plugin.isComponent = plugin.config.getBoolean("component")

        MessagesScheduler.cancelScheduler()

        MessagesScheduler.scheduler()

    }

}