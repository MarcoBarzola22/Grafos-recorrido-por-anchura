public class GrafoMatriz {
    private int numVerts;
    private static final int MAX_VERTICES = 20;
    private Vertice[] vertices;
    private int[][] matrizAdyacencia;

    public GrafoMatriz() {
        this(MAX_VERTICES);
    }

    public GrafoMatriz(int maxVertices) {
        matrizAdyacencia = new int[maxVertices][maxVertices];
        vertices = new Vertice[maxVertices];
        for (int i = 0; i < maxVertices; i++) {
            for (int j = 0; j < maxVertices; j++) {
                matrizAdyacencia[i][j] = 0;
            }
        }
        numVerts = 0;
    }

    public Vertice[] obtenerVertices() {
        return vertices;
    }

    public void nuevoVertice(String nombre) {
        boolean existe = numVertice(nombre) >= 0;
        if (!existe) {
            Vertice v = new Vertice(nombre);
            v.asignarNumVertice(numVerts);
            vertices[numVerts++] = v;
        }
    }

    public int numVertice(String nombreVertice) {
        Vertice v = new Vertice(nombreVertice);
        boolean encontrado = false;
        int i = 0;
        while (i < numVerts && !encontrado) {
            encontrado = vertices[i].equals(v);
            if (!encontrado) {
                i++;
            }
        }
        return (encontrado) ? i : -1;
    }

    public void nuevoArco(String origen, String destino) throws Exception {
        int v = numVertice(origen);
        int w = numVertice(destino);
        if (v < 0 || w < 0) {
            throw new Exception("Vértice no existe");
        }
        matrizAdyacencia[v][w] = 1;
    }

    public boolean adyacente(String origen, String destino) throws Exception {
        int v = numVertice(origen);
        int w = numVertice(destino);
        if (v < 0 || w < 0) {
            throw new Exception("Vértice no existe");
        }
        return matrizAdyacencia[v][w] == 1;
    }

    public int numeroDeVertices() {
        return numVerts;
    }

    public void mostrarMatriz() {
        System.out.print("  | ");
        for (int i = 0; i < numVerts; i++) {
            System.out.print(vertices[i].nomVertice() + " ");
        }
        System.out.println();
        System.out.print("--");
        for (int i = 0; i < numVerts; i++) {
            System.out.print("--");
        }
        System.out.println();
        for (int i = 0; i < numVerts; i++) {
            System.out.print(vertices[i].nomVertice() + " | ");
            for (int j = 0; j < numVerts; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] obtenerMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public Vertice obtenerVertice(int indice) {
        return vertices[indice];
    }
}