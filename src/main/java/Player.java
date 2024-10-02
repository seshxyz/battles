import java.util.*;

public class Player {
    char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public void play(Field field) {}

}

class ComputerPlayer extends Player {
    private Random random;
    private ComputerPlayer computerPlayer;

    public ComputerPlayer() {
        this.random = new Random();
    }

    @Override
    public void play(Field field) {
        int x = random.nextInt(field.getWidth());
        int y = random.nextInt(field.getHeight());
        System.out.format("Bot shots (%d, %d)\n",x,y);
        if (field.getFields()[x][y] == 1) {
            System.out.println(">>>\nBot hit.\n>>>");
            field.getFields()[x][y] = -1;
        } else {
            field.getFields()[x][y] = 7;
            System.out.println(">>>\nBot miss.\n>>>");
        }
    }
}

class RealPlayer extends Player {
    private Scanner scanner;

    public RealPlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void play(Field field) {
        System.out.print("Enter y coordinate (A-J) or number: ");
        String input = scanner.next();
        System.out.print("To shoot enter x coordinate: ");
        int x = scanner.nextInt();
        int y = -1;
        if (input.matches("[a-jA-J]+")) {
            char letter = input.charAt(0);
            y = letter - 'A';
        } else {
            y = Integer.parseInt(input);
        }
        System.out.format("Bot shots (%d, %d)\n",x,y);
        if (field.getFields()[x][y] == 1) {
            System.out.println(">>>\nYou hit.\n>>>");
            field.getFields()[x][y] = -1;
        } else {
            field.getFields()[x][y] = 7;
            System.out.println(">>>\nYou miss.\n>>>");
        }
        System.out.println("Enemy's field:\n________________________");
        field.printField();
        System.out.println("________________________");
    }
}