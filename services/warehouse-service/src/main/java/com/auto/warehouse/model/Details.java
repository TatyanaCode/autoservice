package com.auto.warehouse.model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.Column;

/**
 * author danilova.tatyana 11.08.2023
 */
public class Details  extends BaseEntity {
    @Column( name= "category")
    private String category;

    @Column( name = "status")
    private Status status;

    @Column(name = "count")
    private  int count;

    @Column(name = "article")
    private String article;
}
