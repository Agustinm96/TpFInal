import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.*;

public class ListaUsuarios implements I_FuncionalidadBasicaListaUsuarios, Serializable {
    static Scanner teclado;
    private ContenedorUsuarios<String, Usuario> listaUsuarios;

    public ListaUsuarios() {
        listaUsuarios = new ContenedorUsuarios<>();
    }

    @Override
    public boolean agregarUsuario(Usuario usuarioNuevo) {
        boolean rta1 = false, rta2 = false;
        teclado = new Scanner(System.in);
        while(!(rta1 && rta2)){ /**Se fija si ya existe un nombre de usuario o una cuenta con el dni del usuario nuevo**/
            while(!rta1){
                rta1 = buscarUsuarioPorNombre(usuarioNuevo.getNombreUsuario());
                if(!rta1){
                    System.out.println("Nombre ya existe, ingrese otro.");
                    usuarioNuevo.setNombreUsuario(teclado.nextLine());
                }
            }
            while(!rta2){
                rta2 = buscarUsuarioPorDNI(usuarioNuevo.getDNI());
                if(!rta2){
                    System.out.println("\n DNI ya se encuentra registrado con una cuenta. Ingrese otro o en el menú de inicio recupere su cuenta"); /**CREAR OPCION DE RECUPERO DE CUENTA CUANDO NO SE ACURERDA DNI**/
                    usuarioNuevo.setDNI(teclado.nextLine());
                }
            }
        }

        return listaUsuarios.agregarElemento(usuarioNuevo.getDNI(),usuarioNuevo);
    }

    @Override
    public boolean bajaUsuario(String dniUsuario) {
        return listaUsuarios.bajaElemento(dniUsuario);
    }


    @Override
    public String listarUsuarios() {
        return listaUsuarios.listarElementos("DNI: ", "Usuario: ");
    }

    /**AGREGAR EXCEPION**/

    @Override
    public Usuario buscarUsuario(String dniUsuario) throws ErrorDeBusquedaUsuario {

            Usuario aux = null;

            if(existeUsuario(dniUsuario)) {
                aux = listaUsuarios.buscarElemento(dniUsuario);
            }
            else {
                throw new ErrorDeBusquedaUsuario("\n Usuario no encontrado!!");
            }

            return aux;
    }

    public boolean buscarUsuarioPorDNI(String dniUsuario){
        boolean rta = false;
        if(!existeUsuario(dniUsuario)){
            rta = true;
        }
        return rta;
    }

    public boolean buscarUsuarioPorNombre(String nombreUsuario){
        boolean rta = false;
        ArrayList <Usuario> arrayList = listaUsuarios.devolverElementos();
        for(int i=0; i<arrayList.size();i++){
            if(!arrayList.get(i).getNombreUsuario().equals(nombreUsuario)){
                rta = true;
            }
        }

        if(arrayList.size()==0){
            rta = true;
        }
        return rta;
    }

    /**
     * Metodo para comprobar si existe un usuario
     * @param codigo a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existeUsuario(String codigo) {
        return listaUsuarios.existeElemento(codigo);
    }


    public int cantElementos(){
        return listaUsuarios.cantidadElementos();
    }

    /**
     * Metodo para devolver toods los usuarios en forma de ArrayList
     * @return los usuarios en un ArrayList
     */
    public ArrayList<Usuario> devolverUsuarios() {
        return listaUsuarios.devolverElementos();
    }

    /**
     * Devuelve la lista de usuarios en un arreglo de json
     * @return los usuarios en un JSONArray
     * @throws JSONException
     */
    public JSONArray toJsonArray() throws JSONException {
        JSONArray jsonArray = new JSONArray();

        ArrayList<Usuario> arrayUsuarios = listaUsuarios.devolverElementos();

        for(Usuario usuario : arrayUsuarios) {
            jsonArray.put(usuario.toJSONObject());
        }
        return jsonArray;
    }

    /**FALTA METODO PARA IMPORTAR DESDE JSON**/

}
