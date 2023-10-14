package me.chanwookim.apicalldemo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class ChatController(
    @Qualifier("openaiRestTemplate")
    @Autowired
    val restTemplate: RestTemplate,

    @Value("\${openai.model}")
    val model: String,

    @Value("\${openai.api.url}")
    val apiUrl: String,

) {
    @GetMapping("/chat")
    fun chat(@RequestParam prompt: String): String {
        val request = ChatRequest(model, prompt)
        val response = restTemplate.postForObject(apiUrl, request, ChatResponse::class.java)
        return response?.choices?.get(0)?.message?.content ?: "No response"
    }
}