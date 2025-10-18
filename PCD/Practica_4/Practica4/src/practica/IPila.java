package practica;

/**
 *
 * @author pablo
 */
public interface IPila {

    void Apila(Object elemento) throws Exception;

    Object Desapila() throws Exception;

    int GetNum();

    Object Primero() throws Exception;

}
