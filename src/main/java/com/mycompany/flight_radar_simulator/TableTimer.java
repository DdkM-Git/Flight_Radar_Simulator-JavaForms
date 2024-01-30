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
public class TableTimer extends Thread {

    @Override
    public void run() {
        while (true) {

            Flight_Radar_Simulator.myTable.updateRows();

            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
