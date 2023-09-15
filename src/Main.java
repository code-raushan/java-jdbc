import java.sql.*;

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

            /* Returns: a ResultSet object that contains the data produced by the given query; never null*/
            ResultSet rs = st.executeQuery(sql); // Read Operations
            // For operations like Insert, Update and Delete, we use executeUpdate()

            // If a 'SELECT' query is executed, then we can process the results from the 'ResultSet'.
            // rs.next();
            //
            // String result = rs.getString(2);
            //
            // rs.next();
            // String result2 = rs.getString(2);
            //
            // System.out.println(result);
            // System.out.println(result2);
            //

            // Iterating through the result set and extracting the data;

            while(rs.next()){
                int id = rs.getInt("id");
                String firstName = rs.getString("first_name");

                System.out.println(id + " " + firstName);

            }

            st.close();
            rs.close();
            con.close();

            System.out.println(con);





        }catch(SQLException e){
            System.out.println(e);
            e.printStackTrace();
        }


    }
}