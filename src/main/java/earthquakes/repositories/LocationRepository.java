package earthquakes.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import earthquakes.entities.*;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
   List<Location> findByPlaceID(String placeID);
}