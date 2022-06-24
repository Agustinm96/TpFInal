public interface I_FuncionalidadBasicaListaUsuarios {
    /**
     * Agrega un usuario a la lista
     *
     * @param usuarioNuevo agregado
     * @return true si se agrega, false en caso contrario
     */
    boolean agregarUsuario(Usuario usuarioNuevo);

    /**
     * Da de baja un usuario de la lista
     *
     * @param dni dado de baja.
     * @return true si se da de baja correctamente, false en caso contrario.
     */
    boolean bajaUsuario(String dni);

    /**
     * Lista todos los usuarios de la lista
     *
     * @return los usuarios en forma de String
     */
    String listarUsuarios();

    /**
     * Devuelve un usuario en particular buscandolo a trav�z de su dni
     *
     * @param dniUsuario
     * @return
     */
    Usuario buscarUsuario(String dniUsuario)throws ErrorDeBusquedaUsuario;

}
