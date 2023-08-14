package hmproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Addemp extends JFrame implements ActionListener{
    JTextField tname,temail,tsalary,tphone,tage,taadhar;
    JRadioButton rbmale,rbfemale,rbother;
    JButton submit;
    JComboBox cjob;
    
    Addemp(){
        getContentPane().setBackground(Color.white);
        JLabel head = new JLabel("ADD EMPLOYEES");
        head.setBounds(150, 20, 200, 20);
        head.setFont(new Font("Tahoma", Font.BOLD, 18));
        add(head);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(60,50,120,30);
        name.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(name);
        
        tname = new JTextField();
        tname.setBounds(200,50,150,30);
        add(tname);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60,100,120,30);
        age.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(age);
        
        tage = new JTextField();
        tage.setBounds(200,100,150,30);
        add(tage);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60,150,120,30);
        gender.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(gender);
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(200,150,70,30);
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbmale.setBackground(Color.white);
        add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(280,150,70,30);
        rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbfemale.setBackground(Color.white);
        add(rbfemale);
        
        rbother = new JRadioButton("Other");
        rbother.setBounds(360,150,70,30);
        rbother.setFont(new Font("Tahoma",Font.PLAIN,14));
        rbother.setBackground(Color.white);
        add(rbother);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);
        bg.add(rbother);
        
        JLabel job = new JLabel("JOB");
        job.setBounds(60,200,120,30);
        job.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(job);
        
        String str[] = { " ","Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Waiter/Waiteress","Manager","Accountant"};
        cjob = new JComboBox(str);
        cjob.setBounds(200,200,150,30);
        cjob.setBackground(Color.white);
        add(cjob);
        
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60,250,120,30);
        salary.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(salary);
        
        tsalary = new JTextField();
        tsalary.setBounds(200,250,150,30);
        add(tsalary);
        
        JLabel phone = new JLabel("PHONE");
        phone.setBounds(60,300,120,30);
        phone.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(phone);
        
        tphone = new JTextField();
        tphone.setBounds(200,300,150,30);
        add(tphone);
        
        JLabel email = new JLabel("EMAIL");
        email.setBounds(60,350,120,30);
        email.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(email);
        
        temail = new JTextField();
        temail.setBounds(200,350,150,30);
        add(temail);
        
        JLabel aadhar = new JLabel("AADHAR");
        aadhar.setBounds(60,400,120,30);
        aadhar.setFont(new Font("ahoma", Font.PLAIN, 17));
        add(aadhar);
        
        taadhar = new JTextField();
        taadhar.setBounds(200,400,150,30);
        add(taadhar);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(200,450,150,30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("photos/download.png"));
        JLabel image = new JLabel(i1);
        image.setBounds(380,60,450,450);
        add(image);
        
        setLayout(null);
        setBounds(350,200,850,540);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tname.getText();
        String age = tage.getText();
        String salary = tsalary.getText();
        String phone = tphone.getText();
        String email = temail.getText();
        String aadhar = taadhar.getText();
        
        String gender = null;
        
        if (name.equals("")){
            JOptionPane.showMessageDialog(null,"Name is Empty");
            return;
        }else if(age.equals("")){
            JOptionPane.showMessageDialog(null,"Age is Empty");
            return;
        }else if(salary.equals("")){
            JOptionPane.showMessageDialog(null,"Salary is Empty");
            return;
        }else if(phone.equals("")){
            JOptionPane.showMessageDialog(null,"Phone number is Empty");
            return;
        }else if(email.equals("")){
            JOptionPane.showMessageDialog(null,"Email is Emplty");
            return;
        }else if(aadhar.equals("")){
            JOptionPane.showMessageDialog(null,"Aadhar is Emplty");
            return;
        }else if((rbmale.isSelected()==false)&&(rbfemale.isSelected()==false)&&(rbother.isSelected()==false)){
            JOptionPane.showMessageDialog(null,"Gender is Emplty");
            return;
        }
        
        if (rbmale.isSelected()) {
            gender = "Male";
        } else if (rbfemale.isSelected()){
            gender = "Female";
        } else if(rbother.isSelected()){
            gender = "Other";
        }
        String job = (String) cjob.getSelectedItem();
        Conjava c = new Conjava();
        try {
            String query = "insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successful");
            setVisible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Addemp();
    }
}
