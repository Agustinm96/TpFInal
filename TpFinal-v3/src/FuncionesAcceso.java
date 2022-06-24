import java.util.InputMismatchException;
import java.util.Scanner;

public class FuncionesAcceso {
    static Scanner teclado;

    public static void login(ListaUsuarios lista, ListaCanciones listaCanciones) {
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
                        FuncionesAcceso.menuUsuario(aux, lista, listaCanciones); //ingresa al menu
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

    public static void menuUsuario (Usuario user, ListaUsuarios listaUsuarios, ListaCanciones listaCanciones){
        Scanner scan = new Scanner(System.in);
        String nombreCancion = "";
        Cancion c1 = null;
        boolean salir = false;
        int opcion = 0;
        while (!salir) {
            System.out.println("\n 1. Ver mi perfil");
            System.out.println("\n 2. Modificar mis datos");
            System.out.println("\n 3. Mostrar todas las canciones");
            System.out.println("\n 4. Ver mi playlist");
            System.out.println("\n 5. Agregar cancion a playlist");
            System.out.println("\n 6. Quitar cancion de mi playlist");
            System.out.println("\n 7. Buscar cancion");
            System.out.println("\n 8. Cerrar sesión");

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
                        System.out.println(listaCanciones.listarCanciones());
                    case 4:
                        System.out.println("\n Ingrese el nombre de su Playlist: ");
                        user.getMiPlaylist().setNombrePlayList(teclado.nextLine());
                    case 5:
                        System.out.println("\n Ingrese el nombre de la cancion que desea agregar: ");
                        nombreCancion=teclado.nextLine();
                        c1 = listaCanciones.buscarCancionPorNombre(nombreCancion);
                        if(c1==null){
                            System.out.println("\n La cancion no se encuentra registrada en la app. Lo sentimos!");
                        }else{
                            user.getMiPlaylist().agregarCancion(c1.getTitulo(),c1);
                        }
                    case 6:
                        System.out.println("\n Ingrese el nombre de la cancion que desea eliminar: ");
                        nombreCancion=teclado.nextLine();
                        c1 = listaCanciones.buscarCancionPorNombre(nombreCancion);
                        if(c1==null){
                            System.out.println("\n La cancion no se encuentra registrada en la app. Lo sentimos!");
                        }else{
                            user.getMiPlaylist().agregarCancion(c1.getTitulo(),c1);
                        }
                    case 7:
                        System.out.println("\n Ingrese el nombre de la cancion que desea agregar: ");
                        nombreCancion=teclado.nextLine();
                        c1 = listaCanciones.buscarCancionPorNombre(nombreCancion);
                        System.out.println(c1.toString());
                    case 8:
                        System.out.println("Ingrese nombre de la cancion");
                        String nombre=scan.nextLine();
                        Cancion can=listaCanciones.buscarCancionPorNombre(nombre);
                        if(can==null)
                        {
                            System.out.println("\nEsa cancion no existe");
                        }else
                        {
                            do{
                                System.out.println(can.toString());
                                System.out.println("Desea eliminarla:\n1-Si\n2-No\n");
                                opcion=scan.nextInt();
                                if(opcion==1)
                                {
                                    listaCanciones.bajaCancion(can.getTitulo());
                                }else if(opcion!=1 && opcion!=2)
                                {
                                    System.out.println("\nSeleccione una de las opciones");
                                }

                            }while(opcion!=1 && opcion!=2);

                        }
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

    public static void menuAdmin(ListaUsuarios listaUsuarios, ListaCanciones listaCanciones){
        Scanner scan = new Scanner(System.in);
        boolean salir = false;
        int opcion = 0, opcion1=0, opcion2=0;
        String dniUsuario = "";
        Usuario user = null;
        Cancion c1 = null;

        do{
            System.out.println("\n 0. Cerrar Sesion");
            System.out.println("\n 1. Usuarios");
            System.out.println("\n 2. Canciones");

            try {

                System.out.println("\n Escribe una de las opciones: ");
                opcion = scan.nextInt();

                switch (opcion) {
                    case 0:
                        break;
                    case 1:
                        do{
                            System.out.println("\n 0. Volver");
                            System.out.println("\n 1. Mostrar usuarios");
                            System.out.println("\n 2. Buscar usuario");
                            System.out.println("\n 3. Modificar usuario");
                            System.out.println("\n 4. Dar de baja o alta un usuario");

                            System.out.println("\n Escribe una de las opciones: ");
                            opcion2 = scan.nextInt();

                            switch (opcion2){
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
                        }while(opcion2!=0);
                        break;

                    case 2:
                        do{
                            System.out.println("\n 0. Volver");
                            System.out.println("\n 1. Mostrar canciones");
                            System.out.println("\n 2. Buscar cancion");
                            System.out.println("\n 3. Cargar cancion");


                            System.out.println("\n Escribe una de las opciones: ");
                            opcion1 = scan.nextInt();

                            switch (opcion1){
                                case 1:
                                    System.out.println(listaCanciones.listarCanciones());
                                    break;

                                case 2:
                                    System.out.println("\nIngrese nombre de la cancion");
                                    String nombre=scan.nextLine();
                                    Cancion can=listaCanciones.buscarCancionPorNombre(nombre);
                                    if(can==null)
                                    {
                                        System.out.println("\nEsa cancion no existe");
                                    }else
                                    {
                                        do{
                                            System.out.println(can.toString());
                                            System.out.println("Desea eliminarla:\n1-Si\n2-No\n");
                                            opcion=scan.nextInt();
                                            if(opcion==1)
                                            {
                                                listaCanciones.bajaCancion(can.getTitulo());
                                            }else if(opcion!=1 && opcion!=2)
                                            {
                                                System.out.println("\nSeleccione una de las opciones");
                                            }
                                        }while(opcion!=1 && opcion!=2);

                                    }
                                    break;

                                case 3:
                                    c1 = ControladoraCancion.altaCancion();
                                    listaCanciones.agregarCancion(c1.getTitulo(),c1);
                                    break;

                                case 0:
                                    break;

                                default:
                                    System.out.println("\n Ingrese una opcion correcta!!");

                            }
                        }while(opcion1 != 0);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                scan.next();
            }
        }while(opcion!=0);
    }
}
