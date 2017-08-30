package com.example.administrator.mytab.bean;

/**
 * Created by Administrator on 2017/7/21.
 */
public class ChangeNews {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String newsTitle;
    private int  newsImg1;
    private int  newsImg2;
    private int  newsImg3;

    public ChangeNews(int id,String title,int picture1,int picture2,int picture3){
        this.newsTitle=title;
        this.id=id;
        this.newsImg1=picture1;
        this.newsImg2=picture2;
        this.newsImg3=picture3;
    }
    public int getNewsImg2() {
        return newsImg2;
    }

    public void setNewsImg2(int newsImg2) {
        this.newsImg2 = newsImg2;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public int getNewsImg1() {
        return newsImg1;
    }

    public void setNewsImg1(int newsImg1) {
        this.newsImg1 = newsImg1;
    }

    public int getNewsImg3() {
        return newsImg3;
    }

    public void setNewsImg3(int newsImg3) {
        this.newsImg3 = newsImg3;
    }


}
