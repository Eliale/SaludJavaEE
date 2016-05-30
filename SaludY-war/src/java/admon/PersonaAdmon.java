/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admon;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
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
    private List<Persona> personas; // Todas las personas
    private List<Integer> personasids;// Todos los id de personas

    private static int nr;
    private int idP;

    // De signos vitales
    private Signosvitales signosvitales;
    private List<Signosvitales> lista_signosvitales; // Todos los signos vitales
    private static int nr2;
    private int idS;

    //
    private int x;
    private ArrayList<Integer> persondas_id;
    private String pagina;
    
    
    public PersonaAdmon() {
        persondas_id = new ArrayList<Integer>();

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

    public List<Integer> getPersonasids() {
        // Aqui habra que convertir get(i).getIdPersona

        setPersonas();
        for (int i = 0; i < personas.size(); i++) {
            System.out.println("entra a for");
            persondas_id.add(personas.get(i).getIdpersona());

        }
        return persondas_id;

    }

    public void setPersonasids(List<Integer> personasids) {
        this.personasids = getPersonasids();
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
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensaje;
        mensaje = new FacesMessage("Nueva persona registrada");
        contexto.addMessage(null, mensaje);

    }

    public void edita(ActionEvent e) {
        personaLN.editar(persona);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensaje;
        mensaje = new FacesMessage("Persona modificada");
        contexto.addMessage(null, mensaje);
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

    public void buscar3() {
        Persona p = personaLN.buscar(getPersona().getIdpersona());
        if (p != null) {
            persona = p;
            setPagina("");
        }
        else{
            setPagina("buscarP");
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

    public void iniciar_sv(ActionEvent e) {
        setLista_signosvitales();
    }

    public void creaSignoVital(ActionEvent e) {
        crearSignoVital();

    }

    public void crearSignoVital() {
        signosvitales = new Signosvitales();
        signosvitales.setIdsv(cidSv());
        signosvitales.setFecha(new Date());
        signosvitales.setIdpersona(getPersona());

    }

    public void agregarSV(ActionEvent e) {
        signosVitalesLN.agregarSignoV(signosvitales);
        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensaje;
        mensaje = new FacesMessage("Signo vital agregado a persona " + signosvitales.getIdpersona().getNombre());
        contexto.addMessage(null, mensaje);
    }

    public void agregarSV2(ActionEvent e) {

        // Aqui es la onda antes de agregarlo necesito de una fomra cachar el id seleccionado
        signosvitales.setIdpersona(personaLN.buscar(x));
        signosVitalesLN.agregarSignoV(signosvitales);

        FacesContext contexto = FacesContext.getCurrentInstance();
        FacesMessage mensaje;
        mensaje = new FacesMessage("Signo vital agregado a persona " + signosvitales.getIdpersona().getNombre());
        contexto.addMessage(null, mensaje);

    }

    public void editaSv(ActionEvent e) {
        signosVitalesLN.editarSv(signosvitales);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getPagina() {
        return pagina;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

}
