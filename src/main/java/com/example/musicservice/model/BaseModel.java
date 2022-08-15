package com.example.musicservice.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Data
public class BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;

    @CreationTimestamp
    protected Date created;

    @UpdateTimestamp
    protected Date lastModified;
}
