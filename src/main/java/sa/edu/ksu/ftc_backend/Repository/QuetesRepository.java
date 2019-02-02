package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.Quotes;

public interface QuetesRepository extends CrudRepository<Quotes,Integer> {
}
