//autores: Pablo Méndez 23975 - Gabriel Soto 23900
package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class App{
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("datos.txt"));
            String infix = reader.readLine();
            reader.close();

            Expresion expresion = new Expresion(infix);
            int resultado = expresion.evaluar();

            System.out.println("La expresión infix es: " + infix);
            System.out.println("La expresión postfix es: " + expresion.getPostfix());
            System.out.println("El resultado de la evaluación es: " + resultado);
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
