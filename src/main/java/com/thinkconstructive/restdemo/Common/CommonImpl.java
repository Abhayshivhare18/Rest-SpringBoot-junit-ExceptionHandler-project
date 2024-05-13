package com.thinkconstructive.restdemo.Common;

import com.thinkconstructive.restdemo.model.CloudVendor;
import com.thinkconstructive.restdemo.repository.CloudVendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CommonImpl {
     @Autowired
    CloudVendorRepository cloudVendorRepository;

    @Async("asyncTaskExecutor")
    public void getMethod(CloudVendor cloudVendor) throws Exception {
        try {
            System.out.println("getMethod " + Thread.currentThread().getName());
            System.out.println("start the method");
            Thread.sleep(10000);

            cloudVendor.setVendorPhoneNumber("1234");
            cloudVendorRepository.save(cloudVendor);
            System.out.println("end the method");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
