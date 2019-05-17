package edu.eci.arsw.cartmode;



public class Greeting {

    private String content;
/**
 * Constructor vacio.
 */
    public Greeting() {
    }
/**
 * Constructor que recibe un parametro content.
 * @param content String que representa el contenido del gretting.
 */
    public Greeting(String content) {
        this.content = content;
    }
/**
 * Retorna el contenio del greting.
 * @return content El contenido del Greting
 */
    public String getContent() {
        return content;
    }

}
