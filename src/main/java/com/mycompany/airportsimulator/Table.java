/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.airportsimulator;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mateuszd
 */
public class Table extends javax.swing.JPanel{

        private DefaultTableModel tableModel;
    
    /**
     * Creates new form SamolotyLotniskaSimulator
     */
    public Table() {
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Samolot");
        tableModel.addColumn("KoordynatyA");
        tableModel.addColumn("KoordynatyB");
        tableModel.addColumn("LotniskoA");
        tableModel.addColumn("LotniskoB");
        tableModel.addColumn("Czas");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
    }
    
    public void updateRows(Flight[] flights,int currentTime){
            System.out.print("EEE" + currentTime);
     
            tableModel.setRowCount(flights.length);
            
            for (int i = 0; i < flights.length; i++) {
            
            //flights[i].movePlane();
            
            //System.out.print("QQQ"+flights[i].toString());
            System.out.print("QQQ" + i);
     
            tableModel.setValueAt(flights[i].getPlane().getX(), i,1);
            tableModel.setValueAt(flights[i].getPlane().getY(), i,2);
            
            tableModel.setValueAt(currentTime, i, 5);
            
        }
    }
    
    
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new SamolotyLotniskaSimulator().setVisible(true);
        });
    }
}
