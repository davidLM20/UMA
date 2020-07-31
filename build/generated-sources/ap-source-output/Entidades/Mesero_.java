package Entidades;

import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Mesero.class)
public class Mesero_ { 

    public static volatile SingularAttribute<Mesero, String> codigo;
    public static volatile SingularAttribute<Mesero, String> horario;
    public static volatile SingularAttribute<Mesero, Integer> idMesero;
    public static volatile SingularAttribute<Mesero, String> cedula;
    public static volatile SingularAttribute<Mesero, String> apellido;
    public static volatile SingularAttribute<Mesero, String> direccion;
    public static volatile SingularAttribute<Mesero, String> celular;
    public static volatile SingularAttribute<Mesero, Double> sueldo;
    public static volatile CollectionAttribute<Mesero, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Mesero, String> nombre;

}