package com.mycompany.warehouse.contoller;

import com.mycompany.warehouse.openapi.api.BoxesApi;
import com.mycompany.warehouse.openapi.model.BoxDto;
import com.mycompany.warehouse.service.BoxService;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * BoxController contains the API methods for Box.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0.
 */

@RestController
@RequiredArgsConstructor
public class BoxController implements BoxesApi {

    @NotNull
    private final BoxService boxService;

    /**
     * createBox method creates the box for the given box details.
     * @param boxDto contains the box details as input request
     * @return ResponseEntity BoxDto contains the newly created box details.
     */
    @Override
    public ResponseEntity<BoxDto> createBox(@RequestBody BoxDto boxDto) {
        return new ResponseEntity<>(this.boxService.createBox(boxDto), HttpStatus.CREATED);
    }

}
