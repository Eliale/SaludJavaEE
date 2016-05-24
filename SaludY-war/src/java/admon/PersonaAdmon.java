/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import ln.PersonaLN;
import modelo.Persona;

/**
 *
 * @author eli
 */
@Named(value = "personaAdmon")
@ManagedBean
@SessionScoped
public class PersonaAdmon {

    @EJB
    private PersonaLN personaLN;
    private Persona persona;
    private List<Persona> personas;
    private static int nr;
    private int idP;

    public PersonaAdmon() {
    }
    
     public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Persona> getPersonas() {
        return personaLN.personas();
    }

    public void setPersonas() {
        this.personas = personaLN.personas();
    }

    public void listar(ActionEvent e) {
        personas = personaLN.personas();

    }

    //otro metodo para listas:
    public void iniciarPersonas(ActionEvent e) {
        setPersonas();
    }

    public void creaPersona(ActionEvent e) {
      //  persona=new Persona2();
        //  nr++;
        //persona.setIdpersona(nr);
        //persona.setIdpersona(cidPersona());
        crearPersona();
    }

    public void crearPersona() {
        persona = new Persona();
        persona.setIdpersona(cidPersona());
    }
     public void creaPersona2(ActionEvent e) {
        persona = new Persona();
       // persona.setIdpersona(cidPersona()-1);
    }
     

    public void agregar(ActionEvent e) {
       // setNr();
        // persona.setIdpersona(getNr());
        personaLN.agregar(persona);
        //persona=new Persona2();
        crearPersona();

    }
    
    public void edita(ActionEvent e){
        personaLN.editar(persona);
    }

    public void limpiar(ActionEvent e) {
        persona = new Persona();

    }

    public int cidPersona() {
        if (personaLN.numRan() == 0) {
            nr = 1;
        } else {
            setPersonas();
            nr = personas.get(personas.size() - 1).getIdpersona() + 1;
        }

        return nr;
    }

    public int getNr() {
        return nr;

    }

    public void setNr() {
        nr = personaLN.numRan() + 1;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void buscar(ActionEvent e) {
        Persona p = personaLN.buscar(idP);
        if (p != null) {
            persona = p;
        }

    }
    
       public void buscar2() {
        Persona p = personaLN.buscar(getPersona().getIdpersona());
        if (p != null) {
            persona = p;
        }

    }
}
