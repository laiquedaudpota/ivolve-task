package com.java.app.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static com.java.app.util.AppEnum.STATUS;
import static com.java.app.util.AppEnum.PRIORITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tasks")
@EqualsAndHashCode(callSuper = true)
public class Task extends BaseEntity {

    private Date dueDate;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private STATUS status;

    @Enumerated(EnumType.STRING)
    private PRIORITY priority;

    @JoinColumn(name = "assigned_to")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private User user;

    @JoinColumn(name = "team_id")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private Team team;

    public Task(Long id) {
        super();
        setId(id);
    }
}
