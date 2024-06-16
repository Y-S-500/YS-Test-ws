package com.AMONIC.Airlines.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.AMONIC.Airlines.Entity.Tickets;
import com.AMONIC.Airlines.IService.ITicketsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("v1/api/Tickets")
public class TicketsController extends ABaseController<Tickets, ITicketsService> {

	private static final String UPLOAD_DIR = "uploads/";

    protected TicketsController(ITicketsService service) {
        super(service, "Tickets");
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Seleccione un archivo para subir.");
        }

        try {
            // Crear el directorio de uploads si no existe
            File directory = new File(UPLOAD_DIR);
            if (!directory.exists()) {
                directory.mkdir();
            }

            // Guardar el archivo en la carpeta especificada
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);

            String rutaGuardado = path.toString();
            return ResponseEntity.ok().body("{\"filePath\": \"" + rutaGuardado + "\"}");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error al subir el archivo: " + e.getMessage());
        }
    }}

