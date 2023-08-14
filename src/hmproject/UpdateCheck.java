package hmproject;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateCheck extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField troom,tname,tcheckin,tpaid,tpending;
    JButton check,update,back;
    
    UpdateCheck(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90,20,200,30);
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
        room.setBounds(30,120,100,20);
        add(room);
        
        troom = new JTextField();
        troom.setBounds(200,120,150,25);
        add(troom);
        
        JLabel name = new JLabel("Name");
        name.setBounds(30,160,100,20);
        add(name);
        
        tname = new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);
        
        JLabel checkin = new JLabel("Checkin Time");
        checkin.setBounds(30,200,100,20);
        add(checkin);
        
        tcheckin = new JTextField();
        tcheckin.setBounds(200,200,150,25);
        add(tcheckin);

        JLabel paid = new JLabel("Amount Piad");
        paid.setBounds(30,240,100,20);
        add(paid);
        
        tpaid = new JTextField();
        tpaid.setBounds(200,240,150,25);
        add(tpaid);
        
        JLabel pending = new JLabel("Pending Amount");
        pending.setBounds(30,280,100,20);
        add(pending);
        
        tpending = new JTextField();
        tpending.setBounds(200,280,150,25);
        add(tpending);
        
        check = new JButton("Check");
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("Update");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(150,340,100,30);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(270,340,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,500);
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
                    tname.setText(rs.getString("name"));
                    tcheckin.setText(rs.getString("checkintime"));
                    tpaid.setText(rs.getString("deposit"));
                }
                
                ResultSet rs2 = con.s.executeQuery("select * from room where roomno = '"+troom.getText()+"'");
                while(rs2.next()){
                    String price = rs2.getString("price");
                    int amountpaid = Integer.parseInt(price) - Integer.parseInt(tpaid.getText());
                    tpending.setText(""+amountpaid);
                }
            }catch(Exception e){
                e.printStackTrace();
            } 
        } else if(ae.getSource() == update){
            String number = ccustomer.getSelectedItem();
            String room = troom.getText();
            String name = tname.getText();
            String checkin = tcheckin.getText();
            String deposit = tpaid.getText();
            
            try{
                Conjava c = new Conjava();
               c.s.executeUpdate ("update customer set room = '"+room+"', name = '"+name+"', checkintime = '"+checkin+"', deposit = '"+deposit+"' where number = '"+number+"'");
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
        new UpdateCheck();
    }
}
