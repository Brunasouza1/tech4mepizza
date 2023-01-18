package br.com.tech4mepizza.pizzzaria.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4mepizza.pizzzaria.shared.PizzaCompletoDto;


public interface Pizzarepositorio extends MongoRepository<PizzaCompletoDto,String> {
    
}
