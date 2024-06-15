import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        // Creamos una lista de vértices con nombres diferentes
        ArrayList<Vertice> letras = new ArrayList<>();
        letras.add(new Vertice("X"));
        letras.add(new Vertice("Y"));
        letras.add(new Vertice("Z"));
        letras.add(new Vertice("W"));
        letras.add(new Vertice("P"));
        letras.add(new Vertice("Q"));
        letras.add(new Vertice("S"));

        try {
            // Creamos un grafo con matriz de adyacencia del tamaño de la lista de vértices
            GrafoMatriz matrizAdyacencia = new GrafoMatriz(letras.size());

            System.out.println("Matriz de Adyacencia inicial:");
            matrizAdyacencia.mostrarMatriz();
            System.out.println("========================");

            // Agregamos los vértices a la matriz de adyacencia
            Iterator<Vertice> it = letras.iterator();
            while (it.hasNext()) {
                matrizAdyacencia.nuevoVertice(it.next().nomVertice());
            }

            System.out.println("Matriz de Adyacencia con vértices añadidos:");
            matrizAdyacencia.mostrarMatriz();
            System.out.println("========================");

            // Agregamos nuevos arcos entre los vértices
            matrizAdyacencia.nuevoArco("X", "Y");
            matrizAdyacencia.nuevoArco("X", "Z");
            matrizAdyacencia.nuevoArco("Y", "W");
            matrizAdyacencia.nuevoArco("Z", "P");
            matrizAdyacencia.nuevoArco("P", "Q");
            matrizAdyacencia.nuevoArco("Q", "S");
            matrizAdyacencia.nuevoArco("S", "X");

            System.out.println("Matriz de Adyacencia con nuevos arcos añadidos:");
            matrizAdyacencia.mostrarMatriz();
            System.out.println("========================");

            // Realizamos un recorrido en anchura desde un vértice específico
            System.out.println("Recorrido en Anchura desde el vértice 'X':");
            RecorreGrafo.recorrerAnchura(matrizAdyacencia, "X");

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}