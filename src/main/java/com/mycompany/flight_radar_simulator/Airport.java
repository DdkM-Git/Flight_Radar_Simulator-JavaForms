/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flight_radar_simulator;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author User
 */
public class Airport {

    private final int id;
    private final int x;
    private final int y;
    //private final String name;
    //private com.mycompany.airportsimulator.Plane currentPlane;

    public Airport(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public int getAirportId() {
        return this.id;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public synchronized void refuelPlane(Plane plane) throws InterruptedException {
        plane.refuel();
    }

    public void draw(Graphics g) {
        int r = 20;
        g.setColor(Color.GREEN);
        g.fillRect((int) x - r / 2, (int) y - r / 2, r, r);
        g.setColor(Color.BLACK);
        g.drawString("Airport " + String.valueOf(this.id), (int) this.x - r, (int) this.y + r);
    }
}
