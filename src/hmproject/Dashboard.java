package hmproject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    
    Dashboard(){
        setBounds(0,0,1550,1000);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/hotel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 1000, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1550,1000);
        add(image);
        
        JLabel text = new JLabel("THE RS GROUP WELCOMES YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("ahoma",Font.PLAIN,46));
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar nb = new JMenuBar();
        nb.setBounds(0,0,1550,30);
        image.add(nb);
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        nb.add(hotel);
        hotel.setForeground(Color.red);
        
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        nb.add(admin);
        admin.setForeground(Color.blue);
        
        JMenuItem addemp = new JMenuItem("ADD EMPLOYEE");
        addemp.addActionListener(this);
        admin.add(addemp);
        JMenuItem addroom = new JMenuItem("ADD ROOMS");
        addroom.addActionListener(this);
        admin.add(addroom);
        JMenuItem adddriv = new JMenuItem("ADD DRIVERS");
        adddriv.addActionListener(this);
        admin.add(adddriv);
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getActionCommand().equals("ADD EMPLOYEE")) {
            new Addemp();
        } else if (ae.getActionCommand().equals("ADD ROOMS")){
            new Addroom();
        }  else if (ae.getActionCommand().equals("ADD DRIVERS")){
            new Adddriv();
        } else if (ae.getActionCommand().equals("RECEPTION")){
            new Reception();
        }
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
