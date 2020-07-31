package Entidades;

import Entidades.Menu;
import Entidades.Platopedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Plato.class)
public class Plato_ { 

    public static volatile SingularAttribute<Plato, String> descripcion;
    public static volatile SingularAttribute<Plato, Double> costo;
    public static volatile SingularAttribute<Plato, Double> tiempo;
    public static volatile SingularAttribute<Plato, Integer> idPlato;
    public static volatile CollectionAttribute<Plato, Platopedido> platopedidoCollection;
    public static volatile SingularAttribute<Plato, String> nombre;
    public static volatile CollectionAttribute<Plato, Menu> menuCollection;

}