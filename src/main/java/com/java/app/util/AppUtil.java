package com.java.app.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static com.java.app.util.AppEnum.*;
import static com.java.app.util.AppConstant.*;

public class AppUtil {

    private AppUtil() {
        super();
    }

    // Runtime test
    public static void main(String[] args) {
        println(PRE);
        try {
            println(PRE);

            println(POST);
        } catch (Exception ex) {
            // ex.printStackTrace();
        } finally {
            println(POST);
        }
    }

    // Helper / Util methods
    public static void print(String s) {
        System.out.print(s);
    }

    public static void println(String s) {
        System.out.println(s);
    }

    public static boolean isNull(Object o) {
        return Objects.isNull(o);
    }

    public static boolean isNotNull(Object o) {
        return Objects.nonNull(o);
    }

    private static boolean isEmpty(String s) {
        return s.isEmpty();
    }

    private static boolean isNotEmpty(String s) {
        return !isEmpty(s);
    }

    public static boolean isNotNullNorEmptyString(Object o) {
        return o instanceof CharSequence charSequence
                && isNotNull(charSequence)
                && !charSequence.toString().trim().isEmpty();
    }

    public static boolean isNotNullNorEmptyList(Collection<?> objects) {
        if (isNull(objects) || objects.isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static boolean isNotNullNorEmptyMap(Map<?, ?> objects) {
        if (isNull(objects) || objects.isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static STATUS findAnyStatus(String s) {
        STATUS result = null;
        if (isNotNullNorEmptyString(s)) {
            result = STATUS.valueOf(s.toUpperCase());
        }
        return result;
    }

    public static PRIORITY findAnyPriority(String p) {
        PRIORITY result = null;
        if (isNotNullNorEmptyString(p)) {
            result = PRIORITY.valueOf(p.toUpperCase());
        }
        return result;
    }

    public static String getNewUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getCurrentDate() {
        return DATE_FORMAT_BASIC.format(Calendar.getInstance().getTime());
    }

    public static String toString(Object entity) {
        try {
            // AppConstant.OBJECT_MAPPER.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY.ANY);
            return OBJECT_MAPPER.writeValueAsString(entity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return JSON_EMPTY;
    }

    public static ResponseEntity<String> getFinalizedResponse(String text) {
        GenericResponse<Object> response = new GenericResponse<>(text);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }

    public static ResponseEntity<String> getFinalizedResponse(String text, Boolean result) {
        GenericResponse<Object> response = new GenericResponse<>(text, result);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }

    public static ResponseEntity<String> getFinalizedResponse(String text, Object data) {
        GenericResponse<Object> response = new GenericResponse<>(text, data);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }

    public static ResponseEntity<String> getFinalizedResponse(Integer code, String xReqId, String type, String text) {
        GenericResponse<Object> response = new GenericResponse<>();
        response.setCode(code);
        response.setType(type);
        response.setText(text);
        response.setReqId(xReqId);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.toString());
    }
}