package hmproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Adddriv extends JFrame implements ActionListener{
    
    JButton add,cancel;
    JTextField tname,tcar,tage,tmodel,tlocation;
    JComboBox gencombo,availcombo;
    Adddriv(){
        setLayout(null);
        setBounds(300,200,980,550);
        JLabel head = new JLabel("ADD DRIVERS");
        head.setBounds(150, 20, 200, 20);
        head.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(head);
        
        JLabel name = new JLabel("Name");
        name.setBounds(60, 80, 120, 30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        
        tname = new JTextField();
        tname.setBounds(200,80,150,30);
        add(tname);
        
        JLabel age = new JLabel("Age");
        age.setBounds(60, 130, 120, 30);
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(age);
        
        tage = new JTextField();
        tage.setBounds(200,130,150,30);
        add(tage);
        
        JLabel gender = new JLabel("Gender");
        gender.setBounds(60, 180, 120, 30);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(gender);
        
        String genOption[] = {"Male", "Female", "Other"};
        gencombo = new JComboBox(genOption);
        gencombo.setBounds(200,180,150,30);
        gencombo.setBackground(Color.white);
        add(gencombo);
        
        JLabel car = new JLabel("Car Company");
        car.setBounds(60, 230, 120, 30);
        car.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(car);
        
        tcar = new JTextField();
        tcar.setBounds(200,230,150,30);
        add(tcar);
        
        JLabel model = new JLabel("Car Brand");
        model.setBounds(60, 280, 120, 30);
        model.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(model);
        
        tmodel = new JTextField();
        tmodel.setBounds(200,280,150,30);
        add(tmodel);
        
        JLabel avail = new JLabel("Availability");
        avail.setBounds(60, 330, 120, 30);
        avail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(avail);
        
        String availOption[] = {"Available", "Busy"};
        availcombo = new JComboBox(availOption);
        availcombo.setBounds(200,330,150,30);
        availcombo.setBackground(Color.white);
        add(availcombo);
        
        JLabel location = new JLabel("Location");
        location.setBounds(60, 380, 120, 30);
        location.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(location);
        
        tlocation = new JTextField();
        tlocation.setBounds(200,380,150,30);
        add(tlocation);
        
        add = new JButton("Add Driver");
        add.setForeground(Color.white);
        add.setBackground(Color.black);
        add.setBounds(60,450,130,30);
        add.addActionListener(this);
        add(add);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setBounds(220,450,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(400,80,500,300);
        add(image);
        
        setVisible(true);
        getContentPane().setBackground(Color.white);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == add){
            String name = tname.getText();
            String age = tage.getText();
            String gender = (String) gencombo.getSelectedItem();
            String car = tcar.getText();
            String model = tmodel.getText();
            String avail = (String) availcombo.getSelectedItem();
            String location = tlocation.getText();
            
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is empty");
                return;
            }else if(age.equals("")){
                JOptionPane.showMessageDialog(null, "Age is empty");
                return;
            }else if(car.equals("")){
                JOptionPane.showMessageDialog(null, "Car is empty");
                return;
            }else if(model.equals("")){
                JOptionPane.showMessageDialog(null, "Model is empty");
                return;
            }else if(location.equals("")){
                JOptionPane.showMessageDialog(null, "Location is empty");
                return;
            }
            
            Conjava c = new Conjava();
            try {
                String str = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+avail+"','"+location+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null, "New Driver added successful");
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
        new Adddriv();
    }
}
