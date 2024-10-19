package me.luhen.surfAnnouncements.schedulers

import me.luhen.surfAnnouncements.SurfAnnouncements
import me.luhen.surfAnnouncements.functions.SendMessageFunction
import org.bukkit.Bukkit
import org.bukkit.scheduler.BukkitTask

object MessagesScheduler{

    private val plugin = SurfAnnouncements.instance

    private var scheduler: BukkitTask? = null

    fun cancelScheduler(){

        scheduler?.cancel()

    }

    fun scheduler(){

        var currentMsg: String?

        scheduler = Bukkit.getScheduler().runTaskTimer(plugin, Runnable {

            val isComponent = plugin.isComponent

            if(plugin.isRandom){

                currentMsg = plugin.messages.random()

            } else {

                currentMsg = plugin.messages[plugin.msgNumber]

                if(plugin.msgNumber == (plugin.messages.size - 1)){

                    plugin.msgNumber = 0

                } else {

                    plugin.msgNumber += 1

                }

            }

            SendMessageFunction.sendTheMessage(currentMsg!!, isComponent)

        },0L, 20L * SurfAnnouncements.instance.time)

    }

}