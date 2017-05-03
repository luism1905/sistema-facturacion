/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadisystem.herramientas;

import cadisystem.model.BD.Conexion;
import static com.sun.javafx.tk.Toolkit.getToolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author carlos
 */
public class Tools extends Conexion {

    public void validarSoloNumeros(KeyEvent ke) {
        char c = ke.getKeyChar();
        if (Character.isLetter(c)) {
            ke.consume();
        }

    }

    public Boolean validarJTextfieldCorreo(JTextField jt) {

        if (jt.getText().contains("@") && jt.getText().contains(".")) {
            return true;
        } else {
            return false;
        }

    }

    public void validarMaximoCaracteresTextfield(JTextField jtxt, int max) {

        jtxt.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (jtxt.getText().length() == max) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }


}
