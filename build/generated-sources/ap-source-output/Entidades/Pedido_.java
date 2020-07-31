package Entidades;

import Entidades.Cajero;
import Entidades.Cocinero;
import Entidades.Factura;
import Entidades.Mesero;
import Entidades.Platopedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Integer> estado;
    public static volatile SingularAttribute<Pedido, Integer> numMesa;
    public static volatile SingularAttribute<Pedido, Cajero> idCajero;
    public static volatile SingularAttribute<Pedido, Mesero> idMesero;
    public static volatile CollectionAttribute<Pedido, Platopedido> platopedidoCollection;
    public static volatile SingularAttribute<Pedido, Cocinero> idCocinero;
    public static volatile SingularAttribute<Pedido, Integer> numeroPedido;
    public static volatile SingularAttribute<Pedido, Double> tiempoAproximado;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;
    public static volatile CollectionAttribute<Pedido, Factura> facturaCollection;

}