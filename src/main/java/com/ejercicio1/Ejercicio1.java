package com.ejercicio1;

import AnalizadorLexico.LexAnalizador;
import AnalizadorSintactico.ParserAnanl;

import java.io.FileReader;
import java.io.InputStreamReader;

public class Ejercicio1 {

    public static void main(String... args) throws Exception {
        if (args.length != 0) {
            parseFromFile(args[0]);
        } else {
            System.out.println("Ingrese las operaciones:");
            parseFromConsole();
        }
    }

    private static void parseFromFile(String filePath) throws Exception {
        try (FileReader fileReader = new FileReader(filePath)) {
            parse(fileReader);
        }
    }

    private static void parseFromConsole() throws Exception {
        try (InputStreamReader consoleReader = new InputStreamReader(System.in)) {
            parse(consoleReader);
        }
    }

    private static void parse(InputStreamReader reader) throws Exception {
        new ParserAnanl(new LexAnalizador(reader)).parse();
    }
}


