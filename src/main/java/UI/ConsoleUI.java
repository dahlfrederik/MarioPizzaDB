package UI;

import java.util.Scanner;

public class ConsoleUI implements UI{

    Scanner input = new Scanner(System.in);

    @Override
    public String getInput() {
        return input.nextLine();
    }

    @Override
    public void println(String msg) {
        System.out.println(msg);
    }

    
}

