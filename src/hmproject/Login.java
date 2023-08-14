package hmproject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JTextField username,password;
    JButton login, cancel;
    Login(){
        getContentPane().setBackground(Color.white);
        
        setLayout(null);
        JLabel user = new JLabel("Username");
        user.setBounds(40,20,100,30);
        add(user);
        username = new JTextField();
        username.setBounds(150,20,150,30);
        add(username);
        
        JLabel pass = new JLabel("Password");
        pass.setBounds(40,70,100,30);
        add(pass);
        password = new JTextField();
        password.setBounds(150,70,150,30);
        add(password);
        
        login = new JButton("Login");
        login.setBounds(40,150,120,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(350,10,200,200);
        add(image);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(180,150,120,30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        setBounds(500,200,600,300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = password.getText();
            if(user.equals("")){
                JOptionPane.showMessageDialog(null, "Username is empty");
                return;
            }else if(pass.equals("")){
                JOptionPane.showMessageDialog(null, "Password is empty");
                return;
            }
            Conjava c = new Conjava();
            try {
                String query = "select * from login where username = '" + user + "'and password = '" + pass + "'";
                ResultSet rs;
                rs = c.s.executeQuery(query);
                if (rs.next()){
                    setVisible(false);
                    new Dashboard();
                }else {
                    JOptionPane.showMessageDialog(null,"Invalid information");
                    setVisible(false);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource() == cancel){
            setVisible(false);
        }
    }
        
    public static void main(String[] args){
        new Login();
    }
}
