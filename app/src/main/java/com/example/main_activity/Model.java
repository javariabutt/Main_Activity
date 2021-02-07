package com.example.main_activity;

public class Model {
    String edu_id;
    String edu_work;
    String img;
    String expiry;

    public Model() {
    }

    public Model(String edu_id, String edu_work, String img, String expiry) {
        this.edu_id = edu_id;
        this.edu_work = edu_work;
        this.img = img;
        this.expiry = expiry;
    }

    public String getEdu_id() {
        return edu_id;
    }

    public void setEdu_id(String edu_id) {
        this.edu_id = edu_id;
    }

    public String getEdu_work() {
        return edu_work;
    }

    public void setEdu_work(String edu_work) {
        this.edu_work = edu_work;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
