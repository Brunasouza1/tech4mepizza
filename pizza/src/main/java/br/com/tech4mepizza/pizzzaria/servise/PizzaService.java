package br.com.tech4mepizza.pizzzaria.servise;

import br.com.tech4mepizza.pizzzaria.shared.PizzaCompletoDto;
import br.com.tech4mepizza.pizzzaria.shared.PizzaDto;
import java.util.List;
import java.util.Optional;


public interface PizzaService {
    List<PizzaCompletoDto> obterTodasAsPizzas();
    Optional<PizzaDto> obterPizzaPorId(String id);
    void exculirPizzaPorId (String id);
    PizzaCompletoDto cadastrarPizza(PizzaCompletoDto pizza);
    Optional <PizzaCompletoDto> atualizarPetPorId (String id,PizzaCompletoDto pizza);
}