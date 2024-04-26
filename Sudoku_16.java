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

        // 입력 받기
        for (int i = 0; i < 16; i++) {
            String input = br.readLine().toUpperCase().replaceAll(" ", "");
            for (int j = 0; j < 16; j++) {
                inputArr[i][j] = input.charAt(j);
            }
        }

        // 입력 복사
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
                    bw.write("정답이 없는 문제거나 입력 오류입니다.\nThe question doesn't have a correct answer or is a typing error.");
                    break;
                }
            }
            if (!finish) break;
        }

        if (finish) {
            bw.write("<RESULT> \n");
            bw.write("――――――――――――――――――――――――\n");
            for (int i = 0; i < 16; i++) {
                bw.write("│ ");
                for (int j = 0; j < 16; j++) {
                    bw.write(solveArr[i][j] + " ");
                    if ((j + 1) % 4 == 0) {
                        bw.write("│ ");
                    }
                }
                if ((i + 1) % 4 == 0) {
                    bw.write("\n――――――――――――――――――――――――");
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
        if (!complete && inputArr[y][x] == '0') {
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
            char currChar = solveArr[y][i];
            if ('0' <= currChar && currChar <= '9') {
                nums[currChar - '0'] = false;
            } else {
                alphabet[currChar - 'A'] = false;
            }

            currChar = solveArr[i][x];
            if ('0' <= currChar && currChar <= '9') {
                nums[currChar - '0'] = false;
            } else {
                alphabet[currChar - 'A'] = false;
            }
        }

        for (int i = y / 4 * 4; i < y / 4 * 4 + 4; i++) {
            for (int j = x / 4 * 4; j < x / 4 * 4 + 4; j++) {
                char currChar = solveArr[i][j];
                if ('0' <= currChar && currChar <= '9') {
                    nums[currChar - '0'] = false;
                } else {
                    alphabet[currChar - 'A'] = false;
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

        if (index < list.size()) {
            solveArr[y][x] = list.get(index);
        } else {
            complete = false;
        }
    }
}