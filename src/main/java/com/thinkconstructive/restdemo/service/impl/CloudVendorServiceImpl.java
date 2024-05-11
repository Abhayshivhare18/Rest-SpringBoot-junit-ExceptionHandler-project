package com.thinkconstructive.restdemo.service.impl;

import com.thinkconstructive.restdemo.exception.CloudVendorNotFoundException;
import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudVendorRepository;
import com.thinkconstructive.restdemo.service.CloudVendorService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "updated";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
         cloudVendorRepository.deleteById(cloudVendorId);
         return "Deleted";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
         if(cloudVendorRepository.findById(cloudVendorId).isEmpty()){
             throw new CloudVendorNotFoundException("Requested cloud vendor does not exits");
         }
         return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendors() throws InterruptedException {
       System.out.println("Start getAllCloudVendors()");
        getMethod();
        System.out.println("getAllCloudVendors " +Thread.currentThread().getName());
        return cloudVendorRepository.findAll();

    }

    @Async("asyncTaskExecutor")
    public void getMethod() throws InterruptedException {
        System.out.println("getMethod " +Thread.currentThread().getName());
        System.out.println("start the method");
        Thread.sleep(10000);
        System.out.println("end the method");

    }
}
