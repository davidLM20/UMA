package Entidades;

import Entidades.Pedido;
import Entidades.Plato;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:07")
@StaticMetamodel(Platopedido.class)
public class Platopedido_ { 

    public static volatile SingularAttribute<Platopedido, Integer> estado;
    public static volatile SingularAttribute<Platopedido, Plato> idPlato;
    public static volatile SingularAttribute<Platopedido, Integer> idPlatoPedido;
    public static volatile SingularAttribute<Platopedido, Integer> cantidad;
    public static volatile SingularAttribute<Platopedido, Pedido> idPedido;
    public static volatile SingularAttribute<Platopedido, String> observacion;

}