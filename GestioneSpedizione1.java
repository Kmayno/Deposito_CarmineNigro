import java.util.ArrayList;
import java.util.Scanner;

public class GestioneSpedizione1 {
     // lista per memorizzare le spedizioni, ogni spedizione e' rappresentata come un array di 4 interi
    static ArrayList<int[]> spedizioni = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);



    // funzione per aggiungere una nuova spedizione, l'utente inserisce i valori
    public static void aggiungiSpedizione() {
        // Array per contenere le quantita' di penne per ogni colore
        int[] spedizione = new int[4];
        System.out.println("Inserisci il numero di penne per ogni colore:");
        System.out.print("Rosso: ");
        // Salva il numero di penne rosse
        spedizione[0] = scanner.nextInt();
        System.out.print("Blu: ");
        // Salva il numero di penne blu
        spedizione[1] = scanner.nextInt();
        System.out.print("Verde: ");
        // Salva il numero di penne verdi
        spedizione[2] = scanner.nextInt();
        System.out.print("Nero: ");
        // Salva il numero di penne nere
        spedizione[3] = scanner.nextInt();
        
        // Aggiunge la spedizione alla lista
        spedizioni.add(spedizione);
        System.out.println("Spedizione aggiunta.");
    }



    // funzione per visualizzare tutte le spedizioni registrate
    public static void visualizzaSpedizioni() {
        if (spedizioni.isEmpty()) {
            System.out.println("Nessuna spedizione registrata.");
            return;
        }
        System.out.println("Lista delle spedizioni:");
        for (int i = 0; i < spedizioni.size(); i++) {
            int[] s = spedizioni.get(i);
            System.out.println("Spedizione " + (i + 1) + ": Rosse: " + s[0] + ", Blu: " + s[1] + ", Verdi: " + s[2] + ", Nere: " + s[3]);
        }
    }


    // funzione per calcolare il totale di penne spedite per ogni colore
    public static void calcolaTotalePenne() {
        // Array per memorizzare il totale delle penne per ogni colore
        int[] totali = new int[4];
        for (int[] s : spedizioni) {
            for (int i = 0; i < 4; i++) {
                 // Somma le quantità di ogni colore
                totali[i] += s[i];
            }
        }
        System.out.println("Totale penne spedite:");
        System.out.println("Rosse: " + totali[0] + ", Blu: " + totali[1] + ", Verdi: " + totali[2] + ", Nere: " + totali[3]);
    }


     // funzione per cercare spedizioni che contengano almeno una penna di un determinato colore
    public static void ricercaPerColore() {
        System.out.print("Inserisci il colore da cercare (Rosso, Blu, Verde, Nero): ");
        // Converte l'input in minuscolo
        String colore = scanner.next().toLowerCase();
        int index = switch (colore) {
            case "rosso" -> 0;
            case "blu" -> 1;
            case "verde" -> 2;
            case "nero" -> 3;
            //Se il colore non è valido
            default -> -1;
        };
        if (index == -1) {
            System.out.println("Colore non valido.");
            return;
        }
        boolean trovata = false;
        for (int i = 0; i < spedizioni.size(); i++) {
            if (spedizioni.get(i)[index] > 0) {
                // Verifica se almeno una penna di quel colore è presente
                System.out.println("Spedizione " + (i + 1) + " contiene penne " + colore);
                trovata = true;
            }
        }
        if (!trovata) {
            System.out.println("Nessuna spedizione contiene penne di questo colore.");
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("Benvenuto!");
            System.out.println("Cosa vogliamo fare oggi?");
            System.out.println("1. Aggiungi spedizione");
            System.out.println("2. Visualizza spedizioni");
            System.out.println("3. Calcola totale penne");
            System.out.println("4. Cerca spedizione per colore");
            System.out.println("5. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            // Switch per il menu
            switch (scelta) {
                case 1:
                    aggiungiSpedizione();
                    System.out.print("Vuoi continuare? (s/n)? ");
                    char sceltaContinua1 = scanner.next().charAt(0);
                    if (sceltaContinua1 == 'n' || sceltaContinua1 == 'N') {
                        scanner.close();
                        return;
                    }
                    break;
                case 2:
                    visualizzaSpedizioni();
                    System.out.print("Vuoi continuare? (s/n)? ");
                    char sceltaContinua2 = scanner.next().charAt(0);
                    if (sceltaContinua2 == 'n' || sceltaContinua2 == 'N') {
                        scanner.close();
                        return;
                    }
                    break;
                case 3:
                    calcolaTotalePenne();
                    System.out.print("Vuoi continuare? (s/n)? ");
                    char sceltaContinua3 = scanner.next().charAt(0);
                    if (sceltaContinua3 == 'n' || sceltaContinua3 == 'N') {
                        scanner.close();
                        return;
                    }
                    break;
                case 4:
                    ricercaPerColore();
                    System.out.print("Vuoi continuare? (s/n)? ");
                    char sceltaContinua4 = scanner.next().charAt(0);
                    if (sceltaContinua4 == 'n' || sceltaContinua4 == 'N') {
                        scanner.close();
                        return;
                    }
                    break;
                case 5:
                    System.out.println("Exit");
                    scanner.close();
                    return;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }
}