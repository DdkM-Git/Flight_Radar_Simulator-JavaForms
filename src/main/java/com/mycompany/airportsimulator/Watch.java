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

                boolean isTheFlightFinish = this.isPlaneAtAirport(AirportSimulator.flights.elementAt(i).getPlane(), AirportSimulator.flights.elementAt(i).getEndAirport());
                if (isTheFlightFinish) {
                    AirportSimulator.flights.elementAt(i).getEndAirport().setCurrentPlane(
                            AirportSimulator.flights.elementAt(i).getPlane()
                    );
                    //boolean hasThePlaneFullTank = AirportSimulator.flights.elementAt(i).getPlane().hasFullTank();
                    if (
                        AirportSimulator.flights.elementAt(i).getPlane().refuel()) {
                        System.out.print("AAA");
                        AirportSimulator.flights.add(AirportSimulator.randomFlight(AirportSimulator.flights.elementAt(i).getPlane(), AirportSimulator.flights.elementAt(i).getEndAirport()));
                        AirportSimulator.flights.remove(AirportSimulator.flights.elementAt(i));
                        AirportSimulator.flights.elementAt(i).getEndAirport().clearCurrentPlane();
                    } else {
                        System.out.print("BBB");
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
