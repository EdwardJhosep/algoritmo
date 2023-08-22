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
                "Menú: \n" +
                "1. Agregar persona\n" +
                "2. Detectar si una persona miente\n" +
                "3. Salir\n\n" +
                "Seleccione una opción:");
             //creacion del switch -manejo de opciones
             
              switch (menuChoice) {
                case "1":
                    //agregar
                    addPersona(personas);
                    break;
                case "2":
                    //detectar
                    detectarMentira(personas);
                    break;
                case "3":
                    //salir
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida. Por favor, seleccione una opción válida.");
            }
    }
}
    //Función para agregar información
     private static void addPersona(Map<String, String> personas) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona:");
        String nerviosismo = JOptionPane.showInputDialog("¿" + nombre + " está nervioso/a? (Sí/No)");
        String historia = JOptionPane.showInputDialog("¿" + nombre + " tiene una historia creíble? (Sí/No)");
        String lenguajeNoVerbal = JOptionPane.showInputDialog("¿" + nombre + " presenta lenguaje no verbal sospechoso? (Sí/No)");
        String coherencia = JOptionPane.showInputDialog("¿" + nombre + " mantiene coherencia en su historia? (Sí/No)");
   
    }
         //Función para agregar funcion detectarMentira
    private static void detectarMentira(Map<String, String> personas) {
        //solicitar nombre
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre de la persona para consultar su historial:");
        //obtener 
        String personaInfo = personas.get(nombre);
//condicion negativa  del  nombre verificar
        if (personaInfo == null) {
            //mostar
            JOptionPane.showMessageDialog(null, "Persona no encontrada en el historial.");
            return;//devolver mensage
        }
    }
    
}
