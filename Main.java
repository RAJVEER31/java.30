public class Main {
    static int N = 4;
    static int[]ld = new int [30];
    static int[]rd = new int [30];
    static int[]cl = new int [30];
    static void printsolution(int board[][]){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean solnqueens(int board[][], int col) {
        if (col == N) {
            return true;
        }
        for (int i = 0; i < N; i++) {
            if ((ld[i- col + N - 1]!= 1 && rd[i + col] != 1 && cl[i] != 1)) {
                board [i][col] = 1;
                ld[i - col + N - 1] = 1;
                rd[i + col] = 1;
                cl[i] = 1;
                if (solnqueens(board, col + 1)) {
                    return true;
                }
            board[i][col] = 0;
            ld[i - col + N - 1] = 0;
            rd[i + col] = 0;
            cl[i] = 0; 
            }
        }
        return false;
    }
    public static boolean solnq(){
        int board[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        if (solnqueens(board,0) == false) {
            System.out.println("solution does not exist");
            return false;
        }
        printsolution(board);
        return true;
    }
    public static void main(String[] args) {
        solnq();
    }
}
