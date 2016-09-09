package agenda.dao;

import agenda.JDBC.DaoException;
import java.util.List;

public interface GenericDAO<T> {

    //CRUD
    void registrar (T algo) throws DaoException;
    
    void actualizar (T algo)throws DaoException;
    
    void eliminar (T algo)throws DaoException;
    
    List<T> extraerTodos()throws DaoException;
    
    T obtener(int id)throws DaoException;
   
}
