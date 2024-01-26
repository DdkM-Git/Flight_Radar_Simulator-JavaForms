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
    private String name;

    public Plane(int x, int y, float speed, float fuel, String name) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.fuel = fuel;
        this.fuelMax = fuel;
        this.name = name;
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

    @Override
    public String toString() {
        return "Plane {" + "x=" + x + ", y=" + y + '}';
    }

    public void move(float targetX, float targetY) {
        if (!(this.x == targetX && this.y == targetY) && this.fuel > 0) {
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
            } else {
            }
            this.fuel--;
            System.out.println("Fuel: " + this.fuel);
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

    public void refuelFullTank() {
        this.fuel = this.fuelMax;
    }

    public void draw(Graphics g) {
        int r = 10;
        g.setColor(Color.RED);
        g.fillOval((int) x - r / 2, (int) y - r / 2, r, r);

    }
}
