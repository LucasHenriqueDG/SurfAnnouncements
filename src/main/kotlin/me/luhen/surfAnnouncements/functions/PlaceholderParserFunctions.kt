package me.luhen.surfAnnouncements.functions

object PlaceholderParserFunctions {

    fun replacePlaceholders(placeholder: String, value: String, message: String): String{

        return message.replace(placeholder, value)

    }

}