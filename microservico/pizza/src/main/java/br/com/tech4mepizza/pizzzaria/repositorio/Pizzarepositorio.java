package br.com.tech4mepizza.pizzzaria.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.tech4mepizza.pizzzaria.model.Pizza;


public interface Pizzarepositorio extends MongoRepository<Pizza,String> {
    
}
