package com.mycompany.warehouse;

import com.mycompany.warehouse.openapi.model.BoxDto;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public abstract class BaseTest {

    public BoxDto getBoxDtoDto() {
        return BoxDto.builder().boxCode("box1").locationCode("shelf1").build();
    }

}
