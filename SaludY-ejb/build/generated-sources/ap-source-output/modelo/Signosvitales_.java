package modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Persona;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-05-29T01:40:33")
@StaticMetamodel(Signosvitales.class)
public class Signosvitales_ { 

    public static volatile SingularAttribute<Signosvitales, Date> fecha;
    public static volatile SingularAttribute<Signosvitales, Integer> presions;
    public static volatile SingularAttribute<Signosvitales, Integer> presiond;
    public static volatile SingularAttribute<Signosvitales, Double> peso;
    public static volatile SingularAttribute<Signosvitales, Persona> idpersona;
    public static volatile SingularAttribute<Signosvitales, Integer> idsv;

}