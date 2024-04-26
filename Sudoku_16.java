import java.io.*;
import java.util.*;

public class Sudoku_16 {
    static char[][] inputArr;
    static char[][] solveArr;
    static boolean complete;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        inputArr = new char[16][16];
        solveArr = new char[16][16];
        for (int i = 0; i < 16; i++) {
            String input = br.readLine().toUpperCase().replace(" ", "");
            for (int j = 0; j < 16; j++) {
                inputArr[i][j] = input.charAt(j);
            }
        }
        for (int i = 0; i < 16; i++) {
            System.arraycopy(inputArr[i], 0, solveArr[i], 0, 16);
        }
        complete = true;
        solve(0, 0, 0);
        boolean finish = true;
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (solveArr[i][j] == '0') {
                    finish = false;
                    bw.write("정답이 없는 문제거나 입력 오류입니다.");
                    break;
                }
            }
            if(!finish) break;
        }
        if(finish) {
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 16; j++) {
                    bw.write(solveArr[i][j] + " ");
                }
                bw.write("\n");
            }
        }
        bw.flush();
    }

    private static void solve(int y, int x, int index) {
        if (y == 16) {
            return;
        }
        if (solveArr[y][x] == '0') {
            fillNum(y, x, index);
        }
        if (!complete) {
            return;
        }
        if (x <= 14) {
            solve(y, x + 1, 0);
        } else if (x == 15) {
            solve(y + 1, 0, 0);
        }
        if (!complete) {
            if (inputArr[y][x] != '0') {
                return;
            }
            solveArr[y][x] = '0';
            solve(y, x, index + 1);
        }
    }

    private static void fillNum(int y, int x, int index) {
        complete = true;
        boolean[] nums = new boolean[10];
        boolean[] alphabet = new boolean[7];
        Arrays.fill(nums, true);
        Arrays.fill(alphabet, true);
        nums[0] = false;
        for (int i = 0; i < 16; i++) {
            if ('0' <= solveArr[y][i] && solveArr[y][i] <= '9') {
                nums[solveArr[y][i] - '0'] = false;
            } else {
                alphabet[solveArr[y][i] - 'A'] = false;
            }
            if ('0' <= solveArr[i][x] && solveArr[i][x] <= '9') {
                nums[solveArr[i][x] - '0'] = false;
            } else {
                alphabet[solveArr[i][x] - 'A'] = false;
            }

        }
        for (int i = y / 4 * 4; i < y / 4 * 4 + 4; i++) {
            for (int j = x / 4 * 4; j < x / 4 * 4 + 4; j++) {
                if ('0' <= solveArr[i][j] && solveArr[i][j] <= '9') {
                    nums[solveArr[i][j] - '0'] = false;
                } else {
                    alphabet[solveArr[i][j] - 'A'] = false;
                }
            }
        }
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]) {
                list.add((char) (i + '0'));
            }
        }
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i]) {
                list.add((char) (i + 'A'));
            }
        }
        if (index > list.size() - 1) {
            complete = false;
            return;
        }
        solveArr[y][x] = list.get(index);
    }
}
