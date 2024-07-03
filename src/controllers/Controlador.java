package controllers;

import helpers.Excel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.KeyboardFocusManager;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
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
    }
    
    // Iniciar el formulario
    public void iniciarVista() {
        this.formulario.setTitle("Reglas Asociación");
        this.formulario.setSize(836, 547);
        this.formulario.setLocationRelativeTo(null);
        this.formulario.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.formulario.show();
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
            Controlador.listModel.clear();
            this.formulario.txtNombreItem.setForeground(new Color(0x999999));
            this.formulario.txtNombreItem.setBackground(new Color(0xFFFFFF));
            this.formulario.txtNombreItem.setText("Nombre Item");
            this.formulario.jlItems.setModel(new DefaultListModel<>());
            this.formulario.btnCrearTabla.setEnabled(false);
            this.formulario.jtDatosBinarios.setModel(new DefaultTableModel());
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
            
            for(int i = 0; i < numeroItems; i++) {
                items[i] = this.formulario.jlItems.getModel().getElementAt(i);
            }
            for(int i = 0; i < numeroInstancias; i++) {
                for(int j = 0; j < numeroItems; j++) {
                   datos[i][j] = String.valueOf((int)(Math.random() * 2));
                }
            }
            
            DefaultTableModel model = new DefaultTableModel(datos, items);
            this.formulario.jtDatosBinarios.setModel(model);
            this.formulario.revalidate();
            this.formulario.repaint();
        }
        if(e.getSource() == this.formulario.btnExcel) {
            this.formulario.jtDatosBinarios.setModel(Excel.cargar(formulario));
            if(this.formulario.jtDatosBinarios.getModel() == null) {
                return;
            }      
        }
    }
}
