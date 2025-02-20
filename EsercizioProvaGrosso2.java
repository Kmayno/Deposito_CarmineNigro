import java.util.ArrayList;
import java.util.Scanner;

public class EsercizioProvaGrosso2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // array list necessari
        ArrayList<String> nomiClienti = new ArrayList<>();
        ArrayList<Integer> righePosti = new ArrayList<>();
        ArrayList<Integer> colonnePosti = new ArrayList<>();
        // Arraylist per tenere traccia dei posti occupati
        ArrayList<Boolean> postiOccupati = new ArrayList<>(); 


        while (true) {
            System.out.println("Benvenuto nel Sistema Prenotazioni");
            System.out.println("Cosa vuoi fare oggi?");
            System.out.println("1. Prenota posto");
            System.out.println("2. Cerca prenotazione");
            System.out.println("3. Visualizza posti");
            System.out.println("4. Report posti");
            System.out.println("5. Esci");
            System.out.print("Come vuoi procedere? ");
            int scelta = input.nextInt();

            switch (scelta) {
                // 1.Prenotazione del posto
                case 1:
                    System.out.print("Nome: ");
                    String nome = input.next();
                    System.out.print("Inserisci Riga tra 1 e 3: ");
                    //conversione indice
                    int riga = input.nextInt() - 1; 
                    System.out.print("Inserisci la Colonna tra 1 e 8: ");
                    // Conversione indice 
                    int colonna = input.nextInt() - 1; 
                    // Calcola l'indice del posto nell'ArrayList
                    int indice = riga * 8 + colonna; 

                    if (riga < 0 || riga >= 3 || colonna < 0 || colonna >= 8) {
                        //verifica se il posto e' valido
                        System.out.println("Posto non valido.");
                        break; 
                    }

                    // Verifica se il posto è già occupato
                    if (indice < postiOccupati.size() && postiOccupati.get(indice)) {
                        System.out.println("Posto già occupato.");
                    } else {
                        // Marca il posto come occupato nell'ArrayList
                        while (postiOccupati.size() <= indice) {
                        // Aggiungi elementi 'false' se necessario
                            postiOccupati.add(false); 
                        }
                        postiOccupati.set(indice, true);

                        nomiClienti.add(nome);
                        righePosti.add(riga);
                        colonnePosti.add(colonna);
                        System.out.println("Prenotazione effettuata con successo.");
                    }
                    System.out.print("Vuoi continuare (s/n)? ");
                    char sceltaContinua = input.next().charAt(0);
                    if (sceltaContinua == 'n' || sceltaContinua == 'N') {
                        input.close();
                        return;
                    }
                    break;

                case 2:
                    // 2. Ricerca del posto
                    System.out.print("Nome da cercare: ");
                    String nomeCerca = input.next();

                    boolean trovata = false;
                    for (int i = 0; i < nomiClienti.size(); i++) {
                        if (nomiClienti.get(i).equals(nomeCerca)) {
                            System.out.println("Nome: " + nomiClienti.get(i) + ", Posto: " + (righePosti.get(i) + 1) + "-" + (colonnePosti.get(i) + 1));
                            trovata = true;
                        }
                    }

                    if (!trovata) {
                        System.out.println("Non ho trovato alcuna prenotazione per " + nomeCerca + ".");
                    }

                    System.out.print("Vuoi continuare (s/n)? ");
                    char sceltaContinua2 = input.next().charAt(0);
                    if (sceltaContinua2 == 'n' || sceltaContinua2 == 'N') {
                        input.close();
                        return;
                    }
                    break;

                case 3:
                    // 3. Visualizza posti con ArrayList
                    System.out.println("Ecco una mappa visuale dei posti.");

                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 8; j++) {
                            int indicePosto = i * 8 + j;
                            if (indicePosto < postiOccupati.size() && postiOccupati.get(indicePosto)) {
                                System.out.print("X "); // X = occupato
                            } else {
                                System.out.print("O "); // O = libero
                            }
                        }
                        System.out.println();
                    }
                    System.out.print("Vuoi continuare (s/n)? ");
                    char sceltaContinua3 = input.next().charAt(0);
                    if (sceltaContinua3 == 'n' || sceltaContinua3 == 'N') {
                        input.close();
                        return;
                    }
                    break;

                case 4: // Report posti
                    int postiTotali = 3 * 8;
                    int postiOccupatiCount = 0;
                    for (Boolean occupato : postiOccupati) {
                        if (occupato) {
                            postiOccupatiCount++;
                        }
                    }
                    int postiLiberi = postiTotali - postiOccupatiCount;

                    System.out.println("Ecco il report dei posti: ");
                    System.out.println("Posti totali: " + postiTotali);
                    System.out.println("Posti occupati: " + postiOccupatiCount);
                    System.out.println("Posti liberi: " + postiLiberi);
                    System.out.print("Vuoi continuare (s/n)? ");

                    char sceltaContinua4 = input.next().charAt(0);
                    if (sceltaContinua4 == 'n' || sceltaContinua4 == 'N') {
                        input.close();
                        return;
                    }
                    break;

                case 5:
                    // Esci dal programma

                    input.close();
                    return;

                default:
                    System.out.println("Scelta non valida.");
            }
        }
    }
}