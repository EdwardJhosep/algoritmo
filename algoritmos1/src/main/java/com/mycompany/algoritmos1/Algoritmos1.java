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
        personas.put(nombre, nerviosismo + "," + historia + "," + lenguajeNoVerbal + "," + coherencia);
        JOptionPane.showMessageDialog(null, "Persona agregada correctamente.");
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
        //dividitr la informacion 
        String[] infoParts = personaInfo.split(",");
        //extraer cada componente
        String nerviosismo = infoParts[0];
        String historia = infoParts[1];
        String lenguajeNoVerbal = infoParts[2];
        String coherencia = infoParts[3];
//realizar analisis
        String decision = detectLie(nerviosismo, historia, lenguajeNoVerbal, coherencia);
//mostar cuadro 
        JOptionPane.showMessageDialog(null, "Resultado para " + nombre + ":\n" + decision);
    }
    //creacion de metodo detectLie
    private static String detectLie(String nerviosismo, String historia, String lenguajeNoVerbal, String coherencia) {
        Map<String, Integer> nerviosismoCounts = new HashMap<>();
            //creacion de metodo // Definir los mapas de conteo
        nerviosismoCounts.put("Sí", 4);
        nerviosismoCounts.put("No", 3);
//creacion de metodo // Definir los mapas de conteo
        Map<String, Integer> historiaCounts = new HashMap<>();
        historiaCounts.put("Sí", 5);
        historiaCounts.put("No", 4);
//creacion de metodo // Definir los mapas de conteo
        Map<String, Integer> lenguajeNoVerbalCounts = new HashMap<>();
        lenguajeNoVerbalCounts.put("Sí", 5);
        lenguajeNoVerbalCounts.put("No", 4);
//creacion de metodo // Definir los mapas de conteo
        Map<String, Integer> coherenciaCounts = new HashMap<>();
        coherenciaCounts.put("Sí", 0);
        coherenciaCounts.put("No", 0);
        //calcular la antropia del nodo padre 
        double parentEntropy = calculateEntropy(5, 10);
// Calcular la entropía para diferentes atributos
        double nerviosismoEntropy = calculateEntropy(4, 7);
        double historiaEntropy = calculateEntropy(5, 10);
        double lenguajeNoVerbalEntropy = calculateEntropy(5, 9);
        double coherenciaEntropy = calculateEntropy(5, 8);
// Calcular la ganancia de información
        double nerviosismoGain = calculateInformationGain(parentEntropy, nerviosismoCounts, 10);
        double historiaGain = calculateInformationGain(parentEntropy, historiaCounts, 10);
        double lenguajeNoVerbalGain = calculateInformationGain(parentEntropy, lenguajeNoVerbalCounts, 10);
        double coherenciaGain = calculateInformationGain(parentEntropy, coherenciaCounts, 10);
        // Comprobar cuál atributo tiene la mayor ganancia de información 


        //implementacion de condiciones 
        if (nerviosismoGain > historiaGain && nerviosismoGain > lenguajeNoVerbalGain && nerviosismoGain > coherenciaGain) {
            return "Es probable que  " + nerviosismo.toLowerCase() + " esté mintiendo (Nerviosismo)";
        } else if (historiaGain > nerviosismoGain && historiaGain > lenguajeNoVerbalGain && historiaGain > coherenciaGain) {
            return "Es probable que " + historia.toLowerCase() + " esté mintiendo (Historia)";
        } else if (lenguajeNoVerbalGain > nerviosismoGain && lenguajeNoVerbalGain > historiaGain && lenguajeNoVerbalGain > coherenciaGain) {
            return "Es probable que " + lenguajeNoVerbal.toLowerCase() + " esté mintiendo (Lenguaje No Verbal)";
        } else {
            return "Es probable que " + coherencia.toLowerCase() + " esté mintiendo (Coherencia)";
        }
        
    }
    private static double calculateEntropy(int positiveCount, int total) {
          // Calcula la proporción de casos positivos
        double pPositive = (double) positiveCount / total;
        double pNegative = 1 - pPositive;
// Verifica si alguna proporción es cero
        if (pPositive == 0 || pNegative == 0) {
            return 0;
        }
// Calcula la entropía utilizando la fórmula de la entropía
        return -pPositive * log2(pPositive) - pNegative * log2(pNegative);
    }
    // Función para calcular el logaritmo en base 2 de un valor
    private static double log2(double value) {
        return Math.log(value) / Math.log(2);
    }

    // Función para calcular la ganancia de información
    
    private static double calculateInformationGain(double parentEntropy, Map<String, Integer> attributeCounts, int totalSamples) {
       // Inicializar la variable para almacenar 
        double weightedEntropy = 0;
        for (int count : attributeCounts.values()) {
            double p = (double) count / totalSamples;
            weightedEntropy += p * calculateEntropy(count, totalSamples);
        }
         // Calcular la ganancia de información restando la entropía ponderada
        return parentEntropy - weightedEntropy;
    }
}

