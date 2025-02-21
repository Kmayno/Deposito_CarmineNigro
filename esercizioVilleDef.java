import java.util.ArrayList;
import java.util.Scanner;

public class esercizioVilleDef {
    //uso un unico ArrayList per memorizzare tutte le info delle ville come stringhe
    private static final ArrayList<String> ville = new ArrayList<>();
    //scanner per input da tastiera
    private static final Scanner scanner = new Scanner(System.in);


    //funzione per aggiungere una villa
    private static void aggiungiVilla() {
        //chiede all'utente di inserire il nome della villa
        System.out.println("Come si chiama la villa? ");
        String nome = scanner.nextLine();
        
        //chiede all'utente di inserire un numero
        System.out.println("Ora inserisci il numero di stanze: ");
        int numeroStanze = scanner.nextInt();
        scanner.nextLine();
        
        //chiede all'utente se la villa ha una piscina o meno
        System.out.println("La villa ha una piscina? ");
        System.out.println("Inserisci \"si\" o \"no\". ");
        //trim rimuove gli spazi e toLowerCase riduce tutto in minuscolo
        String piscina = scanner.nextLine().trim().toLowerCase();
        
        // Salva tutti i dati come una singola stringa nell'ArrayList
        String villa = nome + ", Stanze: " + numeroStanze + ", Piscina: " + (piscina.equals("sì") ? "Sì" : "No");
        ville.add(villa);
        System.out.println("Villa aggiunta con successo!");
    }

    //funzione per visualizzare le ville registrate
    private static void visualizzaVille() {
        //utilizzo isEmpty per fare un check
        if (ville.isEmpty()) {
            System.out.println("Nessuna villa registrata a questo nome.");
        } else {
            //mostra le ville salvate nell'arraylist
            System.out.println("Ecco l'elenco delle ville registrate:");
            for (String villa : ville) {
                System.out.println(villa);
            }
        }
    }

    //funzione per cercare una villa specifica usando il nome
    private static void cercaVilla() {
        System.out.println("Inserisci il nome della villa che vuoi cercare: ");
        String nomeCercato = scanner.nextLine().trim().toLowerCase();
        boolean trovata = false;

        for (String villa : ville) {
            // controllo se il nome cercato corrisponde ad uno dei nomi nell'arraylist
            if (villa.toLowerCase().startsWith(nomeCercato + ",")) { 
                System.out.println("Ecco le specifiche della villa:");
                System.out.println(villa);
                trovata = true;
                //forzo l'interruzione del ciclo se ha trovato una villa
                break;
            }
        }

        if (!trovata) {
            System.out.println("Non ho trovato alcuna villa con questo nome.");
        }
    }



    public static void main(String[] args) {
        int scelta;
        do {
            System.err.println("Benvenuto!");
            System.out.println("Scegli cosa fare.");
            System.out.println("1) Aggiungi una villa.");
            System.out.println("2) Visualizza tutte le ville dell'archivio.");
            System.out.println("3) Cerca una villa per nome.");
            System.out.println("4) Esci.");
            System.out.println("Scelta: ");
            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    aggiungiVilla();
                    System.out.print("Vuoi continuare (1/2)? ");

                    int sceltaContinua = scanner.nextInt();
                    if (sceltaContinua == 2) {
                        scanner.close();
                        return;
                    }
                    break;
                case 2:
                    visualizzaVille();
                    System.out.print("Vuoi continuare (s/n)? ");

                    char sceltaContinua1 = scanner.next().charAt(0);
                    if (sceltaContinua1 == 'n' || sceltaContinua1 == 'N') {
                        scanner.close();
                        return;
                    }
                    break;
                case 3:
                    cercaVilla();
                    System.out.print("Vuoi continuare (s/n)? ");

                    char sceltaContinua2 = scanner.next().charAt(0);
                    if (sceltaContinua2 == 'n' || sceltaContinua2 == 'N') {
                        scanner.close();
                        return;
                    }
                    break;
                case 4:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida, riprova.");
            }
        } while (scelta != 4);
    }

}
