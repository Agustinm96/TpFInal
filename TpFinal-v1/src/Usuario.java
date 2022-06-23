import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Usuario extends Persona {

    private int id; //unico atributo que tanto admin como usuario no pueden modificar
    private static int cantUsuariosCreados=0;
    private String nombreUsuario;
    private String clave;
    private String mail;
    private String telefono;
    private int estado; //1 - Habilitado ; 0 - Deshabilitado
    //playList

    public Usuario (String nombreP, String apellidoP, String dniP, int edadP, String fechaNacP, int generoP, String nombre_Usuario, String clave_Usuario, String mail_Usuario, String telefono_Usuario){

        super(nombreP,apellidoP,dniP,edadP,fechaNacP,generoP);
        this.id = IdUsuario();
        nombreUsuario = nombre_Usuario;
        clave = clave_Usuario;
        mail = mail_Usuario;
        telefono = telefono_Usuario;
        estado = 1; //al crearse está habilitado
    }

    public Usuario (){
        super("", "", "", 0, "", 0);
        this.id = IdUsuario();
        this.nombreUsuario = "";
        this.clave = "";
        this.mail = "";
        this.telefono = "";
        this.estado = 1;

    }

    public int getId() {
        return id;
    }

    public int IdUsuario() //método autoincremental de ID
    {
        id = cantUsuariosCreados + 1;
        cantUsuariosCreados += 1;

        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String devuelveHabilitadoOno (){
        String aux = "";
        if (getEstado()==1){
            aux = "\n Usuario habilitado";
        }
        else if(getEstado()==0){
            aux = "\n Usuario dado de baja";
        }
        return aux;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombreUsuario, usuario.nombreUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombreUsuario);
    }

    @Override
    public String toString() {
        return  super.toString() + "\n Id de usuario:" +getId() +"\n Usuario: " +getNombreUsuario() + "\n Clave: " +getClave() + "\n Mail: " +getMail() + "\n Telefono:  " +getTelefono() + devuelveHabilitadoOno();
    }

    public JSONObject toJSONObject()throws JSONException {
            JSONObject jsonObject = new JSONObject();

            jsonObject = super.toJSONObject();
            jsonObject.put("Id de usuario", getId());
            jsonObject.put("Nombre de usuario", getNombreUsuario());
            jsonObject.put("Clave", getClave());
            jsonObject.put("Mail", getMail());
            jsonObject.put("Telefono", getTelefono());
            jsonObject.put("Estado", getEstado());

            return jsonObject;
        }

}

