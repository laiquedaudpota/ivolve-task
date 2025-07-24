package com.java.app.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teams")
@EqualsAndHashCode(callSuper = true)
public class Team extends BaseEntity {

    private String name;
    private String description;

    public Team(Long id) {
        super();
        setId(id);
    }
}
