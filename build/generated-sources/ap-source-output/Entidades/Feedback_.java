package Entidades;

import Entidades.Factura;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, String> calificacion;
    public static volatile SingularAttribute<Feedback, Integer> idFeedBack;
    public static volatile SingularAttribute<Feedback, String> observacion;
    public static volatile CollectionAttribute<Feedback, Factura> facturaCollection;

}