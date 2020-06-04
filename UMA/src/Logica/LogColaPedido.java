/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import CLases.Pedido;
import java.util.ArrayList;

/**
 *
 * @author accel
 */
public class LogColaPedido {
    public ArrayList<Pedido> listaPedidos = new ArrayList<Pedido>();
    public void eliminarPedido(Pedido pedido) {
            this.listaPedidos.remove(pedido);
	}
}
