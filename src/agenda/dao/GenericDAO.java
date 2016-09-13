package agenda.dao;

import agenda.dao.mysql.DaoException;
import java.util.List;

public interface GenericDAO<T, k> {

    //CRUD
    void registrar (T algo) throws DaoException;
    
    void actualizar (T algo)throws DaoException;
    
    void eliminar (T algo)throws DaoException;
    
    List<T> extraerTodos()throws DaoException;
    
    T extraer(int id)throws DaoException;
   
}
