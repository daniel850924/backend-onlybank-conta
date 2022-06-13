package br.unibh.sdm.backend_onlybank.negocio;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import br.unibh.sdm.backend_onlybank.entidades.Conta;
import br.unibh.sdm.backend_onlybank.persistencia.ContaRepository;

/**
 * Classe contendo a lógica de negócio para Conta
 *
 */
@Service
public class ContaService {

    private static final Logger logger= LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    
    private final ContaRepository contaRepo;

    public ContaService(ContaRepository contaRepository){
        this.contaRepo= contaRepository;
    }
    
    public List<Conta> getContas(){
        if(logger.isInfoEnabled()){
            logger.info("Buscando todos os objetos");
        }
        Iterable<Conta> lista = this.contaRepo.findAll();
        if (lista == null) {
        	return new ArrayList<Conta>();
        }
        return IteratorUtils.toList(lista.iterator());
    }

    public Conta getContaById(String id){
        if(logger.isInfoEnabled()){
            logger.info("Buscando Conta com o codigo {}",id);
        }
        Optional<Conta> retorno = this.contaRepo.findById(id);
        if(!retorno.isPresent()){
            throw new RuntimeException("Conta com o codigo "+id+" nao encontrada");
        }
        return retorno.get();
    }


    public Conta saveConta(Conta Conta){
        if(logger.isInfoEnabled()){
            logger.info("Salvando Conta com os detalhes {}",Conta.toString());
        }
        return this.contaRepo.save(Conta);
    }
    
    public void deleteConta(String codigo){
        if(logger.isInfoEnabled()){
            logger.info("Excluindo Conta com id {}",codigo);
        }
        this.contaRepo.deleteById(codigo);
    }

    public boolean isContaExists(Conta Conta){
    	Optional<Conta> retorno = this.contaRepo.findById(Conta.getId());
        return retorno.isPresent() ? true:  false;
    }

    public boolean isContaExists(String codigo){
    	Optional<Conta> retorno = this.contaRepo.findById(codigo);
        return retorno.isPresent() ? true:  false;
    }
}