package com.java.app.util;

import java.io.Serializable;

import static com.java.app.util.AppConstant.*;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericResponse<T> implements Serializable {
    private String reqId;
    private Integer code;
    private String type;
    private String text;
    private Boolean result = Boolean.FALSE;
    private T data;

    // Constructors //
    // Constructors //
    // Constructors //
    public GenericResponse() {
        super();
    }

    public GenericResponse(String text) {
        setData(null);
        setText(text);
    }

    public GenericResponse(String text, Integer code) {
        setData(null);
        setCode(code);
        setText(text);
    }

    public GenericResponse(String text, T data) {
        setData(data);
        setText(text);
        setResult(Boolean.TRUE);
    }

    public GenericResponse(String text, Boolean result) {
        setData(null);
        setText(text);
        setResult(result);
    }

    public GenericResponse(GenericResponse response) {
        setCode(response.getCode());
        setText(response.getText());
        setType(response.getType());
        setReqId(response.getReqId());
        setResult(response.getResult());
    }

    // Setters & Getters //
    // Setters & Getters //
    // Setters & Getters //
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setCode(String code) {
        this.code = new Integer(code);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean result() {
        return result;
    }

    public Boolean isResult() {
        return result;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        try {
            return OBJECT_MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return JSON_EMPTY;
        }
    }
}
