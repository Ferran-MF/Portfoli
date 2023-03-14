package exBasics2;
import java.util.Scanner;

public class Practica1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jugarDeNuevo = true;
        int contadorPartidas= 0;
        
        //Instrucciones del juego
        System.out.println("Bienvenidos al juego de Tres en Raya.");
        System.out.println("Este juego consiste en un tablero de 3x3 en el que dos jugadores se enfrentan para conseguir poner tres de sus fichas en raya.");
        
        //Pregunta jugar de nuevo
        while (jugarDeNuevo) {
            jugar(sc);
            System.out.println("¿Quieres jugar de nuevo? (S/N)");
            jugarDeNuevo = sc.next().equalsIgnoreCase("S");
        }
        sc.close();
    }

    // Función principal del juego
    public static void jugar(Scanner sc) {
        char tablero[][]= new char[3][3];
        
        //Iniciar el tablero
        for (char[] fila : tablero) {
            java.util.Arrays.fill(fila, '-');
        }
        
        char jugador='x';
        mostrar(tablero);
        while (!ganador(tablero)) {
            int fila, columna;
            do {
                //Pedir donde poner la ficha al jugador
                System.out.println("Jugador "+jugador+"\nDonde quieres poner la "+jugador+"?\nIndica la fila");
                fila = sc.nextInt() - 1;
                System.out.println("Indica la columna");
                columna = sc.nextInt() - 1;
            } while (!comprobarMovimiento(fila, columna, tablero));
            //Colocar la ficha en el tablero
            tablero[fila][columna] = jugador;
            //Aqui hace que el tablero se actualice en vez de crear otro
            mostrar(tablero);
            //Cambiar al siguiente jugador
            jugador = (jugador == 'x') ? 'o' : 'x';
        }

    }

    //Comprobar ganador
    public static boolean ganador(char tablero[][]) {
        for (int i = 0; i < 3; i++) {
            // Verifica si gana por fila
            if (tablero[i][0] == tablero[i][1] && tablero[i][0] == tablero[i][2] && tablero[i][0] != '-') {
                System.out.println("Ha ganado " + tablero[i][0]);
                return true;
            }
            // Verifica si gana por columna
            if (tablero[0][i] == tablero[1][i] && tablero[0][i] == tablero[2][i] && tablero[0][i] != '-') {
                System.out.println("Ha ganado " + tablero[0][i]);
                return true;
            }
        }
        // Verifica si gana por diagonal
        if (tablero[0][0] == tablero[1][1] && tablero[0][0] == tablero[2][2] && tablero[0][0] != '-') {
            System.out.println("Ha ganado " + tablero[0][0]);
            return true;
        }
        if (tablero[0][2] == tablero[1][1] && tablero[0][2] == tablero[2][0] && tablero[0][2] != '-') {
            System.out.println("Ha ganado " + tablero[0][2]);
            return true;
        }
        return false;
    }
    //Comprueba si el movimiento es correcto o si ya esta en uso esa posicion
    public static boolean comprobarMovimiento(int fila, int columna, char tablero[][]) {
        if (fila < 0 || fila > 2 || columna < 0 || columna > 2) {
            System.out.println("Te has salido de la pista");
            return false;
        } else if (tablero[fila][columna] != '-') {
            System.out.println("Esta casilla esta ocupada");
            return false;
        }
        return true;
    }
    
    public static void mostrar(char tablero[][]) {
        for (char[] fila : tablero) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}