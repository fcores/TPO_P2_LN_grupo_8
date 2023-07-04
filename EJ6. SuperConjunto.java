import java.util.HashSet;
import java.util.Set;

public class Superconjunto<T> {
    private Set<T> conjuntoUniversal;

    public Superconjunto() {
        conjuntoUniversal = new HashSet<>();
    }

    public void agregarElemento(T elemento) {
        conjuntoUniversal.add(elemento);
    }

    public void eliminarElemento(T elemento) {
        conjuntoUniversal.remove(elemento);
    }

    public boolean contieneElemento(T elemento) {
        return conjuntoUniversal.contains(elemento);
    }

    public boolean esSubconjunto(Set<T> conjunto) {
        return conjuntoUniversal.containsAll(conjunto);
    }

    public Set<T> calcularComplemento(Set<T> conjunto) {
        if (!esSubconjunto(conjunto)) {
            throw new IllegalArgumentException("El conjunto no es subconjunto del superconjunto");
        }

        Set<T> complemento = new HashSet<>(conjuntoUniversal);
        complemento.removeAll(conjunto);
        return complemento;
    }
}

