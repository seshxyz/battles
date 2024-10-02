public class Field {

    private int width;
    private int height;
    private int[][] fields;
    private char[] letters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getFields() {
        return fields;
    }

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.fields = new int[height][width];
    }

    public void printField() {
        System.out.print("   ");
        for (int x = 0; x < width; x++) {
            System.out.print(letters[x] + "   ");
        }
        System.out.println();
        for (int y = 0; y < height; y++) {
            System.out.print(y + "| ");
            for (int x = 0; x < width; x++) {
                System.out.print(fields[y][x] + "   ");
            }
            System.out.println();
        }
    }

}
