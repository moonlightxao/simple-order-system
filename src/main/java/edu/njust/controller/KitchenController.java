package edu.njust.controller;

import edu.njust.service.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class KitchenController {
    @Autowired
    private KitchenService service;

}
