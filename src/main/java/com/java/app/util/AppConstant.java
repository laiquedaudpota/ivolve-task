/**
 *
 */
package com.java.app.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;

public class AppConstant {

    private AppConstant() {
        super();
    }

    public static final String e = "";
    public static final String c = ",";
    public static final String q = "'";
    public static final String d = "-";
    public static final String s = " ";
    public static final String p = "%";
    public static final String LIKE = "%";
    public static final String SLASH_FORWARD = "/";
    public static final String SLASH_BACKWARD = "\\";

    public static final String N = "'N'";
    public static final String Y = "'Y'";
    public static final String NO = "No";
    public static final String YES = "Yes";
    public static final String JSON_EMPTY = "{}";
    public static final String JSON_EMPTY_ARRAY = "[]";

    public static final String PRE = "Request land";
    public static final String POST = "Response sent";

    public static final String TRUE = "true";
    public static final String FALSE = "false";

    public static final String AUTHOR_NAME = "Laique";
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    // public static final String DATE_FORMAT_PATTERN_YYYY_MM = "yyyy-MM";
    public static final String DATE_FORMAT_PATTERN_YYYY_MM_DD = "yyyy-MM-dd";
    // public static final String DATE_FORMAT_PATTERN_STANDARD = DATE_FORMAT_PATTERN_YYYY_MM_DD + "'T'HH:mm:ss.SSS'Z'";
    public static final SimpleDateFormat DATE_FORMAT_BASIC = new SimpleDateFormat(DATE_FORMAT_PATTERN_YYYY_MM_DD);
    // public static final SimpleDateFormat DATE_FORMAT_STANDARD = new SimpleDateFormat(DATE_FORMAT_PATTERN_STANDARD);

    // ******************************* //
    // ***** APP PROPERTIES KEYS ***** //
    // ******************************* //
    public static final String PROP_APP_NAME_KEY = "app.name";
    public static final String PROP_APP_VERSION_KEY = "app.version";

    // ************************** //
    // ***** APP MODEL KEYS ***** //
    // ************************** //
    public static final String KEY_APP_NAME = "appName";
    public static final String KEY_APP_VERSION = "appVersion";

    // ************************** //
    // ***** APP PAGE NAMES ***** //
    // ************************** //
    public static final String VIEW_PAGE_INDEX = "index";
    public static final String VIEW_PAGE_DASHBOARD = "dashboard";

    // ************************* //
    // ***** RESPONSE TEXT ***** //
    // ************************* //
    public static final String MSG_PRE_NOT = " (*_*)";
    public static final String MSG_PRE_YES = " (^.^)";

    public static final String MSG_BAD_REQUEST = "Bad request" + MSG_PRE_NOT;
    public static final String MSG_DATA_SAVED = "Successfully data saved" + MSG_PRE_YES;
    public static final String MSG_DATA_UPDATED = "Successfully data updated" + MSG_PRE_YES;
    public static final String MSG_DATA_NOT_SAVED = "Failed to save the data" + MSG_PRE_NOT;

    public static final String MSG_REQUEST_LAND = "Request received" + MSG_PRE_YES;

    public static final String MSG_DATA_FOUND = "Data found" + MSG_PRE_YES;
    public static final String MSG_DATA_NOT_FOUND = "Data not found" + MSG_PRE_NOT;

    public static final String MSG_FILE_GENERATED = "The file is generated" + MSG_PRE_YES;
    public static final String MSG_FILE_NOT_GENERATED = "Failed to generate the file" + MSG_PRE_NOT;

    public static final String MSG_USER_INVALID = "Invalid User! Sign in to attempt this operation" + MSG_PRE_NOT;
    public static final String MSG_USER_SIGN_IN_PASS = "User signed in successfully" + MSG_PRE_YES;
    public static final String MSG_USER_SIGN_UP_PASS = "User signed up successfully" + MSG_PRE_YES;
    public static final String MSG_USER_SIGN_OUT_PASS = "User signed out successfully" + MSG_PRE_YES;
    public static final String MSG_USER_SIGN_IN_FAIL = "Username or Password is invalid!" + MSG_PRE_NOT;
}
