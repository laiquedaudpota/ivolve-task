package com.java.app.entity;

import java.io.Serializable;

import com.java.app.util.AppUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonInclude;

@Data
@MappedSuperclass
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
    public String toString() {
        return AppUtil.toString(this);
    }
}
