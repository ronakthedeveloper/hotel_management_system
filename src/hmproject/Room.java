package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Room(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel i2 = new JLabel("Room Number");
        i2.setBounds(10,10,100,20);
        add(i2);
        
        JLabel i3 = new JLabel("Availibility");
        i3.setBounds(120,10,100,20);
        add(i3);
        
        JLabel i4 = new JLabel("Status");
        i4.setBounds(230,10,100,20);
        add(i4);
        
        JLabel i5 = new JLabel("Price");
        i5.setBounds(340,10,100,20);
        add(i5);
        
        JLabel i6 = new JLabel("Type");
        i6.setBounds(440,10,100,20);
        add(i6);
        
        table = new JTable();
        table.setBounds(0,40,500,400);
        add(table);
         
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(200,500,130,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    }
    public static void main(String[] args){
        new Room();
    }
}
