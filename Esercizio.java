//LEGGERE LE ISTRUZIONI NEL FILE README.md

//Import di Classi Java necessarie al funzionamento del programma
import java.util.Scanner;

// Classe principale, con metodo main
class Esercizio {
    
    public static Scanner in = new Scanner(System.in);
    public static int leggiComando() {
        int scelta;
        do {
            System.out.println("1. Inserisci elemento");
            System.out.println("2. Elimina elemento");
            System.out.println("3. Ricerca elemento");
            System.out.println("4. Elimina duplicati");
            System.out.println("5. Visualizza vettore");
            System.out.println("6. Esci");
            scelta = Integer.parseInt(in.nextLine());
        } while (scelta<1 || scelta>6);
        return scelta; 
    }

    public static int ricercaElemento(int[] V, int N, int el) {
        int idx, i;
        idx = -1;
        for (i=0; i<N && idx==-1; ++i) {
            if (V[i]==el) {
                idx = i;
            }
        }
        return idx;
    }

    public static int inserisciElemento(int[] V, int N, int el, int iPos) {
        int[] W = new int[N+1];
        int i;
        for (i=0; i<iPos; ++i) {
            W[i] = V[i];
        }
        W[iPos] = el;
        for (i=iPos+1; i<N; ++i) {
            W[i] = V[i-1];
        }
        ++N;
        for (i=0; i<N; ++i) {
            V[i] = W[i];
        }
        return N;
    }
    
    public static void azzeraVettore(int[] V, int N) {
        for (int i=0; i<N; ++i) {
            V[i] = 0;
        }
    }
    

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
