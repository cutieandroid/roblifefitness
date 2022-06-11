package com.example.rob_lifefitnessdiet;

public class imagemmodel {

    String imageurl;
    String Content;





    public imagemmodel(String imageurl, String content) {
        this.imageurl = imageurl;
        this.Content = content;
    }

    public imagemmodel(){

    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
