package com.mycompany.warehouse.service;

import com.mycompany.warehouse.mapper.DataMapper;
import com.mycompany.warehouse.model.Box;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.repository.BoxRepository;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
/**
 * BoxServiceImpl class contains implementations for the box service methods.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

@Service
@RequiredArgsConstructor
@Slf4j
public class BoxServiceImpl implements BoxService {

    private final DataMapper dataMapper;

    @NotNull
    private final BoxRepository boxRepository;

    /**
     * createBox method creates box.
     * @param boxDto details of the product
     * @return BoxDto details of the created box
     */
    @Override
    public BoxDto createBox(BoxDto boxDto) {
        log.debug("A new box is saved(The name of the box is '{}'", boxDto.getBoxCode());
        Box box = dataMapper.mapToBoxModel(boxDto);
        return dataMapper.mapToBoxDto(this.boxRepository.save(box));
    }
}
