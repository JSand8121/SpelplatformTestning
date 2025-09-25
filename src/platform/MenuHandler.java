package platform;

import java.util.Scanner;
import Burr.StartGame;
import Bysen.Bysen;
import Snake.Snake;
import Wouu.Game;

/**
 * Instans av spelplatformens logik
 * */
public class MenuHandler {
    public MenuHandler(){}

    HighScoreHandler hsHandler = new HighScoreHandler();

    public void RunMenu(String[] args){
        boolean stayOpen = true;

        UI ui = new UI();
        Scanner scanner = new Scanner(System.in);

        do {
            //Show menu
            System.out.println(ui.MainMenu());

            try {

                String input = scanner.nextLine();
                char choice = input.toCharArray()[0];

                switch (choice) {
                    case '1':
                        StartGame burr = new StartGame();
                        burr.start();
                        break;
                    case '2':
                        Bysen.main(args);
                        break;
                    case '3':
                        Snake.main(args);
                        break;
                    case '4':
                        Game wouu = new Game();
                        wouu.play();
                        break;
                    case '5':
                        System.out.println(hsHandler.showHighScores());
                        break;
                    case '0':
                        stayOpen = false;
                        System.out.println("Tack för att komma! Vi ses igen!");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
                throw e;
            }

        }while (stayOpen);

    }
}
