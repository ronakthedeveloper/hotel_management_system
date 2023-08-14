package hmproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Addroom extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField troom,tprice;
    JComboBox availcombo,cleancombo,typecombo;
    Addroom(){
        setLayout(null);
        setBounds(330,200,940,470);
        JLabel head = new JLabel("ADD ROOMS");
        head.setBounds(150, 20, 200, 20);
        head.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(head);
        
        JLabel roomno = new JLabel("Room Number");
        roomno.setBounds(60, 80, 120, 30);
        roomno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(roomno);
        
        troom = new JTextField();
        troom.setBounds(200,80,150,30);
        add(troom);
        
        JLabel avail = new JLabel("Available");
        avail.setBounds(60, 130, 120, 30);
        avail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(avail);
        
        String availableOption[] = {"Available", "Occupied"};
        availcombo = new JComboBox(availableOption);
        availcombo.setBounds(200,130,150,30);
        availcombo.setBackground(Color.white);
        add(availcombo);
        
        JLabel clean = new JLabel("Cleaning Status");
        clean.setBounds(60, 180, 120, 30);
        clean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(clean);
        
        String cleanOption[] = {"Cleaned", "Dirty"};
        cleancombo = new JComboBox(cleanOption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);
        
        JLabel price = new JLabel("Price");
        price.setBounds(60, 230, 120, 30);
        price.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(price);
        
        tprice = new JTextField();
        tprice.setBounds(200,230,150,30);
        add(tprice);
        
        JLabel type = new JLabel("Bed Type");
        type.setBounds(60, 280, 120, 30);
        type.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(type);
        
        String typeOption[] = {"Single Bed", "Double Bed"};
        typecombo = new JComboBox(typeOption);
        typecombo.setBounds(200,280,150,30);
        typecombo.setBackground(Color.white);
        add(typecombo);
        
        add = new JButton("Add Room");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String roomno = troom.getText();
            String avail = (String) availcombo.getSelectedItem();
            String clean = (String) cleancombo.getSelectedItem();
            String price = tprice.getText();
            String type = (String) typecombo.getSelectedItem();
            if(roomno.equals("")){
                JOptionPane.showMessageDialog(null,"Room Number is empty");
                return;
            }else if(price.equals("")){
                JOptionPane.showMessageDialog(null, "Price is empty");
                return;
            }
            Conjava c = new Conjava();
            try {
                String str = "insert into room values('"+roomno+"','"+avail+"','"+clean+"','"+price+"','"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Room added successful");
            setVisible(false);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Dashboard();
        }
    }
    public static void main (String[] args){
        new Addroom();
    }
}
