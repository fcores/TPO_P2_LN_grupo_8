import java.util.HashMap;
import java.util.Map;

public class ConjuntoConRepetidos<T> {
    private Map<T, Integer> elementos;

    public ConjuntoConRepetidos() {
        elementos = new HashMap<>();
    }

    /**
     * @Costo: Constante (en promedio)
     **/
    public void agregarElemento(T elemento, int cantidad) {
        if (elementos.containsKey(elemento)) {
            int cantidadActual = elementos.get(elemento);
            elementos.put(elemento, cantidadActual + cantidad);
        } else {
            elementos.put(elemento, cantidad);
        }
    }

    /**
     * @Costo: Constante
     **/
    public void eliminarElemento(T elemento, int cantidad) {
        if (elementos.containsKey(elemento)) {
            int cantidadActual = elementos.get(elemento);
            int nuevaCantidad = cantidadActual - cantidad;
            if (nuevaCantidad <= 0) {
                elementos.remove(elemento);
            } else {
                elementos.put(elemento, nuevaCantidad);
            }
        }
    }

    /**
     * @Costo: Constante
     **/
    public boolean contieneElemento(T elemento) {
        return elementos.containsKey(elemento);
    }

    /**
     * @Costo: Constante
     **/
    public int obtenerCantidad(T elemento) {
        if (elementos.containsKey(elemento)) {
            return elementos.get(elemento);
        } else {
            return 0;
        }
    }
}

