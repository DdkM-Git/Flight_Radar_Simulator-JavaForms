/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flight_radar_simulator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pawel.Figat
 */
public class SceneTimer extends Thread {

    @Override
    public void run() {
        while (true) {

            try {
                sleep(1000);
                Flight_Radar_Simulator.myScene.repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    /*private boolean isPlaneAtAirport(Plane plane, Airport airport) {
        return plane.getX() == airport.getX() && plane.getY() == airport.getY();
    }*/
}
