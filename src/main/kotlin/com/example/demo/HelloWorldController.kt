package com.example.demo

import com.example.demo.toggle.ToggleClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class HelloWorldController(private val toggleClient: ToggleClient) {

    @GetMapping
    fun getHello(): String = if (toggleClient.isToggled("min-bryter")) {
        "morn"
    } else {
        "hello"
    }
}