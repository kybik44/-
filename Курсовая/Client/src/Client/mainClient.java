package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

import static Client.allMenu.firstMenu;

public class mainClient {
    private static Socket clientSocket;
    public static BufferedReader in;
    public static BufferedWriter out;
    public static Scanner reader;

    public static void main(String[] args) {
        try {
            clientSocket = new Socket("localhost", 4044);
            reader = new Scanner(System.in);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        firstMenu();
    }
}