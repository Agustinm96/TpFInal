import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Usuario user = Controladora_Usuario.altaUsuario();
        ListaUsuarios listaDeUsario = new ListaUsuarios();

        System.out.println(listaDeUsario.agregarUsuario(user));
        Usuario user1 = Controladora_Usuario.altaUsuario();
        System.out.println(listaDeUsario.agregarUsuario(user1));*/

        Usuario user1 = new Usuario("Agustin", "Alvarez", "39169663", 25, "03/08/1996", 1, "agustinmalvarez", "des", "mail", "223");
        ListaUsuarios listaUsuarios = new ListaUsuarios();
        listaUsuarios.agregarUsuario(user1);
        //Usuario user2 = Controladora_Usuario.altaUsuario();
        //listaUsuarios.agregarUsuario(user2);
        System.out.println(listaUsuarios.listarUsuarios());

        try {
            listaUsuarios.buscarUsuario("34540");
        } catch (ErrorDeBusquedaUsuario e) {
            e.printStackTrace();
        }


    }
}