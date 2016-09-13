package agenda.Ventanas;

import agenda.dao.mysql.DaoException;
import agenda.dao.ContactoDAO;
import agenda.modelo.Contacto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ContactoTableModel extends AbstractTableModel {

    private ContactoDAO contactos;
    
    public ContactoTableModel(ContactoDAO contactos){
        this.contactos = contactos;
    }
    
   private List<Contacto> datos = new ArrayList<>();
   
   public void actualizaModelo() throws DaoException{
       datos = contactos.extraerTodos();
   }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Nombre";
            case 2: return "Número";
            case 3: return "Correo";
            case 4: return "Ciudad";
            case 5: return "Twitter";
            default: return "N/A";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Contacto c = datos.get(rowIndex);
        switch(columnIndex){
            case 0: return c.getId();
            case 1: return c.getNombre();
            case 2: return c.getNumero();
            case 5: return c.getCorreo();
            case 6: return c.getCiudad();
            case 7: return c.getTwitter();
            default : return "";
        }
    }

}
