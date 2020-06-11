import java.sql.*;

public class DBHelper
{
    Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;
    
    public void createConnection() {
        String protokoll = "jdbc:sqlite:";
        String datenbank = "datenbank.db";
        String user = "internat";
        String kennwort = "pantau";

        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            conn  = DriverManager.getConnection(protokoll+datenbank, user, kennwort);
            System.out.println("Verbindung zur Datenbank steht.");
            stmt = conn.createStatement();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    
    public void closeConnection() {
        try {
            if (rset != null) {
                rset.close();
            }
            stmt.close();    
            conn.close();
            System.out.println("Abgemeldet.\n");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
