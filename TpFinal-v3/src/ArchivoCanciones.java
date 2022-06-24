
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class ArchivoCanciones implements Serializable{

    public static void grabarArchivoManualmente()
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("Canciones.dat");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            ArrayList<String> artista=new ArrayList<String>();
            artista.add("Airbag");
            Cancion cancion1 = new Cancion("Intoxicarme",artista, "Al Parecer Todo Ha Sido una Trampa", "Rock", 181, 2021);
            Cancion cancion2 = new Cancion("Kamikaze",artista, "Al Parecer Todo Ha Sido una Trampa", "Rock", 141, 2021);
            Cancion cancion3 = new Cancion("Ganas de Verte",artista, "Al Parecer Todo Ha Sido una Trampa", "Rock", 183, 2021);
            Cancion cancion4 = new Cancion("Mi sensacion",artista, "Una Hora a Tokyo", "Rock", 246, 2008);

            ArrayList<String> artista2=new ArrayList<String>();
            artista2.add("Conociendo Rusia");
            Cancion cancion5 = new Cancion("Quiere Que Me Llames",artista2, "Cabildo y Juramento", "Rock", 167, 2019);
            Cancion cancion6 = new Cancion("Cabildo y Juramento",artista2, "Cabildo y Juramento", "Rock", 203, 2019);

            ArrayList<String> artista3=new ArrayList<String>();
            artista3.add("Guns N' Roses");
            Cancion cancion7 = new Cancion("It's So Easy",artista3, "Appetite For Destruction", "Rock", 248, 1987);
            Cancion cancion8 = new Cancion("Welcome To The Jungle",artista3, "Appetite For Destruction", "Rock", 260, 1987);
            Cancion cancion9 = new Cancion("Live And Let Die",artista3, "Use Your Illusion I", "Rock", 202, 1991);
            Cancion cancion10 = new Cancion("November Rain",artista3, "Use Your Illusion I", "Rock", 536, 1991);

            ArrayList<String> artista4=new ArrayList<String>();
            artista4.add("El Kuelgue");
            Cancion cancion11 = new Cancion("Circunvalacion",artista4, "Ruli", "Bossa", 167, 2013);
            Cancion cancion12 = new Cancion("En Avenidas",artista4, "Ruli", "Bossa", 167, 2013);

            ArrayList<String> artista5=new ArrayList<String>();
            artista5.add("Coldplay");
            Cancion cancion13 = new Cancion("Yellow",artista5, "Parachutes", "Pop", 199, 2000);
            Cancion cancion14 = new Cancion("Trouble",artista5,"Parachutes", "Pop", 190, 2000);
            Cancion cancion15 = new Cancion("Everglow",artista5, "A Head Full of Dreams", "Pop", 210, 2015);
            Cancion cancion16 = new Cancion("Adventure of a Lifetime",artista5,"A Head Full of Dreams", "Pop", 240, 2015);
            Cancion cancion17 = new Cancion("Up&Up",artista5, "A Head Full of Dreams", "Pop", 199, 2015);
            artista5.add("Tove Lo");
            Cancion cancion18 = new Cancion("Fun",artista5,"A Head Full of Dreams", "Pop", 218, 2015);

            ArrayList<String> artista6=new ArrayList<String>();
            artista6.add("The Beatles");
            Cancion cancion19 = new Cancion("Help!",artista6, "Help!	", "Rock", 207, 1965);
            Cancion cancion20 = new Cancion("Yesterday",artista6, "Help!	", "Rock", 247, 1965);
            Cancion cancion21 = new Cancion("Tell Me What You See",artista6, "Help", "Rock", 187, 1965);
            Cancion cancion22 = new Cancion("Blackbird",artista6,"The Beatles", "Rock", 187, 1968);
            Cancion cancion23 = new Cancion("Julia",artista6,"The Beatles", "Rock", 187, 1968);
            Cancion cancion24 = new Cancion("Come Together",artista6,"Abbey Road", "Rock", 212, 1969);
            Cancion cancion25 = new Cancion("Here Comes The Sun",artista6,"Abbey Road", "Rock", 187, 1969);
            Cancion cancion26 = new Cancion("Two Of Us",artista6,"Let It Be", "Rock", 197, 1970);
            Cancion cancion27 = new Cancion("Let It Be",artista6,"Let It Be", "Rock", 202, 1970);
            Cancion cancion28 = new Cancion("For You Blue",artista6,"Let It Be", "Rock", 240, 1970);



            objectOutputStream.writeObject(cancion1);
            objectOutputStream.writeObject(cancion2);
            objectOutputStream.writeObject(cancion3);
            objectOutputStream.writeObject(cancion4);
            objectOutputStream.writeObject(cancion5);
            objectOutputStream.writeObject(cancion6);
            objectOutputStream.writeObject(cancion7);
            objectOutputStream.writeObject(cancion8);
            objectOutputStream.writeObject(cancion9);
            objectOutputStream.writeObject(cancion10);
            objectOutputStream.writeObject(cancion11);
            objectOutputStream.writeObject(cancion12);
            objectOutputStream.writeObject(cancion13);
            objectOutputStream.writeObject(cancion14);
            objectOutputStream.writeObject(cancion15);
            objectOutputStream.writeObject(cancion16);
            objectOutputStream.writeObject(cancion17);
            objectOutputStream.writeObject(cancion18);
            objectOutputStream.writeObject(cancion19);
            objectOutputStream.writeObject(cancion20);
            objectOutputStream.writeObject(cancion21);
            objectOutputStream.writeObject(cancion22);
            objectOutputStream.writeObject(cancion23);
            objectOutputStream.writeObject(cancion24);
            objectOutputStream.writeObject(cancion25);
            objectOutputStream.writeObject(cancion26);
            objectOutputStream.writeObject(cancion27);
            objectOutputStream.writeObject(cancion28);
            objectOutputStream.close();

        }

        catch (EOFException e1)
        {
            System.out.println("Fin del Archivo");
        }

        catch (FileNotFoundException e2)
        {
            e2.printStackTrace();
        }
        catch (IOException e3)
        {
            e3.printStackTrace();
        }


    }

    public static void grabarArchivo(ListaCanciones canciones)
    {
        try
        {

            FileOutputStream fileOutputStream = new FileOutputStream("Canciones.dat");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            ArrayList<Cancion>  array = canciones.devolverCanciones();
            for(int i=0;i<array.size();i++)
            {
                objectOutputStream.writeObject(array.get(i));
            }

            objectOutputStream.close();
        }

        catch (EOFException e1)
        {
            System.out.println("Fin del Archivo");
        }

        catch (FileNotFoundException e2)
        {
            e2.printStackTrace();
        }
        catch (IOException e3)
        {
            e3.printStackTrace();
        }


    }

    public static ListaCanciones leerArchivo()
    {
        ListaCanciones listaCanciones =  new ListaCanciones();
        try {
            FileInputStream fileInputStream = new FileInputStream("Canciones.dat");

            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);


            int lectura =1;
            while (lectura ==1)
            {
                Cancion aux;
                aux = (Cancion)inputStream.readObject();
                listaCanciones.agregarCancion(aux.getTitulo(), aux);
            }
            inputStream.close();

        }
        catch (EOFException e1)
        {
            System.out.println("Fin del Archivo");
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (ClassNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        return listaCanciones;

    }


}
