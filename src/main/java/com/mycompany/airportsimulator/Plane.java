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
public class Plane {

    private float x;
    private float y;
    private float speed;
    private float fuel;
    private float fuelMax;
    private float fuelTime;
    private String name;
    private Color color;

    public Plane(int x, int y, float speed, float fuel, String name, Color color) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.fuel = fuel;
        this.fuelMax = fuel;
        this.fuelTime = 0;
        this.name = name;
        this.color = color;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public String getName() {
        return name;
    }

    //public boolean hasFullTank() {
    //    return this.fuel == this.fuelMax;
    //}

    @Override
    public String toString() {
        return "Plane {" + "x=" + x + ", y=" + y + '}';
    }

    public void move(float targetX, float targetY, Plane planeAtTheAirport) {
        if (!(this.x == targetX && this.y == targetY) && this.fuel > 0) {
            float radius = 10;
            double dX = this.x - targetX;
            double dY = this.y - targetY;
            double distance = Math.sqrt((dX * dX + dY * dY));

            if ((float) distance >= radius + 2 ||planeAtTheAirport==null|| planeAtTheAirport.equals(this)) {
                this.flyToTheAirport(targetX, targetY);
            } else {
                this.taxiingOverTheAirport(targetX, targetY, radius);
            }

            this.fuel--;
        }
    }

    public void taxiingOverTheAirport(float targetX, float targetY, float radius) {
        double angleToTarget = Math.atan((targetY - this.y) / (targetX - this.x));

        double angleShiftDegrees = 5.0;
        double angleShift = angleShiftDegrees * Math.PI / 180.0;

        double newAngle = angleToTarget + angleShift;

        this.x = targetX + (float) (radius * Math.cos(newAngle));
        this.y = targetY + (float) (radius * Math.sin(newAngle));
        System.out.println("X: " + Math.cos(newAngle) + " Y: " + Math.sin(newAngle));
    }

    public void flyToTheAirport(float targetX, float targetY) {
        double angleRadian = this.makeAngle(targetX, targetY);

        double dX = speed * Math.cos(angleRadian);
        double dY = speed * Math.sin(angleRadian);

        if (angleRadian >= 0 && angleRadian < Math.PI / 2) {
            if (x + dX > targetX) {
                x = targetX;
            } else {
                x += dX;
            }
            if (y + dY > targetY) {
                y = targetY;
            } else {
                y += dY;
            }
        } else if (angleRadian >= Math.PI / 2 && angleRadian < Math.PI) {
            if (x + dX < targetX) {
                x = targetX;
            } else {
                x += dX;
            }
            if (y + dY > targetY) {
                y = targetY;
            } else {
                y += dY;
            }
        } else if (angleRadian >= Math.PI && angleRadian < 3 * Math.PI / 2) {
            if (x + dX < targetX) {
                x = targetX;
            } else {
                x += dX;
            }
            if (y + dY < targetY) {
                y = targetY;
            } else {
                y += dY;
            }
        } else if (angleRadian >= 3 * Math.PI / 2 && angleRadian < 2 * Math.PI) {
            if (x + dX > targetX) {
                x = targetX;
            } else {
                x += dX;
            }
            if (y + dY < targetY) {
                y = targetY;
            } else {
                y += dY;
            }
        }
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

    public boolean refuel() {
        if (this.fuelTime <= 0) {
            this.fuelTime = 9;
        } else {
            this.fuelTime--;
            if (this.fuelTime == 0) {
                this.fuel = this.fuelMax;
                return true;
            }
        }
        return false;
    }

    /*public void refuelTank() {
        float fuelPart = (this.fuelMax - this.fuel) / 10;
        if (this.fuel + fuelPart > this.fuelMax) {
            this.fuel = this.fuelMax;
        } else {
            this.fuel += this.fuel / 10;
        }
    }*/
    public void draw(Graphics g) {
        int r = 10;
        g.setColor(this.color);
        g.fillOval((int) x - r / 2, (int) y - r / 2, r, r);

    }
}
