package Entidades;

import Entidades.Pedido;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Cajero.class)
public class Cajero_ { 

    public static volatile SingularAttribute<Cajero, String> codigo;
    public static volatile SingularAttribute<Cajero, String> horario;
    public static volatile SingularAttribute<Cajero, Integer> idCajero;
    public static volatile SingularAttribute<Cajero, String> cedula;
    public static volatile SingularAttribute<Cajero, String> apellido;
    public static volatile SingularAttribute<Cajero, String> direccion;
    public static volatile SingularAttribute<Cajero, String> celular;
    public static volatile SingularAttribute<Cajero, Double> sueldo;
    public static volatile CollectionAttribute<Cajero, Pedido> pedidoCollection;
    public static volatile SingularAttribute<Cajero, String> nombre;

}