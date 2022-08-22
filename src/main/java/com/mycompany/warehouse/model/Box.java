package com.mycompany.warehouse.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * Box class contains entity details for Box entity.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */
@Entity
@Table
@Data
public class Box {

    @NotNull
    @Id
    @GeneratedValue
    private Long boxId;

    @NotBlank
    private String boxCode;

    @NotBlank
    private String locationCode;


}
