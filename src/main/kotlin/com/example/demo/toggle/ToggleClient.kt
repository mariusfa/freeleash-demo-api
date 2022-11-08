package com.example.demo.toggle

import org.springframework.stereotype.Service

@Service
class ToggleClient(private val toggleStorage: ToggleStorage) {

    private val defaultToggled = false

    fun isToggled(name: String): Boolean {
        val toggleInfo = toggleStorage.getToggleInfo(name) ?: return defaultToggled
        return toggleInfo.isToggled
    }

}