package com.thinkconstructive.restdemo.controller;

import com.thinkconstructive.restdemo.Response.ResponseHandler;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cloudvendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }



    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){

        return ResponseHandler.responseBuilder("Requested vendor details given here",
                HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails(){
        return cloudVendorService.getAllCloudVendors();
    }
     @PostMapping
     public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

         return cloudVendorService.createCloudVendor(cloudVendor);
     }

     @PutMapping
     public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.updateCloudVendor(cloudVendor);
     }

     @DeleteMapping("{vendorId}")
     public String deleteCloudVendorDetails(@PathVariable("vendorId")  String vendorId){

       return cloudVendorService.deleteCloudVendor(vendorId);
     }
}
