

package ar.gob.ambiente.aplicaciones.pruebaenum.mb;

import ar.gob.ambiente.aplicaciones.pruebaenum.entities.FechaDec;
import ar.gob.ambiente.aplicaciones.pruebaenum.entities.TipoFecha;
import ar.gob.ambiente.aplicaciones.pruebaenum.facades.FechaDecFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author rincostante
 */
public class MbFecha implements Serializable{

    @EJB
    private FechaDecFacade fechaFacade;
    
    private FechaDec fecha;
    
    public MbFecha() {
    }

    /**
     * Métodos de acceso
     */
    public FechaDec getFecha() {
        return fecha;
    }

    public void setFecha(FechaDec fecha) {
        this.fecha = fecha;
    }
        
    public TipoFecha[] getTiposFechas() {
        return TipoFecha.values();
    }    
    
    
    @PostConstruct
    public void init(){
        fecha = new FechaDec();
    }    
    
    public void createFecha(){
        FechaDec tempFecha = fecha;
    }
    
    /*************************
     ** Métodos de selección **
     **************************/ 
    /**
     * @param id equivalente al id de la entidad persistida
     * @return la entidad correspondiente
     */
    public FechaDec getFechaDec(java.lang.Long id) {
        return fechaFacade.find(id);
    }  
    

  /********************************************************************
   ** Converter. Se debe actualizar la entidad y el facade respectivo **
   *********************************************************************/
    @FacesConverter(forClass = FechaDec.class)
    public static class FechaDecControllerConverter implements Converter {

         /**
         *
         * @param facesContext
         * @param component
         * @param value
         * @return
         */
        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MbFecha controller = (MbFecha) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mbFecha");
            return controller.getFechaDec(getKey(value));
        }

        java.lang.Long getKey(String value) {
            java.lang.Long key;
            key = Long.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }
       
        String getStringKey(java.lang.Long value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        /**
         *
         * @param facesContext
         * @param component
         * @param object
         * @return
         */
        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof FechaDec) {
                FechaDec o = (FechaDec) object;
                return getStringKey(o.getId());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + FechaDec.class.getName());
            }
        }
    }      
}
