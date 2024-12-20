package me.luhen.surfAnnouncements

import me.luhen.surfAnnouncements.commands.SurfannouncementsCommand
import me.luhen.surfAnnouncements.functions.ConfigFunctions
import net.kyori.adventure.platform.bukkit.BukkitAudiences
import org.bukkit.plugin.java.JavaPlugin

class SurfAnnouncements : JavaPlugin() {

    val messages = mutableListOf<String>()

    var isComponent: Boolean = true

    var time: Int = 20

    var msgNumber: Int = 0

    var isRandom = false

    var adventure :BukkitAudiences? = null

    companion object {

        lateinit var instance: SurfAnnouncements

    }

    init {

        instance = this

    }

    override fun onEnable() {

        adventure = BukkitAudiences.create(this)

        saveDefaultConfig()

        ConfigFunctions.setupDefaults()
        ConfigFunctions.updateMessages()
        ConfigFunctions.updateValues()

        logger.info("[Surf Announcements] Plugin enabled!")

        getCommand("surfannouncements")?.setExecutor(SurfannouncementsCommand)

    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
