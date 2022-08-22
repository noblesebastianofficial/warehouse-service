package com.mycompany.warehouse.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.mycompany.warehouse.BaseIntegrationIT;
import com.mycompany.warehouse.openapi.model.BoxDto;
import org.junit.jupiter.api.Test;

class BoxControllerIntegrationTest extends BaseIntegrationIT {
    private static final String API_ROOT = "/boxes";

    @Test
    void createBox_box_isCreated() throws Exception{
        // Given
        BoxDto boxDto= getBoxDtoDto();
        // When
        mockMvc.perform(post(API_ROOT )
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(boxDto)))
        //Then
        .andExpect(status().isCreated());
    }
    @Test
    void createBox_box_isBadRequest() throws Exception{
        // Given
        BoxDto boxDto= getBoxDtoDto();
        boxDto.boxCode(null);
        // When
        mockMvc.perform(post(API_ROOT )
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(boxDto)))
        //Then
        .andExpect(status().isBadRequest());
    }

    @Test
    void createBox_box_isNotFound() throws Exception{
        // Given
        BoxDto boxDto= getBoxDtoDto();
        boxDto.boxCode(null);
        // When
        mockMvc.perform(post(API_ROOT +"/test")
            .contentType(APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(boxDto)))
        //Then
        .andExpect(status().isNotFound());
    }


}
