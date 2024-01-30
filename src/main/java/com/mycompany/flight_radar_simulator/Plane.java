/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flight_radar_simulator;

import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Plane extends Thread {

    private int id;
    private float x;
    private float y;
    private final float speed;
    private Airport targetAirport;
    private float fuel;
    private final float fuelMax;
    private int flightTime;
    private boolean isRunning;

    public Plane(float x, float y, float speed, float fuel, int id) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.fuel = fuel;
        this.fuelMax = fuel;
        this.id = id;
        this.flightTime = 0;
        this.isRunning = false;
    }

    public int getPlaneId() {
        return this.id;
    }

    public float getX() {
        return this.x;
    }

    public float getY() {
        return this.y;
    }

    public Airport getTargetAirport() {
        return this.targetAirport;
    }

    public int getFlightTime() {
        return this.flightTime;
    }

    public void increaseFlightTime() {
        this.flightTime++;
    }

    public boolean isPlaneRunning() {
        return this.isRunning;
    }

    public void setAirport(Airport airport) {
        this.targetAirport = airport;
    }

    public void flyToTheAirport(Airport airport) {
        double angleRadian = this.makeAngle(airport.getX(), airport.getY());

        double dX = speed * Math.cos(angleRadian);
        double dY = speed * Math.sin(angleRadian);

        if (angleRadian >= 0 && angleRadian < Math.PI / 2) {
            if (x + dX > airport.getX()) {
                x = airport.getX();
            } else {
                x += dX;
            }
            if (y + dY > airport.getY()) {
                y = airport.getY();
            } else {
                y += dY;
            }
        } else if (angleRadian >= Math.PI / 2 && angleRadian < Math.PI) {
            if (x + dX < airport.getX()) {
                x = airport.getX();
            } else {
                x += dX;
            }
            if (y + dY > airport.getY()) {
                y = airport.getY();
            } else {
                y += dY;
            }
        } else if (angleRadian >= Math.PI && angleRadian < 3 * Math.PI / 2) {
            if (x + dX < airport.getX()) {
                x = airport.getX();
            } else {
                x += dX;
            }
            if (y + dY < airport.getY()) {
                y = airport.getY();
            } else {
                y += dY;
            }
        } else if (angleRadian >= 3 * Math.PI / 2 && angleRadian < 2 * Math.PI) {
            if (x + dX > airport.getX()) {
                x = airport.getX();
            } else {
                x += dX;
            }
            if (y + dY < airport.getY()) {
                y = airport.getY();
            } else {
                y += dY;
            }
        }
        this.fuel--;
        //this.flightTime++;
    }

    private double makeAngle(float targetX, float targetY) {
        float distanceX = targetX - this.x;
        float distanceY = targetY - this.y;

        double angleRadian = Math.atan(distanceY / distanceX);

        if (angleRadian < 0) {
            angleRadian = 2 * Math.PI + angleRadian;
        }
        if (distanceX < 0 && distanceY > 0) {
            angleRadian = angleRadian - Math.PI;
        }
        if (distanceX < 0 && distanceY < 0) {
            angleRadian = angleRadian + Math.PI;
        }

        return angleRadian;
    }

    public void refuel() throws InterruptedException {
                    this.isRunning = false;
        Plane.sleep(10000);
        this.fuel = this.fuelMax;
    }

    private void setNewAirport() {
        Airport newAirport = Flight_Radar_Simulator.getRandomAirport();
        while (newAirport.equals(this.targetAirport)) {
            newAirport = Flight_Radar_Simulator.getRandomAirport();
        }
        this.flightTime = 0;
        this.targetAirport = newAirport;
    }

    @Override
    public void run() {
        while (true) {
        this.isRunning = true;
            if (this.x == this.targetAirport.getX() && this.y == this.targetAirport.getY() && this.fuel != this.fuelMax) {
                try {
                    this.targetAirport.refuelPlane(this);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (this.x == this.targetAirport.getX() && this.y == this.targetAirport.getY()) {
                this.setNewAirport();
            } else {
                this.flyToTheAirport(this.targetAirport);
            }
            try {
                sleep(300);
            } catch (InterruptedException ex) {
                Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void draw(Graphics g) {
        int r = 10;
        g.setColor(Color.RED);
        g.fillArc((int) this.x - 3 * r / 2, (int) this.y - r / 2, r, r, 270, 180);
        g.fillRect((int) this.x - r, (int) this.y, 2 * r, r / 2);
        g.setColor(Color.BLACK);
        g.fillRect((int) this.x - r / 4, (int) this.y + r / 4, r / 2, r / 4);
        g.fillOval((int) x + 4 * r / 7, (int) y - r / 4, 4, 4);
        g.drawString("Plane " + String.valueOf(this.id), (int) this.x - r, (int) this.y - r);
    }
}
