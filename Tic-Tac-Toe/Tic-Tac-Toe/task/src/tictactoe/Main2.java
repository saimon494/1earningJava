package tictactoe;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String s = scanner.nextLine().toUpperCase();
        String s1 = s.replace("_"," ");


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
                str[i][j] = s1.substring(k, m);
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


        int row;
        int col;

        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                try {
                    if (row > 0 && row < 4 && col > 0 && col < 4) {
                        try {
                            if (!str[3 - col][row - 1].equals("X") && !str[3 - col][row - 1].equals("O")) {
                                break;
                            } else {
                                row = row / 0;
                            }
                        } catch (Exception e) {
                            System.out.println("This cell is occupied! Choose another one!");
                            continue;
                        }
                        break;
                    } else {
                        row = row / 0;
                    }
                } catch (Exception e) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                break;

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                scanner.next();
            }
        }

        k = 0;
        m = 1;
        System.out.println("---------");
        for (int i = 0; i < str.length; i++) {
            System.out.print("|");
            for (int j = 0; j < str[i].length; j++) {
                str[i][j] = s1.substring(k, m);
                str[3 - col][row - 1] = "X";
                System.out.print(" " + str[i][j]);
                k++;
                m++;
            }
            System.out.println(" |");
        }
        System.out.println("---------");
    }
}

// new coordinate - [3 - col][row - 1]