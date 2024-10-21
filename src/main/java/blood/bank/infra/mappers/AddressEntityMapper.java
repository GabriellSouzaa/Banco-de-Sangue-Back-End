package blood.bank.infra.mappers;

import blood.bank.domain.entities.address.Address;
import blood.bank.infra.persistence.models.AddressEntity;

public class AddressEntityMapper {

    public static AddressEntity toEntity(Address address){
        return new AddressEntity(address.getStreet(), address.getNumber(), address.getNeighborhood(), address.getCity(), address.getState(), address.getPostalCode());
    }

    public static Address toAddress(AddressEntity addressEntity){
        return new Address(addressEntity.getStreet(), addressEntity.getNumber(), addressEntity.getNeighborhood(), addressEntity.getCity(), addressEntity.getState(), addressEntity.getPostalCode());
    }
}
