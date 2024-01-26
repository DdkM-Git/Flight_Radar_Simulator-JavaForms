 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.airportsimulator;

import java.awt.Color;

/**
 *
 * @author mateuszd
 */
public class Airport {
    private int id;
    private int x;
    private int y;
    private String name;
    
    
    public Airport(int id, int x, int y, String name)
    {
        this.id = id;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public int getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return "Airport{" + "x=" + x + ", y=" + y + '}';
    }
}
