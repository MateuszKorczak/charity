package pl.coderslab.charity.services.imple;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.services.interfaces.DonationService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    private final DonationRepository donationRepository;

    public DonationServiceImpl(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override
    public Donation findById(long id) {
        return donationRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("There is no such Donation"));
    }

    @Override
    public Donation saveDonation(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public void updateDonation(Donation donation) {
        donationRepository.save(donation);
    }

    @Override
    public void deleteDonation(long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public List<Donation> findAllDonations() {
        return donationRepository.findAll();
    }

    @Override
    public Long quantityOfAllDonations() {
        return donationRepository.count();
    }

    @Override
    public Long allBagsAmount() {
        return donationRepository.allBagsAmount();
    }
}