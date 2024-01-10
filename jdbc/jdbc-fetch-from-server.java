package jdbcs1;


import java.sql.*;
public class jdbc1{

    public static void main(String args[]) {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
           Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from student");
            while(rs.next())
            {
            	System.out.println(rs.getString("USN"));
            }
            
            if (!con.isClosed())
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
