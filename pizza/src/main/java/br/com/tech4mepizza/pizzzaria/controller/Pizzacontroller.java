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
import br.com.tech4mepizza.pizzzaria.servise.PizzaService;

@RestController
@RequestMapping("/cardapio")
public class Pizzacontroller {
  @Autowired 
  private PizzaService servico;

    @PostMapping
    public Pizza cadastrarPizza(@RequestBody Pizza pizza){
       return servico.cadastrarPizza(pizza);
    }
    
    @GetMapping
    public List<Pizza> obterCardapio(){
        return servico.obterTodasAsPizzas();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> obterPizza(@PathVariable String id){
       return servico.obterPizzaPorId(id);
    }

    @DeleteMapping("/{id}")
    public void excluirPizza (@PathVariable String id){
        servico.exculirPizzaPorId(id);

    }
    @PutMapping("/{id}")
    public Pizza atualizarPizza(@PathVariable String id,@RequestBody Pizza pizza ){
       return servico.atualizarPizzaPorId(id, pizza);
    }
}
