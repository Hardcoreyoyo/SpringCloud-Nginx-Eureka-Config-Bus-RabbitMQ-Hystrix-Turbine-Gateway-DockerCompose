package ServiceRBAC.controller;

public class BaseController {

    protected String commonFallbackMethod() {
        return "自定義 Hystrix 異常訊息";
    }
}
