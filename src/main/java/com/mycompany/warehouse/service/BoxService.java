package com.mycompany.warehouse.service;

import com.mycompany.warehouse.openapi.model.BoxDto;
/**
 * createBox class contains method declaration for the box service methods.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */

public interface BoxService {

    BoxDto createBox(BoxDto boxDto);
}
