package me.chanwookim.apicalldemo

class ChatRequest(
    val model: String,
    val messages: List<Message> = listOf(),
    val n: Int,
    val temperature: Double
) {
    constructor(model: String, prompt: String) :
            this(model, listOf(Message("user", prompt)), 1, 0.9)
}

data class Message(
    val role: String,
    val content: String
)

class ChatResponse(
    val choices: List<Choice>
)

data class Choice(
    val index: Int,
    val message: Message
)