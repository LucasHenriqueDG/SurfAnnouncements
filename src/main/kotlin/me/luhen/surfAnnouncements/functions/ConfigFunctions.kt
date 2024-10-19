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