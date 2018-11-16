package com.example.clas.gym_club.Model;


public class Trainee {
    private String name;
    private String info;
    private int imageId;

    public Trainee(String name, String info, int imageId){
        this.name = name;
        this.info = info;
        this.imageId = imageId;
    }

    public String getName(){
        return this.name;
    }
    public String getInfo(){
        return this.info;
    }
    public int getImageId(){
        return this.imageId;
    }

}
