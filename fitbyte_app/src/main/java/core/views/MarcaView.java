/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

import core.DAO.MarcaDAO;
import core.models.Marca;
import java.util.Scanner;

/**
 *
 * @author developer
 */
public class MarcaView {
    public static void crearMarca(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre de tu marca");
        String nombre_marca = sc.nextLine();
   
        Marca registro = new Marca();
        registro.setNombre_marca(nombre_marca);
        MarcaDAO.crearMarcaDB(registro);
        
    }
    public static void listarMarcas(){
    }
    public static void borrarMarca(){
    }
    public static void editarMarca(){
    }
}
