/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.flight_radar_simulator;

import java.awt.BorderLayout;
import java.util.Vector;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateuszd
 */
public class Table extends javax.swing.JPanel {

    private DefaultTableModel tableModel;

    /**
     * Creates new form SamolotyLotniskaSimulator
     */
    public Table() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Samolot");
        tableModel.addColumn("X");
        tableModel.addColumn("Y");
        tableModel.addColumn("Cel");
        tableModel.addColumn("Czas");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public void updateRows() {
        Vector<Plane> planes = Flight_Radar_Simulator.planes;

        tableModel.setRowCount(planes.size());

        for (int i = 0; i < planes.size(); i++) {

            tableModel.setValueAt(planes.elementAt(i).getPlaneId(), i, 0);
            tableModel.setValueAt(planes.elementAt(i).getX(), i, 1);
            tableModel.setValueAt(planes.elementAt(i).getY(), i, 2);
            tableModel.setValueAt(planes.elementAt(i).getTargetAirport().getAirportId(), i, 3);
            tableModel.setValueAt(planes.elementAt(i).getFlightTime(), i, 4);

            if (planes.elementAt(i).isPlaneRunning()) {
                planes.elementAt(i).increaseFlightTime();
            }
            //tableModel.setValueAt(currentTime, i, 5);
        }
    }
}
