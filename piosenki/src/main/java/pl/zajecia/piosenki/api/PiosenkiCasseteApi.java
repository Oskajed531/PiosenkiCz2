package pl.zajecia.piosenki.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.piosenki.dao.entity.PiosenkiCassete;
import pl.zajecia.piosenki.manager.PiosenkiCasseteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping("/api/piosenki")
public class PiosenkiCasseteApi {

	private PiosenkiCasseteManager piosenkiCassetes;

	@Autowired
	public PiosenkiCasseteApi(PiosenkiCasseteManager piosenkiCassete){
		this.piosenkiCassetes=piosenkiCassete;
	}

	@GetMapping("/all")
	public Iterable<PiosenkiCassete> getAll(){
		return piosenkiCassetes.findAll();
	}

	@GetMapping
	public Optional<PiosenkiCassete> getById(@RequestParam long index){
		return piosenkiCassetes.findAllById(index);
	}

	@PostMapping
	public PiosenkiCassete addPiosenki(@RequestBody PiosenkiCassete piosenkiCassete){
		return piosenkiCassetes.save(piosenkiCassete);
	}
	@PutMapping
	public PiosenkiCassete updatePiosenki(@RequestBody PiosenkiCassete piosenkiCassete){
		return piosenkiCassetes.save(piosenkiCassete);
	}
	@DeleteMapping
	public void deletePiosenki(@RequestParam long index){
		piosenkiCassetes.delete(index);
	}

}
