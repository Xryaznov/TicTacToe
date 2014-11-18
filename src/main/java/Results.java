import java.util.Arrays;

public enum Results {
    ARRAY(new int[][]{
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {6, 4, 2}
    });

    private int[][] array;

    private Results(int[][] array) {
        this.array = array;
    }

    public int[][] getArray() {
        return array;
    }

    public static void main(String[] args) {
        int[][] results = Results.ARRAY.getArray();
        System.out.println(Arrays.asList(results));
    }
}
