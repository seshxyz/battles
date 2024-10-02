import java.util.Random;

class Battleship {

    private Field field;
    private Ship[] ships;
    private Player computerPlayer;
    private Player realPlayer;

    public Battleship() {
        this.field = new Field(10, 10);
        this.ships = new Ship[10];
        for (int i = 0; i < 4; i++) {
            ships[i] = new Ship(1);
        }
        for (int i = 4; i < 7; i++) {
            ships[i] = new Ship(2);
        }
        for (int i = 7; i < 9; i++) {
            ships[i] = new Ship(3);
        }
        ships[9] = new Ship(4);
        this.computerPlayer = new ComputerPlayer();
        this.realPlayer = new RealPlayer();
    }

    public void placeShips() {
        Random random = new Random();
        for (Ship ship : ships) {
            while (true) {
                int x = random.nextInt(field.getWidth());
                int y = random.nextInt(field.getHeight());
                char axis = (char) (random.nextBoolean() ? 'y' : 'x');
                if (ship.place(x, y, axis, field)) {
                    break;
                }
            }
        }
    }

    public void play() {
        placeShips();
        while (true) {
            realPlayer.play(field);
            if (hasWon(field, realPlayer)) {
                System.out.println("You win.");
                break;
            }
            computerPlayer.play(field);
            if (hasWon(field, computerPlayer)) {
                System.out.println("B0T win.");
                break;
            }
        }
    }

    private boolean hasWon(Field field, Player player) {
        for (int i = 0; i < field.getHeight(); i++) {
            for (int j = 0; j < field.getWidth(); j++) {
                if (field.getFields()[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Battleship game = new Battleship();
        game.play();
    }
}
