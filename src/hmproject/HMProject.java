package hmproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HMProject extends JFrame implements ActionListener {
    
    HMProject(){
        setSize(1000, 565);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/hotel.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1000, 565); //location, locality, length, bradth
        add(image);
        
        JLabel text = new JLabel("HOTEL MANAGMENT SYSTEM");
        text.setBounds(130, 20,1000,90);
        image.add(text);
        text.setForeground(Color.black);
        text.setFont(new Font("serif",Font.PLAIN, 50));
        setVisible(true);
        setLocation(100, 100);
        
        JButton next = new JButton("Next");
        next.setBounds(800,450,100,50);
        image.add(next);
        next.setBackground(Color.white);
        next.setForeground(Color.darkGray);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN, 20));
        
        while(true) {
            text.setVisible(false);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
            text.setVisible(true);
            try {
                Thread.sleep(500);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    
    public static void main(String[] args) {
        new HMProject();
    }
    
}
