package SpringCloudGateway.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class gatewayController {

    @Autowired
    private ConfigSetting configSetting;

    @GetMapping("/config/test")
    public String GithubConfigControllerPath(){
        String c = configSetting.getConfigGit();
        return "github 參數: " + c + " ， Service Gateway MasterPath";
    }

    @GetMapping("/gateway/breaker")
    @HystrixCommand
    public String BreakerTestMethod(){
        return "Breaker Test Method ， Service gateway";
    }


}
