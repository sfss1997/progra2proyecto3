
package proyectodosalgoritmos;

import gui.Login;
import javax.swing.JFrame;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class ProyectoDosAlgoritmos {

    /**
     * Ventana principal login.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login login = new Login();
        JFrame jFrame = new JFrame();
        jFrame.setUndecorated(true);
        jFrame.setLocation(450,200);
        jFrame.setTitle("Login");
        jFrame.setSize(399, 245);
        jFrame.add(login);
        jFrame.setVisible(true);
        
    }
    
}
