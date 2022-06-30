package com.example.simplecontroller;

import com.example.simplecontroller.data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class WorldServiceTest {

    private final WorldService worldService;

    private List<World> worlds;

    @Autowired
    public WorldServiceTest(WorldService worldService) {
        this.worldService = worldService;
    }

    @BeforeEach
    public void setupEach() {
        this.worlds = worldService.getWorlds();
    }

    @Test
    public void ensureWorldListIsNotEmpty() {
        assertNotNull(worlds);
        assertFalse(worlds.isEmpty());
    }

    @Test
    public void ensureWorldListHasAllPlanets() {
        assertTrue(worldService.exists("Mercury"));
        assertTrue(worldService.exists("Venus"));
        assertTrue(worldService.exists("Earth"));
        assertTrue(worldService.exists("Mars"));
        assertTrue(worldService.exists("Jupiter"));
        assertTrue(worldService.exists("Saturn"));
        assertTrue(worldService.exists("Uranus"));
        assertTrue(worldService.exists("Neptune"));
    }

    @Test
    public void ensureWorldListHasntAnInvalidPlanets() {
        assertFalse(worldService.exists("Pluto"));
    }
}