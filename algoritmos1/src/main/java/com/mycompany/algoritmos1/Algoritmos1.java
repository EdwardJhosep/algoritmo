/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.algoritmos1;
//importamos JOptionPane-ingreso,Map-funcion,HashMap-almacenar
import javax.swing.JOptionPane;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Administrador
 */
public class Algoritmos1 {

    public static void main(String[] args) {
  //cree una mapa para almacenar los datos 
        Map<String, String> personas = new HashMap<>();
        boolean exit = false;

        while (!exit) {
            //creacion de un menu 
             String menuChoice = JOptionPane.showInputDialog(
                "Menú:\n" +
                "1. Agregar persona\n" +
                "2. Detectar si una persona miente\n" +
                "3. Salir\n\n" +
                "Seleccione una opción:");
    }
}
}

