import java.io.Serializable;
import java.util.*;

/**
 * Contenedor generico que esta pensado para abstraer el comportamiento del
 * HashMap.
 *
 * @author Agustin
 * @param <K,V> Tipo de dato esperodo por el objeto.
 */
public class ContenedorUsuarios <K,V> implements Serializable {
    private HashMap<K,V> contenedor;

    /**
     * Constructor de Contenedor de Usuarios
     */
    public ContenedorUsuarios() {

        contenedor = new HashMap<>();
    }

    /**
     * Agrega un elemento al HashMap
     *
     * @param clave - valor
     * @return boolean Retorna True si se agrego el elemento, False en caso
     *         contrario
     */
    public boolean agregarElemento(K clave, V valor) {
        boolean agregado = false;
        if (!existeElemento(clave)) {
            contenedor.put(clave, valor);
            agregado = true;
        }
        return agregado;
    }


    /**
     * Quita un elemento del HashMap buscandolo por la clave
     *
     * @param clave
     * @return boolean Retorna True si se elimino el elemento, False en caso
     *         contrario
     */
    public boolean bajaElemento(K clave) {
        boolean eliminado = false;
        if (existeElemento(clave)) {
            contenedor.remove(clave);
            eliminado = true;
        }
        return eliminado;
    }

    /**
     * Retorna la cantidad de elementos en el ArrayList
     *
     * @return int cantidad de elementos
     */

    public int cantidadElementos() {
        return contenedor.size();
    }

    /**
     * Lista los elementos en forma de String
     *
     * @return String Texto de elentos del HashMap
     */
    public String listarElementos(String clave, String valor) {
        StringBuilder builder = new StringBuilder();

        Set<Map.Entry<K, V>> set = contenedor.entrySet();
        Iterator<Map.Entry<K, V>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            builder.append("\n\n"+clave + ": " + entry.getKey() + " " + "\n\n"+valor + ": " + entry.getValue());
        }

        return builder.toString();
    }

    /**
     * Busca un elemento en el contenedor
     *
     * @param clave del elemento a buscar
     * @return el elemento buscado
     */

    public V buscarElemento(K clave) {
        if (existeElemento(clave)) {
            return contenedor.get(clave);
        } else {
            return null;
        }
    }

    /**
     * Comprueba si un elemento existe en el contenedor
     *
     * @param  clave a buscar
     * @return true si existe, false en caso contrario
     */


    public boolean existeElemento(K clave) {
        return contenedor.containsKey(clave);
    }

    /**
     *
     * @param clave
     * @param valor
     * @return true si fue modificado - false si no.
     */

    public boolean modificarElemento(K clave, V valor) {
        boolean modificado = false;
        if (existeElemento(clave)) {
            contenedor.put(clave, valor);
            modificado = true;
        }
        return modificado;
    }

    /**
     *
     * @return arrayList de elementos
     */

    public ArrayList<V> devolverElementos() {
        ArrayList <V> elementos = new ArrayList<V>();

        Set<Map.Entry<K, V>> set = contenedor.entrySet();
        Iterator<Map.Entry<K, V>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            elementos.add(entry.getValue());
        }
        return elementos;
    }

}
