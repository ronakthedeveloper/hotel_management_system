package hmproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Reception extends JFrame implements ActionListener{
    JButton newc,rooms,department,allemp,manager,customer,search,update,updateroom,pickup,logout,checkout;
    Reception(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        newc = new JButton("New Customer Form");
        newc.setBounds(10,30,200,30);
        newc.setBackground(Color.black);
        newc.setForeground(Color.white);
        newc.addActionListener(this);
        add(newc);
        
        rooms = new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.addActionListener(this);
        add(rooms);
        
        department = new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.addActionListener(this);
        add(department);
        
        allemp = new JButton("All Employees");
        allemp.setBounds(10,150,200,30);
        allemp.setBackground(Color.black);
        allemp.setForeground(Color.white);
        allemp.addActionListener(this);
        add(allemp);
        
        customer = new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.black);
        customer.setForeground(Color.white);
        customer.addActionListener(this);
        add(customer);
        
        manager = new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.black);
        manager.setForeground(Color.white);
        manager.addActionListener(this);
        add(manager);
        
        checkout = new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.addActionListener(this);
        add(checkout);
        
        update = new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        updateroom = new JButton("Upadte Room Status");
        updateroom.setBounds(10,350,200,30);
        updateroom.setBackground(Color.black);
        updateroom.setForeground(Color.white);
        updateroom.addActionListener(this);
        add(updateroom);
        
        pickup = new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.black);
        pickup.setForeground(Color.white);
        pickup.addActionListener(this);
        add(pickup);
        
        search = new JButton("Serach Room");
        search.setBounds(10,430,200,30);
        search.setBackground(Color.black);
        search.setForeground(Color.white);
        search.addActionListener(this);
        add(search);
        
        logout = new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/rece.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(250,30,500,470);
        add(image);
        
       
        setBounds(350,200,800,600);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newc){
            setVisible(false);
            new Addcustomer();
        } else if(ae.getSource() == rooms){
            setVisible(false);
            new Room();
        } else if(ae.getSource() ==department){
            setVisible(false);
            new Department();
        } else if(ae.getSource() == allemp){
            setVisible(false);
            new Employee();
        } else if(ae.getSource() == manager){
            setVisible(false);
            new Manager();
        } else if(ae.getSource() == customer){
            setVisible(false);
            new Customer();
        } else if(ae.getSource() == search){
            setVisible(false);
            new SearchRoom();
        } else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheck();
        } else if(ae.getSource() == updateroom){
            setVisible(false);
            new UpdateRoom();
        } else if(ae.getSource() == pickup){
            setVisible(false);
            new Pickup();
        } else if(ae.getSource() == checkout){
            setVisible(false);
            new Checkout();
        } else if (ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }   
           
    }
    
    public static void main(String[] args){
        new Reception();
    }
}
