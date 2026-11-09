public class Carta {
    private int numero;
    private String nombre;

    public Carta(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getNombre() {
        return nombre;
    }

    // Esto es clave para que ArraySet sepa que ya existe
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Carta otra = (Carta) o;
        return numero == otra.numero;
    }

    @Override
    public String toString() {
        return numero + " - " + nombre;
    }
}