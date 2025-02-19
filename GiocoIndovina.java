import java.util.Random;
import java.util.Scanner;

public class GiocoIndovina {
        public static void main(String[] args) {
        //dichiaro le variabili
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //setto il booleano per continuare la partita su true
        boolean continua = true;
        
        System.out.println("Benvenuto");
        System.out.println("Sei pronto a giocare con me?");
        //menu rudimentale
        System.out.println("1) Prontissimo!");
        System.out.println("2) Non troppo...");
        int pronto = scanner.nextInt();

    

        if(pronto==1){
            
            System.out.println("Perfetto allora, iniziamo ;)");

            //while booleano per iniziare a giocare e reiterare il gioco nel caso in cui l'utente lo voglia
            while (continua) {
            // Genero un numero casuale tra 1 e 100
            int numeroSegreto = random.nextInt(100) + 1; 
            // Valore scelta utente
            int tentativo;
            // booleano di controllo
            boolean indovinato = false;
            
            System.out.println("Ho scelto a caso un numero tra 1 e 100. Vediamo cosa sai fare!");
            //while del gioco effettivo
            while (!indovinato) {
                System.out.print("Dimmi un numero: ");
                tentativo = scanner.nextInt();

                if (tentativo > numeroSegreto) {
                    //numero troppo alto
                    System.out.println("L'hai sparata alta! Riprova");
                } else if (tentativo < numeroSegreto) {
                    //numero troppo basso
                    System.out.println("L'hai sparata bassa.. Riprova");
                } else {
                   
                    System.out.println("Sei un fenomeno! Il numero era " + numeroSegreto + "!");
                    // setto il booleano su true ed esco dal ciclo
                    indovinato = true;
                }
            }

            //if per chiedere all'utente se vuole continuare a giocare
            System.out.println("Vuoi giocare ancora?");
            System.out.println("1) No");
            System.out.println("2) Si");
            int risposta = scanner.nextInt();
            if (risposta != 2) {
                continua = false;
                System.out.println("Grazie per aver giocato! A presto!");
            }
            
        } 

        }else {
            //uscita nel caso in cui l'utente non si senta pronto per iniziare a giocare
            System.out.println("Alla prossima allora!!");
        }
         

        scanner.close();
    }
}

