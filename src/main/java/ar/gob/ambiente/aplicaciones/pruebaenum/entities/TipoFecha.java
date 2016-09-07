

package ar.gob.ambiente.aplicaciones.pruebaenum.entities;

/**
 *
 * @author rincostante
 */
public enum TipoFecha {
    DE_INSTALACION_DEL_ESTABLECIMIENTO("De Instalación del Establecimiento"),
    DE_CAMBIO_DE_RAZON_SOCIAL("De Cambio de Razón Social"),
    DE_CESACION_DE_ACTIVIDADES_DEL_ESTABLECIMIENTO("De Cesación de Actividades del Establecimiento");

    private String nombre;

    TipoFecha(String nombre){
            this.nombre=nombre;
    }

    public String getNombre() {
            return nombre;
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
    }

    @Override
    public String toString(){
            return nombre;
    }
}
