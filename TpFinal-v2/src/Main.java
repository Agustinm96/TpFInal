import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Usuario user1 = new Usuario("Agustin", "Alvarez", "39169663", 25, "03/08/1996", 1, "agustinmalvarez", "des", "mail", "223");
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        listaUsuarios.agregarUsuario(user1);
        //Usuario user2 = Controladora_Usuario.altaUsuario();
        //listaUsuarios.agregarUsuario(user2);
        System.out.println(listaUsuarios.listarUsuarios());

        FuncionesAcceso.login(listaUsuarios);



    }

/*
    public static void menuPrincipal()
    {
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        Usuario enSesion=null;

        while (!salir) {
            if(enSesion==null)
            {
                System.out.println("1. Iniciar sesion");
                System.out.println("2. Crear nuevo usuario");
                System.out.println("3. Salir");

                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = scan.nextInt();

                    switch (opcion) {
                        case 0:
                            //Menu Admin
                        case 1:
                           // enSesion = ListaUsuarios.login();

                            break;
                        case 2:
                           if(agregarUsuario(altaUsuario()))
                            {
                                System.out.println("Usuario creado exitosamente");
                            }
                            break;
                        case 3:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 2");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    scan.next();
                }
            }
            else
            {
                boolean cerrarSesion=false;
                while (!cerrarSesion) {
                    System.out.println("0. Cerrar Sesion");
                    System.out.println("1. Mostrar todas las canciones");
                    System.out.println("2. Crear una playlist");
                    System.out.println("3. Mis playlist");

                    if(esAdmin)//Mostrar tambien opciones admin
                    {
                        System.out.println("4. Agregar cancion");
                        System.out.println("5. Eliminar cancion");
                        System.out.println("6. Dar de baja usuario");
                        System.out.println("7. Mostrar usuarios");
                    }


                    try {

                        System.out.println("Escribe una de las opciones");
                        opcion = scan.nextInt();

                        switch (opcion) {
                            case 1:
                                listarCanciones();
                                break;
                            case 2:
                                ListaCanciones nuevaPlaylist = new ListaCanciones();//Agregar atributo nombre a las lista(?
                                break;
                            case 3:
                                //mostrar arreglo de playlist(? y opciones para agregar o quitar canciones
                            case 0:
                                cerrarSesion = true;
                                break;
                            default:
                                System.out.println("Solo números entre 1 y 2");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Debes insertar un número");
                        scan.next();
                    }


                }
            }

        }


        public static void menuCanciones()
        {
            Scanner scan = new Scanner(System.in);
            boolean salir = false;
            int opcion;

            while (!salir) {

                System.out.println("1. Dar de alta una cancion");
                System.out.println("2. Eliminar una cancion");
                System.out.println("3. Mostrar lista total de canciones");
                System.out.println("3. Mostrar canciones por artista");

                System.out.println("4. Salir");

                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = scan.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Has seleccionado la opcion 1");
                            break;
                        case 2:
                            System.out.println("Has seleccionado la opcion 2");
                            break;
                        case 3:
                            System.out.println("Has seleccionado la opcion 3");
                            break;
                        case 4:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    scan.next();
                }
            }

        }

        public static void menuUsuario(){
            Scanner scan = new Scanner(System.in);
            boolean salir = false;
            int opcion;

            while (!salir) {

                System.out.println("1. Crear nuevo usuario");
                System.out.println("2. Eliminar Usuario");
                System.out.println("3. Lista de usuarios");
                System.out.println("4. Salir");

                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = scan.nextInt();

                    switch (opcion) {
                        case 1:
                            System.out.println("Has seleccionado la opcion 1");
                            break;
                        case 2:
                            System.out.println("Has seleccionado la opcion 2");
                            break;
                        case 3:
                            System.out.println("Has seleccionado la opcion 3");
                            break;
                        case 4:
                            salir = true;
                            break;
                        default:
                            System.out.println("Solo números entre 1 y 4");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Debes insertar un número");
                    scan.next();
                }
            }

        }




    }*/
}