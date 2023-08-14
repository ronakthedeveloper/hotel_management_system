package hmproject;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField troom,tavailable,tcleaning,tpaid,tpending;
    JButton check,update,back;
    
    UpdateRoom(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,25));
        text.setBounds(30,20,250,30);
        text.setForeground(Color.BLUE);
        add(text);
        
        JLabel id = new JLabel("Customer Id");
        id.setBounds(30,80,100,20);
        add(id);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(30,130,100,20);
        add(room);
        
        troom = new JTextField();
        troom.setBounds(200,130,150,25);
        add(troom);
        
        JLabel name = new JLabel("Availability");
        name.setBounds(30,180,100,20);
        add(name);
        
        tavailable = new JTextField();
        tavailable.setBounds(200,180,150,25);
        add(tavailable);
        
        JLabel checkin = new JLabel("Cleaning Status");
        checkin.setBounds(30,230,100,20);
        add(checkin);
        
        tcleaning = new JTextField();
        tcleaning.setBounds(200,230,150,25);
        add(tcleaning);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,300,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,300,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,300,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,450);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conjava con = new Conjava();
                ResultSet rs = con.s.executeQuery(query);
                while(rs.next()){
                    troom.setText(rs.getString("room"));
                }
                
                ResultSet rs2 = con.s.executeQuery("select * from room where roomno = '"+troom.getText()+"'");
                while(rs2.next()){
                    tavailable.setText(rs2.getString("available"));
                    tcleaning.setText(rs2.getString("clean_status"));
                }
            }catch(Exception e){
                e.printStackTrace();
            } 
        } else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = troom.getText();
            String available = tavailable.getText();
            String cleaning = tcleaning.getText();
            
            try{
                Conjava c = new Conjava();
               c.s.executeUpdate ("update room set available = '"+available+"', clean_status = '"+cleaning+"' where roomno = '"+room+"'");
                JOptionPane.showMessageDialog(null,"Data Updated Successfully");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new UpdateRoom();
    }
}
