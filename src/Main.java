import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM ACTORS;";
        String url = "jdbc:postgresql://localhost:49153/postgres";
        String username = "postgres";
        String password = "postgrespw";

        try {
            // Load the PostgreSQL JDBC driver
//            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println(con);

            /*Returns: a new default Statement object*/
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            rs.next();

            String result = rs.getString(2);
            rs.next();
            String result2 = rs.getString(2);

            System.out.println(result);
            System.out.println(result2);



        }catch(Exception e){
            System.out.println(e);
        }


    }
}