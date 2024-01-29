/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.airportsimulator;

import static com.mycompany.airportsimulator.AirportSimulator.flights;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pawel.Figat
 */
public class Watch extends Thread {

    @Override
    public void run() {
        while (true) {

            for (int i = 0; i < AirportSimulator.flights.size(); i++) {
                Plane currentPlane = AirportSimulator.flights.elementAt(i).getPlane();
                //Airport currentStartAirport = AirportSimulator.flights.elementAt(i).getStartAirport();
                Airport currentEndAirport = AirportSimulator.flights.elementAt(i).getEndAirport();

                boolean isTheFlightFinish = this.isPlaneAtAirport(currentPlane, currentEndAirport);
                if (isTheFlightFinish) {
                    currentEndAirport.setCurrentPlane(
                            AirportSimulator.flights.elementAt(i).getPlane()
                    );
                    if (currentPlane.refuel()) {
                        AirportSimulator.flights.remove(AirportSimulator.flights.elementAt(i));
                        AirportSimulator.flights.add(AirportSimulator.randomFlight(currentPlane, currentEndAirport));
                        currentEndAirport.clearCurrentPlane();
                    }
                } else {
                    AirportSimulator.flights.elementAt(i).movePlane();
                }
            }

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Plane.class.getName()).log(Level.SEVERE, null, ex);
            }

            AirportSimulator.myScene.repaint();
        }

    }

    private boolean isPlaneAtAirport(Plane plane, Airport airport) {
        return plane.getX() == airport.getX() && plane.getY() == airport.getY();
    }

}
