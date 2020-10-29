import java.util.Random;
import java.util.Scanner;

public class Roulette {
    public static void main(String[] args) {
        //variabele voor getallen roulette
        short number = 0;
        //variabele voor uitkomst getal
        int uitkomst = 0;
        short userGuess;
        short bedrag = 100;
        short inzet = -5;
        short winst = 5;
        byte rondes = 10;
        boolean evenGuess = false;
        boolean onevenGuess = false;
        boolean evenValue = false;
        boolean onevenValue = false;


        String vraag = "Zet in op een even of oneven getal van 1 t/m 36";
        String gok = "Je hebt ingezet op ";
        String uitslag = "Het balletje is gevallen op ";

        //array aanmaken voor nummers 0 t/m 36
        short[] rouletteValues = new short[37];
        //array vullen met waarden 0 t/m 36
        for (short value = 0; value < rouletteValues.length; value++) {
            rouletteValues[value] = number;
            number++;
        }
        //
        boolean endplay = false;
        do {
            //loop om het spel 10 keer te spelen
            for (byte i = 0; i < 10; i++) {
                //stoppen als geld op is
                if (bedrag == 0) {
                    System.out.println("Je geld is op. GameOver!!");
                    endplay = true;
                    break;
                }
                //random nummer uit de roulette kiezen
                Random r = new Random();
                uitkomst = r.nextInt(number);

            }
            //cheat code
            //System.out.println(uitkomst);
            if (uitkomst % 2 == 0) {
                //System.out.println("even getal");
                evenValue=true;
                onevenValue=false;
            } else {
                //System.out.println("oneven getal");
                onevenValue=true;
                evenValue=false;
            }
            //gebruikersinvoer s initiëren
            Scanner s = new Scanner(System.in);
            do {
                System.out.println(vraag);
                userGuess = s.nextShort();
                if (userGuess % 2 == 0) {
                    evenGuess=true;
                    onevenGuess=false;
                    System.out.println("even getal");
                } else {
                    System.out.println("oneven getal");
                    onevenGuess=true;
                    evenGuess=false;
                }
            } while (userGuess < 1 || userGuess > 36);
            System.out.println(gok + userGuess);
            System.out.println(uitslag + uitkomst);
            if (uitkomst == 0) {
                System.out.println("Casino takes it all");
            } else if (((Boolean.compare(evenGuess, evenValue) == 0) || (Boolean.compare(onevenGuess, onevenValue) == 0))) {
                System.out.println("You win!!");
                bedrag = (short) (bedrag + winst);
            } else {
                System.out.println("You lost!");
                bedrag = (short) (bedrag - inzet);
            }
            rondes--;
            System.out.println("Je hebt $ " + bedrag + " om in te zetten en nog " + (rondes) + " rondes te gaan");
            if (rondes == 0) {
                System.out.println("Het spel is afgelopen. Wil je nog een keer spelen? (y of n)");
                boolean control = false;
                do {
                    String antwoord = s.next();
                    System.out.println("Antwoord met y of n");
                    if (antwoord.equals("y")) {
                        endplay = false;
                        control = true;
                        rondes = 10;
                    } else if (antwoord.equals("n")) {
                        endplay = true;
                        control = true;
                    }
                } while (!control);

            }


            //blijven doorlopen terwijl endplay false is
        } while (!endplay);

    }

}