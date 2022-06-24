import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArchivoUsuarios implements Serializable{


    public static ListaUsuarios leerArchivoUsuarios()
    {
        ListaUsuarios lista = new ListaUsuarios();
        try {
            FileInputStream fileInputStream = new FileInputStream("Usuarios.dat");

            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);


            int lectura =1;
            while (lectura ==1)
            {
                Usuario aux;
                aux = (Usuario)inputStream.readObject();
                lista.agregarUsuario(aux);
                //System.out.println(aux);//Mostar par aprobar
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
        return lista;

    }



    public static void grabarArchivoUsuarios(ListaUsuarios lista)
    {
        try
        {

            FileOutputStream fileOutputStream = new FileOutputStream("Usuarios.dat");

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            ArrayList<Usuario>  array = lista.devolverUsuarios();
            for(int i=0;i<array.size();i++)
            {
                objectOutputStream.writeObject(array.get(i));
            }
            objectOutputStream.close();

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


}
