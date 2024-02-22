import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "sha644883won");
s=c.createStatement();

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
