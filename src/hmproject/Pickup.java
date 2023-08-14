package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class Pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice typeofcar;
    JCheckBox available;
    Pickup(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Pickup Service");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel bed = new JLabel("Type of Car");
        bed.setBounds(50,100,120,20);
        add(bed);
        
       typeofcar = new Choice();
       typeofcar.setBounds(180,100,200,25);
       add(typeofcar);
       try{
           Conjava c = new Conjava();
           ResultSet rs = c.s.executeQuery("select * from driver");
           while(rs.next()){
               typeofcar.add(rs.getString("car_model"));
           }
       }catch(Exception e){
           e.printStackTrace();
       }
        
        
        JLabel i2 = new JLabel("Name");
        i2.setBounds(30,160,100,20);
        add(i2);
        
        JLabel i3 = new JLabel("Age");
        i3.setBounds(200,160,100,20);
        add(i3);
        
        JLabel i4 = new JLabel("Gender");
        i4.setBounds(330,160,100,20);
        add(i4);
        
        JLabel i5 = new JLabel("Company");
        i5.setBounds(460,160,100,20);
        add(i5);
        
        JLabel i6 = new JLabel("Brand");
        i6.setBounds(630,160,100,20);
        add(i6);
        
        JLabel i7 = new JLabel("Availability");
        i7.setBounds(740,160,100,20);
        add(i7);
        
        JLabel i8 = new JLabel("Location");
        i8.setBounds(870,160,100,20);
        add(i8);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
         
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch (Exception e){
            e.printStackTrace();
        }
        
        submit = new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        submit.setBounds(300,520,120,30);
        add(submit);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        back.setBounds(500,520,120,30);
        add(back);
        
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            try{
               String query = "select * from driver where car_model = '"+typeofcar.getSelectedItem()+"'";
               
               Conjava con = new Conjava();
               ResultSet rs;
               rs = con.s.executeQuery(query);
               table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Pickup();
    }
}
