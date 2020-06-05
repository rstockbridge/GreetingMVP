package dev.rstockbridge.greetingmvp.model

class GreetingModel {
    private val messages = arrayOf("Hi!", "Hello!", "Welcome!")

    fun getMessage(index: Int): String {
        return messages[index % messages.size]
    }
}
