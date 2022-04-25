package com.commentFucntions;

import java.util.Scanner;
import java.util.Stack;

public class Operators {
    static Scanner input = new Scanner(System.in);
    static Stack<Integer> stack = new Stack<>();

    public static void CommentIn() {
        int len;
        System.out.println("Enter your comment");
        String s = input.nextLine();
        len = s.length();
        String a[] = new String[len];


        for (int i = 0; i < len; i++) {
            a[i] = String.valueOf(s.charAt(i));

        }
        Looper(a);
    }

    //++[,>+++[,-]<-]

    public static void Looper(String a[]) {
        String k[] = a;
        int len = k.length;
        int n[] = new int[50];
        int j = 0;
        //int x = 0;
        int f = 0;

        for (int i = 0; i < len; ) {
            switch (k[i]) {
                case "+" -> {
                    n[j] += 1;
                    i++;
                }
                case "-" -> {
                    n[j] -= 1;
                    i++;
                }
                case "<" -> {
                    j--;
                    i++;
                }
                case ">" -> {
                    j++;
                    i++;
                }
                case "[" -> {
                    if (n[j] > 0) {
                        stack.push(i);
                        i++;
                    }

                }
                case "]" -> {
                    if (stack.size() > 0) {
                        if (n[j] != 0) {
                            i = stack.pop();
                        }else {
                            stack.pop();
                            i++;
                        }
                    }
                }
                case "." -> {
                    System.out.println("Enter a number : ");
                    int in = input.nextInt();
                    n[j] = in;
                    i++;
                }
                case "," -> {
                    System.out.println("Output : " + n[j]);
                    i++;
                }
                case null -> {
                    continue;
                }
                default -> System.out.println("Invalid Comment Entry!!!");
            }
        }
    }

    public static void main(String[] args) {
        CommentIn();
    }
}
