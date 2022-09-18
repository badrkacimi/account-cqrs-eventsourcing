package ma.insea.comptecqrses.query.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
    private boolean success;
    private int status;
    private T data;
    private Exception exception;
    private String error;

    public Response(boolean success, int status, T data, String error) {
        this.success = success;
        this.status = status;
        this.data = data;
        this.error = error;
    }
}