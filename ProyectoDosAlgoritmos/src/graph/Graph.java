/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_grafos_algoritmos;

/**
 *
 * @author Equipo
 */
public interface Graph {
    
    public void cancel();
    public boolean isEmpty() throws GraphException;
    public int getSize() throws GraphException;
    public boolean existVertex(Object element) throws GraphException;
    public boolean existEdge(Object v1, Object v2) throws GraphException;
    public void insertVertx(Object element) throws GraphException;
    public void insertEdge(Object v1, Object v2) throws GraphException;
    public void insertWeight(Object v1, Object v2, int weight) throws GraphException;
    public void deleteVertex(Object element) throws GraphException;
    public void deleteEdge(Object v1,Object v2) throws GraphException;
}
