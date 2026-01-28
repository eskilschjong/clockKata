package assignment;


public class ClockCipher {

    public static char[][] generateSquare(String message){

        int length = message.length();
        int[][] order = generateOrder(4);
        char [][] square = new char[4][4];
        int count = 0;
        for (int[] cord : order){
            char ch = (count < message.length()) ? message.charAt(count) : ' ';
            square[cord[0]][cord[1]] = ch;
            count++;
        }
        return square;
    }

    public static int[][] generateOrder(int size){
        int[][] order = new int[size * size][2];
        boolean[][] visited = new boolean[size][size];
        int pos = 0;

        for (int layer = 0; layer <= (size - 1) / 2; layer++) {
            for (int offset = layer; offset <= size - 1 - layer; offset++) {
                int[][] coords = {
                        {layer, offset},
                        {offset, size - 1 - layer},
                        {size - 1 - layer, size - 1 - offset},
                        {size - 1 - offset, layer}
                };
                for (int[] c : coords) {
                    int r = c[0], col = c[1];
                    if (!visited[r][col]) {
                        order[pos][0] = r;
                        order[pos][1] = col;
                        visited[r][col] = true;
                        pos++;
                    }
                }
            }
        }
        return order;
    }



    public static String squareToString(char[][] square){
        StringBuilder sb = new StringBuilder();
        for (char[] row : square){
            for (char c : row){
                if (c == '\0') continue;
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String encrypt(String message){
        return squareToString(generateSquare(message));
    }
}
