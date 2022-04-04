package ServiceRBAC.service;

import ServiceRBAC.feign.FeignServiceSMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    @Qualifier("ServiceRBAC.feign.FeignServiceSMS")
    private FeignServiceSMS feignServiceSMS;

    @Override
    public String Send() {
        return feignServiceSMS.CallSMS();
    }
}
