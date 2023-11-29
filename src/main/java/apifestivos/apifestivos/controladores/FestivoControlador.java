package apifestivos.apifestivos.controladores;

import apifestivos.apifestivos.controladores.dto.EsFestivoResponseDto;
import apifestivos.apifestivos.interfaces.FestivoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path=  "/api/festivos")
@RequiredArgsConstructor
public class FestivoControlador {

    private final FestivoServicio festivoServicio;

    @GetMapping(path = "/obtener-festivos")
    public ResponseEntity<List<Date>> obtenerFestivos(@RequestParam("anio") int anio) {
        System.out.println("hola");
        return ResponseEntity.status(HttpStatus.OK)
                .body(festivoServicio.obtenerFestivos(anio));
    }

    @GetMapping("/es-festivo")
    public ResponseEntity<EsFestivoResponseDto> esFestivo(@RequestParam("fecha") String fecha) {
        try {

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaConvertida = dateFormat.parse(fecha);

            boolean esFestivo = festivoServicio.esFestivo(fechaConvertida);
            EsFestivoResponseDto esFestivoResponse = EsFestivoResponseDto.builder()
                    .esFestivo(esFestivo)
                    .build();

            return ResponseEntity.status(HttpStatus.OK)
                    .body(esFestivoResponse);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null);
        }
    }
}

