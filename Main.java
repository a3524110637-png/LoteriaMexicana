public class Main {
    public static void main(String[] args) {
        Loteria loteria = new Loteria();

        String[] nombres = {
                "El Gallo", "El Diablo", "La Dama", "El Catrin", "El Paraguas",
                "La Sirena", "La Escalera", "La Botella", "El Barril", "El Arbol",
                "El Melon", "El Valiente", "El Gorrito", "La Muerte", "La Pera",
                "La Bandera", "El Bandolon", "El Violoncello", "La Garza", "El Pajaro",
                "La Mano", "La Bota", "La Luna", "El Cotorro", "El Borracho",
                "El Negrito", "El Corazon", "La Sandia", "El Tambor", "El Camaron",
                "Las Jaras", "El Musico", "La Arana", "El Soldado", "La Estrella",
                "El Cazo", "El Mundo", "El Apache", "El Nopal", "El Alacran",
                "La Rosa", "La Calavera", "La Campana", "El Cantarito", "El Venado",
                "El Sol", "La Corona", "La Chalupa", "El Pino", "El Pescado",
                "La Palma", "La Maceta", "El Arpa", "La Rana"
        };

        for (int i = 0; i < nombres.length; i++) {
            loteria.agregarCarta(new Carta(i + 1, nombres[i]));
        }

        System.out.println("\n--- Intentando meter una repetida ---");
        loteria.agregarCarta(new Carta(1, "El Gallo"));

        loteria.mostrarCartasAgregadas();

        System.out.println("\n--- SACANDO 5 CARTAS ALEATORIAS ---");
        for (int i = 0; i < 5; i++) {
            loteria.sacarCartaAleatoria();
        }

        System.out.println("\nQuedan en el mazo: " + loteria.quedan());
    }
}