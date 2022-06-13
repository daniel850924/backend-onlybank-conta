package br.unibh.sdm.backend_onlybank.rest;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.unibh.sdm.backend_onlybank.entidades.Conta;
import br.unibh.sdm.backend_onlybank.negocio.ContaService;

/**
 * Classe contendo as definições de serviços REST/JSON para Conta
 *
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "conta")
public class ContaController {
   
    private final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping
    public List<Conta> getcontas(){
        return contaService.getContas();
    }
    
    @GetMapping(value="{id}")
    public Conta getContaById(@PathVariable String id) throws Exception{
        if(!ObjectUtils.isEmpty(id)){
           return contaService.getContaById(id);
        }
        throw new Exception("Conta com codigo "+id+" nao encontrada");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Conta createConta(@RequestBody @NotNull Conta Conta) throws Exception {
         return contaService.saveConta(Conta);
    }
    
    @PutMapping(value = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Conta updateConta(@PathVariable String id, 
    		@RequestBody @NotNull Conta Conta) throws Exception {
    	if (!id.equals(Conta.getId())) {
    		throw new Exception("Codigo "+id+" nao está correto");
    	}
    	if (!contaService.isContaExists(Conta)) {
    		throw new Exception("Conta com codigo "+id+" não existe");
    	}
        return contaService.saveConta(Conta);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "{id}")
    public boolean updateConta(@PathVariable String id) throws Exception {
    	if (!contaService.isContaExists(id)) {
    		throw new Exception("Conta com codigo "+id+" não existe");
    	} 
    	contaService.deleteConta(id);
        return true;
    }
}