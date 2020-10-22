/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fitbyte_app;

import core.views.AlimentoService;
import core.views.MarcaView;
import java.sql.Connection;
import java.util.Scanner;
/**
 *
 * @author developer
 */
public class App {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void showMenu(){
            System.out.println("-----------------------------------");
            System.out.println(" 1. crear marca");
            System.out.println(" 2. crear alimento");
            System.out.println(" 4. buscador");
            System.out.println(" 5. borrar un alimento");
            System.out.println(" 6. actualizar un alimento ");
            System.out.println(" 7. salir ");
            System.out.println("-----------------------------------");
            System.out.print("> ");
    }
    public static void processOption(String option){
            switch (option){
                case "1":
                    MarcaView.crearMarca();
                    break;
                case "2":
                    AlimentoService.create();
                    break;
                case "4":
                    AlimentoService.find();
                    break;
                case "5":
                    AlimentoService.delete();
                    break;
                case "6":
                    AlimentoService.update();
                    break;
                default:
                    break;
            }
    }
    public static void main(String[] args) {
        System.out.println(" FitByte");
        ConnectionProvider conexion = new ConnectionProvider();
        Scanner sc = new Scanner(System.in);
        String option;
        do{                
            showMenu();
            //leemos la opcion del usuario
            option = scanner.nextLine();
            processOption(option);                    
        }while(!"7".equals(option));
    }
    
}
