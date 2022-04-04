//package ServiceRBAC.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.netflix.hystrix.exception.HystrixBadRequestException;
//import feign.Response;
//import feign.Util;
//import feign.codec.ErrorDecoder;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class FeignClientErrorDecoderConfig implements ErrorDecoder {
//
//    @Override
//    public Exception decode(String methodKey, Response response) {
//
//        try {
//            if(response.body() != null){
//                String jsonStr = Util.toString(response.body().asReader());
//
//
//                // if response.status() == 200 就return new HystrixBadRequestException..
//
//                // 將自定義 Json 包裝成 HystrixBadRequestException，不會觸發 FeignClient的Fallback 策略                if (!ajaxResponse.isIsok()) {
//                return new HystrixBadRequestException("自定義 Json 格式錯誤訊息返回給前端");
//
//            }
//
//        } catch (
//    IOException ex) {
//            return feign.FeignException.errorStatus(methodKey, response);
//        }
//        return feign.FeignException.errorStatus(methodKey, response);
//    }
//
//
//}


//全局配置，對所有FeignClient生效
//@EnableFeignClients(
//        defaultConfiguration = FeignClientErrorDecoder.class
//)
//
//
//
//在單個的FeignClient生效
//@FeignClient(name = "SERVICESMS",
//        configuration = FeignClientErrorDecoder.class,
//        fallback = FeignServiceSmsError.class)
//public interface SmsService {
//    //...
//}


//ErrorDecoder只有在FeignClient遠程服務接口響應的HTTP狀態碼不是200-300的情況下才會被執行。
//所以必須使用HTTP狀態碼的方式傳遞異常。
//
//ErrorDecoder接口是Feign提供的，
//我們可以自定義其實現，
//根據“服務提供端”的HTTP響應的狀態碼，
//判斷遠程服務接口是否出現異常，
//如果出現異常拋出RuntimeException，
//實現異常的傳遞。並且不要觸發FeignClient的Fallback 策略，
//所以拋出HystrixBadRequestException。


//為什麼不要觸發FeignClient的Fallback 策略？
//因為我們現在需要的是RuntimeException，
//如果觸發FeignClient的Fallback 策略就又變成“異常信息”了。
//“異常信息”數據是不能觸發數據庫事務回滾的。
//那FeignClient的Fallback 策略還有什麼用？
//在遠程服務網絡超時或服務宕機的時候，
//還是要依靠FeignClient的Fallback 策略。
//因為此時沒有響應結果返回。