package com.example.rob_lifefitnessdiet;

public class imageandtextmodel {
    String imageurl;
    String header;
    String contentinfo;


    public imageandtextmodel(String imageurl, String header, String contentinfo) {
        this.imageurl = imageurl;
        this.header = header;
        this.contentinfo = contentinfo;
    }

    public imageandtextmodel() {
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContentinfo() {
        return contentinfo;
    }

    public void setContentinfo(String contentinfo) {
        this.contentinfo = contentinfo;
    }
}

