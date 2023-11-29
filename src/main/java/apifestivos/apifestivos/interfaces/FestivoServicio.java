package apifestivos.apifestivos.interfaces;

import apifestivos.apifestivos.entidades.Festivo;
import apifestivos.apifestivos.entidades.Tipo;

import java.util.Date;
import java.util.List;

public interface FestivoServicio {
    List<Date> obtenerFestivos(int año);
    boolean esFestivo(Date fecha);
    List<Tipo> obtenerTipos();
    List<Festivo> obtenerFestivos();
    
}

