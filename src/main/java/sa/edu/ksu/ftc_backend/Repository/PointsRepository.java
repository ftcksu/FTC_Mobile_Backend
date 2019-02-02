package sa.edu.ksu.ftc_backend.Repository;

import org.springframework.data.repository.CrudRepository;
import sa.edu.ksu.ftc_backend.Model.Points;

public interface PointsRepository extends CrudRepository<Points,Integer> {
}
