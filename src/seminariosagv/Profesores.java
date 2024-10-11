
package seminariosagv;

//import com.sun.glass.events.KeyEvent;
import config.Conexion;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SamuelGarduno
 */
public class Profesores extends javax.swing.JFrame {
Conexion con = new Conexion();
    Connection conet;
    /**
     * Creates new form Alumnos
     */
    public Profesores() {
        initComponents();
        consultar("");
        validar();
        setLocationRelativeTo(null);
        tid.setEnabled(false);
        btnguardar.setEnabled(false);
        bmodficar.setEnabled(false);
        btneliminar.setEnabled(false);
    }
        void consultar(String tid){
        DefaultTableModel modelo = new DefaultTableModel();       
        String [] alumnos = new String[5];
        String [] Titulos = {"Id","Nombre","Paterno","Materno","Especialidad"};
        modelo.setColumnIdentifiers(Titulos);
        Tabla.setModel(modelo);
        
        
        
        String sql = "";


        try {
            
            if (tid.equals(""))
            {
                sql = "SELECT * FROM Profesores_Samuel";
            }
            else
            {
                sql = "SELECT * FROM Profesores_Samuel WHERE id like'%" + tid + "%' or nombre like'%" + tid + "%'";
            }
        conet = con.getConeccetion();
        Statement st = conet.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
         {
             alumnos[0] = rs.getString("id");
             alumnos[1] = rs.getString("nombre");
             alumnos[2] = rs.getString("ap1");
             alumnos[3] = rs.getString("ap2");
             alumnos[4] = rs.getString("especialidad");

             
             modelo.addRow(alumnos);
         }
        Tabla.setModel(modelo);
        }
        
        catch(Exception e){
          JOptionPane.showMessageDialog(null, "Consulta No Realizada     "+ e.getLocalizedMessage());
      }
    }

        public void guardar(){
         try
      {
          String insertar = "INSERT INTO Profesores_Samuel (nombre,ap1,ap2,especialidad) values (?,?,?,?)";
          PreparedStatement guardar = conet.prepareStatement(insertar);
          guardar.setString(1,tnombre.getText());
          guardar.setString(2,tpaterno.getText());
          guardar.setString(3,tmaterno.getText());
          guardar.setString(4,tespecialidad.getText());
          guardar.execute();
          JOptionPane.showMessageDialog(null, "guardado con exito");
      }
      catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, "no se guardo" + e.getMessage());
      }
    }

    public void Eliminar(){
    
        String consulta = "DELETE FROM Profesores_Samuel WHERE Profesores_Samuel.id=?;";
        
        try {
             PreparedStatement Eliminar = conet.prepareStatement(consulta);
             Eliminar.setString(1,tid.getText());
             Eliminar.execute();
             
             JOptionPane.showMessageDialog(null,"Se Eliminó ");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"No Se Pudo Eliminar, ERROR:  "+ e.toString());
        }
        
    }

        public void Modificar(){ 

    
        String consulta = "UPDATE Profesores_Samuel SET  Profesores_Samuel.nombre = ?, Profesores_Samuel.ap1 = ?, Profesores_Samuel.ap2 = ?, Profesores_Samuel.especialidad =? WHERE Profesores_Samuel.id=?;";
        
        try {
             PreparedStatement modificar = conet.prepareStatement(consulta);

             modificar.setString(1,tnombre.getText());
             modificar.setString(2,tpaterno.getText());
             modificar.setString(3,tmaterno.getText());
             modificar.setString(4,tespecialidad.getText());
             modificar.setString(5,tid.getText());
             modificar.execute();
             
             JOptionPane.showMessageDialog(null,"Se Actualizo");
            
            
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null,"No Se Pudo Modificar, ERROR:  "+ e.toString());
        }
        
    }

        public void limpiar() {
            tid.setText("");
            tnombre.setText("");
            tpaterno.setText("");
            tmaterno.setText("");
            tespecialidad.setText("");
        }

            public void validar(){
        
            
            if (tnombre.getText().isEmpty()){
                lnombre.setText("CAMPO REQUERIDO");
            }else{
                lnombre.setText("");
            }
            
            if (tpaterno.getText().isEmpty()){
                lpaterno.setText("CAMPO REQUERIDO");
            }else{
                lpaterno.setText("");
            }
            
            if (tmaterno.getText().isEmpty()){
                lmaterno.setText("CAMPO REQUERIDO");
            }else{
                lmaterno.setText("");
            }
            
            if (tespecialidad.getText().isEmpty()){
                lespecialidad.setText("CAMPO REQUERIDO");
            }else{
                lespecialidad.setText("");
            }
            
            
            if (tnombre.getText().isEmpty() || tpaterno.getText().isEmpty() || 
                    tmaterno.getText().isEmpty() || tespecialidad.getText().isEmpty()){
            
                btnguardar.setEnabled(false);
                bmodficar.setEnabled(false);
                btneliminar.setEnabled(false);
            }else{
                btnguardar.setEnabled(true);
                bmodficar.setEnabled(true);
                btneliminar.setEnabled(true);
            }
            
            
            
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        tnombre = new javax.swing.JTextField();
        tpaterno = new javax.swing.JTextField();
        tmaterno = new javax.swing.JTextField();
        tespecialidad = new javax.swing.JTextField();
        Home = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        bmodficar = new javax.swing.JButton();
        tid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lnombre = new javax.swing.JLabel();
        lpaterno = new javax.swing.JLabel();
        lmaterno = new javax.swing.JLabel();
        lespecialidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 300));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seminariosagv/Inconos/profesor.png"))); // NOI18N
        jLabel1.setText("Profesores");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Materno", "Apellido Paterno", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabla);
        if (Tabla.getColumnModel().getColumnCount() > 0) {
            Tabla.getColumnModel().getColumn(0).setResizable(false);
        }

        jLabel2.setText("Nombre");

        jLabel3.setText("Paterno");

        jLabel4.setText("Materno");

        jLabel5.setText("Especialida");

        btnguardar.setBackground(new java.awt.Color(0, 205, 90));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        tnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnombreActionPerformed(evt);
            }
        });
        tnombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tnombreKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tnombreKeyReleased(evt);
            }
        });

        tpaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tpaternoActionPerformed(evt);
            }
        });
        tpaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tpaternoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tpaternoKeyReleased(evt);
            }
        });

        tmaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmaternoActionPerformed(evt);
            }
        });
        tmaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tmaternoKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tmaternoKeyReleased(evt);
            }
        });

        tespecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tespecialidadKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tespecialidadKeyReleased(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(173, 216, 230));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 95, 94));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        bmodficar.setBackground(new java.awt.Color(255, 190, 79));
        bmodficar.setText("Modificar");
        bmodficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodficarActionPerformed(evt);
            }
        });

        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        cbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbuscarKeyReleased(evt);
            }
        });

        jLabel8.setText("Buscar:");

        lnombre.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lnombre.setForeground(new java.awt.Color(255, 0, 0));

        lpaterno.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lpaterno.setForeground(new java.awt.Color(255, 0, 0));

        lmaterno.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lmaterno.setForeground(new java.awt.Color(255, 0, 0));

        lespecialidad.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lespecialidad.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Home)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(cbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnguardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bmodficar)
                                .addGap(18, 18, 18)
                                .addComponent(btneliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnlimpiar))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tespecialidad)
                                    .addComponent(tmaterno)
                                    .addComponent(tpaterno)
                                    .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lnombre)
                                    .addComponent(lpaterno)
                                    .addComponent(lmaterno)
                                    .addComponent(lespecialidad))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(Home)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lnombre))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tpaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lpaterno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tmaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(lmaterno))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tespecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(lespecialidad))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnguardar)
                            .addComponent(bmodficar)
                            .addComponent(btneliminar)
                            .addComponent(btnlimpiar))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
        consultar("");
    }//GEN-LAST:event_btnguardarActionPerformed

    private void tnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnombreActionPerformed

    private void tpaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpaternoActionPerformed

    private void tmaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tmaternoActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
       this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tidActionPerformed

    private void cbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbuscarKeyReleased
        consultar(cbuscar.getText());
    }//GEN-LAST:event_cbuscarKeyReleased

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        if (evt.getClickCount()==1){
            JTable receptor= (JTable)evt.getSource();
            tid.setText( receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            tnombre.setText( receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            tpaterno.setText( receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            tmaterno.setText( receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            tespecialidad.setText( receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());

        }
    }//GEN-LAST:event_TablaMouseClicked

    private void bmodficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodficarActionPerformed
        Modificar();
        consultar("");
    }//GEN-LAST:event_bmodficarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
        validar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        Eliminar();
        consultar("");
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnombreKeyReleased
        validar();
    }//GEN-LAST:event_tnombreKeyReleased

    private void tpaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaternoKeyReleased
        validar();
    }//GEN-LAST:event_tpaternoKeyReleased

    private void tmaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmaternoKeyReleased
        validar();
    }//GEN-LAST:event_tmaternoKeyReleased

    private void tespecialidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tespecialidadKeyReleased
        validar();
    }//GEN-LAST:event_tespecialidadKeyReleased

    private void tnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnombreKeyTyped
        Character c = evt.getKeyChar();
        
        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE){
        evt.consume();
        }
    }//GEN-LAST:event_tnombreKeyTyped

    private void tpaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaternoKeyTyped
        Character c = evt.getKeyChar();
        
        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE){
        evt.consume();
        }
    }//GEN-LAST:event_tpaternoKeyTyped

    private void tmaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmaternoKeyTyped
        Character c = evt.getKeyChar();
        
        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE){
        evt.consume();
        }
    }//GEN-LAST:event_tmaternoKeyTyped

    private void tespecialidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tespecialidadKeyTyped
        Character c = evt.getKeyChar();
        
        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE){
        evt.consume();
        }
    }//GEN-LAST:event_tespecialidadKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Profesores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Profesores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Home;
    private javax.swing.JTable Tabla;
    private javax.swing.JButton bmodficar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JTextField cbuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lespecialidad;
    private javax.swing.JLabel lmaterno;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel lpaterno;
    private javax.swing.JTextField tespecialidad;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tmaterno;
    private javax.swing.JTextField tnombre;
    private javax.swing.JTextField tpaterno;
    // End of variables declaration//GEN-END:variables
}
