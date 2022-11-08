package com.example.demo.toggle

import com.example.demo.toggle.domain.ToggleInfo
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class ToggleStorage {

    private val toggles: ConcurrentHashMap<String, ToggleInfo> = ConcurrentHashMap()

    fun setToggles(updatedToggles: Map<String, ToggleInfo>) {
        toggles.clear()
        toggles.putAll(updatedToggles)
    }

    fun getToggleInfo(name: String): ToggleInfo? = toggles[name]

    fun getToggles(): ConcurrentHashMap<String, ToggleInfo> = toggles
}