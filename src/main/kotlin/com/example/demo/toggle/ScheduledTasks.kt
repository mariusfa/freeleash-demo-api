package com.example.demo.toggle

import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTasks(private val toggleAdapter: ToggleAdapter, private val toggleStorage: ToggleStorage) {

    @Scheduled(fixedRate = 5000)
    fun getTogglesTask() {
        val toggles = toggleAdapter.readToggles()
        toggleStorage.setToggles(toggles)
    }
}