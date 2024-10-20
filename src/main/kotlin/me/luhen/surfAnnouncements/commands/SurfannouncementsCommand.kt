package me.luhen.surfAnnouncements.commands

import me.luhen.surfAnnouncements.SurfAnnouncements
import me.luhen.surfAnnouncements.adventure.ParseFunctions
import me.luhen.surfAnnouncements.functions.ConfigFunctions
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

object SurfannouncementsCommand:CommandExecutor {

    override fun onCommand(sender: CommandSender, p1: Command, p2: String, args: Array<out String>?): Boolean {

        if(args != null) {

            if (args.isNotEmpty()){

                if(args.size == 1){

                    when(args[0]){

                        "reload" -> {

                            ConfigFunctions.reloadFunction()

                            if(sender is Player) {

                                if (SurfAnnouncements.instance.isPaper) {

                                    sender.sendMessage(
                                        ParseFunctions.parseComponents(
                                            "<gradient:#47e7ff:#2fab24>" +
                                                    "[Surf Announcements]</gradient> " +
                                                    "<color:#ffa578>Config File reloaded</color>"
                                        )
                                    )

                                } else {

                                    sender.sendMessage(
                                        "&b[Surf Announcements] " +
                                                "&dConfig File reloaded"
                                    )

                                }

                            } else {

                                SurfAnnouncements.instance.logger.info("[Surf Announcements]" +
                                        " Config File reloaded."
                                )

                            }

                        }

                    }

                }

            }

        }

        return true

    }

}