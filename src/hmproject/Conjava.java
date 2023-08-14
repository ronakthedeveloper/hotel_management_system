package hmproject;

import java.sql.*;

public class Conjava {
    
    Connection c;
    Statement s;
    Conjava(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///hmproject","root","");
            s = c.createStatement();
            
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

