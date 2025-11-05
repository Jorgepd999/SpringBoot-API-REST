package es.etg.daw.dawes.java.rest.restfull.productos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.CreateProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.DeleteProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.EditProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.service.producto.FindProductoService;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.CreateProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.DeleteProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.EditProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.application.usecase.producto.FindProductoUseCase;
import es.etg.daw.dawes.java.rest.restfull.productos.domain.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ProductoConfig {

       private final ProductoRepository productoRepository;

    //POST
      @Bean
    public CreateProductoUseCase createProductoUseCase() {
		//Añadimos en la llamada una instancia de nuestro MOCK.
        return new CreateProductoUseCase(productoRepository);
    }
    //POST
    @Bean
    public CreateProductoService createProductoService(){
        return new CreateProductoService(createProductoUseCase());
    }
    
    //Get
       @Bean
    public FindProductoUseCase findProductoUseCase(){
        return new FindProductoUseCase(productoRepository);
    }
    //GET
    @Bean
    public FindProductoService findProductoService(){
        return new FindProductoService(findProductoUseCase());
    }

    //DELETE
    @Bean
    public DeleteProductoUseCase deleteProductoUseCase(){
        return new DeleteProductoUseCase(productoRepository);
    }

    //DELETE
    @Bean 
    public DeleteProductoService deleteProductoService(){
        return new DeleteProductoService(deleteProductoUseCase());
    }
    //PUT
    @Bean
    public EditProductoUseCase editProductoUseCase(){
        return new EditProductoUseCase(productoRepository);
    }

    //PUT
    @Bean
    public EditProductoService editProductoService(){
        return new EditProductoService(editProductoUseCase());
    }
}
