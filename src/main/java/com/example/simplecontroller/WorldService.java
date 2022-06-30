package com.example.simplecontroller;

import com.example.simplecontroller.data.World;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WorldService {

    public List<World> getWorlds() {
        return Arrays.asList(
                new World(1L, "Mercury"),
                new World(2L, "Venus"),
                new World(3L, "Earth"),
                new World(4L, "Mars"),
                new World(5L, "Jupiter"),
                new World(6L, "Saturn"),
                new World(7L, "Uranus"),
                new World(8L, "Neptune")
        );
    }

    public boolean exists(final String name) {
        List<World> worlds = this.getWorlds();
        return worlds.stream().filter(w -> name.equalsIgnoreCase(w.getName())).count() > 0;
    }
}
