package org.example.response;

public class APIResponse<T> {
   public T data;
   public String message;
   public int statusCode;

    public APIResponse(T data, String message, int statusCode) {
        this.data = data;
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", statusCode=" + statusCode +
                '}';
    }
}
