package com.alkemy.disney.services;

import com.alkemy.disney.entity.Imagen;
import com.alkemy.disney.repository.ImagenRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenService {

    @Autowired
    private ImagenRepository ir;

    @Transactional
    public Imagen save(MultipartFile file) {
        if (file != null) {
            try {
                Imagen imagen = new Imagen();
                imagen.setMime(file.getContentType());
                imagen.setNombre(file.getName());
                imagen.setContenido(file.getBytes());

                return ir.save(imagen);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Transactional
    public Imagen actualizar(String idImagen, MultipartFile file) {
        if (file != null) {
            try {
                Imagen imagen = new Imagen();
                if (idImagen != null) {
                    Optional<Imagen> respuesta = ir.findById(idImagen);
                    if (respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                }
                imagen.setMime(file.getContentType());
                imagen.setNombre(file.getName());
                imagen.setContenido(file.getBytes());

                return ir.save(imagen);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Transactional
    public void delete(Imagen imagen) {
        ir.delete(imagen);
    }
}
