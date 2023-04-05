package pl.zajecia.piosenki.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zajecia.piosenki.dao.entity.PiosenkiCassete;

@Repository
public interface PiosenkiCasseteRepo extends CrudRepository<PiosenkiCassete,Long> {

}
