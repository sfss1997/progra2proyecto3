
package lab_grafos_algoritmos;

/**
 *
 * @author Equipo
 */
public class Vertice {
    public Object element;
    public boolean isVisited;

    public Vertice(Object element) {
        this.element = element;
        this.isVisited = false;
    }

    @Override
    public String toString() {
        return "Vertice{" + "element=" + element + ", isVisited=" + isVisited + '}';
    }
    
}
