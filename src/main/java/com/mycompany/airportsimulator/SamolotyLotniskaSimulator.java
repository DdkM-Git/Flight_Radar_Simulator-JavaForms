package com.mycompany.airportsimulator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author mateuszd
 */
public class SamolotyLotniskaSimulator extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private Timer timer;
    private int currentTime;
    private Flight[] flights = new Flight[3];

    /**
     * Creates new form SamolotyLotniskaSimulator
     */
    public SamolotyLotniskaSimulator() {
        super("Symulator Samolotów i Lotnisk");

        // Tworzenie interfejsu użytkownika
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Samolot");
        tableModel.addColumn("KoordynatyA");
        tableModel.addColumn("KoordynatyB");
        tableModel.addColumn("LotniskoA");
        tableModel.addColumn("LotniskoB");
        tableModel.addColumn("Czas");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);

        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Inicjalizacja symulacji
        currentTime = 0;
        timer = new Timer(1000, (ActionEvent e) -> {
            updateSimulation();
        });

        // Obsługa przycisków
        startButton.addActionListener((ActionEvent e) -> {
            startSimulation();
        });

        stopButton.addActionListener(new ActionListenerImpl());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void startSimulation() {
        currentTime = 0;
        tableModel.setRowCount(0); // Wyczyszczenie tabeli

        // Dodawanie przykładowych samolotów i lotnisk
        //addFlight(new Plane(1, 1, 1, "Airbus"), new Airport(1, 1, "Air1"), new Airport(20, -20, "Air2"), 0);
        //addFlight(new Plane(1, 1, 1, "Airbus"), new Airport(1, 1, "Air1"), new Airport(-20, 30, "Air2"), 1);
        //addFlight(new Plane(1, 1, 1, "Airbus"), new Airport(1, 1, "Air1"), new Airport(-30, -30, "Air2"), 2);

        timer.start();
    }

    private void stopSimulation() {
        timer.stop();
    }

    private void updateSimulation() {
        currentTime++;
        // Symulacja ruchu samolotów (można dostosować logikę symulacji)
        // Aktualizacja tabeli
        for (int i = 0; i < tableModel.getRowCount(); i++) {

            this.flights[i].movePlane();

            tableModel.setValueAt(this.flights[i].getPlane().getX(), i, 1);
            tableModel.setValueAt(this.flights[i].getPlane().getY(), i, 2);

            int time = (int) tableModel.getValueAt(i, 5);
            tableModel.setValueAt(time + 1, i, 5);

        }
    }

    private void addFlight(Plane plane, Airport startAirport, Airport endAirport, int i) {
        this.flights[i] = new Flight(startAirport, endAirport, plane);
        tableModel.addRow(new Object[]{plane.getName(), plane.getX(), plane.getY(), startAirport.getName(), endAirport.getName(), 0});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(SamolotyLotniskaSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SamolotyLotniskaSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SamolotyLotniskaSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SamolotyLotniskaSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new SamolotyLotniskaSimulator().setVisible(true);
        });
    }

    private class ActionListenerImpl implements ActionListener {

        public ActionListenerImpl() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopSimulation();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
