package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.AddressDto;
import com.lms.library_management_system.entity.Address;
import com.lms.library_management_system.service.AddressService;
import com.lms.library_management_system.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for managing Address-related HTTP requests.
 * Exposes endpoints for CRUD operations.
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /**
     * Endpoint to save a new address.
     * URL: POST http://localhost:8080/address
     *
     * @param addressDto The AddressDto object containing address details.
     * @return ResponseEntity containing ResponseStructure with the saved Address.
     */
    @PostMapping
    public ResponseEntity<ResponseStructure<Address>> saveAddress(@RequestBody AddressDto addressDto) {
        return addressService.saveAddress(addressDto);
    }

    /**
     * Endpoint to fetch an address by its ID.
     * URL: GET http://localhost:8080/address/{addressId}
     *
     * @param addressId The ID of the Address to fetch.
     * @return ResponseEntity containing ResponseStructure with the Address or error message.
     */
    @GetMapping("/{addressId}")
    public ResponseEntity<ResponseStructure<Address>> findByAddressId(@PathVariable int addressId) {
        return addressService.findByAddressId(addressId);
    }

    /**
     * Endpoint to update an address by its ID.
     * URL: PUT http://localhost:8080/address/{addressId}
     *
     * Example JSON body for the request:
     * {
     *     "addressId": 1,
     *     "houseNumber": 203,
     *     "area": "mgroad",
     *     "city": "mysore",
     *     "state": "ka",
     *     "country": "India",
     *     "pincode": 560065
     * }
     *
     * @param addressId  The ID of the Address to update.
     * @param addressDto The updated AddressDto object.
     * @return ResponseEntity containing ResponseStructure with the updated Address.
     */
    @PutMapping("/{addressId}")
    public ResponseEntity<ResponseStructure<Address>> updateAddress(
            @PathVariable int addressId,
            @RequestBody AddressDto addressDto) {
        return addressService.updateAddress(addressId, addressDto);
    }
}
