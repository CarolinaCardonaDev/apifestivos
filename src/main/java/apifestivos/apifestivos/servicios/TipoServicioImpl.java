package apifestivos.apifestivos.servicios;

import apifestivos.apifestivos.entidades.Tipo;
import apifestivos.apifestivos.interfaces.TipoServicio;
import apifestivos.apifestivos.repositorios.TipoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TipoServicioImpl implements TipoServicio {

    private final TipoRepositorio tipoRepositorio;

    @Override
    public List<Tipo> obtenerTipos() {
        return this.tipoRepositorio.findAll();
    }

}
