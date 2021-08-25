package cz.bakterio.fileRenamer;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name of file: ");
        String in = sc.nextLine().toLowerCase();
        // System.out.println("in = " + in);
        File file = new File(in);

        if (in.equals("exit")) System.exit(0);

        if (in.equals("folder") || in.equals("dir")) {

            File folder = new File(".");
            File[] files = folder.listFiles();

            renameFiles(files);
        } else {
            if (!file.exists()) {
                System.out.println("This file doesn't exit (typo?).");
                main(args);
            }

            renameFiles(new File[]{file});
        }

        main(args);
    }

    private static void renameFiles(File[] files) {
        for (File file : files) {
            char[] oldNameChar = file.getName().toCharArray();

            StringBuilder newNameBuilder = new StringBuilder();
            for (char i : oldNameChar) {
                if (i == ' ') i = '_';
                newNameBuilder.append(i);
            }

            file.renameTo(new File(newNameBuilder.toString()));
            System.out.println("File " + newNameBuilder.toString()+ " has been renamed.");
        }
    }
}
