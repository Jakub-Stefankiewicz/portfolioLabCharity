package pl.coderslab.charity.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.repository.DonationRepository;

@Service
@RequiredArgsConstructor
public class DonationService {
    private final DonationRepository donationRepository;
}
