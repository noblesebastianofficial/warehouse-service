package com.mycompany.warehouse.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.warehouse.BaseUnitTest;
import com.mycompany.warehouse.openapi.model.BoxDto;
import org.junit.jupiter.api.Test;


class BoxServiceTest extends BaseUnitTest {

    @Test
    void createBox_box_shouldReturnCreatedBox()  {
        // Given
        BoxDto boxDto = getBoxDtoDto();
        // When
        BoxDto boxDtoResponse = this.boxService.createBox(boxDto);
        // Then
        assertThat(boxDtoResponse.getBoxId())
            .isNotNull();
        assertThat(boxDtoResponse.getBoxCode())
            .isEqualTo("box1");
        assertThat(boxDtoResponse.getLocationCode())
            .isEqualTo("shelf1");
    }



}
