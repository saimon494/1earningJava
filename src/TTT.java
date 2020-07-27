import java.util.Scanner;

public class TTT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 9 symbols: ");
        String s = scanner.nextLine().toUpperCase();

        String[][] str = new String[3][3];
        int k = 0; // first index in substring
        int m = 1; // last index in substring
        int countX = 0;
        int countO = 0;
        int countSpace = 0;
        int countInLineX = 0;
        int countInLineO = 0;
        boolean inLineX = false;
        boolean inLineO = false;

        System.out.println("---------");
        for (int i = 0; i < str.length; i++) {
            System.out.print("|");
            for (int j = 0; j < str[i].length; j++) {
                str[i][j] = s.substring(k, m);
                System.out.print(" " + str[i][j]);
                k++;
                m++;
                switch (str[i][j]) {
                    case "X":
                        countX++;
                        break;
                    case "O":
                        countO++;
                        break;
                    case "_":
                    case " ":
                        countSpace++;
                        break;
                }
            }
            System.out.println(" |");
        }
        System.out.println("---------");

//        System.out.println("countX = " + countX);
//        System.out.println("countO = " + countO);
//        System.out.println("countSpace = " + countSpace);

        if (Math.abs(countX - countO) < 2) {
            // check 3 in line in diagonal for X and O
            if (str[0][0].equals("X") && str[1][1].equals("X") && str[2][2].equals("X") ||
                str[0][2].equals("X") && str[1][1].equals("X") && str[2][0].equals("X")) {
                inLineX = true;
            } else if (str[0][0].equals("O") && str[1][1].equals("O") && str[2][2].equals("O") ||
                       str[0][2].equals("O") && str[1][1].equals("O") && str[2][0].equals("O")) {
                inLineO = true;
            }
            // check 3 in line in each row and column for X
            if (!inLineX) {
                for (int i = 0; i < 3; i++) {
                    if (str[i][0].equals("X") && str[i][1].equals("X") && str[i][2].equals("X") && countInLineX == 0) {
                        inLineX = true;
                        countInLineX++;
                    } else if (str[0][i].equals("X") && str[1][i].equals("X") && str[2][i].equals("X") && countInLineX == 0) {
                        inLineX = true;
                        countInLineX++;
                    }
                }
            }
            // check 3 in line in each row and column for O
            if (!inLineO) {
                for (int i = 0; i < 3; i++) {
                    if (str[i][0].equals("O") && str[i][1].equals("O") && str[i][2].equals("O") && countInLineO == 0) {
                        inLineO = true;
                        countInLineO++;
                    } else if (str[0][i].equals("O") && str[1][i].equals("O") && str[2][i].equals("O") && countInLineO == 0) {
                        inLineO = true;
                        countInLineO++;
                    }
                }
            }
//            System.out.println("inLineX = " + inLineX);
//            System.out.println("inLineO = " + inLineO);
//            System.out.println("countInLineX = " + countInLineX);
//            System.out.println("countInLineO = " + countInLineO);

            if (!inLineX && !inLineO && countSpace > 0) {
                System.out.println("Game not finished");
            } else if (!inLineX && !inLineO && countSpace == 0) {
                System.out.println("Draw");
            } else if (inLineX && !inLineO) {
                System.out.println("X wins");
            } else if (!inLineX && inLineO) {
                System.out.println("O wins");
            } else {
                System.out.println("Impossible");
            }

        } else {
            System.out.println("Impossible");
        }
    }
}

//        System.out.println("Game not finished"); // no 3, empty - xo_oox_x_
//        System.out.println("Draw"); // no 3, no empty - xoxooxxxo
//        System.out.println("X wins"); // 3 X - xxxoo__o_  xoxoxoxxo
//        System.out.println("O wins"); // 3 O - xoooxoxxo  oooxx__x_
//        System.out.println("Impossible"); // X - O >= 2 - xo_xo_xox  _o_x__x_x  _oooo_x_x

//        System.out.println("---------");
//        System.out.println("|" + " " + s.substring(0, 1) + " " + s.substring(1, 2) + " " + s.substring(2, 3) + " " + "|");
//        System.out.println("|" + " " + s.substring(3, 4) + " " + s.substring(4, 5) + " " + s.substring(5, 6) + " " + "|");
//        System.out.println("|" + " " + s.substring(6, 7) + " " + s.substring(7, 8) + " " + s.substring(8, 9) + " " + "|");
//        System.out.println("---------");