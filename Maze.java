/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.model;

import com.google.gson.Gson;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Serializable;


import java.io.UnsupportedEncodingException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import pedro.ieslaencanta.com.falkensmaze.Size;
/**
 * 
 * @author CSG
 * 
 */

/**
 * Clase que gestiona y define las características del laberinto
 * Tamaño del laberinto
 * Matriz de bloques de la clase Block
 * Tiempo asociado al laberinto
 * Sonido
 */

@XmlRootElement
public class Maze implements  Serializable{

    private Size size;
    private Block[][] blocks;
    private double time;
    private String sound;

    /**
     *
     */
    public Maze() {
    }

    /**
     *Inicializa el laberinto con un tamaño específico y llena la matriz de bloques con  nuevos objetos de la clase Block
     */
    public void init() {
        this.setBlocks(new Block[this.getSize().getHeight()][this.getSize().getWidth()]);
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = new Block();

            }
        }
    }


    /**
     *Restablece el laberinto a un estado inicial poniendo todos los bloques a null
     */
    public void reset() {
        for (int i = 0; i < this.getBlocks().length; i++) {
            for (int j = 0; j < this.getBlocks()[i].length; j++) {
                this.getBlocks()[i][j] = null;

            }
        }
        this.setBlocks(null);
    }

    /**
     *
     * @param newsize restablece el laberinto a un nuevo tamaño y lo inicializa
     */
    public void reset(Size newsize) {
        this.reset();;
        this.setSize(newsize);
        this.init();
    }


    /**
     *establece un bloque en una posición específica
     * @param value
     * @param row
     * @param col
     */
    public void setBlockValue(String value, int row, int col) {
        this.getBlocks()[col][row].setValue(value);
    }

    /**
     *obtiene un bloque de una posición específica
     * @param row
     * @param col
     * @return
     */
    public String getBlockValue(int row, int col) {
        return this.getBlocks()[row][col].getValue();
    }


    /**
     *
     * @return
     */
    public Size getSize() {
        return size;
    }

    /**
     *
     * @param size
     */
    public void setSize(Size size) {
        this.size = size;
    }

    /**
     *
     * @return
     */
    public double getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     *
     * @return
     */
    public String getSound() {
        return sound;
    }

    /**
     *
     * @param sound
     */
    public void setSound(String sound) {
        this.sound = sound;
    }

    /**
     *
     * @return
     */
    public Block[][] getBlocks() {
        return blocks;
    }

    /**
     *
     * @param blocks
     */
    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }


    /**
     *Carga un laberinto desde un archivo, dependiendo de su extensión (xml, json, bin)
     * y gestiona las excepciones 
     * @param file
     * @return
     * @throws JAXBException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException
     * @throws Exception
     */
    public static Maze load(File file) throws JAXBException, IOException, FileNotFoundException, ClassNotFoundException, Exception {
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        Maze m = null;
        if (extension.equals("xml")) {
            m = Maze.loadXML(file);
        } else {
            if (extension.equals("json")) {
                m = Maze.loadJSON(file);

            } else {
                if (extension.equals("bin")) {
                    m = Maze.loadBin(file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
        return m;

    }

    /**
     *Guarda un laberinto en un archivo, dependiendo de su extensión (xml, json, bin)
     * y gestiona las excepciones
     * @param maze
     * @param file
     * @throws JAXBException
     * @throws Exception
     */
    public static void save(Maze maze, File file) throws JAXBException, Exception {
        if (maze.sound == null || maze.sound.equals("")) {
            throw new Exception("Es necesario indicar el sonido del laberinto");
        }
        String extension = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        if (extension.equals("xml")) {
            Maze.saveXML(maze, file);
        } else {
            if (extension.equals("json")) {
                Maze.saveJSON(maze, file);

            } else {
                if (extension.equals("bin")) {
                    Maze.saveBin(maze, file);
                } else {
                    throw new Exception("Exencsión " + extension + " no permitida");

                }
            }

        }
    }
    /**
     * Métodos privados para cargar el laberinto en los diferentes formatos
     * @param file
     * @return
     * @throws FileNotFoundException
     * @throws IOException 
     */

    private static Maze loadJSON(File file) throws FileNotFoundException, IOException {
        Gson gson = new Gson();
        Reader reader;
        reader = Files.newBufferedReader(file.toPath());
        Maze m = gson.fromJson(reader, Maze.class);
        reader.close();
        return m;
    }

    private static Maze loadXML(File file) throws JAXBException, IOException {

           JAXBContext context = JAXBContext.newInstance(Maze.class);
                Unmarshaller unmarshaller = context.createUnmarshaller();
                Maze maze = (Maze) unmarshaller.unmarshal(
                        file);
                return maze;
          
    }

       public static Maze loadBin(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream os = new FileInputStream(file);
        
        ObjectInputStream oos = new ObjectInputStream(os);
        Maze m = (Maze) oos.readObject();
        oos.close();;
        os.close();
        return m;
    }
       
        /**
     *Métodos privados para guardar el laberinto en los diferentes formatos
     * @param maze
     * @param file
     * @throws FileNotFoundException
     * @throws IOException
     */

    private static void saveJSON(Maze maze, File file) throws FileNotFoundException, UnsupportedEncodingException {
        Gson gson = new Gson();
        String json = gson.toJson(maze);
        java.io.PrintWriter pw = new PrintWriter(file, "UTF-8");
        pw.print(json);
        pw.close();
    }

    private static void saveXML(Maze maze, File file) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(maze.getClass());
        // create an instance of `Marshaller`
        Marshaller marshaller = context.createMarshaller();
        // enable pretty-print XML output
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        // write XML to `StringWriter`
        FileWriter fw = new FileWriter(file, StandardCharsets.UTF_8);//(file, "UTF-8");
        marshaller.marshal(maze, fw);
        fw.close();

    }

   
    public static void saveBin(Maze maze, File file) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(maze);
        oos.close();;
        os.close();
    }

}

