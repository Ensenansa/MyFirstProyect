package edu.eci.arsw.cartmode;
public class HelloMessage {
    private String name;
    /**
     * Constructor vacio para la funcion ToString
     */
    public HelloMessage() {
    }
    /**
     * Constructor con solo el valor del nombre
     * @param name Nombre del jugador
     */
    public HelloMessage(String name) {
        this.name = name;
    }
    /**
     * Retorna el String con el nombre del jugador
     * @return name Representa el nombre del mensaje.
     */
    public String getName() {
        return name;
    }
    /**
     * Establece un nombre para el atributo name.
     * @param name Representa el nombre del mensaje.
     */
    public void setName(String name) {
        this.name = name;
    }
}
