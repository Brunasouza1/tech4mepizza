package br.com.tech4mepizza.pizzzaria.servise;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.tech4mepizza.pizzzaria.model.Pizza;
import br.com.tech4mepizza.pizzzaria.repositorio.Pizzarepositorio;
import br.com.tech4mepizza.pizzzaria.shared.PizzaCompletoDto;
import br.com.tech4mepizza.pizzzaria.shared.PizzaDto;

@Service
public class PizzaServiceImpl implements PizzaService {
    
    @Autowired
    private Pizzarepositorio repositorio;
    
    @Override
    public List<PizzaCompletoDto> obterTodasAsPizzas() {
        List<Pizza>pizzas=repositorio.findAll();
        return pizzas.stream()
        .map(p->new ModelMapper().map(p,PizzaCompletoDto.class))
        .collect(Collectors.toList());

   
    }

    @Override
    public Optional<PizzaDto> obterPizzaPorId(String id) {
        Optional<Pizza>pizza = repositorio.findById(id);

        if(pizza.isPresent()){
            return Optional.of(new ModelMapper().map(pizza.get(),PizzaDto.class));
        }
        return Optional.empty();
    }

    @Override
    public void exculirPizzaPorId(String id) {
        repositorio.deleteById(id);
        
    }

    @Override
    public PizzaCompletoDto cadastrarPizza(PizzaCompletoDto pizza) {
        Pizza pizzas =new ModelMapper().map(pizza,Pizza.class);
        repositorio.save(pizzas);
        return new ModelMapper().map(pizza,PizzaCompletoDto.class);
    }

    @Override
    public Optional <PizzaCompletoDto> atualizarPetPorId(String id, PizzaCompletoDto dto) {
        Optional<Pizza> retorno = repositorio.findById(id);
        
        if (retorno.isPresent()){
            Pizza pizza =new ModelMapper().map(dto,Pizza.class);
            pizza.setId(id);
            repositorio.save(pizza);
            return Optional.of(new ModelMapper().map(pizza, PizzaCompletoDto.class));
        }else{
            return Optional.empty();
        }
       
    }
    
}
