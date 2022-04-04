//package SpringCloudGateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.util.pattern.PathPatternParser;
//
//import java.util.Arrays;
//
//@Configuration
//public class CorsWebConfig {
//
//    @Bean
//    public CorsWebFilter corsFilter() {
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowedMethods(Arrays.asList(
//                HttpMethod.POST.name(),
//                HttpMethod.GET.name()
//        ));
//        config.addAllowedOrigin("Http://localhost:8080"); //假設目前的我的前端應用是：localhost:8080
//        config.addAllowedHeader("*");
//
//        UrlBasedCorsConfigurationSource source
//                = new UrlBasedCorsConfigurationSource(new PathPatternParser());
//        source.registerCorsConfiguration("/**", config);
//
//        return new CorsWebFilter(source);
//    }
//
//}
//
//
////TODO 不想在代碼層面把配置內容寫死，
//// 仍然可以採用nacos裡面的配置屬性自動組裝GlobalCorsProperties及CorsWebFilter
//// 並讓yml中的跨域配置生效
//
////@Configuration
////@AutoConfigureAfter(GlobalCorsProperties.class)
////public class CorsWebConfig {
////
////    @Resource
////    private  GlobalCorsProperties globalCorsProperties;
////
////    @Bean
////    public CorsWebFilter corsFilter() {
////        UrlBasedCorsConfigurationSource source
////                = new UrlBasedCorsConfigurationSource(new PathPatternParser());
////        globalCorsProperties.getCorsConfigurations()
////                .forEach(source::registerCorsConfiguration);
////        return new CorsWebFilter(source);
////    }
////
////}
//
////spring:
////    cloud:
////        gateway:
////            globalcors:
////                cors-configurations:
////                    '[/**]':
////                    allowCredentials: true
////                    exposedHeaders: "*"
////                    allowedHeaders: "*"
////                    allowedOrigins: "http://localhost:8080"
////                    allowedMethods:
////                    - GET
////                    - POST