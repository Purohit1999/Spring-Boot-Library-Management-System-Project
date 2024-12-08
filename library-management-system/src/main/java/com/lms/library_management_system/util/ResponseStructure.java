package com.lms.library_management_system.util;

import lombok.Getter;
import lombok.Setter;

/**
 * A generic response structure for standardizing API responses.
 *
 * @param <T> The type of the response data.
 */
@Getter
@Setter
public class ResponseStructure<T> {

    private int statusCode;  // HTTP status code (e.g., 200, 400)
    private String message;  // A message describing the operation's outcome
    private T data;          // The actual data (can be an object, list, or null)

    // Optional: If Lombok isn't generating methods, you can define them manually
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
}
