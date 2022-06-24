import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controladora_Usuario {
    static Scanner teclado;

    public static Usuario altaUsuario (){
        teclado = new Scanner(System.in);

        System.out.println("\n Complete los siguientes campos por favor: ");

        System.out.println("\n Nombre: ");
        String nombre_Persona = teclado.nextLine();

        System.out.println("\n Apellido: ");
        String apellido_Persona = teclado.nextLine();

        System.out.println("\n DNI: ");
        String dni_Persona = teclado.nextLine();

        System.out.println("\n Edad: ");
        int edad_Persona = validaEdad();

        teclado.nextLine();

        System.out.println("\n Fecha de nacimiento: ");
        String fechaNac_Persona = validaFechaNacimiento();

        System.out.println("\n Seleccione una opcion: ");
        System.out.println("\n 1- Masculino.");
        System.out.println("\n 2- Femenino.");
        System.out.println("\n 3- Otro.");
        System.out.println("\n 4- No definido.");
        int genero_Persona=validacionGenero();

        teclado.nextLine();

        System.out.println("\n Nombre de usuario: "); //no probado aun
        String nombre_Usuario = validaUsuario();

        System.out.println("\n Clave: ");
        String clave_Usuario =  validaClave();

        System.out.println("\n Email: ");
        String mail_Usuario = teclado.nextLine();

        System.out.println("\n Telefono: ");
        String telefono_Usuario = teclado.nextLine();

        Usuario user = new Usuario(nombre_Persona, apellido_Persona, dni_Persona,edad_Persona,fechaNac_Persona,genero_Persona,nombre_Usuario,clave_Usuario,mail_Usuario,telefono_Usuario);

        return user;

    }

    public static int validacionGenero (){
        int genero_Persona=0;
        while(genero_Persona<1 || genero_Persona>4){
            genero_Persona= teclado.nextInt();
            if(genero_Persona<1 || genero_Persona>4){
                System.out.println("\n Ingrese una opcion valida");
            }
        }
        return genero_Persona;
    }

    public static int validaEdad (){
        int edad=0;
        boolean rta = false;
        while(!rta){
            edad = teclado.nextInt();
            if(edad<=0){
                System.out.println("\n Error! Ingrese nuevamente.");
            }else
                rta=true;
        }
        return edad;
    }

    public static String validaClave(){
        String clave1= teclado.nextLine();
        System.out.println("\n Ingrese clave nuevamente: ");
        String clave2 = teclado.nextLine();

        while (!clave1.equals(clave2)){
            System.out.println("\n Las claves no coinciden");
            System.out.println("\n Clave: ");
            clave1= teclado.nextLine();
            System.out.println("\n Ingrese clave nuevamente: ");
            clave2 = teclado.nextLine();
        }
        return clave1;
    }

    public static String validaUsuario (){
        String usuario = teclado.nextLine();
        while(usuario.length()>30){
            System.out.println("\n Demasiados caracteres!! Ingrese nuevamente. Recuerde, deben ser menos de 30");
            usuario = teclado.nextLine();
        }
        return usuario;
    }

    public static String validaFechaNacimiento (){//Falta validar el año (deja ingresar > al actual)
        boolean rta = false;
        String fechaNacimiento= teclado.nextLine();
        String fechaSalida = "";
        while(!rta){
            try {
                Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimiento);
                fechaSalida = new SimpleDateFormat("dd/MM/yyyy").format(fecha);
                if(!fechaNacimiento.equals(fechaSalida)){
                    System.out.println("\n Ingrese nuevamente ");
                    fechaNacimiento= teclado.nextLine();
                }
                else{
                    rta = true;
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        return fechaSalida;
    }

    public static String validaNombreUsuarioNuevo(ListaUsuarios lista){
        teclado = new Scanner(System.in);
        String nombreUsuario = teclado.nextLine();
        ArrayList<Usuario> listaUsuarios = lista.devolverUsuarios();
        boolean rta = Controladora_Usuario.recorreArrayList(listaUsuarios, nombreUsuario);

        while(!rta) {
            System.out.println("\n Nombre de usuario existente! Ingrese nuevamente");
            nombreUsuario = teclado.nextLine();
            rta = Controladora_Usuario.recorreArrayList(listaUsuarios, nombreUsuario);
            }
        return nombreUsuario;
    }


    public static boolean recorreArrayList (ArrayList<Usuario>lista, String nombreUsuario){
        boolean rta = false;
        for(int i=0;i<lista.size();i++){
            if(!lista.get(i).getNombreUsuario().equals(nombreUsuario)){
                rta = true;
            }
            else{
                rta = false;
            }
        }
        return rta;
    }

    public static Usuario modificaUsuario(Usuario user, ListaUsuarios lista){
        int opcion=0;
        String clave= "", nuevoNombreUsuario="";
        teclado = new Scanner(System.in);

        do{
            System.out.println("\n Menu de modificaciones, ingrese la opcion de sus datos que desea modificar: ");
            System.out.println("\n Opcion 1. Nombre de usuario");
            System.out.println("\n Opcion 2. Clave");
            System.out.println("\n Opcion 3. Telefono");
            System.out.println("\n Opcion 4. Mail");
            System.out.println("\n Opcion 5. Darme de baja");
            System.out.println("\n Opcion 6. Volver");


            try {

                System.out.println("Ingrese una de las opciones: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("\n Nuevo nombre de usuario: ");
                        nuevoNombreUsuario= Controladora_Usuario.validaNombreUsuarioNuevo(lista);
                        user.setNombreUsuario(nuevoNombreUsuario);

                        break;
                    case 2:
                        System.out.println("\n Clave: ");
                        clave =  validaClave();
                        user.setClave(clave);
                        break;
                    case 3:
                        System.out.println("\n Telefono");
                        user.setTelefono(teclado.nextLine());

                        case 4:
                            System.out.println("\n Mail");
                            user.setMail(teclado.nextLine());
                            break;

                    case 5:
                        user.setEstado(0);
                        System.out.println("\n Usuario dado de baja correctamente!");
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                teclado.next();
            }
        }while(opcion<1 || opcion>5);

        return user;
    }

    public static void bajaOaltaUsuario (Usuario user){
        if(user.getEstado()==1){
            user.setEstado(0);
        }else{
            user.setEstado(1);
        }
    }


}
