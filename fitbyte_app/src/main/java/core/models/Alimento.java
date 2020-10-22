/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.models;

/**
 *
 * @author developer
 */
public class Alimento {
    private int id_alimento;
    private int marca_id;
    private String nombre_alimento;
    
    public Alimento(){
    }
    
     public Alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }
     
    public Alimento(String nombre_alimento, int marca_id) {
        this.nombre_alimento = nombre_alimento;
        this.marca_id = marca_id;
    }
    
    public Alimento(int id_alimento, String nombre_alimento, int marca_id) {
        this.id_alimento = id_alimento;
        this.nombre_alimento = nombre_alimento;
        this.marca_id = marca_id;
    }
    
    public int getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(int id_alimento) {
        this.id_alimento = id_alimento;
    }

    public int getMarca_id() {
        return marca_id;
    }

    public void setMarca_id(int fk_marca_id) {
        this.marca_id = fk_marca_id;
    }

    public String getNombre_alimento() {
        return nombre_alimento;
    }

    public void setNombre_alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }
    
}
