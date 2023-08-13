package model;

import ch.qos.logback.core.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * author danilova.tatyana 11.08.2023
 */
@Data
@Entity
@Table(name =  "tools")
public class Tools extends BaseEntity {
    @Column( name= "category")
    private String category;

    @Column( name = "status")
    private Status status;

    @Column(name = "count")
    private  int count;

    @Column(name = "article")
    private String article;
}
