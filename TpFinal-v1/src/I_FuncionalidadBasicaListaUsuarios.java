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
     * @param aDarBaja dado de baja.
     * @return true si se da de baja correctamente, false en caso contrario.
     */
    boolean bajaUsuario(Usuario aDarBaja);

    /**
     * Da de baja un usuario de la lista
     *
     * @param index de la lista donde se encuentra el usuario a dar de baja
     * @return true si se da de baja correctamente, false en caso contrario.
     */
    Usuario bajaUsuario(int index);

    /**
     * Lista todos los usuarios de la lista
     *
     * @return los usuarios en forma de String
     */
    String listarUsuario();

    /**
     * Devuelve un usuario en particular buscandolo a trav�z del indice de la lista
     *
     * @param index
     * @return
     */
    Usuario buscarUsuario(int index);
}
