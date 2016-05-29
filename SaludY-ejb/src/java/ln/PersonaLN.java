/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ln;

import dao.PersonaFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import modelo.Persona;

/**
 *
 * @author eli
 */
@Stateless
@LocalBean
public class PersonaLN {

    @EJB
    private PersonaFacade personaFacade;
    private Persona persona;
    private Integer[] ids;

    public void crearPersona(Persona p) {
        personaFacade.create(p);
    }

    public void agregar(Persona p) {
        personaFacade.create(p);
    }

    public Persona buscar(int idPersona) {
        return personaFacade.find(idPersona);

    }

    public void editar(Persona p) {
        personaFacade.edit(p);
    }

    public List<Persona> personas() {
        return personaFacade.findAll();
    }


    public int numRan() {
        return personaFacade.count();
    }

    public void borrar(Persona p) {
        personaFacade.remove(p);
    }
}
