package jdbcprogram;
import java.sql.*;
import java.util.*;
public class jdbcsimple{

    public static <I> void main(String args[]) {
        Connection con = null;
        try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
          PreparedStatement pt=con.prepareStatement("insert into student values(?,?)") ;
          Scanner sc = new Scanner(System.in);
          System.out.println("enter usn and name\n");
          int x = sc.nextInt();
          String y = sc.next();
          pt.setInt(1, x);
          pt.setString(2,y);
           int rs=pt.executeUpdate();
//            while(rs.next())
//            {
//            	System.out.println(rs.getString("USN"));
//            	System.out.println(rs.getString("Name"));
//            	
//            }
//            
//            if (!con.isClosed())
                System.out.println("Successfully connected to MySQL server...");
        } catch(Exception e) {
            System.err.println("Exception: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch(SQLException e) {}
        }
    }
}