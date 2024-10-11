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
public class Alumnos extends javax.swing.JFrame {

    Conexion con = new Conexion();
    Connection conet;

    /**
     * Creates new form Alumnos
     */
    public Alumnos() {
        initComponents();
        consultar("");
        validar();
        setLocationRelativeTo(null);
        tid.setEnabled(false);
        btnguardar.setEnabled(false);
        bmodficar.setEnabled(false);
        btneliminar.setEnabled(false);

    }

    void consultar(String tid) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] alumnos = new String[6];
        String[] Titulos = {"Id", "Nombre", "Paterno", "Materno", "Correo", "Edad"};
        modelo.setColumnIdentifiers(Titulos);
        Tabla.setModel(modelo);

        String sql = "";

        try {

            if (tid.equals("")) {
                sql = "SELECT * FROM Alumnos_Samuel";
            } else {
                sql = "SELECT * FROM Alumnos_Samuel WHERE id like'%" + tid + "%' or nombre like'%" + tid + "%'";
            }
            conet = con.getConeccetion();
            Statement st = conet.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                alumnos[0] = rs.getString("id");
                alumnos[1] = rs.getString("nombre");
                alumnos[2] = rs.getString("ap1");
                alumnos[3] = rs.getString("ap2");
                alumnos[4] = rs.getString("email");
                alumnos[5] = rs.getString("edad");

                modelo.addRow(alumnos);
            }
            Tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Consulta No Realizada     " + e.getLocalizedMessage());
        }
    }

    public void guardar() {
        try {
            String insertar = "INSERT INTO Alumnos_Samuel (nombre,ap1,ap2,email,edad) values (?,?,?,?,?)";
            PreparedStatement guardar = conet.prepareStatement(insertar);
            guardar.setString(1, tnombre.getText());
            guardar.setString(2, tpaterno.getText());
            guardar.setString(3, tmaterno.getText());
            guardar.setString(4, tcorreo.getText());
            guardar.setString(5, tedad.getText());
            guardar.execute();
            JOptionPane.showMessageDialog(null, "guardado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "no se guardo" + e.getMessage());
        }
    }

    public void Eliminar() {

        String consulta = "DELETE FROM Alumnos_Samuel WHERE Alumnos_Samuel.id=?;";

        try {
            PreparedStatement Eliminar = conet.prepareStatement(consulta);
            Eliminar.setString(1, tid.getText());
            Eliminar.execute();

            JOptionPane.showMessageDialog(null, "Se Eliminó ");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No Se Pudo Eliminar, ERROR:  " + e.toString());
        }

    }

    public void Modificar() {

        String consulta = "UPDATE Alumnos_Samuel SET  Alumnos_Samuel.nombre = ?, Alumnos_Samuel.ap1 = ?, Alumnos_Samuel.ap2 = ?, Alumnos_Samuel.email =?, Alumnos_Samuel.edad =? WHERE Alumnos_Samuel.id=?;";

        try {
            PreparedStatement modificar = conet.prepareStatement(consulta);

            modificar.setString(1, tnombre.getText());
            modificar.setString(2, tpaterno.getText());
            modificar.setString(3, tmaterno.getText());
            modificar.setString(4, tcorreo.getText());
            modificar.setString(5, tedad.getText());
            modificar.setString(6, tid.getText());
            modificar.execute();

            JOptionPane.showMessageDialog(null, "Se Actualizo");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "No Se Pudo Modificar, ERROR:  " + e.toString());
        }

    }

    public void limpiar() {
        tid.setText("");
        tnombre.setText("");
        tpaterno.setText("");
        tmaterno.setText("");
        tcorreo.setText("");
        tedad.setText("");
    }

    public void validar() {

        if (tnombre.getText().isEmpty()) {
            lnombre.setText("CAMPO REQUERIDO");
        } else {
            lnombre.setText("");
        }

        if (tpaterno.getText().isEmpty()) {
            lpaterno.setText("CAMPO REQUERIDO");
        } else {
            lpaterno.setText("");
        }

        if (tmaterno.getText().isEmpty()) {
            lmaterno.setText("CAMPO REQUERIDO");
        } else {
            lmaterno.setText("");
        }
        if (tcorreo.getText().isEmpty()) {
            lcorreo.setText("CAMPO REQUERIDO");
        } else if (!tcorreo.getText().contains("@") || !tcorreo.getText().contains(".")) {
            lcorreo.setText("*Correo Invalido");
        } else {
            lcorreo.setText("");
        }
        if (tedad.getText().isEmpty()) {
            ledad.setText("CAMPO REQUERIDO");
        } else {
            ledad.setText("");
        }

        if (tnombre.getText().isEmpty() || tpaterno.getText().isEmpty()
                || tmaterno.getText().isEmpty() || tcorreo.getText().isEmpty() || tedad.getText().isEmpty()) {

            btnguardar.setEnabled(false);
            bmodficar.setEnabled(false);
            btneliminar.setEnabled(false);
        } else {
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
        tnombre = new javax.swing.JTextField();
        tpaterno = new javax.swing.JTextField();
        tmaterno = new javax.swing.JTextField();
        tcorreo = new javax.swing.JTextField();
        tedad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        tid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        bmodficar = new javax.swing.JButton();
        cbuscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        lnombre = new javax.swing.JLabel();
        lpaterno = new javax.swing.JLabel();
        lmaterno = new javax.swing.JLabel();
        lcorreo = new javax.swing.JLabel();
        ledad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(700, 300));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/seminariosagv/Inconos/estudiante.png"))); // NOI18N
        jLabel1.setText("Alumnos");

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno", "Correo", "Edad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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

        tcorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tcorreoKeyReleased(evt);
            }
        });

        tedad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tedadKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tedadKeyReleased(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Paterno");

        jLabel4.setText("Materno");

        jLabel5.setText("Correo");

        jLabel6.setText("Edad");

        btnguardar.setBackground(new java.awt.Color(0, 205, 90));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 95, 94));
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        tid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        bmodficar.setBackground(new java.awt.Color(255, 190, 79));
        bmodficar.setText("Modificar");
        bmodficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bmodficarActionPerformed(evt);
            }
        });

        cbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbuscarKeyReleased(evt);
            }
        });

        jLabel8.setText("Buscar:");

        btnlimpiar.setBackground(new java.awt.Color(173, 216, 230));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        lnombre.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lnombre.setForeground(new java.awt.Color(255, 0, 0));

        lpaterno.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lpaterno.setForeground(new java.awt.Color(255, 0, 0));

        lmaterno.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lmaterno.setForeground(new java.awt.Color(255, 0, 0));

        lcorreo.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        lcorreo.setForeground(new java.awt.Color(255, 0, 0));

        ledad.setFont(new java.awt.Font("Lucida Grande", 3, 15)); // NOI18N
        ledad.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnguardar)
                        .addGap(18, 18, 18)
                        .addComponent(bmodficar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnlimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Home)
                                .addGap(37, 37, 37)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(cbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(tedad, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                        .addComponent(tmaterno)
                                        .addComponent(tpaterno))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(117, 117, 117)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lpaterno)
                                            .addComponent(lmaterno)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ledad)
                                        .addGap(5, 5, 5))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lnombre))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(tcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lcorreo)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(Home))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(lnombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(tcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(lcorreo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ledad))
                            .addComponent(jLabel6))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnguardar)
                    .addComponent(bmodficar)
                    .addComponent(btneliminar)
                    .addComponent(btnlimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tnombreActionPerformed

    private void tpaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tpaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tpaternoActionPerformed

    private void tmaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tmaternoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        guardar();
        consultar("");
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        Eliminar();
        consultar("");
    }//GEN-LAST:event_btneliminarActionPerformed

    private void bmodficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bmodficarActionPerformed
        Modificar();
        consultar("");
    }//GEN-LAST:event_bmodficarActionPerformed

    private void cbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbuscarKeyReleased
        consultar(cbuscar.getText());
    }//GEN-LAST:event_cbuscarKeyReleased

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        if (evt.getClickCount() == 1) {
            JTable receptor = (JTable) evt.getSource();
            tid.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 0).toString());
            tnombre.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 1).toString());
            tpaterno.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 2).toString());
            tmaterno.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 3).toString());
            tcorreo.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 4).toString());
            tedad.setText(receptor.getModel().getValueAt(receptor.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_TablaMouseClicked

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiar();
        validar();
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void tidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_tidActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void tnombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnombreKeyReleased
        validar();
    }//GEN-LAST:event_tnombreKeyReleased

    private void tpaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaternoKeyReleased
        validar();
    }//GEN-LAST:event_tpaternoKeyReleased

    private void tmaternoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmaternoKeyReleased
        validar();
    }//GEN-LAST:event_tmaternoKeyReleased

    private void tcorreoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tcorreoKeyReleased
        validar();
    }//GEN-LAST:event_tcorreoKeyReleased

    private void tedadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tedadKeyReleased
        validar();
    }//GEN-LAST:event_tedadKeyReleased

    private void tnombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tnombreKeyTyped
        Character c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_tnombreKeyTyped

    private void tpaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tpaternoKeyTyped
        Character c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_tpaternoKeyTyped

    private void tmaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tmaternoKeyTyped
        Character c = evt.getKeyChar();

        if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
            evt.consume();
        }
    }//GEN-LAST:event_tmaternoKeyTyped

    private void tedadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tedadKeyTyped
        char c = evt.getKeyChar();

        if ((c < '0' || c > '9')) {
            evt.consume();
        }
    }//GEN-LAST:event_tedadKeyTyped

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
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alumnos().setVisible(true);
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lcorreo;
    private javax.swing.JLabel ledad;
    private javax.swing.JLabel lmaterno;
    private javax.swing.JLabel lnombre;
    private javax.swing.JLabel lpaterno;
    private javax.swing.JTextField tcorreo;
    private javax.swing.JTextField tedad;
    private javax.swing.JTextField tid;
    private javax.swing.JTextField tmaterno;
    private javax.swing.JTextField tnombre;
    private javax.swing.JTextField tpaterno;
    // End of variables declaration//GEN-END:variables
}
//3 Preguntas sobre para que sirve tu codigo
