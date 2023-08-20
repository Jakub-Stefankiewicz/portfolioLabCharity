package pl.coderslab.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public List<Institution> findAll() {
        return institutionRepository.findAll(Pageable.ofSize(4)).getContent();
    }

    public Institution findById(Long id) {
        return institutionRepository.findById(id).get();
    }

    public void save(Institution institution) {
        institutionRepository.save(institution);
    }

    public void delete(Institution institution){
        institutionRepository.delete(institution);
    }
}
