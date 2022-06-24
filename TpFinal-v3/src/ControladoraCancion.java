import java.util.ArrayList;
import java.util.Scanner;

public class ControladoraCancion {
    static Scanner teclado;

    public static Cancion altaCancion()
    {
        teclado = new Scanner(System.in);

        System.out.println("\n Complete los siguientes campos por favor: ");

        System.out.println("\n Titulo: ");
        String titulo = teclado.nextLine();

        System.out.println("\n Album: ");
        String album = teclado.nextLine();

        System.out.println("\n Duracion: ");
        Double duracion = teclado.nextDouble();

        System.out.println("\n Año: ");
        int Anio = teclado.nextInt();

        System.out.println("\n Seleccione un genero: ");
        String genero=teclado.nextLine();

        teclado.nextLine();

        System.out.println("\n Nombre Artista: ");
        ArrayList<String> artista=new ArrayList<String>();
        artista.add(teclado.nextLine());
        System.out.println("\n Si tiene algun otro artista ingreselo, de lo contrario ingrese 'no': ");
        String pregunta=teclado.nextLine();
        if(!pregunta.equals("no") && !pregunta.equals("No") && !pregunta.equals("NO") && !pregunta.equals("nO")) {
            artista.add(pregunta);
            System.out.println("\n Si tiene algun otro artista ingreselo, de lo contrario ingrese 'no': ");
            String pregunta2 = teclado.nextLine();
            if (!pregunta2.equals("no") && !pregunta2.equals("No") && !pregunta2.equals("NO") && !pregunta2.equals("nO")) {
                artista.add(pregunta2);

            }

        }

        Cancion cancion = new Cancion(titulo, artista, album, genero, duracion, Anio);
        return cancion;
    }



}
