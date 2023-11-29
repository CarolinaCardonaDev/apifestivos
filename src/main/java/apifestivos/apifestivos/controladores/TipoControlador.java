package apifestivos.apifestivos.controladores;

import apifestivos.apifestivos.entidades.Tipo;
import apifestivos.apifestivos.interfaces.TipoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tipos")
@RequiredArgsConstructor
public class TipoControlador {

    private final TipoServicio tipoServicio;

    @GetMapping(path = "/todos")
    public List<Tipo> obtenerTipos() {
        return tipoServicio.obtenerTipos();
    }

}



