package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.CreateProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.DeleteProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.db.repository.mock.ProductoRepositoryMockImpl;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductoConfig {

    //POST
      @Bean
    public CreateProductoUseCase createProductoUseCase() {
		//Añadimos en la llamada una instancia de nuestro MOCK.
        return new CreateProductoUseCase(new ProductoRepositoryMockImpl());
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
    public DeleteProductoUseCase deleteProductoUseCase(){
        return new DeleteProductoUseCase();
    }

    //DELETE
    @Bean 
    public DeleteProductoService deleteProductoService(){
        return new DeleteProductoService(deleteProductoUseCase());
    }
    //PUT
    @Bean
    public EditProductoUseCase editProductoUseCase(){
        return new EditProductoUseCase();
    }

    //PUT
    @Bean
    public EditProductoService editProductoService(){
        return new EditProductoService(editProductoUseCase());
    }
}
