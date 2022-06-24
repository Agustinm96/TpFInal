import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionesAcceso {
    static Scanner teclado;

    public static void login(ListaUsuarios lista) {
        teclado = new Scanner(System.in);
        boolean rta = false;
        Usuario aux = null;
        String nombreUsuario = "", claveUsuario = "", DNI = "";
        int intentos = 1, continuar = 1;

        while (continuar == 1) {
            System.out.println("\n Ingrese su nombre de usuario: ");
            nombreUsuario = teclado.nextLine();
            aux = lista.devuelveUsuarioPorNombre(nombreUsuario);
            if (aux == null) {
                try {
                    throw new ErrorDeBusquedaUsuario("\n No existe usuario registrado bajo ese nombre!!");
                } catch (ErrorDeBusquedaUsuario e) {
                    System.out.println(e.getMessage());
                    System.out.println("\n Si desea probar nuevamente ingrese 1, de lo contrario ingrese 0");
                    System.out.println("\n Opcion: ");
                    continuar = teclado.nextInt();
                    nombreUsuario = teclado.nextLine();
                }
            } else {
                continuar = 0;
                while (!rta && intentos <= 3) {
                    System.out.println("\n Ingrese su contraseña: ");
                    claveUsuario = teclado.nextLine();
                    if (!aux.getClave().equals(claveUsuario)) {
                        try {
                            throw new ContraseñaIncorrecta("\n Contrasenia incorrecta. Tenes 3 intentos para ingresar la contraseña correcta.\n Al tercer intento fallido te pediremos que ingreses tu DNI para corroborar que seas vos y te bridaremos tu contrasenia si es asi.", intentos);
                        } catch (ContraseñaIncorrecta e) {
                            System.out.println(e.getMessage());
                            intentos++;
                        }
                    } else {
                        rta = true;
                        System.out.println("\n Bienvenido a SpotyLab " +aux.getNombre()+ "!!!");
                        FuncionesAcceso.menuUsuario(aux, lista /**lista de canciones**/); //ingresa al menu
                    }
                }
                if (intentos > 3) {
                    System.out.println("\n DNI: ");
                    DNI = teclado.nextLine();
                    try {
                        aux = lista.buscarUsuario(DNI);
                    } catch (ErrorDeBusquedaUsuario e) {
                        System.out.println(e.getMessage());
                    }finally {
                        if(aux!=null){
                            System.out.println("\n Su contrasenia es: "+aux.getClave()); /**RECUPERA CONTRASEÑA**/
                        }
                    }
                }

            }
        }
    }

    public static void menuUsuario (Usuario user, ListaUsuarios listaUsuarios /**, lista de canciones**/){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0;
        while (!salir) {
            System.out.println("\n 1. Ver mi perfil");
            System.out.println("\n 2. Modificar mis datos");
            System.out.println("\n 3. Mostrar todas las canciones");
            System.out.println("\n 4. Crear una playlist");
            System.out.println("\n 5. Ver mi playlist");
            System.out.println("\n 6. Agregar cancion a playlist");
            System.out.println("\n 7. Quitar cancion de mi playlist");
            System.out.println("\n 8. Buscar cancion");
            System.out.println("\n 9. Cerrar sesión");

            try {

                System.out.println("\n Escribe una de las opciones: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println(user.toString());
                        break;
                    case 2:
                        Controladora_Usuario.modificaUsuario(user,listaUsuarios);
                        break;
                    case 3:
                        //MostrarListaCanciones
                    case 4:
                        //Falta playListUsuario
                        break;
                    case 5:
                        //mostrarPlaylist
                    case 6:
                        //opcion de playlist
                    case 7:
                        //opcion de playlist
                    case 8:
                        //opcion de lista de canciones (no esta en este tp)
                    case 9:
                        salir = true;
                    default:
                        System.out.println("Solo números entre 1 y 9");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        }
    }

    public static void menuAdmin(ListaUsuarios listaUsuarios /**Lista Canciones**/){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0, opcion1=0;
        String dniUsuario = "";
        Usuario user = null;

        while (!salir) {
            System.out.println("\n 0. Cerrar Sesion");
            System.out.println("\n 1. Usuarios");
            System.out.println("\n 2. Canciones");

            try {

                System.out.println("Escribe una de las opciones: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 1:
                        do{
                            System.out.println("\n 0. Volver");
                            System.out.println("\n 1. Mostrar usuarios");
                            System.out.println("\n 2. Buscar usuario");
                            System.out.println("\n 3. Modificar usuario");
                            System.out.println("\n 4. Dar de baja o alta un usuario");

                            System.out.println("Escribe una de las opciones: ");
                            opcion = scan.nextInt();

                            switch (opcion){
                                case 1:
                                    System.out.println(listaUsuarios.devolverUsuarios().toString());
                                    break;

                                case 2:
                                    System.out.println("\n Ingrese DNI: ");
                                    dniUsuario = teclado.nextLine();
                                    try {
                                        System.out.println(listaUsuarios.buscarUsuario(dniUsuario).toString());
                                    } catch (ErrorDeBusquedaUsuario e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;

                                case 3:
                                    System.out.println("\n Ingrese DNI: ");
                                    dniUsuario = teclado.nextLine();
                                    try {
                                        user = listaUsuarios.buscarUsuario(dniUsuario);
                                    } catch (ErrorDeBusquedaUsuario e) {
                                        System.out.println(e.getMessage());
                                    }
                                    Controladora_Usuario.modificaUsuario(user, listaUsuarios);
                                    break;

                                case 4:
                                    System.out.println("\n Ingrese DNI: ");
                                    dniUsuario = teclado.nextLine();
                                    try {
                                        user = listaUsuarios.buscarUsuario(dniUsuario);
                                    } catch (ErrorDeBusquedaUsuario e) {
                                        System.out.println(e.getMessage());
                                    }
                                    Controladora_Usuario.bajaOaltaUsuario(user);

                                case 0:
                                    break;

                                default:
                                    System.out.println("\n Ingrese una opcion correcta!!");

                            }
                        }while(opcion!=0);
                        break;

                    case 2:
                        do{
                            System.out.println("\n 0. Volver");
                            System.out.println("\n 1. Mostrar canciones");
                            System.out.println("\n 2. Buscar cancion");
                            System.out.println("\n 3. Modificar cancion");

                            System.out.println("Escribe una de las opciones: ");
                            opcion1 = scan.nextInt();

                            switch (opcion1){
                                case 1:
                                    /**Mostrar Lista de canciones**/
                                    break;

                                case 2:
                                    /**Buscar Cancion**/
                                    break;

                                case 3:
                                   /**Menu de modificacion de cancion**/
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("\n Ingrese una opcion correcta!!");

                            }
                        }while(opcion1!=0);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        }
    }
}
