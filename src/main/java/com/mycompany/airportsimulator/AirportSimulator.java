/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.airportsimulator;

import java.util.Vector;

/**
 *
 * @author mateuszd
 */
public class AirportSimulator extends javax.swing.JFrame {

    //private Timer timer;
    private int currentTime;
    //public static Vector<Plane> tab = new Vector<>();
    public static Vector<Airport> airports = new Vector<>();
    public static Vector<Plane> planes = new Vector<>();
    public static Vector<Flight> flights = new Vector<>();
    public static Scene myScene;

    //public static Vector<Plane> tab = new Vector<>();
    //public static Scene ms;
    public AirportSimulator() {
        initComponents();

        AirportSimulator.airports.add(new Airport(1, 50, 50, "Air1"));
        AirportSimulator.airports.add(new Airport(2, 90, 60, "Air2"));
        AirportSimulator.airports.add(new Airport(3, 180, 130, "Air3"));
        AirportSimulator.airports.add(new Airport(4, 100, 150, "Air4"));
        AirportSimulator.airports.add(new Airport(5, 160, 180, "Air5"));

        /*AirportSimulator.addPlane(new Plane(AirportSimulator.airports.elementAt(0).getX(), AirportSimulator.airports.elementAt(0).getY(), 5, 60, "Airbus"));
        AirportSimulator.addPlane(new Plane(AirportSimulator.airports.elementAt(1).getX(), AirportSimulator.airports.elementAt(1).getY(), 5, 60, "Airbus"));
        AirportSimulator.addPlane(new Plane(AirportSimulator.airports.elementAt(2).getX(), AirportSimulator.airports.elementAt(2).getY(), 5, 60, "Airbus"));
        this.addPlane(new Plane(this.airports[3].getX(), this.airports[3].getY(), 5, 60, "Airbus"));*/
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(0).getX(), AirportSimulator.airports.elementAt(0).getY(), 5, 60, "Airbus1"));
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(1).getX(), AirportSimulator.airports.elementAt(1).getY(), 5, 60, "Airbus2"));
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(2).getX(), AirportSimulator.airports.elementAt(2).getY(), 5, 60, "Airbus3"));
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(3).getX(), AirportSimulator.airports.elementAt(3).getY(), 5, 60, "Airbus4"));

        currentTime = 0;
        /*timer = new Timer(1000, (ActionEvent e) -> {
            updateSimulation();
        });*/

    }

    private void startSimulation() {
        //currentTime = 0;

                AirportSimulator.airports.add(new Airport(1, 50, 50, "Air1"));
        AirportSimulator.airports.add(new Airport(2, 90, 60, "Air2"));
        AirportSimulator.airports.add(new Airport(3, 180, 130, "Air3"));
        AirportSimulator.airports.add(new Airport(4, 100, 150, "Air4"));
        AirportSimulator.airports.add(new Airport(5, 160, 180, "Air5"));

        /*AirportSimulator.addPlane(new Plane(AirportSimulator.airports.elementAt(0).getX(), AirportSimulator.airports.elementAt(0).getY(), 5, 60, "Airbus"));
        AirportSimulator.addPlane(new Plane(AirportSimulator.airports.elementAt(1).getX(), AirportSimulator.airports.elementAt(1).getY(), 5, 60, "Airbus"));
        AirportSimulator.addPlane(new Plane(AirportSimulator.airports.elementAt(2).getX(), AirportSimulator.airports.elementAt(2).getY(), 5, 60, "Airbus"));
        this.addPlane(new Plane(this.airports[3].getX(), this.airports[3].getY(), 5, 60, "Airbus"));*/
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(0).getX(), AirportSimulator.airports.elementAt(0).getY(), 5, 60, "Airbus1"));
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(1).getX(), AirportSimulator.airports.elementAt(1).getY(), 5, 60, "Airbus2"));
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(2).getX(), AirportSimulator.airports.elementAt(2).getY(), 5, 60, "Airbus3"));
        AirportSimulator.planes.add(new Plane(AirportSimulator.airports.elementAt(3).getX(), AirportSimulator.airports.elementAt(3).getY(), 5, 60, "Airbus4"));

        
        // Dodawanie przykładowych samolotów i lotnisk
        for (Plane plane : AirportSimulator.planes) {
            AirportSimulator.flights.add(randomFlight(plane, AirportSimulator.airports.elementAt(0)));
        }

        Watch w = new Watch();
        w.start();
        //this.table1.updateRows(this.flights, this.currentTime);
        //timer.start();
    }

    private void stopSimulation() {
        //timer.stop();
    }

    public static Flight randomFlight(Plane plane, Airport startAirport) {
        Airport targetAirport = AirportSimulator.randomAirport();

        while (targetAirport.getId() == startAirport.getId()) {
            targetAirport = AirportSimulator.randomAirport();
        }

        return new Flight(startAirport, targetAirport, plane);
    }

    public static Airport randomAirport() {
        double random = Math.random() * AirportSimulator.airports.capacity();
        return AirportSimulator.airports.elementAt((int) random);
    }

    /*private void updateSimulation() {
        currentTime++;
        for (int i = 0; i < flights.length; i++) {

            if (this.isPlaneAtAirport(flights[i].getPlane(), flights[i].getEndAirport())) {
                if (flights[i].getPlane().hasFullTank()) {
                    this.newFlight(randomFlight(flights[i].getPlane(), flights[i].getEndAirport()), i);
                } else {
                    flights[i].getPlane().refuel();
                }
            } else {
                flights[i].movePlane();
            }
        }
        this.table1.updateRows(this.flights, this.currentTime);

        scene1.repaint();
    }*/

 /*private void newFlight(Flight flight, int i) {
        this.flights[i] = flight;
    }*/
 /*private Airport randomAirport() {
        double random = Math.random() * this.airports.length;
        return this.airports[(int) random];
    }*/

 /*private boolean isPlaneAtAirport(Plane plane, Airport airport) {
        return plane.getX() == airport.getX() && plane.getY() == airport.getY();
    }*/

 /*private Flight randomFlight(Plane plane, Airport startAirport) {
        Airport targetAirport = this.randomAirport();

        while (targetAirport.getId() == startAirport.getId()) {
            targetAirport = this.randomAirport();
        }

        return new Flight(startAirport, targetAirport, plane);
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        scene1 = new com.mycompany.airportsimulator.Scene();
        table1 = new com.mycompany.airportsimulator.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scene1Layout = new javax.swing.GroupLayout(scene1);
        scene1.setLayout(scene1Layout);
        scene1Layout.setHorizontalGroup(
            scene1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        scene1Layout.setVerticalGroup(
            scene1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 199, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scene1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scene1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(table1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:

        //System.out.println("Hello " + this.currentTime);
        startSimulation();
        myScene = scene1;
        /*
        int r = (int)(Math.random()*255);
        int g = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);*/

        //Plane plane = new Plane((int)(Math.random()*ms.getWidth()),(int)(Math.random()*ms.getHeight()),30,new Color(r,g,b));
        /// b.start();
        //tab.add(plane);
        //myScene1.repaint();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        /*Watch w = new Watch();
        w.start();*/
        //new MainWindow.ActionListenerImpl();
        stopSimulation();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AirportSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AirportSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AirportSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AirportSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AirportSimulator().setVisible(true);
        });
    }

    /*private class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopSimulation();
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.mycompany.airportsimulator.Scene scene1;
    private com.mycompany.airportsimulator.Table table1;
    // End of variables declaration//GEN-END:variables
}
