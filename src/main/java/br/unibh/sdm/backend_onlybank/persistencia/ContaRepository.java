package br.unibh.sdm.backend_onlybank.persistencia;
import java.util.Optional;

import br.unibh.sdm.backend_onlybank.entidades.Conta;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


/**
 * Esta classe estende o padrão CrudRepository 
 *
 */
@EnableScan()
public interface ContaRepository extends CrudRepository<Conta, String> {

	Optional<Conta> findById(String id);
	
}
