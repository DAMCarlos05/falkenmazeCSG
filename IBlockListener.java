/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.falkensmaze.components;

/**
 *
 * @author CSG
 */
/*Al implementar esta interfaz, una clase puede definir su propia lógica para responder a los clics y dobles clics en bloques, 
*lo que facilita la implementación de funcionalidades interactivas en la aplicación.
*/
public interface IBlockListener {

    /**
     *
     * @param b
     */
    public void onClicked(Block b);

    /**
     *
     * @param b
     */
    public void onDoubleClicked(Block b);
}
