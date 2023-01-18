package br.com.tech4mepizza.pizzzaria.servise;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4mepizza.pizzzaria.repositorio.Pizzarepositorio;
import br.com.tech4mepizza.pizzzaria.shared.PizzaCompletoDto;
import br.com.tech4mepizza.pizzzaria.shared.PizzaDto;
@Service
public class PizzaServiceImpl implements PizzaService {
    
    @Autowired
    private Pizzarepositorio repositorio;
    
    @Override
    public List<PizzaCompletoDto> obterTodasAsPizzas() {
        return repositorio.findAll();
    }

    @Override
    public Optional<PizzaDto> obterPizzaPorId(String id) {
        Optional<PizzaCompletoDto>pizza = repositorio.findById(id);

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
        return repositorio.save(pizza);
    }

    @Override
    public Optional <PizzaCompletoDto> atualizarPetPorId(String id, PizzaCompletoDto pizza) {
        Optional<PizzaCompletoDto> retorno = repositorio.findById(id);
        pizza.setId(id);
        if(retorno.isPresent()){
            pizza.setId(id);
            return Optional.of(repositorio.save(pizza));
        }else{
            return null;
        }
       
    }
    
}
