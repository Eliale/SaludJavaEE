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
import ln.SignosVitalesLN;
import modelo.Persona;
import modelo.Signosvitales;

/**
 *
 * @author eli
 */
@Named(value = "personaAdmon")
@ManagedBean
@SessionScoped
public class PersonaAdmon {

    @EJB
    private SignosVitalesLN signosVitalesLN;

    @EJB
    private PersonaLN personaLN;
    private Persona persona;
    private List<Persona> personas;
    private static int nr;
    private int idP;

    // De signos vitales
    private Signosvitales signosvitales;
    private List<Signosvitales> lista_signosvitales;
    private static int nr2;
    private int idS;

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
        crearPersona();
    }

    public void crearPersona() {
        persona = new Persona();
        persona.setIdpersona(cidPersona());
    }

    public void creaPersona2(ActionEvent e) {
        persona = new Persona();

    }

    public void agregar(ActionEvent e) {
        personaLN.agregar(persona);
        crearPersona();

    }

    public void edita(ActionEvent e) {
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

    public void buscar3() {
        Persona p = personaLN.buscar(getPersona().getIdpersona());
        if (p != null) {
            persona = p;
        }
        crearSignoVital();
    }

       //metodos para Signos vitales
    public Signosvitales getSignosvitales() {
        return signosvitales;
    }

    public void setSignosvitales(Signosvitales signosvitales) {
        this.signosvitales = signosvitales;
    }

    public List<Signosvitales> getLista_signosvitales() {
        return signosVitalesLN.lista_sv();
    }

    public void setLista_signosvitales() {
        this.lista_signosvitales = signosVitalesLN.lista_sv();
    }

//    public void listar_sv(ActionEvent e) {
//        lista_signosvitales = signosVitalesLN.lista_sv();
//    }

    public void iniciar_sv(ActionEvent e) {
        
        
        setLista_signosvitales();
    }

    public void creaSignoVital(ActionEvent e) {
        crearSignoVital();
    }

    public void crearSignoVital() {
        signosvitales = new Signosvitales();
        signosvitales.setIdsv(cidSv());
        signosvitales.setIdpersona(getPersona());

    }

    public void creaSignoV2(ActionEvent e) {
        signosvitales = new Signosvitales();

    }

    public int[] mostrarPersonas() {
        return personaLN.personasid();
    }

    public void agregarSV(ActionEvent e) {
        signosVitalesLN.agregarSignoV(signosvitales);
        crearSignoVital();

    }

    public void editaSv(ActionEvent e) {
        signosVitalesLN.editarSv(signosvitales);
    }

    public void limpiarSv(ActionEvent e) {
        signosvitales = new Signosvitales();

    }

    public int cidSv() {
        if (signosVitalesLN.numRanSv() == 0) {
            nr2 = 1;
        } else {
            setLista_signosvitales();
            nr2 = lista_signosvitales.get(lista_signosvitales.size() - 1).getIdsv() + 1;
        }

        return nr2;
    }

    public int getNr2() {
        return nr2;

    }

    public void setNr2() {
        nr2 = signosVitalesLN.numRanSv() + 1;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void buscarSV(ActionEvent e) {
        Signosvitales sv = signosVitalesLN.buscarSignoV(idS);
        if (sv != null) {
            signosvitales = sv;
        }

    }

    public void buscarSV2() {
        Signosvitales sv = signosVitalesLN.buscarSignoV(getSignosvitales().getIdsv());
        if (sv != null) {
            signosvitales = sv;
        }

    }

    public void agregarPer(ActionEvent e) {
        persona.setIdpersona(idS);
        signosvitales.setIdpersona(persona);
    }

}
