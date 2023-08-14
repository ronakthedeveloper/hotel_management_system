package hmproject;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;
import java.awt.event.*;
public class Addcustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JButton add,back;
    JTextField tnumber,tname,tcountry,tdeposit;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime;
    Addcustomer(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway",Font.PLAIN,20));
        add(text);
        
        JLabel id = new JLabel("ID");
        id.setBounds(35,80,100,20);
        id.setFont(new Font("Raleway",Font.PLAIN,20));
        add(id);
        
        String option[]= {" ","Aadhar Card","Passport","Driving Licenese","Voter-id card","Ration card"};
        comboid = new JComboBox(option);
        comboid.setBounds(200,80,150,20);
        add(comboid);
        
        JLabel number = new JLabel("Number");
        number.setBounds(35,120,100,20);
        number.setFont(new Font("Raleway",Font.PLAIN,20));
        add(number);
        
        tnumber = new JTextField();
        tnumber.setBounds(200,120,150,25);
        add(tnumber);
        
        JLabel name = new JLabel("Name");
        name.setBounds(35,160,100,20);
        name.setFont(new Font("Raleway",Font.PLAIN,20));
        add(name);
        
        tname = new JTextField();
        tname.setBounds(200,160,150,25);
        add(tname);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(35,200,100,20);
        gender.setFont(new Font("Raleway",Font.PLAIN,20));
        add(gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,200,60,25);
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(290,200,80,25);
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        
        JLabel country = new JLabel("Country");
        country.setBounds(35,240,100,20);
        country.setFont(new Font("Raleway",Font.PLAIN,20));
        add(country);
        
        tcountry = new JTextField();
        tcountry.setBounds(200,240,150,25);
        add(tcountry);
        
        JLabel room = new JLabel("Room Number");
        room.setBounds(35,280,150,20);
        room.setFont(new Font("Raleway",Font.PLAIN,20));
        add(room);
        
        croom = new Choice();
        try{
            Conjava con = new Conjava();
            String query = "select * from room where available = 'Available'";
            ResultSet rs = con.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        croom.setBounds(200,280,150,25);
        add(croom);
        
        JLabel checkin = new JLabel("Checkin time");
        checkin.setBounds(35,320,150,20);
        checkin.setFont(new Font("Raleway",Font.PLAIN,20));
        add(checkin);
        
        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200,320,200,25);
        checkintime.setFont(new Font("Raleway",Font.PLAIN,15));
        add(checkintime);
        
        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(35,360,100,20);
        deposit.setFont(new Font("Raleway",Font.PLAIN,20));
        add(deposit);
        
        tdeposit = new JTextField();
        tdeposit.setBounds(200,360,150,25);
        add(tdeposit);
        
        add = new JButton("Add");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(50,410,120,25);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(240,410,120,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,50,300,400);
        add(image);
        
        
        setBounds(350,200,800,550);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String id = (String) comboid.getSelectedItem();
            String number = tnumber.getText();
            String name = tname.getText();
            String gender = null;
            if (rbmale.isSelected()){
                gender = "Male";
            }else {
                gender = "Female";
            }
            String country = tcountry.getText();
            String room = croom.getSelectedItem();
            String time = checkintime.getText();
            String deposit = tdeposit.getText();
            
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Number is empty");
                return;
            }else if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is empty");
                return;
            }else if(country.equals("")){
                JOptionPane.showMessageDialog(null, "country is empty");
                return;
            }else if(time.equals("")){
                JOptionPane.showMessageDialog(null, "Time is empty");
                return;
            }else if(deposit.equals("")){
                JOptionPane.showMessageDialog(null, "Deposit is empty");
                return;
            }else if((rbmale.isSelected()==false)&&(rbfemale.isSelected()==false)){
                JOptionPane.showMessageDialog(null,"gender is empty");
                return;
            }
            
            Conjava c = new Conjava();
            try{
                String query = "insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposit+"')";
                String query2 = "update room set available = 'Occupied' where roomno = '"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New Customer Added Successfully");
                setVisible(false);
                new Reception();
                
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Addcustomer();

    }
}