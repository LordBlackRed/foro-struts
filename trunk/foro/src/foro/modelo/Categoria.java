package foro.modelo;
// Generated 12-jun-2012 13:39:35 by Hibernate Tools 3.4.0.CR1


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Categoria generated by hbm2java
 */
public class Categoria  implements java.io.Serializable {


     private int id;
     private String nombre;
     private List<Topic> topics = new ArrayList<Topic>();

    public Categoria() {
    }

	
    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public Categoria(int id, String nombre, List<Topic> topics) {
       this.id = id;
       this.nombre = nombre;
       this.topics = topics;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Topic> getTopics() {
        return this.topics;
    }
    
    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }




}

