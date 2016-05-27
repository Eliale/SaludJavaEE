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
@Named(value = "signosAdmon")
@ManagedBean
@SessionScoped
public class SignosAdmon {
    @EJB
    private PersonaLN personaLN;
    @EJB
    private SignosVitalesLN signosVitalesLN;
    
    private Signosvitales signosvitales;
    private List<Signosvitales> lista_signosvitales;
    private static int nr2;
    private int idS;
    private Persona persona;
    
    public SignosAdmon() {
        signosvitales = new Signosvitales();
    }

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
    
    public void listar_sv(ActionEvent e){
        lista_signosvitales = signosVitalesLN.lista_sv();
    }
    
    public void iniciar_sv(ActionEvent e){
        setLista_signosvitales();
    }
    
    public void creaSignoVital(ActionEvent e){
        crearSignoVital();
    }
    
     public void crearSignoVital() {
        signosvitales = new Signosvitales();
        signosvitales.setIdsv(cidSv());
      //  signosvitales.setIdpersona(persona);
       
    }
     public void creaSignoV2(ActionEvent e) {
        signosvitales = new Signosvitales();

    }
     public int[] mostrarPersonas(){
         return personaLN.personasid();
     }
     

    public void agregarSV(ActionEvent e) {
        signosVitalesLN.agregarSignoV(signosvitales);
        crearSignoVital();

    }
    
    public void editaSv(ActionEvent e){
        signosVitalesLN.editarSv(signosvitales);
    }

    public void limpiarSv(ActionEvent e) {
        signosvitales = new Signosvitales();

    }

    public int cidSv() {
        if (signosVitalesLN.numRanSv()== 0) {
            nr2 = 1;
        } else {
            setLista_signosvitales();
            nr2 = lista_signosvitales.get(lista_signosvitales.size() - 1).getIdsv()+ 1;
        }

        return nr2;
    }

    public int getNr() {
        return nr2;

    }

    public void setNr() {
        nr2 =signosVitalesLN.numRanSv() + 1;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void buscar(ActionEvent e) {
        Signosvitales sv = signosVitalesLN.buscarSignoV(idS);
        if (sv != null) {
            signosvitales = sv;
        }

    }
    
       public void buscar2() {
        Signosvitales sv = signosVitalesLN.buscarSignoV(getSignosvitales().getIdsv());
        if (sv != null) {
            signosvitales = sv;
        }

    }
       
       public void agregarPer(ActionEvent e){
           persona.setIdpersona(idS);
           signosvitales.setIdpersona(persona);
       }
}
