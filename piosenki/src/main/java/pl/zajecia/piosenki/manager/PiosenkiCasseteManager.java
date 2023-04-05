package pl.zajecia.piosenki.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zajecia.piosenki.dao.PiosenkiCasseteRepo;
import pl.zajecia.piosenki.dao.entity.PiosenkiCassete;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class PiosenkiCasseteManager {
	private PiosenkiCasseteRepo piosenkiCasseteRepo;


	@Autowired
	public PiosenkiCasseteManager(PiosenkiCasseteRepo piosenkiCasseteRepo) {
		this.piosenkiCasseteRepo = piosenkiCasseteRepo;
	}

	public Optional<PiosenkiCassete> findAllById(Long id){
		return piosenkiCasseteRepo.findById(id);
	}

	public Iterable<PiosenkiCassete> findAll(){
		return piosenkiCasseteRepo.findAll();
	}

	public PiosenkiCassete save(PiosenkiCassete piosenkiCassete){
		return piosenkiCasseteRepo.save(piosenkiCassete);
	}
	public void delete(Long id){
		piosenkiCasseteRepo.deleteById(id);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void fillDb(){
		save(new PiosenkiCassete(1L,"tytul1", LocalDate.of(1999,2,2)));
		save(new PiosenkiCassete(2L,"tytul2", LocalDate.of(2022,8,12)));
	}
}
