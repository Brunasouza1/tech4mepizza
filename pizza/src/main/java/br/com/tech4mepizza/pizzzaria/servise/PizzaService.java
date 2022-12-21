package br.com.tech4mepizza.pizzzaria.servise;

import br.com.tech4mepizza.pizzzaria.model.Pizza;
import java.util.List;
import java.util.Optional;




public interface PizzaService {
    List<Pizza> obterTodasAsPizzas();
    Optional<Pizza> obterPizzaPorId(String id);
    void exculirPizzaPorId (String id);
    Pizza cadastrarPizza(Pizza pizza);
    Pizza atualizarPizzaPorId (String id,Pizza pizza);
}