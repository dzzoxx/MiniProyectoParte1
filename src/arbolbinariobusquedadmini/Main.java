package arbolbinariobusquedadmini;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        
        ArbolBinario arbol = new ArbolBinario();
        
        String respuesta;
        int dato;
        
        System.out.println("===== ARBOL BINARIO =====");
        do {            
            System.out.println("\nIngrese el dato que desea insertar: ");
            dato = lector.nextInt();
            
            arbol.insertar(dato);
            
            System.out.println("Deseas insertar otro dato? (s/n)");
            respuesta=lector.next();
            
        } while (respuesta.equalsIgnoreCase("s"));
        int opcion;
        arbol.mostrarArbol();
        
        do {         
            System.out.println("<<< MENU DE RECORRIDOS >>>");
System.out.println("\n1. PREORDEN");
System.out.println("2. INORDEN");
System.out.println("3. POSTORDEN");
System.out.println("4. BUSCAR DATO");
System.out.println("5. ELIMINAR DATO");
System.out.println("6. Salir");
            
            System.out.println("Selecciones una opcion: ");
            opcion = lector.nextInt();
            
            switch (opcion) {

    case 1:
        System.out.println("\nRecorrido PreOrden (R - I - D):");
        arbol.preOrden();
        break;

    case 2:
        System.out.println("\nRecorrido InOrden (I - R - D):");
        arbol.inOrden();
        break;

    case 3:
        System.out.println("\nRecorrido PostOrden (I - D - R):");
        arbol.postOrden();
        break;

    case 4:
        System.out.println("\nIngrese el dato que desea buscar:");
        dato = lector.nextInt();

        int nivel = arbol.buscarNivel(dato);

        if (nivel == -1) {
            System.out.println("El dato NO se encuentra en el arbol.");
        } else {
            System.out.println("El dato " + dato + " SI se encuentra.");
            System.out.println("Se encuentra en el nivel: " + nivel);
        }
        break;

    case 5:
        System.out.println("\nIngrese el dato que desea eliminar:");
        dato = lector.nextInt();

        if (arbol.buscar(dato)) {
            arbol.eliminar(dato);
            System.out.println("El dato " + dato + " fue eliminado.");
            
            System.out.println("\nArbol actualizado: ");
            arbol.mostrarArbol();
        } else {
            System.out.println("El dato no se encuentra en el arbol.");
        }
        break;

    case 6:
        System.out.println("\nPrograma finalizado");
        break;

    default:
        System.out.println("\nOpcion no valida");
}
        } while (opcion !=6);
        lector.close();
    }
    
}
