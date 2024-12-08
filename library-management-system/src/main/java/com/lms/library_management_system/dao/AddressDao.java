package com.lms.library_management_system.dao;

import com.lms.library_management_system.entity.Address;
import com.lms.library_management_system.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List; // Import for List
import java.util.Optional;

@Repository
public class AddressDao {

    @Autowired
    private AddressRepository addressRepository;

    /**
     * Find an Address by its ID.
     *
     * @param addressId the ID of the Address to retrieve
     * @return the Address entity if found, otherwise null
     */
    public Address findByAddressId(int addressId) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        return optionalAddress.orElse(null);
    }

    /**
     * Save an Address.
     *
     * @param address the Address entity to be saved
     * @return the saved Address
     */
    public Address saveAddress(Address address) {
        return addressRepository.save(address);
    }

    /**
     * Update an Address by its ID.
     *
     * @param addressId the ID of the Address to update
     * @param address   the Address entity with updated details
     * @return the updated Address entity if successful, otherwise null
     */
    public Address updateAddress(int addressId, Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            Address existingAddress = optionalAddress.get();

            // Update only the necessary fields
            existingAddress.setHouseNumber(address.getHouseNumber());
            existingAddress.setArea(address.getArea());
            existingAddress.setCity(address.getCity());
            existingAddress.setState(address.getState());
            existingAddress.setCountry(address.getCountry());
            existingAddress.setPincode(address.getPincode());

            return addressRepository.save(existingAddress);
        }
        return null;
    }

    /**
     * Delete an Address by its ID.
     *
     * @param addressId the ID of the Address to delete
     * @return true if the deletion was successful, otherwise false
     */
    public boolean deleteAddress(int addressId) {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            addressRepository.delete(optionalAddress.get());
            return true;
        }
        return false;
    }

    /**
     * Fetch all Addresses from the database.
     *
     * @return a list of all Address entities
     */
    public List<Address> fetchAllAddress() {
        return addressRepository.findAll(); // Fetches all records from the Address table
    }
}
