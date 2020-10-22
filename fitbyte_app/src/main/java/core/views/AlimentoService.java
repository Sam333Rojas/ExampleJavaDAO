/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.views;

import core.DAO.AlimentoDAO;
import core.models.Alimento;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author developer
 */
public class AlimentoService {
    public static final String THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE = "El ID indicado no existe";
    private static final Scanner scanner = new Scanner(System.in);
    
    public static void find(){
        System.out.println("indica el id del alimento a mostrar (0 oara todos los alimentos) \n >");
        int id_alimento = scanner.nextInt();
        if(id_alimento != 0){
            scanner.nextLine(); // Eat enter
            Alimento alimento = AlimentoDAO.find(id_alimento);
            if(alimento != null){                
                System.out.println(""+ alimento.getId_alimento());
                System.out.println("ID alimento: "+ alimento.getId_alimento() );
                System.out.println("nombre alimento : "+ alimento.getNombre_alimento());
                System.out.println("id marca : " + alimento.getMarca_id());        
            }else{
                System.out.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);    
            }
        }else{
            ArrayList<Alimento> data = AlimentoDAO.findAll();
            for(Alimento i : data){
                System.out.println("ID alimento: "+ i.getId_alimento() );
                System.out.println("nombre alimento : "+ i.getNombre_alimento());
                System.out.println("id marca : " + i.getMarca_id());
            }
        }
    }
    
    public static void create(){
        Alimento registro = new Alimento();
        System.out.println("------------------------");
        System.out.println("Escribe el nombre de tu alimento");
        registro.setNombre_alimento(scanner.nextLine());
        System.out.println("Tu alimento tiene marca? (true/false) \n >");
        boolean foo = scanner.nextBoolean();
        if(foo == true){
            System.out.println("------------------------");
            System.out.println("tu alimento tiene marca");
            System.out.println("cual es el id de la marca de tu alimento");
            registro.setMarca_id(scanner.nextInt());
        }else if(foo ==false){
            System.out.println("------------------------");
            System.out.println("tu alimento no tiene marca");
            registro.setMarca_id(1);
        }
        
        if(AlimentoDAO.create(registro)>0){
            System.out.println("El alimento fue creado");
        }else{
            System.out.println("Hubo un error al crear el alimento");
        }
        
    }
    
    public static void update(){
        int opcion;
        System.out.println("indica el id del alimento a actualizar");
        Alimento alimento = AlimentoDAO.find(scanner.nextInt());
        System.out.println("----------------------");
        System.out.println("info del actual alimento que deseas cambiar");
        System.out.println("id:" + alimento.getId_alimento());
        System.out.println("nombre:" + alimento.getNombre_alimento());
        System.out.println("id marca del alimento:"+ alimento.getMarca_id());
        System.out.println("----------------------");
        System.out.println("Deseas cambiar:");
        System.out.println("1.nombre del alimento");
        System.out.println("2.marca del alimento");
        opcion = scanner.nextInt();
        System.out.println("----------------------");
        if(alimento != null){
            switch(opcion){
                case 1:
                    System.out.println("indica el nuevo nombre del alimento");
                    scanner.nextLine(); // Eat enter
                    alimento.setNombre_alimento(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("indica el id de la  nueva marca del alimento");
                    alimento.setMarca_id(scanner.nextInt());
                    break;
                default:
                    break;
            }

            if(AlimentoDAO.update(alimento)>0){
                System.out.println("el alimento fue actualizado");        
            }else{
                System.out.println("hubo un error al actualizar el alimento");
            }
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }

    }
   
    
    public static void delete(){
        System.out.println("indica el ID del alimento a borrar \n >");
        if(AlimentoDAO.delete(scanner.nextInt())>0){
            System.out.println("El alimento fue borrado");
        }else{
            System.err.println(THE_ID_DOES_NOT_EXIST_ERROR_MESSAGE);
        }
        scanner.nextLine(); // Eat enter
    }
    
    
}
