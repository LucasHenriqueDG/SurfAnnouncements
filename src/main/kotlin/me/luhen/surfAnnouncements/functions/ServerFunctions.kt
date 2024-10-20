package me.luhen.surfAnnouncements.functions

import me.luhen.surfAnnouncements.SurfAnnouncements

object ServerFunctions {

    fun isPaperServer(): Boolean {
        return try {
            Class.forName("com.destroystokyo.paper.PaperConfig")
            SurfAnnouncements.instance.logger.info("This is a paper server. Enabling components support.")
            true
        } catch (e: ClassNotFoundException) {
            SurfAnnouncements.instance.logger.info("This is a spigot server. Components are not going to be supported.")
            false
        }
    }

}