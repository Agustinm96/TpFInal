import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;

public class ContenedorTreeMap<K, V extends Cancion> implements Serializable {
    private TreeMap<K, V>contenedor;

    public ContenedorTreeMap(TreeMap<K, V> mapaArbol) {
        super();
        this.contenedor = mapaArbol;
    }

    public ContenedorTreeMap() {
        super();
        this.contenedor =new TreeMap<K, V>();
    }

    public void agregarElemento(K clave,V valor) {
        contenedor.put(clave, valor);
    }

    public V bajaElemento(K clave) {
        return contenedor.remove(clave);
    }

    public int cantidadElementos() {
        return contenedor.size();
    }

    public String listarElementos() {
        StringBuilder builder = new StringBuilder();

        for (Entry<K,V> entry :contenedor.entrySet()) {
            V val = entry.getValue();
            builder.append(val.toString());
        }    return builder.toString();
    }


    public V buscarElemento(K clave){
        return contenedor.get(clave);
    }


    public boolean existeElemento(K clave) {
        return contenedor.containsKey(clave);
    }


    public ArrayList<V> devolverElementos() {
        ArrayList <V> elementos = new ArrayList<V>();

        Set<Entry<K, V>> set = contenedor.entrySet();
        Iterator<Entry<K, V>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<K, V> entry = iterator.next();
            elementos.add(entry.getValue());
        }
        return elementos;
    }


    public JSONArray toJsonArray() throws JSONException {
        JSONArray jsonArray = new JSONArray();
        for (Entry<K,V> entry :contenedor.entrySet()) {
            V val = entry.getValue();
            jsonArray.put(val.toJSONObject());
        }

        return jsonArray;
    }





}
