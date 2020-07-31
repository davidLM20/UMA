package Entidades;

import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:07")
@StaticMetamodel(Cocinero.class)
public class Cocinero_ { 

    public static volatile SingularAttribute<Cocinero, String> codigo;
    public static volatile SingularAttribute<Cocinero, String> horario;
    public static volatile SingularAttribute<Cocinero, String> cedula;
    public static volatile SingularAttribute<Cocinero, String> apellido;
    public static volatile SingularAttribute<Cocinero, String> direccion;
    public static volatile SingularAttribute<Cocinero, Integer> idCocinero;
    public static volatile SingularAttribute<Cocinero, String> celular;
    public static volatile SingularAttribute<Cocinero, Double> sueldo;
    public static volatile CollectionAttribute<Cocinero, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Cocinero, String> nombre;

}