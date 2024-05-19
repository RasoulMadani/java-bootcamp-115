package com.logic;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    //connect to postgres
    public static void main(String[] args) throws SQLException, InterruptedException {
        ConnectionUtil db = new ConnectionUtil();

        Connection conn = db.connect_to_db("postgres", "root", "rZn4MeI7tuET5E5PVWcAluFO");
        db.createTable(conn, "recovery");

        while (true) {

            while (!input.hasNextInt()) { //please enter your social security number
                input.nextLine();
            }
            int socials = input.nextInt();
            if (socials == 1) {
                break;
            }
            System.out.println("Please enter the balance your will transfer");

            while (!input.hasNextDouble()) {
                input.nextLine();
            }
            double transfer = input.nextDouble();
            db.insert_row(conn, socials, transfer);
            System.out.println();
            System.out.println("would you like to continue entering data");
            System.out.println("Yes(1)/No(2)");
            while (!input.hasNextInt()) {
                input.nextLine();
            }
            if (input.nextInt() == 2) {
                db.balance(conn, "recovery");
                System.out.println("would you like to delete an entry Yes(1)/No(2)");
               while (input.nextInt() == 1) {
                    System.out.println("select an account id, press ENTER");
                    int idm = input.nextInt();
                    db.delete(conn, idm);
                    Thread.sleep(1000);
                    db.balance(conn, "recovery");
                    System.out.println();
                    System.out.println("press 2 to exit");
                    Thread.sleep(3000);
                    break;
                } break;

            } else
                System.out.println("Please enter another social security number **1 to exit program");

        }
    }
}



