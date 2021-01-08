package pl.coderslab.charity.services.interfaces;

import pl.coderslab.charity.entity.Donation;

import java.util.List;

public interface DonationService {

    Donation findById(long id);

    Donation saveDonation(Donation donation);

    void updateDonation(Donation donation);

    void deleteDonation(long id);

    List<Donation> findAllDonations();

    Long quantityOfAllDonations();

    Long allBagsAmount();
}
