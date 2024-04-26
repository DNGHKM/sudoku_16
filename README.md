# 🧩16 x 16 스도쿠 풀이 프로그램 / 16 x 16 Sudoku solver

### 📖 설명 
1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, G 로 이루어진</br>

16 x 16 사이즈의 스도쿠를 풀어주는 프로그램입니다. 

###  ✏️입력
* 주어진 칸 : 1 ~ 9 또는 A ~ G 
* 빈칸 : 0

###  👉🏻 기타 참고사항
* 영문은 대소문자 구별 없이 입력하시면 됩니다.
* 입력은 띄어쓰기 여부와 상관 없이 입력 가능합니다. (입력예시 참조)
* 입력에 오류가 있거나 정답이 없는 문제의 경우 정답이 없다는 메시지가 출력됩니다.

----
###  📖 Explain
A program that solves a 16 x 16 sudoku </br>
consisting of the letters 1, 2, 3, 4, 5, 6, 7, 8, 9, A, B, C, D, E, F, G.

### ️ ️✏️ Input
Given squares: 1 to 9 or A to G
Blank spaces: 0

### 👉🏻 Other notes
The English language is not case-sensitive.</br>
You can type with or without spaces (see example input).</br>
If there is an error in your input or the question does not have a correct answer, </br>
you will receive a message that there is no correct answer.

-----
#### ✏️ 입력 예시 1 / Input Examples 1

6 0 0 1 0 8 C 5 0 9 0 0 0 0 2 0</br>
5 0 0 G 4 0 0 0 E 0 0 D 0 0 1 0</br>
7 2 9 0 A 0 0 0 0 F 1 8 6 0 0 E</br>
B 0 3 0 0 D 0 0 4 0 0 0 5 0 9 G</br>
4 6 1 0 0 0 E 8 9 B 0 0 3 0 0 5</br>
0 0 8 B 0 1 0 9 0 G F 4 0 0 0 C</br>
E 5 D 0 0 0 F 0 0 0 6 0 0 0 A F</br>
C 9 G 7 F 0 0 4 0 0 5 E 0 0 0 0</br>
3 G 2 6 1 0 0 0 D 4 C F 0 8 0 9</br>
F A B 0 0 0 3 G 0 0 0 0 C E D 2</br>
8 0 C 0 6 2 F 0 0 A 0 0 0 G 0 0</br>
0 D 0 0 0 0 4 0 0 0 G 5 1 0 3 0</br>
0 0 4 C G F 0 0 7 6 0 A D 9 0 0</br>
0 0 6 0 0 E 8 0 0 0 0 2 4 5 0 1</br>
2 E F 0 C 0 9 1 8 5 D G B 0 6 0</br>
D B 0 0 0 0 A 7 F E 4 0 0 2 0 8</br>
</br>

-----

####  ✏️ 입력 예시 2 / Input Examples 2

600108C509000020</br>
500G4000E00D0010</br>
7290A0000F18600E</br>
B0300D004000509G</br>
461000E89B003005</br>
008B01090GF4000C</br>
E5D000F0006000AF</br>
C9G7F004005E0000</br>
3G261000D4CF0809</br>
FAB0003G0000CED2</br>
80C062F00A000G00</br>
0D00004000G51030</br>
004CGF00760AD900</br>
00600E8000024501</br>
2EF0C09185DGB060</br>
DB0000A7FE400208</br>
<br>
-----

#### 🖨️ 결과 / Result</br>

6 4 E 1 7 8 C 5 G 9 A B F 3 2 D</br>
5 F A G 4 9 2 6 E C 3 D 8 B 1 7</br>
7 2 9 D A B G 3 5 F 1 8 6 C 4 E</br>
B C 3 8 E D 1 F 4 7 2 6 5 A 9 G</br>
4 6 1 F 2 A E 8 9 B 7 C 3 D G 5</br>
A 3 8 B 5 1 D 9 2 G F 4 E 6 7 C</br>
E 5 D 2 B G F C 1 8 6 3 9 4 A F</br>
C 9 G 7 F 3 6 4 A D 5 E 2 1 8 B</br>
3 G 2 6 1 7 B E D 4 C F A 8 5 9</br>
F A B 4 9 5 3 G 6 1 8 7 C E D 2</br>
8 1 C 5 6 2 F D 3 A E 9 7 G B 4</br>
9 D 7 E 8 C 4 A B 2 G 5 1 F 3 6</br>
1 8 4 C G F 5 2 7 6 B A D 9 E 3</br>
G 7 6 A D E 8 B C 3 9 2 4 5 F 1</br>
2 E F 3 C 4 9 1 8 5 D G B 7 6 A</br>
D B 5 9 3 6 A 7 F E 4 1 G 2 C 8</br>