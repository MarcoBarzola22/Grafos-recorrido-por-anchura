public class RecorreGrafo {
    public static final int CLAVE = -1;

    public static void recorrerAnchura(GrafoMatriz g, String origen) throws Exception {
        int v = g.numVertice(origen);
        if (v < 0) {
            throw new Exception("Vértice origen no existe");
        }

        ColaLista cola = new ColaLista();
        int[] marcados = new int[g.numeroDeVertices()];

        for (int i = 0; i < g.numeroDeVertices(); i++) {
            marcados[i] = CLAVE;
        }

        marcados[v] = 0; // Marcar el vértice origen
        cola.insertar(v);

        while (!cola.colaVacia()) {
            int w = (int) cola.quitar();
            System.out.println("Vértice " + g.obtenerVertice(w).nomVertice() + " - Visitado");

            // Marcar y encolar los vértices adyacentes no marcados
            for (int u = 0; u < g.numeroDeVertices(); u++) {
                if (g.obtenerMatrizAdyacencia()[w][u] == 1 && marcados[u] == CLAVE) {
                    marcados[u] = marcados[w] + 1;
                    cola.insertar(u);
                }
            }
        }
    }
}