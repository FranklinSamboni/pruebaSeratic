package com.example.frank.boletic.net.response;

import java.util.Objects;

/**
 * Created by FRANK on 2/09/2017.
 */

public class MyResponse {

    private int status;
    private String message;

    //private Object object;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
