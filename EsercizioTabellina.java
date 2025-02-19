import java.util.Scanner;

public class EsercizioTabellina {
        public static void main(String[] args) {
        // variabile scanner
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Benvenuto!");
        System.out.println("Inserisci un numero: ");
        //leggiamo l'input dell'utente
        int numero = scanner.nextInt();

        //variabile per il ciclo
        int i = 0;

        // uso il ciclo while per calcolare e stampare la tabellina
        while (i <= 10) {
            //calcola e stampa i risultati
            System.out.println(numero + " * " + i + " = " + (numero * i));
            //incremento il contatore del ciclo
            i++;
        }

        scanner.close();
    }
}

