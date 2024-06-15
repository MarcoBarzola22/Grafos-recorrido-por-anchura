public class ColaLista {
    private Nodo frente;
    private Nodo fin;

    public ColaLista() {
        frente = fin = null;
    }

    public boolean colaVacia() {
        return frente == null;
    }

    public void insertar(Object elemento) {
        Nodo a = new Nodo(elemento);
        if (colaVacia()) {
            frente = a;
        } else {
            fin.siguiente = a;
        }
        fin = a;
    }

    public Object quitar() throws Exception {
        if (colaVacia()) {
            throw new Exception("Cola vacía");
        }
        Object aux = frente.elemento;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        return aux;
    }
}