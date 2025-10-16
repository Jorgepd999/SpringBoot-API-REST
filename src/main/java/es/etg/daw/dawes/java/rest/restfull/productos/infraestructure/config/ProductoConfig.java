package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.FindProductoUseCase;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductoConfig {

    //POST
    
    @Bean
    public CreateProductoUseCase createProductoUseCase() {
        return new CreateProductoUseCase();
    }

    //POST
    @Bean
    public CreateProductoService createProductoService(){
        return new CreateProductoService(createProductoUseCase());
    }
    
    //Get
       @Bean
    public FindProductoUseCase findProductoUseCase(){
        return new FindProductoUseCase();
    }
    //GET
    @Bean
    public FindProductoService findProductoService(){
        return new FindProductoService(findProductoUseCase());
    }

    //DELETE
    @Bean
    public DeleteProductoCase deleteProductoCase(){
        return new DeleteProductoCase();
    }

    //DELETE
    @Bean 
    public DeleteProductoService deleteProductoService(){
        return new DeleteProductoService(deleteProductoCase());
    }

}
