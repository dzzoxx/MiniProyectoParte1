package arbolbinariobusquedadmini;

public class ArbolBinario {

    private Nodo raiz; //referencia al primer nodo del arbol
    
    public ArbolBinario(){//creacion del arbol sin valores
        raiz = null;
    }
    
    public void insertar(int dato){
        raiz = insertarR(raiz, dato);
    }
    private Nodo insertarR(Nodo nodo, int dato){
        //si no existe un nodo, se crea uno nuevo
        if (nodo == null) {
            return new Nodo(dato);
        }
        //para insertar a la izquierda
        if (dato<nodo.dato) {
            nodo.izquierdo = insertarR(nodo.izquierdo, dato);
            
                    
        } else if (dato>nodo.dato){
            nodo.derecho = insertarR(nodo.derecho, dato);
            
        }
        return nodo;
    }
    
    public boolean buscar(int dato){
        return buscarR(raiz, dato);
    }
    public boolean buscarR(Nodo nodo, int dato){
        //si esta vacio no existe dato
        if (nodo == null) {
            return false;    
        }
        //si encontramos el dato
        if (dato == nodo.dato){
            return true;
        }
        //para buscar a la izquierda con el metodo recursivo
        if (dato<nodo.dato) {
            return buscarR(nodo.izquierdo, dato);
        } else {
            return buscarR(nodo.derecho, dato);
        }
    }
    public void eliminar(int dato){
        raiz = eliminarR(raiz, dato);
    }
    private Nodo eliminarR(Nodo nodo, int dato){

    if (nodo == null) {
        return null;
    }

    if (dato < nodo.dato) {

        nodo.izquierdo = eliminarR(nodo.izquierdo, dato);

    } else if (dato > nodo.dato) {

        nodo.derecho = eliminarR(nodo.derecho, dato);

    } else {

        // No tiene hijo izquierdo
        if (nodo.izquierdo == null) {
            return nodo.derecho;
        }

        // No tiene hijo derecho
        if (nodo.derecho == null) {
            return nodo.izquierdo;
        }

        // Tiene dos hijos
        Nodo auxiliar = encontrarPequeño(nodo.derecho);

        nodo.dato = auxiliar.dato;

        nodo.derecho = eliminarR(nodo.derecho, auxiliar.dato);
    }

    return nodo;
}
    private Nodo encontrarPequeño(Nodo nodo){//para eleminiar un nodo con 2 hijos
        while(nodo.izquierdo !=null){
            nodo = nodo.izquierdo;
        }
        return nodo;
    }
    
    //la recusrisividad hace que cada nodo vulva a pasar por las mismas instrucciones
    //RECCORRIDOS
    //PREORDEN
     public void preOrden() {
        preOrdenRecursivo(raiz);
        System.out.println();
    }

    private void preOrdenRecursivo(Nodo nodo) {//nodo a revisar actulamente ej 70, 10 etc

        if (nodo != null) {

            System.out.print(nodo.dato + " ");//empieza en raiz

            preOrdenRecursivo(nodo.izquierdo);//es el hijo izquierdo que pasa a ser el nodo

            preOrdenRecursivo(nodo.derecho);//mismo recorrido desde el hijo derecho
        }
    }

    // =========================
    // INORDEN
    // =========================

    public void inOrden() {
        inOrdenRecursivo(raiz);
        System.out.println();
    }

    private void inOrdenRecursivo(Nodo nodo) {

        if (nodo != null) {

            inOrdenRecursivo(nodo.izquierdo);

            System.out.print(nodo.dato + " ");

            inOrdenRecursivo(nodo.derecho);
        }
    }

    // =========================
    // POSTORDEN
    // =========================

    public void postOrden() {
        postOrdenRecursivo(raiz);
        System.out.println();
    }

    private void postOrdenRecursivo(Nodo nodo) {

        if (nodo != null) {

            postOrdenRecursivo(nodo.izquierdo);

            postOrdenRecursivo(nodo.derecho);

            System.out.print(nodo.dato + " ");
        }
    }
  public void mostrarArbol() {
    mostrarArbolRecursivo(raiz, 0);
}

private void mostrarArbolRecursivo(Nodo nodo, int nivel) {

    if (nodo != null) {

        mostrarArbolRecursivo(nodo.derecho, nivel + 1);

        for (int i = 0; i < nivel; i++) {
            System.out.print("       ");
        }

        System.out.println(nodo.dato);

        mostrarArbolRecursivo(nodo.izquierdo, nivel + 1);
    }
}
public int buscarNivel(int dato) {
    return buscarNivelR(raiz, dato, 0);
}

private int buscarNivelR(Nodo nodo, int dato, int nivel) {

    if (nodo == null) {
        return -1;
    }

    if (dato == nodo.dato) {
        return nivel;
    }

    if (dato < nodo.dato) {
        return buscarNivelR(nodo.izquierdo, dato, nivel + 1);
    } else {
        return buscarNivelR(nodo.derecho, dato, nivel + 1);
    }
}
    }
   
 