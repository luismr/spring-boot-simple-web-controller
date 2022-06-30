package com.example.simplecontroller;

import com.example.simplecontroller.data.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldController {

    private final WorldService worldService;

    @Autowired
    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping(path = "/worlds", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<World> getWorlds() {
        return worldService.getWorlds();
    }

}
