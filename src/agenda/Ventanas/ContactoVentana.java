package agenda.Ventanas;

import agenda.dao.mysql.MySQLDaoManager;
import agenda.dao.mysql.DaoException;
import agenda.dao.DAOManager;
import agenda.dao.mysql.MySQLContactoDAO;
import agenda.modelo.Contacto;
import java.sql.SQLException;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

class ContactoVentana extends javax.swing.JFrame {

    Contacto contacto;
    
    private boolean editable;

    static DAOManager manager;

    DefaultTableModel model;
    
    public ContactoVentana(DAOManager manager) {
        initComponents();
        ContactoVentana.manager = manager;

        String titulo[] = {"Nombre", "Número", "Correo", "Ciudad", "Twitter",};
        String datos[][] = {};

        model = new DefaultTableModel(datos, titulo);

        tabla.setModel(model);
        
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent x1) {
                boolean selecciona = (tabla.getSelectedRow() != -1); //Si seleccional algo menor que cero no ha seleccionado nada
                editar.setEnabled(selecciona);
                borrar.setEnabled(selecciona);
            }
        });
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        txtNombre.setEditable(editable);
        txtNumero.setEditable(editable);
        txtCorreo.setEditable(editable);
        txtCiudad.setEditable(editable);
        txttwitter.setEditable(editable);
    }

    public void cargarDatos() {
        if (contacto != null) {
            txtNombre.setText(this.contacto.getNombre());
            txtNumero.setText(this.contacto.getNumero());
            txtCorreo.setText(this.contacto.getCorreo());
            txtCiudad.setText(this.contacto.getCiudad());
            txttwitter.setText(this.contacto.getTwitter());
        } else {
            txtNombre.setText("");
            txtNumero.setText("");
            txtCorreo.setText("");
            txtCiudad.setText("");
            txttwitter.setText("");
        }

        txtNombre.requestFocus();
    }

    public void guardarDatos() {
       
        this.contacto.setNombre(txtNombre.getText());
        this.contacto.setCorreo(txtCorreo.getText());
        this.contacto.setCorreo(txtCorreo.getText());
        this.contacto.setCiudad(txtCiudad.getText());
        this.contacto.setTwitter(txttwitter.getText());
    }

    public Contacto obtenerContactoSeleccionado() throws DaoException {
        int id = (int) tabla.getValueAt(tabla.getSelectedRow(), 0);
        return manager.getContactoDAO().extraer(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        nuevo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        editar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        botonguardar = new javax.swing.JButton();
        botoncancelar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txttwitter = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        fondo = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jButton5.setText("jButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jToolBar1.setRollover(true);

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/add.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.setFocusable(false);
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jToolBar1.add(nuevo);
        jToolBar1.add(jSeparator1);

        editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/editar.png"))); // NOI18N
        editar.setText("Editar");
        editar.setEnabled(false);
        editar.setFocusable(false);
        editar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(editar);

        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/borrar.png"))); // NOI18N
        borrar.setText("Borrar");
        borrar.setEnabled(false);
        borrar.setFocusable(false);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(borrar);
        jToolBar1.add(jSeparator2);
        jToolBar1.add(jSeparator3);

        botonguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/guardar.png"))); // NOI18N
        botonguardar.setText("Guardar");
        botonguardar.setEnabled(false);
        botonguardar.setFocusable(false);
        botonguardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botonguardar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        botonguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonguardarActionPerformed(evt);
            }
        });
        jToolBar1.add(botonguardar);

        botoncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/cancelar.png"))); // NOI18N
        botoncancelar.setText("Cancelar");
        botoncancelar.setEnabled(false);
        botoncancelar.setFocusable(false);
        botoncancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        botoncancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(botoncancelar);

        getContentPane().add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 50));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 470, 240));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        txtTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/telefono rojo vector.png"))); // NOI18N
        txtTelefono.setText("jLabel5");
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 340, 370));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Número:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Correo:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Twitter:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Ciudad:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 180, 20));
        getContentPane().add(txttwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 170, 20));
        getContentPane().add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 170, 20));
        getContentPane().add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 180, 20));

        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 260, 20));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agenda/images/azul grisáceo.jpg"))); // NOI18N
        fondo.setText("jLabel1");
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) throws DaoException {
        setContacto(null);
        setEditable(false);
        botonguardar.setEnabled(false);
        botoncancelar.setEnabled(false);
        tabla.clearSelection();
        cargarDatos();
    }

    private void editarActionPerformed(java.awt.event.ActionEvent evt) throws DaoException {
        Contacto contacto = obtenerContactoSeleccionado();
        setContacto(contacto);
        setEditable(true);
        cargarDatos();
    }

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        setContacto(null); //pongo los campos vacíos (ver constructor)
        cargarDatos();
        setEditable(true);
        botonguardar.setEnabled(true);
        botoncancelar.setEnabled(true);


    }//GEN-LAST:event_nuevoActionPerformed

    private void botonguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonguardarActionPerformed
        
        contacto.setNombre(txtNombre.getText());
        contacto.setNumero(txtNumero.getText());
        contacto.setCorreo(txtCorreo.getText());
        contacto.setCiudad(txtCiudad.getText());
        contacto.setTwitter(txttwitter.getText());

        Object datos[] = {contacto.getNombre(), contacto.getNumero(), contacto.getCorreo(), contacto.getCiudad(), contacto.getTwitter()};
        model.addRow(datos);
    }//GEN-LAST:event_botonguardarActionPerformed

    public static void main(String args[]) throws SQLException {
        //establezco la conexión con el manager
        DAOManager manager = new MySQLDaoManager("localhost", "root", "root", "contactos");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactoVentana(manager).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton botoncancelar;
    private javax.swing.JButton botonguardar;
    private javax.swing.JButton editar;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton nuevo;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JLabel txtTelefono;
    private javax.swing.JTextField txttwitter;
    // End of variables declaration//GEN-END:variables

}
