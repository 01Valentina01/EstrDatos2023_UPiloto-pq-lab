package co.edu.unipiloto.estdatos.tallerheap.mundo;

import co.edu.unipiloto.estdatos.tallerheap.estructuras.IHeap;
import java.util.ArrayList;
import co.edu.unipiloto.estdatos.tallerheap.pq.MaxPQ;

public class Pizzeria {
    // ----------------------------------
    // Constantes
    // ----------------------------------

    /**
     * Constante que define la accion de recibir un pedido
     */
    public final static String RECIBIR_PEDIDO = "RECIBIR";
    /**
     * Constante que define la accion de atender un pedido
     */
    public final static String ATENDER_PEDIDO = "ATENDER";
    /**
     * Constante que define la accion de despachar un pedido
     */
    public final static String DESPACHAR_PEDIDO = "DESPACHAR";
    /**
     * Constante que define la accion de finalizar la secuencia de acciones
     */
    public final static String FIN = "FIN";

    // ----------------------------------
    // Atributos
    // ----------------------------------
    private IHeap<Pedido> pedidosRecibidosHeap;
    private ArrayList<Pedido> colaDespachos;

    /**
     * Heap que almacena los pedidos recibidos
     */
    // TODO 
    /**
     * Getter de pedidos recibidos
     *
     * @return
     */
    // TODO 
    public IHeap<Pedido> getPedidosRecibidosHeap() {
        return pedidosRecibidosHeap;
    }

    /**
     * Cola de elementos por despachar
     */
    // TODO 
    /**
     * Getter de elementos por despachar
     * @return 
     */
    // TODO 
        public ArrayList<Pedido> getColaDespachos() {
        return colaDespachos;
    }
    
    // ----------------------------------
    // Constructor
    // ----------------------------------
    /**
     * Constructor de la case Pizzeria
     */
    public Pizzeria() {
        // TODO 
// Inicializar el montículo máximo para los pedidos recibidos
       // pedidosRecibidosHeap = new IHeap<>();
        // Inicializar la cola de despachos
        colaDespachos = new ArrayList<>();
    }

    // ----------------------------------
    // Métodos
    // ----------------------------------
    /**
     * Agrega un pedido a la cola de prioridad de pedidos recibidos
     *
     * @param nombreAutor nombre del autor del pedido
     * @param precio precio del pedido
     * @param cercania cercania del autor del pedido
     */
    public void agregarPedido(String nombreAutor, double precio, int cercania) {
        // TODO 
        Pedido pedido = new Pedido(nombreAutor, precio, cercania);
        pedidosRecibidosHeap.add(pedido);
    }

    // Atender al pedido más importante de la cola
    /**
     * Retorna el proximo pedido en la cola de prioridad o null si no existe.
     *
     * @return p El pedido proximo en la cola de prioridad
     */
    public Pedido atenderPedido() {
        // TODO 
        return pedidosRecibidosHeap.poll();
    }

    /**
     * Despacha al pedido proximo a ser despachado.
     *
     * @return Pedido proximo pedido a despachar
     */
    public Pedido despacharPedido() {
        // TODO 
        if (!colaDespachos.isEmpty()) {
            Pedido pedidoDespachado = colaDespachos.remove(0);
            return pedidoDespachado;
        } else {
            return null;
        }
    }

    /**
     * Retorna la cola de prioridad de pedidos recibidos como una lista.
     *
     * @return list lista de pedidos recibidos.
     */
    public ArrayList<Pedido> pedidosRecibidosList() {
        // TODO 
        return null;
    }

    /**
     * Retorna la cola de prioridad de despachos como una lista.
     *
     * @return list cola de prioridad de despachos.
     */
    public ArrayList<Pedido> colaDespachosList() {
        // TODO 
        return new ArrayList<>(colaDespachos);
    }
}
