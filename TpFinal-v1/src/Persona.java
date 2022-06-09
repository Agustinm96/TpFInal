import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String apellido;
    private String DNI;
    int edad;
    private String fechaNacimiento;
    private int genero;

    public Persona(String n, String a, String d,int e,String fechaNac, int g){
        nombre = n;
        apellido = a;
        DNI = d;
        edad = e;
        fechaNacimiento = fechaNac;
        genero = g;
    }

    public Persona (){
        this.nombre = "";
        this.apellido = "";
        this.DNI= "";
        this.edad = 0;
        this.fechaNacimiento= "";
        this.genero= 0;
    }

    public String getNombre() {
        String output = nombre.substring(0,1).toUpperCase() + nombre.substring(1).toLowerCase();
        return output;
    }

    public String getDNI() {
        return DNI;
    }

    public int getGeneroInt() {
        return this.genero;
    }

    public String getGenero() {
        String rta = "";
        switch(this.genero) {
            case(1):
                rta = "Masculino";
                break;
            case(2):
                rta = "Femenino";
                break;
            case(3):
                rta = "Otro";
                break;
            default:
                rta = "No definido";
                break;
        }
        return rta;
    }


    public String getApellido() {
        String output = apellido.substring(0,1).toUpperCase() + apellido.substring(1).toLowerCase();

        return output;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    /**
     * Metodo que conviete una persona a un objeto de json
     * @return la persona en forma de JSONObject
     * @throws JSONException
     */
    public JSONObject toJSONObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("Nombre", getNombre());
        jsonObject.put("Apellido", getApellido());
        jsonObject.put("DNI", getDNI());
        jsonObject.put("Edad", getEdad());
        jsonObject.put("Genero", getGeneroInt());
        jsonObject.put("Fecha de nac", getFechaNacimiento());

        return jsonObject;
    }

    /**
     * Metodo para importar una persona desde un objeto JSON
     * @param jsonObject a importar
     * @return la persona
     * @throws JSONException
     */

    public static Persona fromJSONObject(JSONObject jsonObject) throws JSONException {

        String nombre = jsonObject.getString("Nombre");
        String apellido = jsonObject.getString("Apellido");
        String DNI = jsonObject.getString("DNI");
        int edad = jsonObject.getInt("Edad");
        Integer genero = jsonObject.getInt("Genero");
        String fechaNac = jsonObject.getString("Fecha de nac");
        Persona persona = new Persona(nombre, apellido, DNI, edad, fechaNac, genero);

        return persona;
    }



    @Override
    public String toString() {
        return "\n Nombre: " + getNombre() + "\n Apellido: " + getApellido() + "\n DNI: " + DNI + "\n Edad: " + edad + "\n FechaNacimiento: " + fechaNacimiento + "\n Genero: " +getGenero();
    }
}
