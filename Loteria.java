import java.util.*;

public class Loteria {
    // Aqui usamos LA interfaz de tu profe, no HashSet
    private SetADT<Carta> mazo;
    private ArrayList<Carta> sacadas;

    public Loteria() {
        mazo = new ArraySet<>();
        sacadas = new ArrayList<>();
    }

    public void agregarCarta(Carta carta) {
        if (mazo.contains(carta)) {
            System.out.println("Ya existe, no se agrega: " + carta);
        } else {
            mazo.add(carta);
            System.out.println("Agregada: " + carta);
        }
    }

    // Punto 2: impresion de las agregadas, no importa el orden
    public void mostrarCartasAgregadas() {
        System.out.println("\n--- CARTAS AGREGADAS (" + mazo.size() + ") ---");
        Iterator<Carta> it = mazo.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    // Punto 3: sacar de manera aleatoria
    public Carta sacarCartaAleatoria() {
        if (mazo.isEmpty()) {
            System.out.println("Ya no hay cartas en el mazo!");
            return null;
        }

        // Pasamos el Set a lista para poder sacar una al azar
        ArrayList<Carta> lista = new ArrayList<>();
        Iterator<Carta> it = mazo.iterator();
        while (it.hasNext()) {
            lista.add(it.next());
        }

        Random rnd = new Random();
        Carta sacada = lista.get(rnd.nextInt(lista.size()));

        mazo.remove(sacada);
        sacadas.add(sacada);
        System.out.println("Salio: " + sacada);
        return sacada;
    }

    public int quedan() {
        return mazo.size();
    }
}