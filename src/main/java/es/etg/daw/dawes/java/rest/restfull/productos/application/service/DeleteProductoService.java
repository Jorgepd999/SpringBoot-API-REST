package es.etg.daw.dawes.java.rest.restfull.productos.application.service;

import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteProductoService {

    private final DeleteProductoCase deleteProductoCase;

    public void delete(int id){
        deleteProductoCase.delete(id);
    }
    
}

