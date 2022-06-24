public interface I_FuncionalidadBasicaCanciones {

    boolean agregarCancion(String nombre ,Cancion nuevaCancion);

    boolean bajaCancion(String nombre ,Cancion bajaCancion);

    Cancion bajaCancion(String nombre);

    String listarCanciones();

    Cancion buscarCancion(String nombre);

    boolean buscarCancionPorNombre(String nombreCancion);

}
