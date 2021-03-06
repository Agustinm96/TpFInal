public class Contrase├▒aIncorrecta extends Exception{
    private int cantIntentos;

    public Contrase├▒aIncorrecta(String message, int cantidadDeIntentos){
        super(message);
        cantIntentos = cantidadDeIntentos;
    }

    public int getCantIntentos() {
        return cantIntentos;
    }

    @Override
    public String getMessage() {
        return super.getMessage() + "\n Cantidad de intentos: " +getCantIntentos();
    }
}
