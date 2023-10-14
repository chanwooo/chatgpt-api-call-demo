package me.chanwookim.apicalldemo

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.web.client.RestTemplate

@Configuration
class OpenAIRestTemplateConfig(
    @Value("\${openai.api.key}")
    val openaiApiKey: String,
) {
    @Bean
    @Qualifier("openaiRestTemplate")
    fun openaiRestTemplate(): RestTemplate {
        val restTemplate = RestTemplate()
        restTemplate.interceptors.add(ClientHttpRequestInterceptor { request, body, execution ->
            request.headers.setBearerAuth(openaiApiKey)
            execution.execute(request, body)
        })
        return restTemplate
    }
}