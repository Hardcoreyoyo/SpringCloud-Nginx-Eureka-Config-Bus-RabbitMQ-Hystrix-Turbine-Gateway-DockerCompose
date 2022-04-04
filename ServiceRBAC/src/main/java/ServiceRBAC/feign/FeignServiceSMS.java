package ServiceRBAC.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

// name 要跟 eureka dashboard 的 Application 名稱一模模一樣樣
@FeignClient(name = "SERVICESMS", fallback = FeignServiceSmsError.class)
public interface FeignServiceSMS {

    @PostMapping("/sms/send")
    String CallSMS();

}
