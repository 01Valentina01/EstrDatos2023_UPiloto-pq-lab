package co.edu.unipiloto.estdatos.tallerheap.mundo;

public class Pedido  implements Comparable<Pedido>  {

    // ----------------------------------
    // Atributos
    // ----------------------------------
    /**
     * Precio del pedido
     */
    private double precio;

    /**
     * Autor del pedido
     */
    private String autorPedido;

    /**
     * Cercania del pedido
     */
    private int cercania;

    // ----------------------------------
    // Constructor
    // ----------------------------------
    /**
     * Constructor del pedido TODO Defina el constructor de la clase
     */
    public Pedido(String autorPedido, double precio, int cercania) {
        this.precio = precio;
        this.autorPedido = autorPedido;
        this.cercania = cercania;
    }

    // ----------------------------------
    // Métodos
    // ----------------------------------

    /**
     * Getter del precio del pedido
     *
     * @return El precio del pedido
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Getter del autor del pedido
     *
     * @return El autor del pedido
     */
    public String getAutorPedido() {
        return autorPedido;
    }

    /**
     * Getter de la cercania del pedido
     *
     * @return La cercanía del pedido
     */
    public int getCercania() {
        return cercania;
    }
    //TODO
    
    @Override
    public int compareTo(Pedido otroPedido) {
        return Double.compare(otroPedido.getPrecio(), this.precio);
    }
    
    
}