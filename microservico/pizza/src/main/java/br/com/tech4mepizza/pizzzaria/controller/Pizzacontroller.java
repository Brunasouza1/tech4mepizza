package br.com.tech4mepizza.pizzzaria.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.tech4mepizza.pizzzaria.servise.PizzaService;
import br.com.tech4mepizza.pizzzaria.shared.PizzaCompletoDto;
import br.com.tech4mepizza.pizzzaria.shared.PizzaDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping ("/cardapio")
public class Pizzacontroller {
  @Autowired 
  private PizzaService servico;

    @PostMapping
    public ResponseEntity <PizzaCompletoDto> cadastrarPizza(@RequestBody @Valid PizzaCompletoDto pizza){
       return new ResponseEntity<>(servico.cadastrarPizza(pizza),HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity< List<PizzaCompletoDto>> obterCardapio(){
        return new ResponseEntity<>(servico.obterTodasAsPizzas(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity <PizzaDto> obterPizza(@PathVariable String id){
      Optional <PizzaDto> retorno = servico.obterPizzaPorId(id);
      
      if (retorno.isPresent()){
         return new ResponseEntity<>(retorno.get(),HttpStatus.FOUND);
      }else{
         return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> excluirPizza (@PathVariable String id){
      servico.exculirPizzaPorId(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }
   
      
    @PutMapping("/{id}")
    public ResponseEntity <PizzaCompletoDto>atualizarPet(@PathVariable String id ,@RequestBody PizzaCompletoDto pizza){
     Optional <PizzaCompletoDto> retorno = servico.atualizarPetPorId(id, pizza);

     if(retorno.isPresent()){
     return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
     }else{
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
     }    
   }

   @GetMapping("/porta")
      public String obterPorta (@Value("${local.server.port}") String porta){
         return "a instancia que respondeu a retribuição está rodando na porta "+ porta;
      }

}
