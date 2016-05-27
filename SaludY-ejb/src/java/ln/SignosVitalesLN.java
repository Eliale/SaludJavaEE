package ln;

import dao.SignosvitalesFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Persona;
import modelo.Signosvitales;

@Stateless
@LocalBean
public class SignosVitalesLN {

    @EJB
    private SignosvitalesFacade signosvitalesFacade;
    private Signosvitales signosvitales;
    private Persona persona;

    public void crearSignoV(Signosvitales sv) {
        signosvitalesFacade.create(sv);
    }

    public void agregarSignoV(Signosvitales sv) {
        signosvitalesFacade.create(sv);
    }

    public Signosvitales buscarSignoV(int idSignoV) {
        return signosvitalesFacade.find(idSignoV);
    }

    public void editarSv(Signosvitales sv) {
        signosvitalesFacade.edit(sv);
    }

    public List<Signosvitales> lista_sv() {
//        List<Signosvitales> all, temp = null;
//
//        all = signosvitalesFacade.findAll();
//
//        for (int i = 0; i < all.size(); i++) {
//            if (all.get(i).getIdpersona().getIdpersona() == persona.getIdpersona()) {
//                temp.add(all.get(i));
//            }
//
//        }
            return signosvitalesFacade.findAll();
        //return temp;
    }

    public int numRanSv() {
        return signosvitalesFacade.count();
    }

    public void borrarSv(Signosvitales sv) {
        signosvitalesFacade.remove(sv);
    }
}
