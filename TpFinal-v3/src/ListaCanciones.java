import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONException;

public class ListaCanciones implements I_FuncionalidadBasicaCanciones, Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private ContenedorTreeMap<String, Cancion> listaCanciones;

    public ListaCanciones(ContenedorTreeMap<String, Cancion> listaCanciones) {
        super();
        this.listaCanciones = listaCanciones;
    }
    public ListaCanciones() {
        super();
        this.listaCanciones = new ContenedorTreeMap<String, Cancion>();
    }
    @Override
    public boolean agregarCancion(String nombre, Cancion nuevaCancion) {

        listaCanciones.agregarElemento(nombre, nuevaCancion);
        return true;

    }
    @Override
    public boolean bajaCancion(String nombre, Cancion bajaCancion) {
        listaCanciones.bajaElemento(nombre);
        return true;
    }
    @Override
    public Cancion bajaCancion(String nombre) {
        // TODO Auto-generated method stub
        return listaCanciones.bajaElemento(nombre);
    }
    @Override
    public String listarCanciones() {
        return listaCanciones.listarElementos();

    }
    @Override
    public Cancion buscarCancion(String nombre) {
        return listaCanciones.buscarElemento(nombre);
    }

    @Override
    public Cancion buscarCancionPorNombre(String nombreCancion) {
        return listaCanciones.buscarElemento(nombreCancion);
    }

    public static ListaCanciones fromJSONArray(JSONArray jsonArray) throws JSONException
    {
        ListaCanciones listaCanciones=new ListaCanciones();
        for(int i = 0 ; i < jsonArray.length() ; i ++) {
            Cancion cancion=(Cancion) Cancion.fromJSONObject(jsonArray.getJSONObject(i));
            listaCanciones.agregarCancion(cancion.getTitulo(), cancion);

        }
        return listaCanciones;
    }

    public ArrayList<Cancion> devolverCanciones() {
        return listaCanciones.devolverElementos();
    }


}