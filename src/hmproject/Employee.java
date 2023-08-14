package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Employee extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Employee(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel i2 = new JLabel("Name");
        i2.setBounds(40,10,100,20);
        add(i2);
        
        JLabel i3 = new JLabel("Age");
        i3.setBounds(170,10,100,20);
        add(i3);
        
        JLabel i4 = new JLabel("Gender");
        i4.setBounds(290,10,100,20);
        add(i4);
        
        JLabel i5 = new JLabel("Job");
        i5.setBounds(400,10,100,20);
        add(i5);
        
        JLabel i6 = new JLabel("Salary");
        i6.setBounds(540,10,100,20);
        add(i6);
        
        JLabel i7 = new JLabel("Phone");
        i7.setBounds(670,10,100,20);
        add(i7);
        
        JLabel i8 = new JLabel("Email");
        i8.setBounds(790,10,100,20);
        add(i8);
        
        JLabel i9 = new JLabel("Aadhar");
        i9.setBounds(910,10,100,20);
        add(i9);
        
        table = new JTable();
        table.setBounds(0,40,1000,400);
        add(table);
         
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(420,500,130,30);
        add(back);
        
        setBounds(300,200,1000,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Employee();
    }
}
