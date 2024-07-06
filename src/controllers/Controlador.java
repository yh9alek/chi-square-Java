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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import views.JDProyecto;

/**
 *
 * @author yh9pl
 */
public class Controlador implements MouseListener, FocusListener, ActionListener, TableModelListener {
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
        this.formulario.setSize(1084, 600);
        this.formulario.setIconImage(new ImageIcon(getClass().getResource("/sources/upsin-icon.jpg")).getImage());
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
        this.formulario.jtDependencia.setModel(new DefaultTableModel());
        this.formulario.txtNombreItem.requestFocus();
        this.formulario.lbl11.setText("--");
        this.formulario.lbl12.setText("--");
        this.formulario.lbl13.setText("--");
        this.formulario.lbl14.setText("--");
        this.formulario.lbl15.setText("--");
        this.formulario.lbl16.setText("--");
        this.formulario.lbl17.setText("--");
        this.formulario.lbl18.setText("--");
        this.formulario.lbl21.setText("--");
        this.formulario.lbl22.setText("--");
        this.formulario.lbl23.setText("--");
        this.formulario.lbl24.setText("--");
        this.formulario.lbl25.setText("--");
        this.formulario.lbl26.setText("--");
        this.formulario.lbl27.setText("--");
        this.formulario.lbl28.setText("--");
        this.formulario.cb1.setText("--%");
        this.formulario.cb2.setText("--%");
        this.formulario.cb3.setText("--%");
        this.formulario.cb4.setText("--%");
        this.formulario.cb5.setText("--%");
        this.formulario.cb6.setText("--%");
        this.formulario.cb7.setText("--%");
        this.formulario.cb8.setText("--%");
        this.formulario.cf1.setText("--%");
        this.formulario.cf2.setText("--%");
        this.formulario.cf3.setText("--%");
        this.formulario.cf4.setText("--%");
        this.formulario.cf5.setText("--%");
        this.formulario.cf6.setText("--%");
        this.formulario.cf7.setText("--%");
        this.formulario.cf8.setText("--%");
        this.formulario.lblComprar.setText("");
        this.formulario.lblNoComprar.setText("");
    }
    
    // Cargar los nombres de los labels de items (cobertura y confianza)
    private void cargarNombreItems() {
        String item1 = this.formulario.cmbItem1.getSelectedItem().toString();
        String item2 = this.formulario.cmbItem2.getSelectedItem().toString();
        this.formulario.lbl11.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl12.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl13.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl14.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl15.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl16.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl17.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl18.setText(Controlador.obtenerIniciales(item1));
        this.formulario.lbl21.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl22.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl23.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl24.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl25.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl26.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl27.setText(Controlador.obtenerIniciales(item2));
        this.formulario.lbl28.setText(Controlador.obtenerIniciales(item2));
    }
    
    // Método utilizado para calcular los valores de la tabla de factor de dependencia
    private void calcularDependencia(String item1, String item2, String[][] modelo) {
        DefaultTableModel modeloDependencia = null;
        
        // Sacar los valores de celdas a trabajar
        float total = Float.parseFloat(modelo[3][3]);
        float totalV = Float.parseFloat(modelo[3][1]);
        float totalV2 = Float.parseFloat(modelo[3][2]);
        float totalH = Float.parseFloat(modelo[1][3]);
        float totalH2 = Float.parseFloat(modelo[2][3]);
        float valor11 = Float.parseFloat(modelo[1][1]);
        float valor12 = Float.parseFloat(modelo[1][2]);
        float valor21 = Float.parseFloat(modelo[2][1]);
        float valor22 = Float.parseFloat(modelo[2][2]);
        
        // Calcular el factor de dependencia
        float one = (valor11 / total) / ((totalH / total) * (totalV / total));
        float two = (valor12 / total) / ((totalH / total) * (totalV2 / total));
        float three = (valor21 / total) / ((totalH2 / total) * (totalV / total));
        float four = (valor22 / total) / ((totalH2 / total) * (totalV2 / total));
        
        // Crear los datos para el modelo de dependencia
        String[] nombresColumnas = new String[] {"", "", ""};
        String[][] datosDependencia = new String[3][3];

        datosDependencia[0][0] = "";
        datosDependencia[0][1] = item2;
        datosDependencia[0][2] = "~ " + item2;

        datosDependencia[1][0] = "   " + item1;
        datosDependencia[1][1] = String.format("%.3f", one);
        datosDependencia[1][2] = String.format("%.3f", two);
        datosDependencia[2][0] = "~ " + item1;
        datosDependencia[2][1] = String.format("%.3f", three);
        datosDependencia[2][2] = String.format("%.3f", four);
        this.formulario.lblComprar.setText("");
        this.formulario.lblNoComprar.setText("");
        
        if(one < two) this.formulario.lblComprar.setText("Comprar " + item1 + " disminuye la compra de " + item2);
        else if(one > two) this.formulario.lblComprar.setText("Comprar " + item1 + " aumenta la compra de " + item2);
        else this.formulario.lblComprar.setText("No hay dependencia entre uno y otro");
        if(three > four) this.formulario.lblNoComprar.setText("No comprar " + item1 + " aumenta la compra de " + item2);
        else if(three < four) this.formulario.lblNoComprar.setText("No comprar " + item1 + " disminuye la compra de " + item2);
        else this.formulario.lblNoComprar.setText("No hay dependencia entre uno y otro");
        
        // Crear un modelo para la tabla de dependencia, pasandole los datos previamente asignados
        modeloDependencia = new DefaultTableModel(datosDependencia, nombresColumnas){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas no sean editables
            }
        };        
        // Cargar la tabla de dependencia con el modelo y actualizar la UI del programa
        this.formulario.jtDependencia.setModel(modeloDependencia);
        this.formulario.jtDependencia.revalidate();
        this.formulario.jtDependencia.repaint();
    }
    
    // Método utilizado para calcular los valores de cobertura y confianza
    private void calcularCbCf() {
        this.cargarNombreItems();
        DefaultTableModel datos = (DefaultTableModel)this.formulario.jtContingencia.getModel();
        // Calculos de cobertura
        this.formulario.cb1.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 1)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb2.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 2)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb3.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 1)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb4.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 2)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb5.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 1)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb6.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 1)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb7.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 2)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        this.formulario.cb8.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 2)) / Float.parseFloat((String)datos.getValueAt(3, 3))) * 100))+"%");
        // Calculos de confianza
        this.formulario.cf1.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 1)) / Float.parseFloat((String)datos.getValueAt(1, 3)) * 100))+"%"));
        this.formulario.cf2.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 2)) / Float.parseFloat((String)datos.getValueAt(1, 3)) * 100))+"%"));
        this.formulario.cf3.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 1)) / Float.parseFloat((String)datos.getValueAt(2, 3)) * 100))+"%"));
        this.formulario.cf4.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 2)) / Float.parseFloat((String)datos.getValueAt(2, 3)) * 100))+"%"));
        this.formulario.cf5.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 1)) / Float.parseFloat((String)datos.getValueAt(3, 1)) * 100))+"%"));
        this.formulario.cf6.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 1)) / Float.parseFloat((String)datos.getValueAt(3, 1)) * 100))+"%"));
        this.formulario.cf7.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(1, 2)) / Float.parseFloat((String)datos.getValueAt(3, 2)) * 100))+"%"));
        this.formulario.cf8.setText(String.valueOf((int)((Float.parseFloat((String)datos.getValueAt(2, 2)) / Float.parseFloat((String)datos.getValueAt(3, 2)) * 100))+"%"));
    }
    
    // Método utilizado para calcular los valores de la tabla de contingencia
    private void calcularContingencia(String item1, String item2) {
        int indiceItem1 = -1;
        int indiceItem2 = -1;

        // Buscar los índices de los ítems seleccionados
        for (int i = 0; i < this.formulario.jtDatosBinarios.getColumnCount(); i++) {
            if (this.formulario.jtDatosBinarios.getColumnName(i).equals(item1)) {
                indiceItem1 = i;
                item1 = Controlador.obtenerIniciales(item1);
            } 
            if (this.formulario.jtDatosBinarios.getColumnName(i).equals(item2)) {
                indiceItem2 = i;
                item2 = Controlador.obtenerIniciales(item2);
            }
        }
        
        if(indiceItem1 == -1 || indiceItem2 == -1) return;

        // Inicializar las frecuencias
        int[][] frecuencias = new int[3][3];

        for (int i = 0; i < this.formulario.jtDatosBinarios.getRowCount(); i++) {
            int valorItem1 = Integer.parseInt(String.valueOf(this.formulario.jtDatosBinarios.getValueAt(i, indiceItem1)));
            int valorItem2 = Integer.parseInt(String.valueOf(this.formulario.jtDatosBinarios.getValueAt(i, indiceItem2)));

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

        // Crear los datos para el modelo de contingencia
        String[] nombresColumnas = new String[] {"", "", "", ""};
        String[][] datosContingencia = new String[4][4];

        datosContingencia[0][0] = "";
        datosContingencia[0][1] = item2;
        datosContingencia[0][2] = "~ " + item2;
        datosContingencia[0][3] = "Total";

        datosContingencia[1][0] = "   " + item1;
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
        
        // Crear un modelo para la tabla de contingencia con los datos previamente asignados
        DefaultTableModel modelContingencia = new DefaultTableModel(datosContingencia, nombresColumnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Hacer que las celdas no sean editables
            }
        };
        
        // Cargar la tabla de contingencia con el modelo creado
        this.formulario.jtContingencia.setModel(modelContingencia);
        this.calcularCbCf();
        this.calcularDependencia(item1, item2, datosContingencia);
        this.formulario.jtContingencia.getTableHeader().repaint();
        this.formulario.jtContingencia.revalidate();
        this.formulario.jtContingencia.repaint();
    }
    
    // Método que inicia todos los cálculos
    private void cargarContingencia() {
        String item1 = "", item2 = "";
        try
        {
            item1 = this.formulario.cmbItem1.getModel().getSelectedItem().toString();
            item2 = this.formulario.cmbItem2.getModel().getSelectedItem().toString();
            this.calcularContingencia(item1, item2);
        } catch(Exception err) { }
    }
    
    private static String obtenerIniciales(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        
        StringBuilder iniciales = new StringBuilder();
        String[] palabras = input.split(" ");
        
        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                iniciales.append(palabra.charAt(0));
            }
        }
        
        return iniciales.toString().toUpperCase();
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
    
    // Manejar evento cuando el mouse pasa por encima (lit solo es para ponerle el HAND cursor)
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
    
    // Manejar evento click
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.formulario.btnAgregar) {
            // Validaciones
            if((this.formulario.txtItems.getText().equals("0") || this.formulario.txtItems.getText().equals("")) ||
               (this.formulario.txtInstancias.getText().equals("0") || this.formulario.txtInstancias.getText().equals(""))) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar valores validos de items e instancias.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtItems.requestFocus();
                return;
            }
            if(this.formulario.txtNombreItem.getText().equals("") || this.formulario.txtNombreItem.getText().equals("Nombre Item")) {
                JOptionPane.showMessageDialog(this.formulario, "Debes ingresar un nombre de item.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtNombreItem.requestFocus();
                return;
            }
            // Lógica
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
                this.formulario.txtItems.requestFocus();
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
            
            // Validaciones
            if(this.formulario.jlItems.getModel().getSize() < numeroItems) {
                JOptionPane.showMessageDialog(this.formulario, "Faltan items por ingresar.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                this.formulario.txtNombreItem.setText("");
                this.formulario.txtNombreItem.requestFocus();
                return;
            }
            
            //Lógica
            String[] items = new String[numeroItems];
            String[][] datos = new String[numeroInstancias][numeroItems];
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            
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
            
            // Creación del modelo de datos para la tabla binaria y los comboBox
            DefaultTableModel model = new DefaultTableModel(datos, items);
            this.formulario.jtDatosBinarios.setModel(model);
            this.formulario.cmbItem1.setModel(modelo1);
            this.formulario.cmbItem1.setEnabled(true);
            this.formulario.cmbItem1.setSelectedIndex(0);
            this.formulario.cmbItem2.setModel(modelo2);
            this.formulario.cmbItem2.setEnabled(true);
            this.formulario.cmbItem2.setSelectedIndex(1);
            this.formulario.lblSeleccion.setEnabled(true);
            // Importante, se agrega un listener al modelo para controlar cada vez que se
            // actualiza el valor de alguna celda
            model.addTableModelListener(this);
            this.cargarContingencia();
            this.formulario.revalidate();
            this.formulario.repaint();
        }
        if(e.getSource() == this.formulario.btnExcel) {
            this.limpiar();
            DefaultTableModel modelo = Excel.cargar(this.formulario);
            if(modelo == null) {
                return;
            }
            if(modelo.getColumnCount() > 8) {
                JOptionPane.showMessageDialog(this.formulario, "No se admiten tablas con más de 8 items.", "Reglas de Asociación", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            this.formulario.jtDatosBinarios.setModel(modelo);
            // Modelos de datos para los comboBox
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            
            // Lógica para crear los datos del modelo de la tabla binaria
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
                modelo.addTableModelListener(this);
                this.cargarContingencia();
            } catch(Exception err) { }
            this.formulario.revalidate();
            this.formulario.repaint();
        }
        // Cada vez que se cambia el item de los comboBox, recalcular todo
        if(e.getSource() == this.formulario.cmbItem1) {
            if(this.formulario.jtDatosBinarios.getModel() != null)
                this.cargarContingencia();
        }
        if(e.getSource() == this.formulario.cmbItem2) {
            if(this.formulario.jtDatosBinarios.getModel() != null)
                this.cargarContingencia();
        }
    }
    
    // Evento que sucede al cambiar alguna celda binaria
    @Override
    public void tableChanged(TableModelEvent e) {
        this.cargarContingencia();
    }
}
