package com.thinkconstructive.restdemo.controller;

import com.thinkconstructive.restdemo.Response.ResponseHandler;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import com.thinkconstructive.restdemo.service.impl.CloudVendorServiceImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cloudvendor")
@CacheConfig(cacheNames = "CloudVendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;

    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }



    @GetMapping("{vendorId}")
    @Cacheable(key="#vendorId")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId){
        System.out.println("Getting Student with db {} "+ vendorId);
        return ResponseHandler.responseBuilder("Requested vendor details given here",
                HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping("/getAllVendor")
    public List<CloudVendor> getAllCloudVendorDetails() throws InterruptedException {
        return cloudVendorService.getAllCloudVendors();
    }
     @PostMapping
     public String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor){

         return cloudVendorService.createCloudVendor(cloudVendor);
     }

     @PutMapping
     @CacheEvict(key = "#cloudVendor",allEntries = true)
     public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor){
        return cloudVendorService.updateCloudVendor(cloudVendor);
     }

     @DeleteMapping("{vendorId}")
     public String deleteCloudVendorDetails(@PathVariable("vendorId")  String vendorId){

       return cloudVendorService.deleteCloudVendor(vendorId);
     }

    @PostMapping("/SaveCheckAsc")
    public CloudVendor checkAsyncroCall(@RequestBody CloudVendor cloudVendor) throws InterruptedException {
        return cloudVendorService.getAllCloudVendorsAs(cloudVendor);
    }


}
