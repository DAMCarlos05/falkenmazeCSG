/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
/**
 * 
 * @author CSG
 * 
 */
/*
 * Representa el tamaño, implementa Cloneable para permitir la creación de copias, Comparable para permitir la comparación y Serializable para que sus instancias se puedan guardar en un archivo o transmitirse a través de una red y recrearse en otro entorno
 */
@XmlRootElement
public class Size implements Cloneable, Comparable<Size>, Serializable {
    private int width;
    private int height;
   
    /**
     *
     */
    public Size(){
    }

    /**
     *Constructor para establecer el ancho y el alto del elemento
     * @param width
     * @param height
     */
    public Size(int width,int height){
        this.width=width;
        this.height=height;
    }
    

    /**
     *Crea una copia del objeto Size
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException{
        return new Size(this.getWidth(), this.getHeight());
    }

    /**
     *Comprueba si existe otro objeto igual
     * @param o
     * @return
     */
    @Override 
    public boolean equals(Object o){
        if(! (o instanceof Size)){
            return false;
        }
        if (this.getWidth()==((Size)(o)).getWidth() && this.getHeight()==((Size)(o)).getHeight()){
            return true;
        }else{
            return false;
        }
        
    }

    /**
     *compara este objeto con otro: devuelve -1  si es menor, 0 si son iguales, 1 si es mayor
     * @param o
     * @return
     */
    @Override 
    public int compareTo(Size o) {
        if(this.getWidth()==o.getWidth() && this.getHeight()==o.getHeight())
            return 0;
        if(this.getWidth()<o.getWidth())
            return -1;
        else
            return 1;
    }
   

    /**
     *
     * @return
     */
    public String toString(){
        return "W:"+this.width+" H:"+this.height;
    }
    /**
     * @return the width
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(int height) {
        this.height = height;
    }
 
}

