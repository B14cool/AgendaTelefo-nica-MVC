package agenda.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLDBConnection implements DBConnection {

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    
    @Override
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost/contactos", "root", "root");
    }

    @Override
    public void desconectar(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                Logger.getLogger(MySQLDBConnection.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
}
