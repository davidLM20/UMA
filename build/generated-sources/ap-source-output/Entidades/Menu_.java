package Entidades;

import Entidades.Plato;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-10T06:02:06")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> descripcion;
    public static volatile SingularAttribute<Menu, String> meses;
    public static volatile SingularAttribute<Menu, Integer> idMenu;
    public static volatile SingularAttribute<Menu, String> dias;
    public static volatile CollectionAttribute<Menu, Plato> platoCollection;
    public static volatile SingularAttribute<Menu, String> nombre;

}