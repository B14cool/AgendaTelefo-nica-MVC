package MySQL;

import agenda.dao.ContactoDAO;
import agenda.dao.DAOManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoManager implements DAOManager {
    private Connection con;
    
    private ContactoDAO contacto = null;
    
    //Crea la conección automáticamente
    public MySQLDaoManager(String host, String user, String pass, String database ) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, user, pass );
    }
    

    @Override
    public ContactoDAO getContactoDAO() {
       //PATRÓN SINGLETON!
       
       if (contacto == null) {
           contacto = new MySQLAContactoDAO(con); //SE PASA LA CONECCIÓN
       }
       return contacto;
    }
}
