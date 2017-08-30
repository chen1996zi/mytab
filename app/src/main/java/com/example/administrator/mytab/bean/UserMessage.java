package com.example.administrator.mytab.bean;

/**
 * Created by Administrator on 2017/7/23.
 */
public class UserMessage {
    private int image;
    private String username;
    private String uerAdvice;

    public UserMessage(int image,String username,String userAdvice){
        this.image=image;
        this.uerAdvice=userAdvice;
        this.username=username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getUerAdvice() {
        return uerAdvice;
    }

    public void setUerAdvice(String uerAdvice) {
        this.uerAdvice = uerAdvice;
    }
}
