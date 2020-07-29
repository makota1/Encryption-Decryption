package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    private static String data = "";
    private static int key = 0;
    private static String mode = "enc";
    private static String in = "";
    private static String out = "";
    private static String alg = "shift";


    public static void main(String[] args) {

        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i].equals("-mode")) {
                    mode = args[i + 1];
                }
                if (args[i].equals("-key")) {
                    key = Integer.parseInt(args[i + 1]);
                }
                if (args[i].equals("-data")) {
                    data = args[i + 1];
                }
                if (args[i].equals("-in")) {
                    in = args[i + 1];
                }
                if (args[i].equals("-out")) {
                    out = args[i + 1];
                }
                if (args[i].equals("-alg")) {
                    alg = args[i + 1];
                }
            }

            switch (mode) {
                case "enc":
                    if (alg.equals("unicode")) {
                        toEncryptUnion();
                    } else {
                        toEncryptShift();
                    }
                    break;
                case "dec":
                    if (alg.equals("unicode")) {
                        toDecryptUnion();
                    } else {
                        toDecryptShift();
                    }
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println("Unknown Error");
        }

    }

    private static void toEncryptShift() {
        char[] encryptedMessage;
        char alphabet = 0;
        if (!"".equals(data)) {
            encryptedMessage = data.toCharArray();
            for (int i = 0; i < encryptedMessage.length; i++) {
                alphabet = encryptedMessage[i];
                if (alphabet >= 'a' && alphabet <= 'z') {
                    alphabet = (char) (alphabet + key);
                    if (alphabet > 'z') {
                        alphabet = (char) (alphabet + 'a' - 'z' - 1);
                    }
                    encryptedMessage[i] = alphabet;
                } else if (alphabet >= 'A' && alphabet <= 'Z') {
                    alphabet = (char) (alphabet + key);
                    if (alphabet > 'Z') {
                        alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                    }
                    encryptedMessage[i] = alphabet;
                } else {
                    encryptedMessage[i] = alphabet;
                }
            }

            System.out.println(encryptedMessage);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                File file = new File(in);
                Scanner fileScanner = new Scanner(file);
                encryptedMessage = fileScanner.nextLine().toCharArray();
                for (int i = 0; i < encryptedMessage.length; i++) {
                    alphabet = encryptedMessage[i];
                    if (alphabet >= 'a' && alphabet <= 'z') {
                        alphabet = (char) (alphabet + key);
                        if (alphabet > 'z') {
                            alphabet = (char) (alphabet + 'a' - 'z' - 1);
                        }
                        encryptedMessage[i] = alphabet;
                    } else if (alphabet >= 'A' && alphabet <= 'Z') {
                        alphabet = (char) (alphabet + key);
                        if (alphabet > 'Z') {
                            alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                        }
                        encryptedMessage[i] = alphabet;
                    } else {
                        encryptedMessage[i] = alphabet;
                    }
                }
                writer.write(encryptedMessage);
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error. File doesn't exist");
            }
        }
    }

    private static void toDecryptShift() {
        char[] encryptedMessage;
        char alphabet = 0;
        if (!"".equals(data)) {
            encryptedMessage = data.toCharArray();
            for (int i = 0; i < encryptedMessage.length; i++) {
                alphabet = encryptedMessage[i];
                if (alphabet >= 'a' && alphabet <= 'z') {
                    alphabet = (char) (alphabet - key);
                    if (alphabet < 'a') {
                        alphabet = (char) (alphabet - 'a' + 'z' + 1);
                    }
                    encryptedMessage[i] = alphabet;
                } else if (alphabet >= 'A' && alphabet <= 'Z') {
                    alphabet = (char) (alphabet - key);
                    if (alphabet < 'A') {
                        alphabet = (char) (alphabet - 'A' + 'Z' + 1);
                    }
                    encryptedMessage[i] = alphabet;
                } else {
                    encryptedMessage[i] = alphabet;
                }
            }

            System.out.println(encryptedMessage);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                File file = new File(in);
                Scanner fileScanner = new Scanner(file);
                encryptedMessage = fileScanner.nextLine().toCharArray();
                for (int i = 0; i < encryptedMessage.length; i++) {
                    alphabet = encryptedMessage[i];
                    if (alphabet >= 'a' && alphabet <= 'z') {
                        alphabet = (char) (alphabet - key);
                        if (alphabet < 'a') {
                            alphabet = (char) (alphabet - 'a' + 'z' + 1);
                        }
                        encryptedMessage[i] = alphabet;
                    } else if (alphabet >= 'A' && alphabet <= 'Z') {
                        alphabet = (char) (alphabet - key);
                        if (alphabet < 'A') {
                            alphabet = (char) (alphabet - 'A' + 'Z' + 1);
                        }
                        encryptedMessage[i] = alphabet;
                    } else {
                        encryptedMessage[i] = alphabet;
                    }
                }
                writer.write(encryptedMessage);
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error. File doesn't exist");
            }
        }
    }

    public static void toEncryptUnion() {
        char[] encryptedMessage;

        if (!"".equals(data)) {
            encryptedMessage = data.toCharArray();
            for (int i = 0; i < encryptedMessage.length; i++) {
                encryptedMessage[i] += key;
            }
            System.out.println(encryptedMessage);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                File file = new File(in);
                Scanner fileScanner = new Scanner(file);
                encryptedMessage = fileScanner.nextLine().toCharArray();
                for (int i = 0; i < encryptedMessage.length; i++) {
                    encryptedMessage[i] += key;
                }
                writer.write(encryptedMessage);
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error. File doesn't exist");
            }
        }
    }

    public static void toDecryptUnion() {
        char[] encryptedMessage;

        if (!"".equals(data)) {
            encryptedMessage = data.toCharArray();
            for (int i = 0; i < encryptedMessage.length; i++) {
                encryptedMessage[i] -= key;
            }
            System.out.println(encryptedMessage);
        } else {
            try (FileWriter writer = new FileWriter(out)) {
                File file = new File(in);
                Scanner fileScanner = new Scanner(file);
                encryptedMessage = fileScanner.nextLine().toCharArray();
                for (int i = 0; i < encryptedMessage.length; i++) {
                    encryptedMessage[i] -= key;
                }
                writer.write(encryptedMessage);
                fileScanner.close();
            } catch (Exception e) {
                System.out.println("Error. File doesn't exist");
            }
        }
    }
}

