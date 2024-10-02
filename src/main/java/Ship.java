public class Ship {

    private int size;
    private int[] posX;
    private int[] posY;


    public Ship(int size) {
        this.size = size;
        this.posX = new int[size];
        this.posY = new int[size];
    }

    public boolean place(int x, int y, char axis, Field field) {
        if (axis == 'y') {
            for (int i = 0; i < size; i++) {
                if (x + i >= field.getWidth() || field.getFields()[y][x + i] != 0) {
                    return false;
                }
                // Проверка соседней на наличие занятого пространства сверху, снизу, слева и справа
                if (y > 0 && field.getFields()[y - 1][x + i] == 1) return false; //выше текущей
                if (y < field.getHeight() - 1 && field.getFields()[y + 1][x + i] == 1) return false;
                if (x + i > 0 && field.getFields()[y][x + i - 1] == 1) return false;
                if (x + i < field.getWidth() - 1 && field.getFields()[y][x + i + 1] == 1) return false;
            }
            for (int i = 0; i < size; i++) {
                field.getFields()[y][x + i] = 1;
                posX[i] = x + i;
                posY[i] = y;
            }
        } else if (axis == 'x') {
            for (int i = 0; i < size; i++) {
                if (y + i >= field.getHeight() || field.getFields()[y + i][x] != 0) {
                    return false;
                }
                if (x > 0 && field.getFields()[y + i][x - 1] == 1) return false;
                if (x < field.getWidth() - 1 && field.getFields()[y + i][x + 1] == 1) return false;
                if (y + i > 0 && field.getFields()[y + i - 1][x] == 1) return false;
                if (y + i < field.getHeight() - 1 && field.getFields()[y + i + 1][x] == 1) return false;
            }
            for (int i = 0; i < size; i++) {
                field.getFields()[y + i][x] = 1;
                posX[i] = x;
                posY[i] = y + i;
            }
        }
        return true;
    }
}
