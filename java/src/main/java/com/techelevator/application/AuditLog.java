package com.techelevator.application;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class AuditLog {

    private static File logFile= new File("Audit.txt");

    public static void write(String message) {
        LocalDateTime timeStamp = LocalDateTime.now();
        String lineOfLog = timeStamp + ": " + message + " ";
        PrintWriter writer = null;
        try {
            if (logFile.exists()) {
                writer = new PrintWriter(new FileOutputStream(logFile.getAbsoluteFile(), true));
            }
            else {
                writer = new PrintWriter(logFile.getAbsoluteFile());
            }
        } catch (FileNotFoundException e) {
        }
        writer.append(lineOfLog);
        writer.flush();
        writer.close();
    }
}