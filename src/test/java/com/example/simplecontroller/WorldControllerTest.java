package com.example.simplecontroller;

import com.example.simplecontroller.data.World;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(WorldController.class)
public class WorldControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private WorldService worldService;

    @BeforeEach
    public void beforeEach() {
        List<World> worlds = Arrays.asList(
                new World(1L, "Mercury"),
                new World(2L, "Venus"),
                new World(3L, "Earth"),
                new World(4L, "Mars"),
                new World(5L, "Jupiter"),
                new World(6L, "Saturn"),
                new World(7L, "Uranus"),
                new World(8L, "Neptune")
        );

        given(worldService.getWorlds()).willReturn(worlds);
    }

    @Test
    public void givenListOfWorldsThenReturnsJsonArray() throws Exception {
        mvc.perform(get("/worlds").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(8)));
    }

    @Test
    public void givenListOfWorldsThenReturnsMercuryInFirstPlace() throws Exception {
        mvc.perform(get("/worlds").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(8)))
                .andExpect(jsonPath("$[0].name", hasToString("Mercury")));
    }

    @Test
    public void givenListOfWorldsThenReturnsEarthInThirdPlace() throws Exception {
        mvc.perform(get("/worlds").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(8)))
                .andExpect(jsonPath("$[2].name", hasToString("Earth")));
    }

}
