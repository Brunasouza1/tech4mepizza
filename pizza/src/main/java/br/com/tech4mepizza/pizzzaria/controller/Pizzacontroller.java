package br.com.tech4mepizza.pizzzaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4mepizza.pizzzaria.model.Pizza;
import br.com.tech4mepizza.pizzzaria.repositorio.Pizzarepositorio;

@RestController
@RequestMapping("/cardapio")
public class Pizzacontroller {
    @Autowired
    private Pizzarepositorio repositorio;

    @PostMapping
    public Pizza cadastrarPizza(@RequestBody Pizza pizza){
        return repositorio.save(pizza);
    }
    
    @GetMapping
    public List<Pizza> obterCardapio(){
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> obterPizza(@PathVariable String id){
        return repositorio.findById(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPizza (@PathVariable String id){
        repositorio.deleteById(id);

    }
    @PutMapping("/{id}")
    public Pizza atualizarPizza(@PathVariable String id,@RequestBody Pizza pizza ){
        pizza.setId(id);
        return repositorio.save(pizza);
    }
}
