package agenda.dao.mysql;

import agenda.dao.ContactoDAO;
import agenda.dao.DAOManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 * 
 * Throws SQLException
 * Crea una concexión
 */
public class MySQLDaoManager implements DAOManager {
    
    private Connection con;
    
    private ContactoDAO contacto = null;
    
    public MySQLDaoManager(Connection conexion){
        this.con = conexion;
    }
    
    /**
     * Conecta con la base de datos
     * @param host
     * @param user
     * @param pass
     * @param database
     * @throws SQLException 
     */
    public MySQLDaoManager(String host, String user, String pass, String database ) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, pass );
    }
    

    @Override
    public ContactoDAO getContactoDAO() {
       //PATRÓN SINGLETON!
       
       if (contacto == null) {
           contacto = new MySQLContactoDAO(con); //SE PASA LA CONECCIÓN
       }
       return contacto;
    }
}
