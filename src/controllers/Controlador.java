package controllers;

import helpers.Excel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import views.JDProyecto;

/**
 *
 * @author yh9pl
 */
public class Controlador implements MouseListener, FocusListener, ActionListener {
    private JDProyecto formulario;
    public static DefaultListModel<String> listModel;
    
    public Controlador(JDProyecto formulario) {
        this.formulario = formulario;
        Controlador.listModel = new DefaultListModel<>();
        
        // Listeners
        this.formulario.txtItems.addFocusListener(this);
        this.formulario.txtInstancias.addFocusListener(this);
        this.formulario.txtNombreItem.addFocusListener(this);
        this.formulario.background.addMouseListener(this);
        this.formulario.btnLimpiarItems.addMouseListener(this);
        this.formulario.btnLimpiarItems.addActionListener(this);
        this.formulario.btnAgregar.addMouseListener(this);
        this.formulario.btnAgregar.addActionListener(this);
        this.formulario.btnCrearTabla.addMouseListener(this);
        this.formulario.btnCrearTabla.addActionListener(this);
        this.formulario.btnExcel.addMouseListener(this);
        this.formulario.btnExcel.addActionListener(this);
        this.formulario.cmbItem1.addActionListener(this);
        this.formulario.cmbItem2.addActionListener(this);
    }
    
    // Iniciar el formulario
    public void iniciarVista() {
        this.formulario.setTitle("Reglas Asociación");
        this.formulario.setSize(836, 600);
        this.formulario.setLocationRelativeTo(null);
        this.formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.formulario.show();
    }
    
    private void limpiar() {
        Controlador.listModel.clear();
        this.formulario.txtNombreItem.setForeground(new Color(0x999999));
        this.formulario.txtNombreItem.setBackground(new Color(0xFFFFFF));
        this.formulario.txtNombreItem.setText("Nombre Item");
        this.formulario.jlItems.setModel(new DefaultListModel<>());
        this.formulario.btnCrearTabla.setEnabled(false);
        this.formulario.lblSeleccion.setEnabled(false);
        this.formulario.cmbItem1.setEnabled(false);
        this.formulario.cmbItem1.setModel(new DefaultComboBoxModel<>());
        this.formulario.cmbItem2.setEnabled(false);
        this.formulario.cmbItem2.setModel(new DefaultComboBoxModel<>());
        this.formulario.jtDatosBinarios.setModel(new DefaultTableModel());
        this.formulario.jtContingencia.setModel(new DefaultTableModel());
        this.formulario.txtNombreItem.requestFocus();
    }
    
    private void calcularContingencia(String item1, String item2) {
        int indiceItem1 = -1;
        int indiceItem2 = -1;

        // Buscar los índices de los ítems seleccionados
        for (int i = 0; i < this.formulario.jtDatosBinarios.getColumnCount(); i++) {
            if (this.formulario.jtDatosBinarios.getColumnName(i).equals(item1)) {
                indiceItem1 = i;
            } 
            if (this.formulario.jtDatosBinarios.getColumnName(i).equals(item2)) {
                indiceItem2 = i;
            }
        }

        if (indiceItem1 == -1 || indiceItem2 == -1) {
            JOptionPane.showMessageDialog(this.formulario, "Ítems no encontrados.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Inicializar las frecuencias
        int[][] frecuencias = new int[3][3];

        for (int i = 0; i < this.formulario.jtDatosBinarios.getRowCount(); i++) {
            int valorItem1 = Integer.parseInt((String) this.formulario.jtDatosBinarios.getValueAt(i, indiceItem1));
            int valorItem2 = Integer.parseInt((String) this.formulario.jtDatosBinarios.getValueAt(i, indiceItem2));

            if (valorItem1 == 1 && valorItem2 == 1) {
                frecuencias[0][0]++;
            } else if (valorItem1 == 1 && valorItem2 == 0) {
                frecuencias[0][1]++;
            } else if (valorItem1 == 0 && valorItem2 == 1) {
                frecuencias[1][0]++;
            } else if (valorItem1 == 0 && valorItem2 == 0) {
                frecuencias[1][1]++;
            }
        }

        // Calcular los totales
        frecuencias[0][2] = frecuencias[0][0] + frecuencias[0][1];
        frecuencias[1][2] = frecuencias[1][0] + frecuencias[1][1];
        frecuencias[2][0] = frecuencias[0][0] + frecuencias[1][0];
        frecuencias[2][1] = frecuencias[0][1] + frecuencias[1][1];
        frecuencias[2][2] = frecuencias[0][2] + frecuencias[1][2];

        // Crear el TableModel para la tabla de contingencia
        String[] nombresColumnas = new String[] {"", "", "", ""};
        String[][] datosContingencia = new String[4][4];

        datosContingencia[0][0] = "";
        datosContingencia[0][1] = item2;
        datosContingencia[0][2] = "~ " + item2;
        datosContingencia[0][3] = "Total";

        datosContingencia[1][0] = item1;
        datosContingencia[2][0] = "~ " + item1;
        datosContingencia[3][0] = "Total";

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 3; j++) {
                datosContingencia[i][j] = String.valueOf(frecuencias[i-1][j-1]);
            }
        }

        datosContingencia[3][1] = String.valueOf(frecuencias[2][0]);
        datosContingencia[3][2] = String.valueOf(frecuencias[2][1]);
        datosContingencia[3][3] = String.valueOf(frecuencias[2][2]);

        DefaultTableModel modelContingencia = new DefaultTableModel(datosContingencia, nombresColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas no sean editables
            }
        };

        this.formulario.jtContingencia.setModel(modelContingencia);
        this.formulario.jtContingencia.getTableHeader().repaint();
        this.formulario.jtContingencia.revalidate();
        this.formulario.jtContingencia.repaint();
    }
    
    private void cargarContingencia() {
        String item1 = "", item2 = "";
        try
        {
            item1 = this.formulario.cmbItem1.getSelectedItem().toString();
            item2 = this.formulario.cmbItem2.getSelectedItem().toString();
            this.calcularContingencia(item1, item2);
        } catch(Exception err) { }
    }
    
    // Manejar evento del focus entrante
    @Override
    public void focusGained(FocusEvent e) {
        if(e.getSource() == this.formulario.txtItems) {
            this.formulario.txtItems.setForeground(new Color(0x353535));
            this.formulario.txtItems.setBackground(new Color(0xF9F4E0));
            if(this.formulario.txtItems.getText().equals("0")) {
                this.formulario.txtItems.setText("");
            }
        }
        if(e.getSource() == this.formulario.txtInstancias) {
            this.formulario.txtInstancias.setForeground(new Color(0x353535));
            this.formulario.txtInstancias.setBackground(new Color(0xF9F4E0));
            if(this.formulario.txtInstancias.getText().equals("0")) {
                this.formulario.txtInstancias.setText("");
            }
        }
        if(e.getSource() == this.formulario.txtNombreItem) {
            this.formulario.txtNombreItem.setForeground(new Color(0x353535));
            this.formulario.txtNombreItem.setBackground(new Color(0xF9F4E0));
            if(this.formulario.txtNombreItem.getText().equals("Nombre Item")) {
                this.formulario.txtNombreItem.setText("");
            }
        }
    }
    
    // Manejar evento cuando salgamos del foco
    @Override
    public void focusLost(FocusEvent e) {
        if(e.getSource() == this.formulario.txtItems) {
            if(this.formulario.txtItems.getText().equals("") ||
               this.formulario.txtItems.getText().equals("0")) {
                this.formulario.txtItems.setForeground(new Color(0x999999));
                this.formulario.txtItems.setBackground(new Color(0xFFFFFF));
                this.formulario.txtItems.setText("0");
            } else {
                this.formulario.txtItems.setBackground(new Color(0xFBF7E8));
            }
        }
        if(e.getSource() == this.formulario.txtInstancias) {
            if(this.formulario.txtInstancias.getText().equals("") || 
               this.formulario.txtInstancias.getText().equals("0")) {
                this.formulario.txtInstancias.setForeground(new Color(0x999999));
                this.formulario.txtInstancias.setBackground(new Color(0xFFFFFF));
                this.formulario.txtInstancias.setText("0");
            } else {
                this.formulario.txtInstancias.setBackground(new Color(0xFBF7E8));
            }
        }
        if(e.getSource() == this.formulario.txtNombreItem) {
            if(this.formulario.txtNombreItem.getText().equals("")) {
                this.formulario.txtNombreItem.setForeground(new Color(0x999999));
                this.formulario.txtNombreItem.setBackground(new Color(0xFFFFFF));
                this.formulario.txtNombreItem.setText("Nombre Item");
            } else {
                this.formulario.txtNombreItem.setBackground(new Color(0xFBF7E8));
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Restablecer el foco
        if(e.getSource() == this.formulario.background) {
            KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource() == this.formulario.btnLimpiarItems) {
            this.formulario.btnLimpiarItems.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == this.formulario.btnAgregar) {
            this.formulario.btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == this.formulario.btnCrearTabla) {
            this.formulario.btnCrearTabla.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
        if(e.getSource() == this.formulario.btnExcel) {
            this.formulario.btnExcel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.formulario.btnAgregar) {
            if((this.formulario.txtItems.getText().equals("0") || this.formulario.txtItems.getText().equals("")) ||
               (this.formulario.txtInstancias.getText().equals("0") || this.formulario.txtInstancias.getText().equals(""))) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar valores validos de items e instancias.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(this.formulario.txtNombreItem.getText().equals("") || this.formulario.txtNombreItem.getText().equals("Nombre Item")) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar un nombre de item.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(this.formulario.jlItems.getModel().getSize() < Integer.parseInt(this.formulario.txtItems.getText())) {
                Controlador.listModel.addElement(this.formulario.txtNombreItem.getText());
                this.formulario.jlItems.setModel(Controlador.listModel);
                this.formulario.txtNombreItem.setText("");
                this.formulario.txtNombreItem.requestFocus();
                if(this.formulario.jlItems.getModel().getSize() == Integer.parseInt(this.formulario.txtItems.getText())) {
                    this.formulario.btnCrearTabla.setEnabled(true);
                }
            } else {
                JOptionPane.showMessageDialog(this.formulario, "Aumenta el número de items para agregar más.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        if(e.getSource() == this.formulario.btnLimpiarItems) {
            this.limpiar();
            this.formulario.txtNombreItem.requestFocus();
        }
        if(e.getSource() == this.formulario.btnCrearTabla) {
            int numeroItems = Integer.parseInt(this.formulario.txtItems.getText());
            int numeroInstancias = Integer.parseInt(this.formulario.txtInstancias.getText());
            
            if(this.formulario.jlItems.getModel().getSize() < numeroItems) {
                JOptionPane.showMessageDialog(this.formulario, "Faltan items por ingresar.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            
            String[] items = new String[numeroItems];
            String[][] datos = new String[numeroInstancias][numeroItems];
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel<String>();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel<String>();
            
            for(int i = 0; i < numeroItems; i++) {
                items[i] = this.formulario.jlItems.getModel().getElementAt(i);
                modelo1.addElement(this.formulario.jlItems.getModel().getElementAt(i));
                modelo2.addElement(this.formulario.jlItems.getModel().getElementAt(i));
            }
            for(int i = 0; i < numeroInstancias; i++) {
                for(int j = 0; j < numeroItems; j++) {
                   datos[i][j] = String.valueOf((int)(Math.random() * 2));
                }
            }
            
            DefaultTableModel model = new DefaultTableModel(datos, items);
            this.formulario.jtDatosBinarios.setModel(model);
            this.formulario.cmbItem1.setModel(modelo1);
            this.formulario.cmbItem1.setEnabled(true);
            this.formulario.cmbItem1.setSelectedIndex(0);
            this.formulario.cmbItem2.setModel(modelo2);
            this.formulario.cmbItem2.setEnabled(true);
            this.formulario.cmbItem2.setSelectedIndex(1);
            this.formulario.lblSeleccion.setEnabled(true);
            this.cargarContingencia();
            this.formulario.revalidate();
            this.formulario.repaint();
        }
        if(e.getSource() == this.formulario.btnExcel) {
            this.limpiar();
            this.formulario.jtDatosBinarios.setModel(Excel.cargar(this.formulario));
            if(this.formulario.jtDatosBinarios.getModel() == null) {
                return;
            }
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel<String>();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel<String>();
            
            for(int i = 0; i < this.formulario.jtDatosBinarios.getModel().getColumnCount(); i++) {
                modelo1.addElement(this.formulario.jtDatosBinarios.getModel().getColumnName(i));
                modelo2.addElement(this.formulario.jtDatosBinarios.getModel().getColumnName(i));
            }
            try
            {
                this.formulario.cmbItem1.setModel(modelo1);
                this.formulario.cmbItem1.setEnabled(true);
                this.formulario.cmbItem1.setSelectedIndex(0);
                this.formulario.cmbItem2.setModel(modelo2);
                this.formulario.cmbItem2.setEnabled(true);
                this.formulario.cmbItem2.setSelectedIndex(1);
                this.formulario.lblSeleccion.setEnabled(true);
                this.cargarContingencia();
            } catch(Exception err) { }
            this.formulario.revalidate();
            this.formulario.repaint();
        }
        if(e.getSource() == this.formulario.cmbItem1) {
            this.cargarContingencia();
        }
        if(e.getSource() == this.formulario.cmbItem2) {
            this.cargarContingencia();
        }
    }
}
