import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        /**USUARIOS HARCODEADOS, en caso de que se rompa el archivo**/
        /*Usuario user1 = new Usuario("Agustin", "Alvarez", "39169663", 25, "03/08/1996", 1, "agustinmalvarez", "des", "mail", "223");
        Usuario user2 = new Usuario("Pepe", "Sand", "25317496", 42, "17/07/1980", 1, "pepeSand", "LoveLanus", "pepeSand@gmail.com", "11456987");
        */

        /**CREACION DE CONTENEDORES**/
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        ListaCanciones listaCanciones = new ListaCanciones();


        /**PASO CONTENIDO DE ARCHIVO A CONTENEDORES**/
       listaUsuarios = ArchivoUsuarios.leerArchivoUsuarios();
        listaCanciones = ArchivoCanciones.leerArchivo();


       /* System.out.println(listaUsuarios.listarUsuarios().toString());
       Usuario user = listaUsuarios.devuelveUsuarioPorNombre("agustinmalvarez");
        user.getMiPlaylist().setNombrePlayList("Correr");
        Cancion c1 = new Cancion();
        c1 = listaCanciones.buscarCancionPorNombre("Kamikaze");
        System.out.println(c1.toString());

        user.getMiPlaylist().agregarCancion(c1.getTitulo(),c1);
        user.getMiPlaylist().listarCanciones();
        user.getMiPlaylist().bajaCancion(c1.getTitulo(),c1);
        user.getMiPlaylist().listarCanciones();
        //user.getMiPlaylist().agregarCancion();

        //Main.menuPrincipal(listaUsuarios, listaCanciones);


        /**CUANDO FINALIZA LA EJECUCION GRABA LOS ARCHIVOS PARA AGREGAR EL NUEVO CONTENIDO**/

        //ArchivoUsuarios.grabarArchivoUsuarios(listaUsuarios);
        //ArchivoCanciones.grabarArchivo(listaCanciones);
    }


    public static void menuPrincipal(ListaUsuarios listaDeUsuarios, ListaCanciones listaCanciones)
    {
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion;


        while (!salir) {
                System.out.println("1. Iniciar sesion");
                System.out.println("2. Crear nuevo usuario");
                System.out.println("3. Salir");

                try {

                    System.out.println("Escribe una de las opciones");
                    opcion = scan.nextInt();

                    switch (opcion) {
                        case 0:
                            FuncionesAcceso.menuAdmin(listaDeUsuarios, listaCanciones);
                            break;
                        case 1:
                            FuncionesAcceso.login(listaDeUsuarios, listaCanciones);
                            break;
                        case 2:
                           if(listaDeUsuarios.agregarUsuario((Controladora_Usuario.altaUsuario())))
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

        }

}
