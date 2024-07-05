package views;

import controllers.Controlador;
import helpers.EstiloFilas;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author yh9pl
 */
public class JDProyecto extends javax.swing.JDialog {

    /**
     * Creates new form JDProyecto
     */
    public JDProyecto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // Aplicar estilo de filas tipo Excel a la tabla
        this.jtDatosBinarios.setDefaultRenderer(Object.class, new EstiloFilas());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        txtItems = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtInstancias = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnLimpiarItems = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlItems = new javax.swing.JList<>();
        txtNombreItem = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnCrearTabla = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtDatosBinarios = new javax.swing.JTable();
        btnExcel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cmbItem1 = new javax.swing.JComboBox<>();
        cmbItem2 = new javax.swing.JComboBox<>();
        lblSeleccion = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtContingencia = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cf1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl21 = new javax.swing.JLabel();
        cb1 = new javax.swing.JLabel();
        lbl12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl22 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cb2 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        cf2 = new javax.swing.JLabel();
        cf3 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cb3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl23 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbl13 = new javax.swing.JLabel();
        cf4 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cb4 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        lbl24 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        lbl14 = new javax.swing.JLabel();
        cf5 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        cb5 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lbl15 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        lbl25 = new javax.swing.JLabel();
        lbl26 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lbl16 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        cb6 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cf6 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        lbl27 = new javax.swing.JLabel();
        cb7 = new javax.swing.JLabel();
        cf7 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        lbl17 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        cb8 = new javax.swing.JLabel();
        cf8 = new javax.swing.JLabel();
        lbl18 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        lbl28 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtDependencia = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblComprar = new javax.swing.JLabel();
        lblNoComprar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        background.setBackground(new java.awt.Color(255, 255, 255));
        background.setFocusable(false);
        background.setLayout(null);

        txtItems.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtItems.setForeground(new java.awt.Color(153, 153, 153));
        txtItems.setText("0");
        txtItems.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtItemsKeyTyped(evt);
            }
        });
        background.add(txtItems);
        txtItems.setBounds(20, 70, 70, 30);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Items");
        background.add(jLabel1);
        jLabel1.setBounds(20, 40, 80, 20);

        txtInstancias.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtInstancias.setForeground(new java.awt.Color(153, 153, 153));
        txtInstancias.setText("0");
        txtInstancias.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInstanciasKeyTyped(evt);
            }
        });
        background.add(txtInstancias);
        txtInstancias.setBounds(100, 70, 70, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("DEPENDENCIA");
        background.add(jLabel2);
        jLabel2.setBounds(850, 40, 180, 20);

        btnLimpiarItems.setText("Limpiar Datos");
        background.add(btnLimpiarItems);
        btnLimpiarItems.setBounds(20, 240, 150, 30);

        jlItems.setFocusable(false);
        jScrollPane1.setViewportView(jlItems);

        background.add(jScrollPane1);
        jScrollPane1.setBounds(20, 160, 150, 70);

        txtNombreItem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNombreItem.setForeground(new java.awt.Color(153, 153, 153));
        txtNombreItem.setText("Nombre Item");
        txtNombreItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreItemKeyPressed(evt);
            }
        });
        background.add(txtNombreItem);
        txtNombreItem.setBounds(20, 120, 110, 30);

        btnAgregar.setText("+");
        background.add(btnAgregar);
        btnAgregar.setBounds(140, 120, 30, 30);

        btnCrearTabla.setBackground(new java.awt.Color(102, 102, 255));
        btnCrearTabla.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCrearTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearTabla.setText("Crear tabla binaria");
        btnCrearTabla.setEnabled(false);
        background.add(btnCrearTabla);
        btnCrearTabla.setBounds(20, 280, 150, 30);

        jtDatosBinarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDatosBinarios.setFocusable(false);
        jtDatosBinarios.setShowVerticalLines(true);
        jtDatosBinarios.getTableHeader().setResizingAllowed(false);
        jtDatosBinarios.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jtDatosBinarios);

        background.add(jScrollPane2);
        jScrollPane2.setBounds(180, 70, 360, 240);

        btnExcel.setBackground(new java.awt.Color(33, 163, 102));
        btnExcel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExcel.setText("Cargar tabla Excel");
        background.add(btnExcel);
        btnExcel.setBounds(20, 320, 150, 30);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Instancias");
        background.add(jLabel3);
        jLabel3.setBounds(100, 40, 80, 20);

        cmbItem1.setEnabled(false);
        background.add(cmbItem1);
        cmbItem1.setBounds(330, 320, 100, 30);

        cmbItem2.setEnabled(false);
        background.add(cmbItem2);
        cmbItem2.setBounds(440, 320, 100, 30);

        lblSeleccion.setText("Seleccionar Items:");
        lblSeleccion.setEnabled(false);
        background.add(lblSeleccion);
        lblSeleccion.setBounds(220, 325, 100, 16);

        jtContingencia.setBackground(new java.awt.Color(204, 204, 255));
        jtContingencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtContingencia.setFocusable(false);
        jtContingencia.setGridColor(new java.awt.Color(255, 255, 255));
        jtContingencia.setRowSelectionAllowed(false);
        jtContingencia.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jtContingencia.setShowHorizontalLines(true);
        jtContingencia.setShowVerticalLines(true);
        jtContingencia.getTableHeader().setResizingAllowed(false);
        jtContingencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jtContingencia);

        background.add(jScrollPane3);
        jScrollPane3.setBounds(560, 70, 240, 110);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("TABLA BINARIA");
        background.add(jLabel4);
        jLabel4.setBounds(180, 40, 110, 20);

        jLabel5.setText("=1");
        background.add(jLabel5);
        jLabel5.setBounds(610, 190, 40, 16);

        jLabel6.setText("cf");
        background.add(jLabel6);
        jLabel6.setBounds(790, 190, 20, 16);

        cf1.setText("0%");
        background.add(cf1);
        cf1.setBounds(807, 190, 40, 16);

        jLabel8.setText("cb");
        background.add(jLabel8);
        jLabel8.setBounds(730, 190, 20, 16);

        lbl11.setText("item1");
        background.add(lbl11);
        lbl11.setBounds(560, 190, 40, 16);

        jLabel10.setText("=1");
        background.add(jLabel10);
        jLabel10.setBounds(690, 190, 40, 16);

        lbl21.setText("item2");
        background.add(lbl21);
        lbl21.setBounds(640, 190, 40, 16);

        cb1.setText("0%");
        background.add(cb1);
        cb1.setBounds(750, 190, 40, 16);

        lbl12.setText("item1");
        background.add(lbl12);
        lbl12.setBounds(560, 210, 40, 16);

        jLabel14.setText("=1");
        background.add(jLabel14);
        jLabel14.setBounds(610, 210, 40, 16);

        lbl22.setText("item2");
        background.add(lbl22);
        lbl22.setBounds(640, 210, 40, 16);

        jLabel16.setText("=0");
        background.add(jLabel16);
        jLabel16.setBounds(690, 210, 40, 16);

        jLabel17.setText("cb");
        background.add(jLabel17);
        jLabel17.setBounds(730, 210, 20, 16);

        cb2.setText("0%");
        background.add(cb2);
        cb2.setBounds(750, 210, 40, 16);

        jLabel19.setText("cf");
        background.add(jLabel19);
        jLabel19.setBounds(790, 210, 20, 16);

        cf2.setText("0%");
        background.add(cf2);
        cf2.setBounds(807, 210, 40, 16);

        cf3.setText("0%");
        background.add(cf3);
        cf3.setBounds(807, 230, 40, 16);

        jLabel22.setText("cf");
        background.add(jLabel22);
        jLabel22.setBounds(790, 230, 20, 16);

        cb3.setText("0%");
        background.add(cb3);
        cb3.setBounds(750, 230, 40, 16);

        jLabel24.setText("cb");
        background.add(jLabel24);
        jLabel24.setBounds(730, 230, 20, 16);

        jLabel25.setText("=1");
        background.add(jLabel25);
        jLabel25.setBounds(690, 230, 40, 16);

        lbl23.setText("item2");
        background.add(lbl23);
        lbl23.setBounds(640, 230, 40, 16);

        jLabel27.setText("=0");
        background.add(jLabel27);
        jLabel27.setBounds(610, 230, 40, 16);

        lbl13.setText("item1");
        background.add(lbl13);
        lbl13.setBounds(560, 230, 40, 16);

        cf4.setText("0%");
        background.add(cf4);
        cf4.setBounds(807, 250, 40, 16);

        jLabel30.setText("cf");
        background.add(jLabel30);
        jLabel30.setBounds(790, 250, 20, 16);

        cb4.setText("0%");
        background.add(cb4);
        cb4.setBounds(750, 250, 40, 16);

        jLabel32.setText("cb");
        background.add(jLabel32);
        jLabel32.setBounds(730, 250, 20, 16);

        jLabel33.setText("=0");
        background.add(jLabel33);
        jLabel33.setBounds(690, 250, 40, 16);

        lbl24.setText("item2");
        background.add(lbl24);
        lbl24.setBounds(640, 250, 40, 16);

        jLabel35.setText("=0");
        background.add(jLabel35);
        jLabel35.setBounds(610, 250, 40, 16);

        lbl14.setText("item1");
        background.add(lbl14);
        lbl14.setBounds(560, 250, 40, 16);

        cf5.setText("0%");
        background.add(cf5);
        cf5.setBounds(807, 275, 40, 16);

        jLabel38.setText("cf");
        background.add(jLabel38);
        jLabel38.setBounds(790, 275, 20, 16);

        cb5.setText("0%");
        background.add(cb5);
        cb5.setBounds(750, 275, 40, 16);

        jLabel40.setText("cb");
        background.add(jLabel40);
        jLabel40.setBounds(730, 275, 20, 16);

        jLabel41.setText("=1");
        background.add(jLabel41);
        jLabel41.setBounds(690, 275, 40, 16);

        lbl15.setText("item1");
        background.add(lbl15);
        lbl15.setBounds(640, 275, 40, 16);

        jLabel43.setText("=1");
        background.add(jLabel43);
        jLabel43.setBounds(610, 275, 40, 16);

        lbl25.setText("item2");
        background.add(lbl25);
        lbl25.setBounds(560, 275, 40, 16);

        lbl26.setText("item2");
        background.add(lbl26);
        lbl26.setBounds(560, 295, 40, 16);

        jLabel46.setText("=1");
        background.add(jLabel46);
        jLabel46.setBounds(610, 295, 40, 16);

        lbl16.setText("item1");
        background.add(lbl16);
        lbl16.setBounds(640, 295, 40, 16);

        jLabel48.setText("=0");
        background.add(jLabel48);
        jLabel48.setBounds(690, 295, 40, 16);

        jLabel49.setText("cb");
        background.add(jLabel49);
        jLabel49.setBounds(730, 295, 20, 16);

        cb6.setText("0%");
        background.add(cb6);
        cb6.setBounds(750, 295, 40, 16);

        jLabel51.setText("cf");
        background.add(jLabel51);
        jLabel51.setBounds(790, 295, 20, 16);

        cf6.setText("0%");
        background.add(cf6);
        cf6.setBounds(807, 295, 40, 16);

        jLabel53.setText("cb");
        background.add(jLabel53);
        jLabel53.setBounds(730, 315, 20, 16);

        lbl27.setText("item2");
        background.add(lbl27);
        lbl27.setBounds(560, 315, 40, 16);

        cb7.setText("0%");
        background.add(cb7);
        cb7.setBounds(750, 315, 40, 16);

        cf7.setText("0%");
        background.add(cf7);
        cf7.setBounds(807, 315, 40, 16);

        jLabel57.setText("=1");
        background.add(jLabel57);
        jLabel57.setBounds(690, 315, 40, 16);

        lbl17.setText("item1");
        background.add(lbl17);
        lbl17.setBounds(640, 315, 40, 16);

        jLabel59.setText("=0");
        background.add(jLabel59);
        jLabel59.setBounds(610, 315, 40, 16);

        jLabel60.setText("cf");
        background.add(jLabel60);
        jLabel60.setBounds(790, 315, 20, 16);

        jLabel61.setText("cf");
        background.add(jLabel61);
        jLabel61.setBounds(790, 335, 20, 16);

        cb8.setText("0%");
        background.add(cb8);
        cb8.setBounds(750, 335, 40, 16);

        cf8.setText("0%");
        background.add(cf8);
        cf8.setBounds(807, 335, 40, 16);

        lbl18.setText("item1");
        background.add(lbl18);
        lbl18.setBounds(640, 335, 40, 16);

        jLabel65.setText("=0");
        background.add(jLabel65);
        jLabel65.setBounds(610, 335, 40, 16);

        lbl28.setText("item2");
        background.add(lbl28);
        lbl28.setBounds(560, 335, 40, 16);

        jLabel67.setText("=0");
        background.add(jLabel67);
        jLabel67.setBounds(690, 335, 40, 16);

        jLabel68.setText("cb");
        background.add(jLabel68);
        jLabel68.setBounds(730, 335, 20, 16);

        jtDependencia.setBackground(new java.awt.Color(204, 204, 255));
        jtDependencia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtDependencia.setFocusable(false);
        jtDependencia.setGridColor(new java.awt.Color(255, 255, 255));
        jtDependencia.setRowSelectionAllowed(false);
        jtDependencia.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jtDependencia.setShowHorizontalLines(true);
        jtDependencia.setShowVerticalLines(true);
        jtDependencia.getTableHeader().setResizingAllowed(false);
        jtDependencia.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jtDependencia);

        background.add(jScrollPane4);
        jScrollPane4.setBounds(850, 70, 190, 110);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("TABLA DE CONTINGENCIA");
        background.add(jLabel7);
        jLabel7.setBounds(560, 40, 180, 20);

        lblComprar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        background.add(lblComprar);
        lblComprar.setBounds(850, 190, 250, 16);

        lblNoComprar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        background.add(lblNoComprar);
        lblNoComprar.setBounds(850, 210, 250, 16);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void txtItemsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtItemsKeyTyped
        char c = evt.getKeyChar();
        if (!(c >= '2' && c <= '8')) {
            evt.consume(); // Consume el evento para evitar que se procese
        }
        // Verifica que el campo tenga solo un carácter
        if (this.txtItems.getText().length() >= 1) {
            evt.consume(); // Consume el evento si ya hay un carácter
        }
    }//GEN-LAST:event_txtItemsKeyTyped

    private void txtInstanciasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstanciasKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)) {
            evt.consume();
        }
        if(this.txtInstancias.getText().indexOf('0') == 0) {
            evt.consume();
        }
    }//GEN-LAST:event_txtInstanciasKeyTyped

    private void txtNombreItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreItemKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if((this.txtItems.getText().equals("0") || this.txtItems.getText().equals("")) ||
               (this.txtInstancias.getText().equals("0") || this.txtInstancias.getText().equals(""))) {
                JOptionPane.showMessageDialog(this, "Debes ingresar valores validos de items e instancias.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(this.txtNombreItem.getText().equals("") || this.txtNombreItem.getText().equals("Nombre Item")) {
                JOptionPane.showMessageDialog(this, "Debes ingresar un nombre de item.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(this.jlItems.getModel().getSize() < Integer.parseInt(this.txtItems.getText())) {
                Controlador.listModel.addElement(this.txtNombreItem.getText());
                this.jlItems.setModel(Controlador.listModel);
                this.txtNombreItem.setText("");
                this.txtNombreItem.requestFocus();
                if(this.jlItems.getModel().getSize() == Integer.parseInt(this.txtItems.getText())) {
                    this.btnCrearTabla.setEnabled(true);
                    this.btnCrearTabla.requestFocus();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Aumenta el número de items para agregar más.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_txtNombreItemKeyPressed

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
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDProyecto dialog = new JDProyecto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel background;
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCrearTabla;
    public javax.swing.JButton btnExcel;
    public javax.swing.JButton btnLimpiarItems;
    public javax.swing.JLabel cb1;
    public javax.swing.JLabel cb2;
    public javax.swing.JLabel cb3;
    public javax.swing.JLabel cb4;
    public javax.swing.JLabel cb5;
    public javax.swing.JLabel cb6;
    public javax.swing.JLabel cb7;
    public javax.swing.JLabel cb8;
    public javax.swing.JLabel cf1;
    public javax.swing.JLabel cf2;
    public javax.swing.JLabel cf3;
    public javax.swing.JLabel cf4;
    public javax.swing.JLabel cf5;
    public javax.swing.JLabel cf6;
    public javax.swing.JLabel cf7;
    public javax.swing.JLabel cf8;
    public javax.swing.JComboBox<String> cmbItem1;
    public javax.swing.JComboBox<String> cmbItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JList<String> jlItems;
    public javax.swing.JTable jtContingencia;
    public javax.swing.JTable jtDatosBinarios;
    public javax.swing.JTable jtDependencia;
    public javax.swing.JLabel lbl11;
    public javax.swing.JLabel lbl12;
    public javax.swing.JLabel lbl13;
    public javax.swing.JLabel lbl14;
    public javax.swing.JLabel lbl15;
    public javax.swing.JLabel lbl16;
    public javax.swing.JLabel lbl17;
    public javax.swing.JLabel lbl18;
    public javax.swing.JLabel lbl21;
    public javax.swing.JLabel lbl22;
    public javax.swing.JLabel lbl23;
    public javax.swing.JLabel lbl24;
    public javax.swing.JLabel lbl25;
    public javax.swing.JLabel lbl26;
    public javax.swing.JLabel lbl27;
    public javax.swing.JLabel lbl28;
    public javax.swing.JLabel lblComprar;
    public javax.swing.JLabel lblNoComprar;
    public javax.swing.JLabel lblSeleccion;
    public javax.swing.JTextField txtInstancias;
    public javax.swing.JTextField txtItems;
    public javax.swing.JTextField txtNombreItem;
    // End of variables declaration//GEN-END:variables
}
