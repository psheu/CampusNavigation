package com.example.student.campusnavigation;

//Creates a building object

public class Building {
    public String name;
    public double lat;
    public double lon;
    public Building(String n, double lat, double lon)
    {
        name = n;
        lat = this.lat;
        lon = this.lon;
    }
    public String getName(){
        return name;
    }
    public double getLat(){
        return lat;
    }
    public double getLon(){
        return lon;
    }
}

