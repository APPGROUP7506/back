package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    //1 true
    private short code;
    private String message;
    private Object data;

    public static Result success()
    {
        return new Result((short)1,"success",null);
    }
    public static Result success(Object indata)
    {
        return new Result((short)1,"success",indata);
    }
    public static Result error()
    {
        return new Result((short)0,"failed",null);
    }
    public static Result error(String errorMessage)
    {
        return new Result((short)0,errorMessage,null);
    }
}
