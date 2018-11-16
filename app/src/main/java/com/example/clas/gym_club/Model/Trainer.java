package com.example.clas.gym_club.Model;


public class Trainer {
    private String name;
    private String info;
    private String learnerNum;
    private int imageId;

    public Trainer(String name, String info, String learnerNum, int imageId){
        this.name = name;
        this.info = info;
        this.learnerNum = learnerNum;
        this.imageId = imageId;
    }

    public String getName(){
        return this.name;
    }
    public String getInfo(){
        return this.info;
    }
    public String getLearnerNum(){
        return this.learnerNum;
    }
    public int getImageId(){
        return this.imageId;
    }

}
