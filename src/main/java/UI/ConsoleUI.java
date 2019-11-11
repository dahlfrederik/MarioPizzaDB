package UI;

import java.util.Scanner;

public class ConsoleUI {

    Scanner input = new Scanner(System.in);

    public String getInput() {
        return input.nextLine();
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    
}

