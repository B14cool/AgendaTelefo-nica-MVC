package agenda.Ventanas;

import agenda.modelos.Contacto;

public class DatosContactoPanel extends javax.swing.JPanel {

    Contacto contacto;
    
    boolean editable;
    
     public DatosContactoPanel() {
         new DatosContactoPanel();
    }

    public Contacto getContatco() {
        return contacto;
    }

    public void setContatco(Contacto contatco) {
        this.contacto = contatco;
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
        txtTwitter.setEditable(editable);
    }
    
    public void cargarDatos(){
        
        if(contacto != null) {
            txtNombre.setText(contacto.getNombre());
            txtNumero.setText(contacto.getNumero());
            txtCorreo.setText(contacto.getCorreo());
            txtCiudad.setText(contacto.getCiudad());
            txtTwitter.setText(contacto.getTwitter());
        } else {
            txtNombre.setText("");
            txtNumero.setText("");
            txtCorreo.setText("");
            txtCiudad.setText("");
            txtTwitter.setText("");
        }
    }
    
    public void GuardarContacto(){
        if(contacto == null){
            contacto = new Contacto();
        }
       contacto.setNombre(txtNombre.getText());
       contacto.setNumero(txtNumero.getText());
       contacto.setCorreo(txtCorreo.getText());
       contacto.setCiudad(txtCiudad.getText());
       contacto.setTwitter(txtTwitter.getText());
    }
    
   

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        txtTwitter = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Datos a guardar/editar/borrar");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nombre:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 30));

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Correo: ");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        jLabel7.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ciudad:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 60, 20));

        txtCiudad.setBackground(new java.awt.Color(0, 68, 130));
        txtCiudad.setForeground(new java.awt.Color(255, 255, 255));
        add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 140, 30));

        txtCorreo.setBackground(new java.awt.Color(0, 68, 130));
        txtCorreo.setForeground(new java.awt.Color(255, 255, 255));
        add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 430, 30));

        txtNombre.setBackground(new java.awt.Color(0, 68, 130));
        txtNombre.setForeground(new java.awt.Color(255, 255, 255));
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 170, 30));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Número:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, 30));

        txtNumero.setBackground(new java.awt.Color(0, 68, 130));
        txtNumero.setForeground(new java.awt.Color(255, 255, 255));
        add(txtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 150, 30));

        txtTwitter.setBackground(new java.awt.Color(0, 68, 130));
        txtTwitter.setForeground(new java.awt.Color(255, 255, 255));
        add(txtTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 210, 30));

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Twitter: ");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, -1, 30));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtTwitter;
    // End of variables declaration//GEN-END:variables
}
