
package tda;

import domain.User;
import static tda.LoadTda.userList;

/**
 * Clase para el mantenimiento de cada entidad.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class CrudMaintenance {
    
    public Boolean validateUser(String user, String password) {
        for (int i = 0; i < userList.size(); i++) {
            User userAux = userList.get(i);
            if(userAux.getUser().equals(user)) {
                if(userAux.getPassword().equals(password)) {
                    return true;
                }
            }
            
        }
        return false;
    }
    
    public int validateRole(String user) {
        for (int i = 0; i < userList.size(); i++) {
            User userAux = userList.get(i);
            if(userAux.getUser().equals(user)) {
                if(userAux.getRole().equals("Operador")) {
                    return 1;
                } else if(userAux.getRole().equals("Administrador")) {
                    return 2;
                }
            }
        }
        return -1;
    }
    
    public void addProduct() {
    }

    public void deleteProduct() {
    }

    public void searchProduct() {
    }

    public void updateProduct() {
    }
    
    public void addCategory() {
    }

    public void deleteCategory() {
    }

    public void searchCategory() {
    }

    public void updateCategory() {
    }
    
    public void addBacth() {
    }

    public void deleteBacth() {
    }

    public void searchBacth() {
    }

    public void updateBacth() {
    }
    
    public void addTransportUnit() {
    }

    public void deleteTransportUnit() {
    }

    public void searchTransportUnit() {
    }

    public void updateTransportUnit() {
    }
    
}
