package uvg.edu.gt;

public class Factory {
    public static Lista createLista(String type){
        if (type.equalsIgnoreCase("ListaSimple")){
            return new ListaSimple<>();
        } else if (type.equalsIgnoreCase("ListaDoble")) {
            return new ListaDoble<>();
        } else {
            throw new IllegalArgumentException("Error: tipo de lista no encontrado");
        }
    }
}
