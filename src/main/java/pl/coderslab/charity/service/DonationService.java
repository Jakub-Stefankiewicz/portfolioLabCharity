package pl.coderslab.charity.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;


@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;

    public Long donationsQuantity(){
        return donationRepository.count();
    }

    public Long bagsQuantity(){
        return donationRepository.countQuantity().orElse(0L);
    }

    public void save(Donation donation){
        donationRepository.save(donation);
    }
}
