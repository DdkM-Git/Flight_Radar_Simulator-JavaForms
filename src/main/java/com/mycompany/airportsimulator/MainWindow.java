/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.airportsimulator;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateuszd
 */
public class MainWindow extends javax.swing.JFrame {

    private Timer timer;
    private int currentTime;
    private Flight[] flights = new Flight[4];
    private Airport[] airports = new Airport[5];
    private Plane[] planes = new Plane[4];

    //public static Vector<Plane> tab = new Vector<>();
    //public static Scene ms;
    public MainWindow() {
        initComponents();

        this.addAirport(new Airport(1, 1, 1, "Air1"), 0);
        this.addAirport(new Airport(2, 20, -20, "Air2"), 1);
        this.addAirport(new Airport(3, -20, 30, "Air3"), 2);
        this.addAirport(new Airport(4, -30, -30, "Air4"), 3);
        this.addAirport(new Airport(5, 30, 30, "Air5"), 4);

        this.addPlane(new Plane(1, 1, 1, 30, "Airbus"), 0);
        this.addPlane(new Plane(1, 1, 1, 30, "Airbus"), 1);
        this.addPlane(new Plane(1, 1, 1, 30, "Airbus"), 2);
        this.addPlane(new Plane(1, 1, 1, 30, "Airbus"), 3);

        currentTime = 0;
        timer = new Timer(1000, (ActionEvent e) -> {
            updateSimulation();
        });

    }

    private void startSimulation() {
        //currentTime = 0;

        // Dodawanie przykładowych samolotów i lotnisk
        addFlight(randomFlight(this.planes[0], this.airports[0]), 0);
        addFlight(randomFlight(this.planes[1], this.airports[0]), 1);
        addFlight(randomFlight(this.planes[2], this.airports[0]), 2);
        addFlight(randomFlight(this.planes[3], this.airports[0]), 3);

        this.table1.updateRows(this.flights, this.currentTime);
        timer.start();
    }

    private void stopSimulation() {
        timer.stop();
    }

    private void updateSimulation() {
        currentTime++;
        for (Flight flight : this.flights) {
            flight.movePlane();
        }
        this.table1.updateRows(this.flights, this.currentTime);
    }

    private void addFlight(Plane plane, Airport startAirport, Airport endAirport, int i) {
        this.flights[i] = new Flight(startAirport, endAirport, plane);
    }

    private void addFlight(Flight flight, int i) {
        this.flights[i] = flight;
    }

    private void addAirport(Airport airport, int i) {
        this.airports[i] = airport;
    }

    private void addPlane(Plane plane, int i) {
        this.planes[i] = plane;
    }

    private Airport randomAirport() {
        double random = Math.random() * this.airports.length;
        return this.airports[(int) random];
    }

    private Flight randomFlight(Plane plane, Airport startAirport) {
        Airport targetAirport = this.randomAirport();

        while (targetAirport.getId() == startAirport.getId()) {
            targetAirport = this.randomAirport();
        }

        return new Flight(startAirport, targetAirport, plane);
    }

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
        /*ms = new Scene();
        
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainWindow().setVisible(true);
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