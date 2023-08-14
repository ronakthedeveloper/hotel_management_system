package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedtype;
    JCheckBox available;
    SearchRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Search for Rooms");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(400,30,200,30);
        add(text);
        
        JLabel bed = new JLabel("Bed Type");
        bed.setBounds(50,100,120,20);
        add(bed);
        
        bedtype = new JComboBox(new String[]{"Single Bed","Double Bed"});
        bedtype.setBounds(150,100,150,25);
        bedtype.setBackground(Color.WHITE);
        add(bedtype);
        
        available = new JCheckBox("Only display Available");
        available.setBounds(450,100,150,25);
        available.setBackground(Color.WHITE);
        add(available);
        
        JLabel i2 = new JLabel("Room Number");
        i2.setBounds(50,160,100,20);
        add(i2);
        
        JLabel i3 = new JLabel("Availibility");
        i3.setBounds(270,160,100,20);
        add(i3);
        
        JLabel i4 = new JLabel("Claening Status");
        i4.setBounds(450,160,100,20);
        add(i4);
        
        JLabel i5 = new JLabel("Price");
        i5.setBounds(670,160,100,20);
        add(i5);
        
        JLabel i6 = new JLabel("Type");
        i6.setBounds(850,160,100,20);
        add(i6);
        
        table = new JTable();
        table.setBounds(0,200,1000,300);
        add(table);
         
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from room");
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
               String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
               String query2 = "select * from room where available = 'Available' AND bed_type = '"+bedtype.getSelectedItem()+"'";
               Conjava con = new Conjava();
               ResultSet rs;
               if (available.isSelected()){
                   rs = con.s.executeQuery(query2);
               }else{
                   rs = con.s.executeQuery(query1);
               }
               
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
        new SearchRoom();
    }
}
