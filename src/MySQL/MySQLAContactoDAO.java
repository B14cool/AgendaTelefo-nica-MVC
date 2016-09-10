package MySQL;

import agenda.JDBC.DaoException;
import agenda.modelos.Contacto;
import agenda.dao.ContactoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLAContactoDAO implements ContactoDAO {

    final String INSERT = "INSERT INTO contactos(nombre, numero, correo, ciudad, twitter) VALUES(?, ?, ?, ?) ";
    final String UPDATE = "UPDATE contactos SET nombre = ?, numero = ?, correo = ?, ciudad = ?, twitter = ? WHERE id = ?";
    final String DELETE = "DELETE FROM contactos WHERE id"; //porque el id es único, puede haber dos personas con mismo nombre
    final String GETALL = "SELECT id, nombre, numero, correo, ciudad, twitter FROM contactos";
    final String GETONE = "WHERE nombre = ?";
    private Connection con;

    public MySQLAContactoDAO(Connection con) {
        this.con = con;
    }
    
//Transformar un ResulSet en un Contacto
    private Contacto transformarResultSet(ResultSet rs) throws SQLException {
        String nombre = rs.getString("nombre");
        String numero = rs.getString("numero");
        String correo = rs.getString("correo");
        String ciudad = rs.getString("ciudad");
        String twitter = rs.getString("twitter");

        Contacto contacto = new Contacto(nombre, numero, correo, ciudad, twitter);
        //en scaso de no tener id
        contacto.setId(rs.getInt("id"));
        return contacto;
    }


    @Override
    public void registrar(Contacto contacto) throws DaoException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        try {
            stat = con.prepareStatement(INSERT);
            
            stat.setString(1, contacto.getNombre());/*...campo 1*/
            stat.setString(2, contacto.getNumero());
            stat.setString(3, contacto.getCorreo());
            stat.setString(4, contacto.getCiudad());
            stat.setString(5, contacto.getTwitter());
            if (stat.executeUpdate() == 0) {
                throw new DaoException("Error en SQL. ");
            }
            rs = stat.getGeneratedKeys();
            if (rs.next()) {
                contacto.setId(rs.getInt(1));
            } else {
                throw new DaoException("No se puede asignar el ID al contacto.");
            }
            //se guardó?
            if (stat.executeUpdate() == 0) {
                throw new DaoException("Tal vez no se guardó...");
            }
        } catch (SQLException ex) {
            throw new DaoException("Error en el query SQL.", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close(); //cierro la conección
                } catch (SQLException ex) {
                    throw new DaoException("Error en el query SQL", ex);
                }
            }
        }
    }

   
    @Override
    public void actualizar(Contacto contacto) throws DaoException {
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement(UPDATE);
            //stat.setInt(0, 0);
            stat.setString(1, contacto.getNombre());
            stat.setString(2, contacto.getNumero());
            stat.setString(3, contacto.getCorreo());
            stat.setString(4, contacto.getCiudad());
            stat.setString(5, contacto.getTwitter());
            stat.setInt(4, contacto.getId());
            //No se guardó? {
            if (stat.executeUpdate() == 0) {
                throw new DaoException("Tal vez no se modificó el contacto.");
            }
        } catch (SQLException ex) {
            throw new DaoException("Error en el query SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close(); //cierro la conección
                } catch (SQLException ex) {
                    throw new DaoException("Error en el query SQL", ex);
                }
            }
        }
    }

    @Override
    public void eliminar(Contacto contacto) throws DaoException {
        PreparedStatement stat = null;
        try {
            stat = con.prepareStatement(DELETE);
            stat.setInt(1, contacto.getId());
            // No se borró? {
            if (stat.executeUpdate() == 0) {
                throw new DaoException("Puede ser que no se guardó, revise.");
            }
        } catch (SQLException ex) {
            throw new DaoException("Error de SQL", ex);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                    throw new DaoException("Error en SQL", ex);
                }
            }
        }
    }

    @Override
    public List<Contacto> extraerTodos() throws DaoException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        //Lista de Contactos 
        List<Contacto> contactos = new ArrayList<>();
        try {
            stat = con.prepareStatement(GETALL);
            rs = stat.executeQuery();
            //mientras haya un contacto, muéstralo
            while(rs.next()) {
                contactos.add(transformarResultSet(rs));
            }
        } catch (SQLException ex) {
            throw new DaoException("Error en SQL", ex);
        } finally {
            //cerramos el ResultSet
            if(rs != null){
                try {
                    rs.close();
                } catch (Exception ex) {
                    throw new DaoException("Error en SQL", ex);
                }
            }
            //Cerramos el Statement
            if (stat != null) {
                try {
                    stat.close();
                } catch (Exception ex) {
                    throw new DaoException("Error en SQL", ex);
                }
            }
        }
        return contactos;
    }

    public Contacto buscar(int id) throws DaoException  {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Contacto contacto = null;
        try {
            stat = con.prepareStatement(GETONE);
            stat.setInt(1, id);
            rs = stat.executeQuery();
            if (rs.next()) {
                contacto = transformarResultSet(rs);
            } else {
                throw new DaoException("No se ha encontrado ese registro.");
            }
        } catch (SQLException ex) {
            throw new DaoException("Error en SQL", ex);
        } finally {
            if(rs != null){
                try {
                    rs.close();
                } catch (Exception ex) {
                    throw new DaoException("Error en SQL", ex);
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (Exception ex) {
                    throw new DaoException("Error en SQL", ex);
                }
            }
        }
        return contacto;
    }
}
