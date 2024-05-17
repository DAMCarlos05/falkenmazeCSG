/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/**
 * 
 * @author CSG
 * 
 */
/*
 * Clase Block como raiz de un documento xml, que define un objeto de tipo Block
 */
@XmlRootElement
public class Block implements  Serializable {
       private String value;
    
    /**
     *Atributo que representa el valor de Block
     */
    public Block(){
        this.value=null;
    }

    /**
     *
     * @return Devuelve el valor actual 
     */
    public String getValue(){
        return this.value;
    }

    /**
     *
     * @param value Establece un nuevo valor
     */
    public void setValue(String value){
        this.value=value;
    }

    /**
     *
     * @return Verifica si el bloque está vacío
     */
    public boolean isEmpty(){
        return this.value==null;
    }
}

