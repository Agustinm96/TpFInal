public class Administrador extends Persona{
    private String usuario_Admin;
    private String clave_Admin;

    public Administrador(String n, String a, String dni, int e, String fechaNac, int g, String uA, String cA){
        super(n,a,dni,e,fechaNac,g);
        usuario_Admin = uA;
        clave_Admin = cA;
    }

    public String getUsuario_Admin() {
        return usuario_Admin;
    }

    public void setUsuario_Admin(String usuario_Admin) {
        this.usuario_Admin = usuario_Admin;
    }

    public String getClave_Admin() {
        return clave_Admin;
    }

    public void setClave_Admin(String clave_Admin) {
        this.clave_Admin = clave_Admin;
    }
}
