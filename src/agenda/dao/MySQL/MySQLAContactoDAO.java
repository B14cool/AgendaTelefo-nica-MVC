package agenda.dao.MySQL;

import agenda.JDBC.DaoException;
import agenda.modelos.Contacto;
import agenda.dao.ContactoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLAContactoDAO implements ContactoDAO {

    final String INSERT = "INSERT INTO contactos(nombre, numero, correo, ciudad, twitter) VALUES(?, ?, ?, ?) ";
    final String UPDATE = "UPDATE contactos SET nombre = ?, numero = ?, correo = ?, ciudad = ?, twitter = ? WHERE id = ?";
    final String DELETE = "DELETE FROM contactos WHERE id"; //porque el id es único, puede haber dos personas con mismo nombre
    final String GETALL = "SELECT id, nombre, numero, correo, ciudad, twitter FROM contactos";
    final String GETONE = "SELECT id, nombre, numero, correo, ciudad, twitter WHERE id = ?";
    private Connection con;

    public MySQLAContactoDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void registrar(Contacto contacto) throws DaoException {
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement(INSERT);
            stat.setString(1, contacto.getNombre());
            stat.setString(2, contacto.getNumero());
            stat.setString(3, contacto.getCorreo());
            stat.setString(4, contacto.getCiudad());
            stat.setString(5, contacto.getTwitter());

            //se guardó?
            if (stat.executeUpdate() == 0) {
                throw new DaoException("Revise si se guardó");
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
    public void actualizar(Contacto contacto) throws DaoException {
        PreparedStatement stat = null;

        try {
            stat = con.prepareStatement(UPDATE);
            stat.setString(1, contacto.getNombre());
            stat.setString(2, contacto.getNumero());
            stat.setString(3, contacto.getCorreo());
            stat.setString(4, contacto.getCiudad());
            stat.setString(5, contacto.getTwitter());

            //No se guardó? {
            if (stat.executeUpdate() == 0) {
                throw new DaoException("Revise si se guardó.");
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
    public List<Contacto> extraerTodos() {
        return;
    }

    @Override
    public Contacto obtener(int id) {
        return;
    }

}
