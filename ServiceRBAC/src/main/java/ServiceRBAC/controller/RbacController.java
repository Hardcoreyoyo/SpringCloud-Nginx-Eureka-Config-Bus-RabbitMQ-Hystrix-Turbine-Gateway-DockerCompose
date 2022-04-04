package ServiceRBAC.controller;

import ServiceRBAC.service.SendEmailService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rbac")
//@DefaultProperties(defaultFallback = "commonFallbackMethod") // 可以指定該類中所有方法在發生服務熔斷異常的時候，執行fallback函數。
public class RbacController extends BaseController{

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private ConfigSetting configSetting;

    @GetMapping("")
    public String MasterPath(){
        return "/rbaac Service RBAC MasterPath";
    }

    @GetMapping("/sms")
    @HystrixCommand
    public String CallSMS(){
        return sendEmailService.Send();
    }

    @GetMapping("/config/test")
    public String GithubConfigControllerPath(){
        String c = configSetting.getConfigGit();
        return "github 參數: " + c + " ， Service RBAC MasterPath";
    }

    @GetMapping("/breaker")
    @HystrixCommand( // 不推薦此方法 雖然可以實現功能，但增大了代碼量，而且非常冗餘
            commandProperties = {
                    @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1000"), // 統計窗口時間
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),  // 啟用熔斷功能
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),  // 5個請求失敗觸發熔斷
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),  // 請求錯誤率超過60%觸發熔斷
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "30000"),// 熔斷後開始嘗試恢復的時間
            }
    )
    public String BreakerTestMethod(){
        return "Breaker Test Method ， Service RBAC";
    }

    @GetMapping("/breaker/yml")
    @HystrixCommand // 全局配置完成之後，想讓哪一個方法實現斷路器功能，就在哪一個方法上加上註解：
    public String BreakerTestyml(){
        return "Breaker Test 設定檔配置全局熔斷 ， Service RBAC";
    }
    // 絕大部分接口調用採用全局配置的方式，針對個別個性化重點業務接口使用註解配置。註解配置屬性會覆蓋全局配置屬性，註解配置的優先級更高。
    // 總結就是：追求統一處理、允許個性化實現






}
