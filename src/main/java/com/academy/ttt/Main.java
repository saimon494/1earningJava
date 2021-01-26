package com.academy.ttt;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int row;
        int col;
        String s = "XO";
        int k = 0;
        int m = 1;
        int countSpace = 9;
        int countInLineX = 0;
        int countInLineO = 0;
        boolean inLineX = false;
        boolean inLineO = false;

        String[][] str = new String[3][3];
        Scanner scanner = new Scanner(System.in);

        System.out.println("---------");
        for (int i = 0; i < str.length; i++) {
            System.out.print("|");
            for (int j = 0; j < str[i].length; j++) {
                str[i][j] = " ";
                System.out.print(" " + str[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("---------");

        while (true) {
            System.out.print("Enter the coordinates: ");

            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                try {
                    if (row > 0 && row < 4 && col > 0 && col < 4) {
                        try {

                            if (!str[3 - col][row - 1].equals("X") && !str[3 - col][row - 1].equals("O")) {
                                str[3 - col][row - 1] = s.substring(k, m);
                                countSpace--;
                                if (k == 1 && m == 2) {
                                    k = 0;
                                    m = 1;
                                } else {
                                    k++;
                                    m++;
                                }

                                System.out.println("---------");
                                for (int i = 0; i < str.length; i++) {
                                    System.out.print("|");
                                    for (int j = 0; j < str[i].length; j++) {
                                        System.out.print(" " + str[i][j]);
                                    }
                                    System.out.println(" |");
                                }
                                System.out.println("---------");

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
                                        if (str[i][0].equals("X") && str[i][1].equals("X") &&
                                                str[i][2].equals("X") && countInLineX == 0) {
                                            inLineX = true;
                                            countInLineX++;
                                        } else if (str[0][i].equals("X") && str[1][i].equals("X") &&
                                                str[2][i].equals("X") && countInLineX == 0) {
                                            inLineX = true;
                                            countInLineX++;
                                        }
                                    }
                                }

                                // check 3 in line in each row and column for O
                                if (!inLineO) {
                                    for (int i = 0; i < 3; i++) {
                                        if (str[i][0].equals("O") && str[i][1].equals("O") &&
                                                str[i][2].equals("O") && countInLineO == 0) {
                                            inLineO = true;
                                            countInLineO++;
                                        } else if (str[0][i].equals("O") && str[1][i].equals("O") &&
                                                str[2][i].equals("O") && countInLineO == 0) {
                                            inLineO = true;
                                            countInLineO++;
                                        }
                                    }
                                }

                                if (!inLineX && !inLineO && countSpace == 0) {
                                    System.out.println("Draw");
                                    break;
                                } else if (inLineX && !inLineO) {
                                    System.out.println("X wins");
                                    break;
                                } else if (!inLineX && inLineO) {
                                    System.out.println("O wins");
                                    break;
                                }

                                continue;
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
    }
}
