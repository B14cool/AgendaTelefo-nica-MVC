package agenda.dao;

import agenda.dao.mysql.DaoException;
import java.util.List;

public interface GenericDAO<T, k> {

    //CRUD
    void insertar (T algo) throws DaoException;
    
    void modificar (T algo)throws DaoException;
    
    void eliminar (T algo)throws DaoException;
    
    List<T> extraerTodos()throws DaoException;
    
    T extraer(int id)throws DaoException;
   
}
