public class Vertice {
    private String nombre;
    private int numVertice;

    public Vertice(String nombre) {
        this.nombre = nombre;
        this.numVertice = -1; // -1 indica que el vértice no está en la matriz
    }

    public String nomVertice() {
        return nombre;
    }

    public boolean equals(Vertice otro) {
        return nombre.equals(otro.nombre);
    }

    public void asignarNumVertice(int num) {
        numVertice = num;
    }

    @Override
    public String toString() {
        return nombre + " (" + numVertice + ")";
    }
}
