/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airportsimulator;

/**
 *
 * @author mateuszd
 */
public class Flight {
    
    private Airport startAirport;
    private Airport endAirport;
    private Plane plane;
    
    public Airport getStartAirport(){
        return this.startAirport;
    }
    
    public Airport getEndAirport(){
        return this.endAirport;
    }
    
    public Plane getPlane(){
        return this.plane;
    }
    
    
    public Flight(Airport startAirport, Airport endAirport, Plane plane){
        this.startAirport = startAirport;
        this.endAirport = endAirport;
        this.plane = plane;
    }
    
    public void movePlane(){
        this.plane.move(this.endAirport.getX(),this.endAirport.getY());
    }
    
    public void movePlane(int i){
        
    }
    
    @Override
    public String toString()
    {
        return "Flight {" + "A=" + this.startAirport.toString() + ", B=" + this.endAirport.toString() + ", P=" + this.plane.toString() + '}';
    }
}
