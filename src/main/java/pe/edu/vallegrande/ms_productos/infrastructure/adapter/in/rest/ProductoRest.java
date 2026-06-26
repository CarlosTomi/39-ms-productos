package pe.edu.vallegrande.ms_productos.infrastructure.adapter.in.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.edu.vallegrande.ms_productos.application.port.in.IProductoServicePort;
import pe.edu.vallegrande.ms_productos.domain.model.Producto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoRest {

    private final IProductoServicePort servicePort;

    @GetMapping
    public Flux<Producto> findAll() {
        return servicePort.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Producto> findById(@PathVariable Long id) {
        return servicePort.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Producto> create(@RequestBody Producto product) {
        return servicePort.create(product);
    }

    @PutMapping("/{id}")
    public Mono<Producto> update(@PathVariable Long id, @RequestBody Producto product) {
        return servicePort.update(id, product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete(@PathVariable Long id) {
        return servicePort.delete(id);
    }

    @PatchMapping("/{id}/decrease-stock")
    public Mono<Producto> decreaseStock(@PathVariable Long id, @RequestParam Integer quantity) {
        return servicePort.decreaseStock(id, quantity);
    }
}