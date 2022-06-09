import java.util.ArrayList;
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
        String fechaNac_Persona = teclado.nextLine();

        System.out.println("\n Seleccione una opcion: ");
        System.out.println("\n 1- Masculino.");
        System.out.println("\n 2- Femenino.");
        System.out.println("\n 3- Otro.");
        System.out.println("\n 4- No definido.");
        int genero_Persona=validacionGenero();

        teclado.nextLine();

        System.out.println("\n Nombre de usuario: ");
        String nombre_Usuario = teclado.nextLine();

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


}
