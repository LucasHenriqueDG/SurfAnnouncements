package me.luhen.surfAnnouncements

import me.luhen.surfAnnouncements.commands.SurfannouncementsCommand
import me.luhen.surfAnnouncements.functions.ConfigFunctions
import me.luhen.surfAnnouncements.functions.ServerFunctions
import org.bukkit.plugin.java.JavaPlugin

class SurfAnnouncements : JavaPlugin() {

    val messages = mutableListOf<String>()

    var isComponent: Boolean = true

    var time: Int = 20

    var msgNumber: Int = 0

    var isRandom = false

    var isPaper = false

    companion object {

        lateinit var instance: SurfAnnouncements

    }

    init {

        instance = this

    }

    override fun onEnable() {

        isPaper = ServerFunctions.isPaperServer()


        saveDefaultConfig()

        ConfigFunctions.updateMessages()
        ConfigFunctions.updateValues()

        logger.info("[Surf Announcements] Plugin enabled!")

        getCommand("surfannouncements")?.setExecutor(SurfannouncementsCommand)

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
