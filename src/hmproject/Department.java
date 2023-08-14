package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel i2 = new JLabel("Department");
        i2.setBounds(180,10,100,20);
        add(i2);
        
        JLabel i3 = new JLabel("Budget");
        i3.setBounds(420,10,100,20);
        add(i3);
        
        table = new JTable();
        table.setBounds(0,50,700,350);
        add(table);
         
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(280,400,120,30);
        add(back);
        
        setBounds(400,200,700,480);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Department();
    }
}
