//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {
    // Il programma parte con una chiamata a main().
    public static void main(String args[]) {
        int N, pos, x, i, scelta, indice;
        System.out.println("Inserire la grandezza del vettore: ");
        do {
            N = Integer.parseInt(in.nextLine());
        } while (N < 0);

        int[] V = new int[N * 100];
        azzeraVettore(V, N);

        do {
            scelta = leggiComando();
            switch (scelta) {
                case 1:
                    do {
                        System.out.println("Inserire la posizione: ");
                        pos = Integer.parseInt(in.nextLine());
                    } while (pos < 0 || pos > N - 1);
                    System.out.println("Inserire il valore: ");
                    x = Integer.parseInt(in.nextLine());
                    N = inserisciElemento(V, N, pos, x);
                    break;

                case 2:
                    do {
                        System.out.println("Inserire posizione: ");
                        pos = Integer.parseInt(in.nextLine());
                    } while (pos < 0 || pos > N - 1);
                    N = eliminaElemento(V, N, pos);
                    break;

                case 3:
                    System.out.println("Inserire il valore: ");
                    x = Integer.parseInt(in.nextLine());
                    indice = ricercaElemento(V, N, x);
                    if (indice >= 0) {
                        System.out.println("Elemento: " + x + " trovato in posizione: " + indice);
                    } else {
                        System.out.println("Elemento: " + x + " non trovato.");
                    }
                    break;

                case 4:
                    N = eliminaDuplicati(V, N);
                    break;

                case 5:
                    visualizzaVettore(V, N);
                    break;

                case 6:
                    System.out.println("Uscita dal programma...");
                    break;

                default:
                    System.out.println("Opzione non valida.");
            }
        } while (scelta != 6);
    }
}

//LEGGERE LE ISTRUZIONI NEL FILE README.md
