package br.com.tech4mepizza.pizzzaria.servise;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4mepizza.pizzzaria.model.Pizza;
import br.com.tech4mepizza.pizzzaria.repositorio.Pizzarepositorio;
@Service
public class PizzaServiceImpl implements PizzaService {
    
    @Autowired
    private Pizzarepositorio repositorio;
    
    @Override
    public List<Pizza> obterTodasAsPizzas() {
        return repositorio.findAll();
    }

    @Override
    public Optional<Pizza> obterPizzaPorId(String id) {
        return repositorio.findById(id);
    }

    @Override
    public void exculirPizzaPorId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public Pizza cadastrarPizza(Pizza pizza) {
        return repositorio.save(pizza);
    }

    @Override
    public Pizza atualizarPizzaPorId(String id, Pizza pizza) {
        pizza.setId(id);
        return repositorio.save(pizza);
    }
    
}
