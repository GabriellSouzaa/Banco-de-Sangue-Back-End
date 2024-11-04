package blood.bank.infra.gateways;

import blood.bank.application.gateways.BloodBagRepositoryGateway;
import blood.bank.domain.entities.bloodBag.BloodBag;
import blood.bank.infra.mappers.BloodBagEntityMapper;
import blood.bank.infra.models.requests.BloodBagRequest;
import blood.bank.infra.models.requests.DonationRequest;
import blood.bank.infra.persistence.models.BloodBagEntity;
import blood.bank.infra.persistence.models.DonationEntity;
import blood.bank.infra.persistence.models.DonorEntity;
import blood.bank.infra.persistence.models.PeopleEntity;
import blood.bank.infra.persistence.repositories.BloodBagRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class BloodBagRepositoryJpa implements BloodBagRepositoryGateway {

    private final BloodBagRepository bloodBagRepository;

    private final BloodBagEntityMapper bloodBagEntityMapper;

    private final JdbcTemplate jdbcTemplate;

    public BloodBagRepositoryJpa(BloodBagRepository bloodBagRepository, BloodBagEntityMapper bloodBagEntityMapper, JdbcTemplate jdbcTemplate) {
        this.bloodBagRepository = bloodBagRepository;
        this.bloodBagEntityMapper = bloodBagEntityMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BloodBag> getBloodBags() {
        List<BloodBagEntity> bloodBags = bloodBagRepository.findAll();
        return bloodBags.stream().map(BloodBagEntityMapper::toBloodBag).collect(Collectors.toList());
    }

    @Override
    public void deleteExpiredBloodBags() {
        String sql = "DELETE FROM bolsa_de_sangue WHERE data_validade < ?";
        jdbcTemplate.update(sql, LocalDate.now());
    }

    @Override
    public void createBloodBag(BloodBagRequest bloodBagRequest) {
        BloodBagEntity bloodBag = new BloodBagEntity();

        bloodBag.setBloodType(bloodBagRequest.getBloodType());
        bloodBag.setBloodComponent(bloodBagRequest.getBloodComponent());
        bloodBag.setBagVolume(bloodBagRequest.getBagVolume());
        bloodBag.setCollectionDate(bloodBagRequest.getCollectionDate());
        bloodBag.setExpirationDate(bloodBagRequest.getExpirationDate());
        bloodBag.setBagStatus(bloodBagRequest.getBagStatus());
        bloodBag.setTestResult(bloodBagRequest.getTestResult());
        bloodBag.setFreezerNumber(bloodBagRequest.getFreezerNumber());
        bloodBag.setBatchCode(bloodBagRequest.getBatchCode());
        bloodBag.setComplianceStatus(bloodBagRequest.getComplianceStatus());
        bloodBag.setNotes(bloodBagRequest.getNotes());
        bloodBag.setProcessingDate(bloodBagRequest.getProcessingDate());

        if(!bloodBagRequest.getDonations().isEmpty()){
            for(DonationRequest donation : bloodBagRequest.getDonations()){
                PeopleEntity peopleEntity = new PeopleEntity();
                DonorEntity donor = new DonorEntity();
                DonationEntity donationEntity = new DonationEntity();
                peopleEntity.setFullName(donation.getDonor().getPeople().getFullName());
                peopleEntity.setDateOfBirth(donation.getDonor().getPeople().getDateOfBirth());
                peopleEntity.setGender(donation.getDonor().getPeople().getGender());
                peopleEntity.setEmail(donation.getDonor().getPeople().getEmail());
                donor.setPeople(peopleEntity);
                donor.setBloodType(donation.getDonor().getBloodType());
                donor.setRegisterDate(donation.getDonor().getRegisterDate());
                donor.setLastDonationDate(donation.getDonor().getLastDonationDate());
                donor.setNumberOfDonations(donation.getDonor().getNumberOfDonations());
                donor.setEligibility(donation.getDonor().getEligibility());
                donor.setMedicalNotes(donation.getDonor().getMedicalNotes());
                donor.setbCoinsBalance(donation.getDonor().getbCoinsBalance());
                donor.setImage(donation.getDonor().getImage());
                donationEntity.setDonor(donor);
                donationEntity.setDateDonation(donation.getDateDonation());
                donationEntity.setDonatioType(donation.getDonatioType());
                donationEntity.setQuantityCollected(donationEntity.getQuantityCollected());
                donationEntity.setDonationStatus(donation.getDonationStatus());
                donationEntity.setObservation(donation.getObservation());
                donationEntity.setDonationScore(donation.getDonationScore());
                bloodBag.getDonations().add(donationEntity);
            }
        }
        bloodBagRepository.save(bloodBag);
    }

    @Override
    public void updateBloodBag(String batchCode, BloodBagRequest bloodBagRequest) {
        BloodBagEntity bloodBag = bloodBagRepository.findBloodBagEntityByBatchCode(batchCode);

        bloodBag.setBloodType(bloodBagRequest.getBloodType());
        bloodBag.setBloodComponent(bloodBagRequest.getBloodComponent());
        bloodBag.setBagVolume(bloodBagRequest.getBagVolume());
        bloodBag.setCollectionDate(bloodBagRequest.getCollectionDate());
        bloodBag.setExpirationDate(bloodBagRequest.getExpirationDate());
        bloodBag.setBagStatus(bloodBagRequest.getBagStatus());
        bloodBag.setTestResult(bloodBagRequest.getTestResult());
        bloodBag.setFreezerNumber(bloodBagRequest.getFreezerNumber());
        bloodBag.setBatchCode(bloodBagRequest.getBatchCode());
        bloodBag.setComplianceStatus(bloodBagRequest.getComplianceStatus());
        bloodBag.setNotes(bloodBagRequest.getNotes());
        bloodBag.setProcessingDate(bloodBagRequest.getProcessingDate());

        if(!bloodBagRequest.getDonations().isEmpty()){
            for(DonationRequest donation : bloodBagRequest.getDonations()){
                PeopleEntity peopleEntity = new PeopleEntity();
                DonorEntity donor = new DonorEntity();
                DonationEntity donationEntity = new DonationEntity();
                peopleEntity.setFullName(donation.getDonor().getPeople().getFullName());
                peopleEntity.setDateOfBirth(donation.getDonor().getPeople().getDateOfBirth());
                peopleEntity.setGender(donation.getDonor().getPeople().getGender());
                peopleEntity.setEmail(donation.getDonor().getPeople().getEmail());
                donor.setPeople(peopleEntity);
                donor.setBloodType(donation.getDonor().getBloodType());
                donor.setRegisterDate(donation.getDonor().getRegisterDate());
                donor.setLastDonationDate(donation.getDonor().getLastDonationDate());
                donor.setNumberOfDonations(donation.getDonor().getNumberOfDonations());
                donor.setEligibility(donation.getDonor().getEligibility());
                donor.setMedicalNotes(donation.getDonor().getMedicalNotes());
                donor.setbCoinsBalance(donation.getDonor().getbCoinsBalance());
                donor.setImage(donation.getDonor().getImage());
                donationEntity.setDonor(donor);
                donationEntity.setDateDonation(donation.getDateDonation());
                donationEntity.setDonatioType(donation.getDonatioType());
                donationEntity.setQuantityCollected(donationEntity.getQuantityCollected());
                donationEntity.setDonationStatus(donation.getDonationStatus());
                donationEntity.setObservation(donation.getObservation());
                donationEntity.setDonationScore(donation.getDonationScore());
                bloodBag.getDonations().add(donationEntity);
            }
    }
        bloodBagRepository.save(bloodBag);
    }

    @Override
    public void deleteBloodBag(String batchCode) {
        BloodBagEntity bloodBagEntity = bloodBagRepository.findBloodBagEntityByBatchCode(batchCode);
        bloodBagRepository.delete(bloodBagEntity);
    }

}

