import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Cancion {
    private static int cantCanciones=0;
    private int idCancion;
    private String Titulo;
    private ArrayList<String> artistas;
    private String Album;
    private String Genero;
    private double Duracion;
    private int anio;

    public Cancion() {
        this.artistas=new ArrayList<String>();
        this.Duracion= 0;
        this.Genero="";
        this.idCancion=idCancion();
        this.Titulo="";
        this.Album="";
        this.anio=0;

    }
    public int idCancion()
    {
        cantCanciones++;
        return cantCanciones;
    }

    public int getIdCancion() {
        return idCancion;
    }


    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }


    public String getTitulo() {
        return Titulo;
    }


    public void setTitulo(String titulo) {
        Titulo = titulo;
    }


    public ArrayList<String> getArtistas() {
        return artistas;
    }


    public void setArtistas(ArrayList<String> artistas) {
        this.artistas = artistas;
    }


    public String getAlbum() {
        return Album;
    }


    public void setAlbum(String Album) {
		Album = Album;
    }


    public String getGenero() {
        return Genero;
    }


    public void setGenero(String genero) {
        Genero = genero;
    }


    public double getDuracion() {
        return Duracion;
    }


    public void setDuracion(double duracion) {
        Duracion = duracion;
    }


    public int getAnio() {
        return anio;
    }


    public void setAnio(int anio) {
        this.anio = anio;
    }


    @Override
    public String toString() {
        return "Cancion [idCancion=" + idCancion + ", T�tulo=" + Titulo + ", artistas=" + artistas + ", Album=" + Album
                + ", G�nero=" + Genero + ", Duracion=" + Duracion + ", año=" + anio + "]";
    }


    public Cancion(int idCancion, String titulo, ArrayList<String> artistas, String album, String genero,
                   double duracion, int anio) {
        super();
        this.idCancion = idCancion;
        Titulo = titulo;
        this.artistas = artistas;
		Album = album;
        Genero = genero;
        Duracion = duracion;
        this.anio = anio;
    }
    public Cancion(String titulo, ArrayList<String> artistas, String album, String genero,
                   double duracion, int anio) {
        super();
        this.idCancion = idCancion();
        Titulo = titulo;
        this.artistas = artistas;
		Album = album;
        Genero = genero;
        Duracion = duracion;
        this.anio = anio;
    }
    public JSONObject toJSONObject()throws JSONException {
        JSONObject jsonObject = new JSONObject();


        jsonObject.put("Id de cancion", getIdCancion());
        jsonObject.put("Titulo", getTitulo());
        jsonObject.put("Año", getAnio());
        jsonObject.put("Duracion", getDuracion());
        jsonObject.put("Genero", getGenero());
        jsonObject.put("Album", getAlbum());
        jsonObject.put("Artistas",getArtistas());

        return jsonObject;
    }




}
