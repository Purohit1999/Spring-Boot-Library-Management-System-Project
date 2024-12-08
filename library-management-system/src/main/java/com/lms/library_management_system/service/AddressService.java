package com.lms.library_management_system.service;

import com.lms.library_management_system.dao.AddressDao;
import com.lms.library_management_system.dto.AddressDto;
import com.lms.library_management_system.entity.Address;
import com.lms.library_management_system.exception.AddressIdNotFoundException;
import com.lms.library_management_system.util.ResponseStructure;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * MIT License
 * Copyright (c) 2024 Purohit1999
 */

/**
 * Service layer for managing Address entities.
 */
@Service
public class AddressService {

    private final AddressDao addressDao;
    private final ModelMapper modelMapper;

    @Autowired
    public AddressService(AddressDao addressDao, ModelMapper modelMapper) {
        this.addressDao = addressDao;
        this.modelMapper = modelMapper;

        // Configure ModelMapper to skip null values during mapping
        this.modelMapper.getConfiguration().setSkipNullEnabled(true);
    }

    /**
     * Save a new address.
     *
     * @param addressDto The DTO containing address details.
     * @return ResponseEntity containing the saved address.
     */
    public ResponseEntity<ResponseStructure<Address>> saveAddress(AddressDto addressDto) {
        Address address = modelMapper.map(addressDto, Address.class);
        Address savedAddress = addressDao.saveAddress(address);

        ResponseStructure<Address> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Address Saved Successfully");
        response.setData(savedAddress);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Retrieve an address by its ID.
     *
     * @param addressId The ID of the address.
     * @return ResponseEntity containing the address if found.
     * @throws AddressIdNotFoundException if the address does not exist.
     */
    public ResponseEntity<ResponseStructure<Address>> findByAddressId(int addressId) {
        Address dbAddress = addressDao.findByAddressId(addressId);

        if (dbAddress == null) {
            throw new AddressIdNotFoundException("Address with ID " + addressId + " not found");
        }

        ResponseStructure<Address> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Address Found");
        response.setData(dbAddress);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Update an existing address.
     *
     * @param addressId  The ID of the address to update.
     * @param addressDto The DTO containing updated address details.
     * @return ResponseEntity containing the updated address.
     * @throws AddressIdNotFoundException if the address does not exist.
     */
    public ResponseEntity<ResponseStructure<Address>> updateAddress(int addressId, AddressDto addressDto) {
        Address existingAddress = addressDao.findByAddressId(addressId);

        if (existingAddress == null) {
            throw new AddressIdNotFoundException("Address with ID " + addressId + " not found");
        }

        // Map updated values from DTO to existing entity
        modelMapper.map(addressDto, existingAddress);

        // Save the updated address
        Address updatedAddress = addressDao.saveAddress(existingAddress);

        ResponseStructure<Address> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Address Updated Successfully");
        response.setData(updatedAddress);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Delete an address by its ID.
     *
     * @param addressId The ID of the address to delete.
     * @return ResponseEntity confirming the deletion.
     * @throws AddressIdNotFoundException if the address does not exist.
     */
    public ResponseEntity<ResponseStructure<String>> deleteAddress(int addressId) {
        boolean isDeleted = addressDao.deleteAddress(addressId);

        if (!isDeleted) {
            throw new AddressIdNotFoundException("Address with ID " + addressId + " not found");
        }

        ResponseStructure<String> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Address Deleted Successfully");
        response.setData("Address with ID " + addressId + " has been deleted");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * Fetch all addresses.
     *
     * @return ResponseEntity containing the list of all addresses.
     */
    public ResponseEntity<ResponseStructure<List<Address>>> fetchAllAddresses() {
        List<Address> addresses = addressDao.fetchAllAddress();

        ResponseStructure<List<Address>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Addresses Fetched Successfully");
        response.setData(addresses);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
