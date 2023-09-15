import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String sql = "SELECT * FROM Actors;";
        String url = "jdbc:postgresql://localhost:49153/postgres";
        String username = "postgres";
        String password = "postgrespw";

        String insertSql = "INSERT INTO Actors values (?, ?, ?, ?, ?)";

        try {
            // Load the PostgreSQL JDBC driver
//            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println(con);

            /*Returns: a new default Statement object*/
            Statement st = con.createStatement();

            /* Returns: a ResultSet object that contains the data produced by the given query; never null*/
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
            PreparedStatement pst = con.prepareStatement(insertSql);
            pst.setInt(1, 7);
            pst.setString(2, "Jhon");
            pst.setString(3, "Dairy");
            pst.setInt(4, 35);
            pst.setString(5, "Male");

            int count = pst.executeUpdate(); // returns the number of rows affected;
            ResultSet rs = st.executeQuery(sql); // Read Operations


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
            e.printStackTrace();
        }

    }
}
/**
 * 1. Import the packages (java.sql.*)
 * 2. a. Load the driver
 * 2. b. Register the driver
 * 3. Establish the connection using DriverManager.getConnection()
 * 4. Create the statement using connection.createStatement()
 * 5. Execute the query using statement.executeQuery() or statement.executeUpdate(); takes sql string params
 * 6. Process the result (ResultSet in case of query)
 * 7. Close the connection
 * */

