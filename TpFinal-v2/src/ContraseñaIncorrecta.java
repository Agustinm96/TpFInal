public class ContraseñaIncorrecta extends Exception{
    private int cantIntentos;

    public ContraseñaIncorrecta(String message, int cantidadDeIntentos){
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
