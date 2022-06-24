import java.io.Serializable;

public class PlayList implements Serializable, I_FuncionalidadBasicaCanciones {
    private String nombrePlayList;
    private ListaCanciones listaCancionesPlayList;

    public PlayList (String nombre){
        nombrePlayList = nombre;
        listaCancionesPlayList = new ListaCanciones();
    }

    public PlayList (){
        nombrePlayList = "";
        listaCancionesPlayList = new ListaCanciones();
    }

    public void setNombrePlayList(String nombrePlayList) {
        this.nombrePlayList = nombrePlayList;
    }

    public String getNombrePlayList() {
        return nombrePlayList;
    }

    @Override
    public boolean agregarCancion(String nombre, Cancion nuevaCancion) {
        return listaCancionesPlayList.agregarCancion(nuevaCancion.getTitulo(),nuevaCancion);
    }

    @Override
    public boolean bajaCancion(String nombre, Cancion bajaCancion) {
        return listaCancionesPlayList.bajaCancion(bajaCancion.getTitulo(), bajaCancion);
    }

    @Override
    public Cancion bajaCancion(String nombre) {
        return listaCancionesPlayList.bajaCancion(nombre);
    }

    @Override
    public String listarCanciones() {
        return getNombrePlayList() + listaCancionesPlayList.listarCanciones();
    }

    @Override
    public Cancion buscarCancion(String nombre) {
        return listaCancionesPlayList.buscarCancion(nombre);
    }

    @Override
    public Cancion buscarCancionPorNombre(String nombreCancion) {
        return listaCancionesPlayList.buscarCancion(nombreCancion);
    }

}
