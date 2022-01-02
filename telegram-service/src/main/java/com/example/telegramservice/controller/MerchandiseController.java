package com.example.telegramservice.controller;

import com.example.telegramservice.service.Bot;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/merchandise")
public class MerchandiseController {

    private final Bot bot;

    @PostMapping("/new-merchandise")
    public void pushNewMerchandise(@RequestBody String text) {
        bot.send(text);
    }
}
