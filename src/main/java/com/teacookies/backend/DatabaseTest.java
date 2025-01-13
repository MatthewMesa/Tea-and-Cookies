import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseTest {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlserver://localhost:1433;databaseName=tc_elearning;trustServerCertificate=true";
        String username = "sa";
        String password = "1509";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Conexión exitosa a SQL Server");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
