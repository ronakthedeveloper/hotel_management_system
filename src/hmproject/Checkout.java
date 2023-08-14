package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Checkout extends JFrame implements ActionListener{
    Choice customerid;
    JLabel roomnumber,checkintime,checkouttime;
    JButton checkout,back;
    Checkout(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Checkout");
        text.setBounds(90,20,200,30);
        text.setForeground(Color.BLUE);
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(text);
         
        JLabel id = new JLabel("Customer Id");
        id.setBounds(30,80,100,20);
        add(id);
         
        customerid = new Choice();
        customerid.setBounds(150,80,150,25);
        add(customerid);
         
        JLabel room = new JLabel("Room Number");
        room.setBounds(30,130,100,30);
        add(room);
         
        roomnumber = new JLabel();
        roomnumber.setBounds(150,130,100,30);
        add(roomnumber);
         
        JLabel checkin = new JLabel("Checkin Time");
        checkin.setBounds(30,180,100,30);
        add(checkin);
         
        checkintime = new JLabel();
        checkintime.setBounds(150,180,100,30);
        add(checkintime);
       
        JLabel lcheckout = new JLabel("Checkout Time");
        lcheckout.setBounds(30,230,100,30);
        add(lcheckout);
         
        checkouttime = new JLabel();
        checkouttime.setBounds(150,230,100,30);
        add(checkouttime);
         
        Date date = new Date();
        checkouttime = new JLabel("" + date);
        checkouttime.setBounds(150,230,100,30);
        add(checkouttime);
         
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setBounds(30,280,120,30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(170,280,120,30);
        back.addActionListener(this);
        add(back);
         
        try{
            Conjava c = new Conjava();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                customerid.add(rs.getString("number"));
                roomnumber.setText(rs.getString("room"));
                checkintime.setText(rs.getString("checkintime"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
        
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i2);
        image.setBounds(350,50,400,250);
        add(image);
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == checkout){
            String query1 = "delete from customer where number = '"+customerid.getSelectedItem()+"'";
            String query2 = "update room set available = 'Available' where roomno = '"+roomnumber.getText()+"'";
            try{
                Conjava con = new Conjava();
                con.s.executeUpdate(query1);
                con.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null,"Checkout Done");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args){
        new Checkout();
    }
}
