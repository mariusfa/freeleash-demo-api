package com.example.demo.toggle

import com.example.demo.toggle.domain.ToggleInfo
import com.example.demo.toggle.dto.ToggleDTO
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service

@Service
class ToggleAdapter(private val restTemplateBuilder: RestTemplateBuilder) {

    private val log: Logger = LoggerFactory.getLogger(ToggleAdapter::class.java)

    private val team = "postman"
    private val toggleUrl = "http://localhost:8080/toggle?team=${team}"
    private val restTemplate = restTemplateBuilder.build()


    fun readToggles(): Map<String, ToggleInfo> {
        val toggleList = restTemplate.getForObject(toggleUrl, Array<ToggleDTO>::class.java)?.toList() ?: emptyList()
        log.info(toggleList.toString())
        return toggleList.associate { it.name to ToggleInfo(isToggled = it.isToggled) }
    }
}