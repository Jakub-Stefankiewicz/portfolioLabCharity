package pl.coderslab.charity.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;

    public Long donationsQuantity(){
        return donationRepository.count();
    }

    public Long bagsQuantity(){
        List<Donation> donationList=donationRepository.findAll();
        Long bags=0L;
        for (Donation donation:donationList) {
            bags=bags+donation.getQuantity();
        }
        return bags;
    }

    public void save(Donation donation){
        donationRepository.save(donation);
    }
}
