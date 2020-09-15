package com.example.demo.controller;

import com.example.demo.model.Owner;
import com.example.demo.services.OwnerService;
import org.graalvm.compiler.phases.contract.PhaseSizeContract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ownerControllerTest {

    @Mock
    OwnerService ownerService;

    @InjectMocks
    OwnerController ownerController;

    Set<Owner> ownerSet;

    MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        ownerSet=new HashSet<>();
        ownerSet.add(Owner.builder().id(1L).build());

        ownerSet.add(Owner.builder().id(2L).build());
        mockMvc= MockMvcBuilders.standaloneSetup(ownerController).build();
    }

    @Test
    void listOwner() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }
    @Test
    void listOwnerByIndex() throws Exception {
        when(ownerService.findAll()).thenReturn(ownerSet);
        mockMvc.perform(get("/owners/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/index"))
                .andExpect(model().attribute("owners",hasSize(2)));
    }

    @Test
    void notImplement() throws Exception{
        mockMvc.perform(get("owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("NotImplement"));
        verifyZeroInteractions(ownerService);

    }
}