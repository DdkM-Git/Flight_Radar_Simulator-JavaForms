/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airportsimulator;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author mateuszd
 */
public class Airport {

    private int id;
    private int x;
    private int y;
    private String name;
    private Plane currentPlane;

    public Airport(int id, int x, int y, String name) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
        //this.currentPlane = null;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Plane getCurrentPlane() {
        return this.currentPlane;
    }

    public void setCurrentPlane(Plane plane) {
        if (this.currentPlane == null) {
            this.currentPlane = plane;
        }
    }

    public void clearCurrentPlane() {
        this.currentPlane = null;
    }
    
    @Override
    public String toString() {
        return "Airport{" + "x=" + x + ", y=" + y + '}';
    }

    public void draw(Graphics g) {
        int r = 20;
        g.setColor(Color.GREEN);
        g.fillRect((int) x - r / 2, (int) y - r / 2, r, r);

    }
}
