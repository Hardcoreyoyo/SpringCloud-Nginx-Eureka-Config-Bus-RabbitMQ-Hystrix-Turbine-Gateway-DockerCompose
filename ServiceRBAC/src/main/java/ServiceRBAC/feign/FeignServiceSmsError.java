package ServiceRBAC.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceSmsError implements FeignServiceSMS{

    @Override
    public String CallSMS() {
        return "ServiceRBAC custom FeignServiceSmsError";
    }
}
