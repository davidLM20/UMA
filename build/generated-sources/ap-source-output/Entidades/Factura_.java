package Entidades;

import Entidades.Cliente;
import Entidades.Feedback;
import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Factura.class)
public class Factura_ { 

    public static volatile SingularAttribute<Factura, String> fecha;
    public static volatile SingularAttribute<Factura, Cliente> idCliente;
    public static volatile SingularAttribute<Factura, Integer> idFactura;
    public static volatile SingularAttribute<Factura, Double> valor;
    public static volatile SingularAttribute<Factura, String> numeroFactura;
    public static volatile SingularAttribute<Factura, Feedback> idFeedBack;
    public static volatile SingularAttribute<Factura, Pedido> idPedido;

}