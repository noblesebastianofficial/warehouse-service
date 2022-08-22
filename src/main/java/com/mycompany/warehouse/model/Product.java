package com.mycompany.warehouse.model;

import java.sql.Timestamp;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.engine.backend.types.Searchable;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.IndexedEmbedded;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

/**
 * Product class contains entity details for Product entity.
 *
 * @author Noble Sebastian.
 * @version 1.0.1.0
 */
@Entity
@Table
@Data
@Indexed
public class Product  {


    @NotNull
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @KeywordField(sortable = Sortable.YES, searchable = Searchable.YES)
    private String name;

    @FullTextField
    private String description;

    @NotNull
    private Double price;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "box_id", nullable = false)
    @IndexedEmbedded
    private Box box;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private Timestamp updatedAt;

}
