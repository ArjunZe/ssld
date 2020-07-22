/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infa.ssl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author mreddy
 */
public class Menu {

    public static String formattedDate;

    public static void main(String[] args) throws IOException, InterruptedException, Exception {
        Scanner in = new Scanner(System.in);
        boolean quit = false;
        String goMenu;
        int menuItem;
        do {
            System.out.println("               /\\\\\\\\\\\\\\\\\\\\\\        /\\\\\\\\\\\\\\\\\\\\\\     /\\\\\\               /\\\\\\\\\\\\\\\\\\\\\\\\            ");
            System.out.println("              /\\\\\\/////////\\\\\\    /\\\\\\/////////\\\\\\  \\/\\\\\\              \\/\\\\\\////////\\\\\\         ");
            System.out.println("              \\//\\\\\\      \\///    \\//\\\\\\      \\///   \\/\\\\\\              \\/\\\\\\      \\//\\\\\\       ");
            System.out.println("                \\////\\\\\\            \\////\\\\\\          \\/\\\\\\              \\/\\\\\\       \\/\\\\\\      ");
            System.out.println("                    \\////\\\\\\            \\////\\\\\\       \\/\\\\\\              \\/\\\\\\       \\/\\\\\\     ");
            System.out.println("                        \\////\\\\\\            \\////\\\\\\    \\/\\\\\\              \\/\\\\\\       \\/\\\\\\    ");
            System.out.println("                  /\\\\\\      \\//\\\\\\    /\\\\\\      \\//\\\\\\   \\/\\\\\\              \\/\\\\\\       /\\\\\\    ");
            System.out.println("                  \\///\\\\\\\\\\\\\\\\\\\\\\/    \\///\\\\\\\\\\\\\\\\\\\\\\/    \\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\  \\/\\\\\\\\\\\\\\\\\\\\\\\\/    ");
            System.out.println("                     \\///////////        \\///////////      \\///////////////   \\////////////     ");
            System.out.println("              -------------------------------------------------------------------------------");
            System.out.println("");
            System.out.println(" 		           1 - PKIX                         5 - UNLIMITED STRENGTH");
            System.out.println(" 		           2 - SNI                          6 - LEGACY CIPHERS");
            System.out.println(" 		           3 - LEGACY PROTOCOLS             7 - TWO WAY SSL");
            System.out.println(" 		           4 - PROXY CERTS                  8 - NOT SURE		                ");
            System.out.println("");
            System.out.print("Choose menu item (0 for quit): ");
            menuItem = in.nextInt();
            switch (menuItem) {
                case 1:
                    repeatedStuff("PKIX");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 2:
                    repeatedStuff("SNI");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 3:
                    repeatedStuff("PROTOCOLS");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 4:
                    repeatedStuff("PROXYCERTS");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 5:
                    repeatedStuff("POLICY");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 6:
                    repeatedStuff("CIPHERS");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 7:
                    repeatedStuff("TWOWAYSSL");
                    System.out.println("Do you want to test two way SSL? (y/n):");
                    if (in.next().equalsIgnoreCase("y")) {
                        repeatedStuff("TWOWAYSSLTEST");
                    }
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 8:
                    repeatedStuff("NOTSURE");
                    System.out.println("Type m goto Menu:");
                    goMenu = in.next();
                    if (goMenu.equalsIgnoreCase("m")) {
                    }
                    break;
                case 0:
                    System.out.println("Wann Clear Logs? (y/n)");
                    if (in.next().equalsIgnoreCase("y")) {
                        Menu.commander("del");
                    }
                    goMenu = in.next();
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
            //Thread.sleep(4000);
            Menu.commander("wipe");
            // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } while (!quit);
        System.out.println("Bye-bye!");
    }

    public static int commander(String command) throws InterruptedException {
        //ProcessBuilder processBuilder = new ProcessBuilder();
        String OS = System.getProperty("os.name").toLowerCase();
        //System.out.println("You are on :" + OS);
        String cmdORbash;
        String javaORdotjava;
        String finalCommand;
        String wipe;
        String whichC;
        String del;
        int exitVal = 100;
        if (OS.contains("win")) {
            cmdORbash = "cmd.exe";
            javaORdotjava = "java";
            wipe = "cls";
            whichC = "/c";
            del="del *_j.log";
        } else {
            cmdORbash = "bash";
            javaORdotjava = "./java";
            wipe = "clear";
            whichC = "-c";
            del="rm *_j.log";
        }
        if (command.contains("echo")) {
            try {
                new ProcessBuilder(cmdORbash, whichC, command).inheritIO().start().waitFor();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.contains("del")) {
            try {
                new ProcessBuilder(cmdORbash, whichC, del).inheritIO().start().waitFor();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (command.contains("wipe")) {
            try {
                new ProcessBuilder(cmdORbash, whichC, wipe).inheritIO().start().waitFor();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            finalCommand = javaORdotjava + " " + command;
            try {
                System.out.println("Waiting..");
                exitVal = new ProcessBuilder(cmdORbash, whichC, finalCommand).inheritIO().start().waitFor();
                /*if (exitVal == 0) {
                    System.out.println("Success!");
                } else {
                    System.out.println("Abnormal !");
                }*/
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return exitVal;
    }

    public static void repeatedStuff(String action) throws InterruptedException, IOException {
        String host = null;
        String cmdTxt = null;
        String logFile;
        String actionFlags = "";
        String URL = null;
        String verb = null;
        String keystore = null;
        String keypass = null;
        boolean bkp = false;
        Scanner in = new Scanner(System.in);
        if (action.equalsIgnoreCase("PKIX") | action.equalsIgnoreCase("SNI")
                | action.equalsIgnoreCase("PROTOCOLS") | action.equalsIgnoreCase("POLICY")
                | action.equalsIgnoreCase("CIPHERS") | action.equalsIgnoreCase("NOTSURE")) {
            //!true |!
            System.out.println("Enter Hostname:Port :");
            host = in.next();
        }
        logFile = action + "_j.log";
        //clear old log
        Menu.commander("echo . >" + logFile);
        //new ProcessBuilder("cmd", "/c", "echo . >"+logFile).inheritIO().start().waitFor();
        if (action.equalsIgnoreCase("PKIX")) {
            actionFlags = "";
        } else if (action.equalsIgnoreCase("SNI")) {
            System.out.println("SNI? (true/false):");
            String sni = in.next();
            if (sni.equalsIgnoreCase("true")) {
                actionFlags = "-Djsse.enableSNIExtension=true";
            } else {
                actionFlags = "-Djsse.enableSNIExtension=false";
            }
        } else if (action.equalsIgnoreCase("PROTOCOLS")) {
            actionFlags = "-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2";
        } else if (action.equalsIgnoreCase("PROXYCERTS")) {
            System.out.println("Enter ProxyHostname:ProxyPort :");
            host = in.next();
            actionFlags = "";
        } else if (action.equalsIgnoreCase("POLICY")) {
            backup();
            FileUtils.writeStringToFile(new File("..\\jre\\lib\\security\\java.security"), System.getProperty("line.separator") + "crypto.security=unlimited", true);
            actionFlags = "";
        } else if (action.equalsIgnoreCase("CIPHERS")) {
            backup();
            File file = new File("..\\jre\\lib\\security\\java.security");
            List<String> lines = FileUtils.readLines(file);
            List<String> updatedLines = lines.stream().filter(s -> !s.contains("jdk.tls.disabledAlgorithms")).collect(Collectors.toList());
            FileUtils.writeLines(file, updatedLines, false);
            actionFlags = "";
        } else if (action.equalsIgnoreCase("TWOWAYSSL")) {
            System.out.println("Enter URL :");
            URL = in.next();
            System.out.println("Enter Verb (GET, POST, etc.) :");
            verb = in.next();
            actionFlags = "";
        } else if (action.equalsIgnoreCase("TWOWAYSSLTEST")) {
            System.out.println("Enter URL :");
            URL = in.next();
            System.out.println("Enter Verb (GET, POST, etc.) :");
            verb = in.next();
            System.out.println("Enter Absolute Keystore Path:");
            keystore = in.next();
            System.out.println("Enter Keystore Password:");
            keypass = in.next();
            actionFlags = "-Djavax.net.ssl.keyStore=" + keystore + " " + "-Djavax.net.ssl.keyStorePassword=" + keypass;
        } else if (action.equalsIgnoreCase("NOTSURE")) {
            System.out.println("Do you want to try SNI? (y/n):");
            if (in.next().equalsIgnoreCase("y")) {
                actionFlags += "-Djsse.enableSNIExtension=true ";
            } else {
                actionFlags += "-Djsse.enableSNIExtension=false ";
            }
            System.out.println("Do you want to try all TLS versions? (y/n):");
            if (in.next().equalsIgnoreCase("y")) {
                actionFlags += "-Dhttps.protocols=TLSv1,TLSv1.1,TLSv1.2 ";
            }
            System.out.println("Do you want to try all legacy CIPHERS? (y/n):");
            if (in.next().equalsIgnoreCase("y")) {
                backup();
                bkp = true;
                File file = new File("..\\jre\\lib\\security\\java.security");
                List<String> lines = FileUtils.readLines(file);
                List<String> updatedLines = lines.stream().filter(s -> !s.contains("jdk.tls.disabledAlgorithms")).collect(Collectors.toList());
                FileUtils.writeLines(file, updatedLines, false);
            }
            System.out.println("Do you want to try unlimited strength? (y/n):");
            if (in.next().equalsIgnoreCase("y")) {
                if (!bkp) {
                    backup();
                }
                FileUtils.writeStringToFile(new File("..\\jre\\lib\\security\\java.security"), System.getProperty("line.separator") + "crypto.security=unlimited", true);
            }
        }
        //build Commands
        if (action.equalsIgnoreCase("TWOWAYSSL") | action.equalsIgnoreCase("TWOWAYSSLTEST")) {
            cmdTxt = "-Djavax.net.debug=ssl " + actionFlags + " -cp ssld.jar com.infa.ssl.SkipVerification " + URL + " " + verb + " >" + logFile;
        } else {
            cmdTxt = "-Djavax.net.debug=ssl " + actionFlags + " -cp ssld.jar com.infa.ssl.Diagnose " + host + " >" + logFile;
        }
        System.out.println("Command  : " + cmdTxt);
        int exitcode = Menu.commander(cmdTxt);
        //int exitcode = new ProcessBuilder("cmd", "/c", cmdTxt).inheritIO().start().waitFor();
        System.out.println("Command ExitCode : " + exitcode);
        System.out.print("Verifying..... ");
        if (FileUtils.readFileToString(new File(logFile)).contains("No errors, certificate is already trusted")
                | FileUtils.readFileToString(new File(logFile)).contains("added to 'cacerts' using alias")
                | FileUtils.readFileToString(new File(logFile)).contains("CertificateRequest")
                | FileUtils.readFileToString(new File(logFile)).contains("matching alias")) {
            if (action.equalsIgnoreCase("TWOWAYSSL")) {
                System.out.println("Two Way SSl found on this endpoint!");
            } else if (action.equalsIgnoreCase("TWOWAYSSLTEST")) {
                System.out.println("TWO WAY SSL Finished Successfully!");
            } else {
                System.out.println("Succesfull!");
            }
            if (action.equalsIgnoreCase("CIPHERS")) {
                System.out.println("However this shoud not be considered as fix but as a temp fix. This means your endpoint is using a legacy cipher.");
                System.out.println("Rolling back the changes !");
                restore();
            }
        } else {
            System.out.println("Not Succesfull!");
            if (action.equalsIgnoreCase("POLICY")) {
                System.out.println("Rolling back the changes.");
                restore();
            }
        }
    }

    public static void backup() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        formattedDate = myDateObj.format(myFormatObj);
        //System.out.println("After formatting: " + formattedDate);
        Path source = Paths.get("..\\jre\\lib\\security\\java.security");
        Path target = Paths.get("..\\jre\\lib\\security\\java.security_" + formattedDate);
        try {
            Files.copy(source, target);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void restore() {
        Path target = Paths.get("..\\jre\\lib\\security\\java.security");
        Path source = Paths.get("..\\jre\\lib\\security\\java.security_" + formattedDate);
        try {
            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
