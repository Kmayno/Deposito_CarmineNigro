import java.util.Scanner;
public class EsercizioDoWhile {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        //creo la variabile somma
        int somma = 0;
        //creo il booleano per il controllo
        boolean continua = true;
        //creo la variabile per il numero inserito
        int numero;

        
        
        System.out.println("Inserisci i numeri che vuoi sommare");
        System.out.println("Per fermarti inserisci un numero negativo");
        
        //ciclo do-while
        do {
            //leggo il numero dato dall'utente
            numero = scanner.nextInt(); 
            if (numero >= 0) {
                //aggiungo il numero alla somma
                somma += numero; 
            } else {
                // il ciclo continua finche non lo stoppiamo
                continua = false; 
            }
            // il ciclo continua finche' e' true
        } while (continua); 

        // stampo la somma dei numeri
        System.out.println("La somma dei numeri inseriti e': " + somma);

        scanner.close();
    }
}