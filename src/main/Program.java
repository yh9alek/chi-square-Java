package main;

import controllers.Controlador;
import javax.swing.JFrame;
import views.JDProyecto;

/**
 *
 * @author yh9pl
 */
public class Program {
    public static void main(String[] args) {
        try {
            // Cambiar el Look and Feel
            javax.swing.UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        JDProyecto formulario = new JDProyecto(new JFrame(), true);
        Controlador controller = new Controlador(formulario);
        controller.iniciarVista();
    }
}
