//package SpringCloudGateway.filter;
//
//import SpringCloudGateway.responseMapper.JsonResponse;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import java.nio.charset.StandardCharsets;
//
//@Configuration
//public class JWTAuthCheckFilter {
//
//    @Bean
//    @Order(-102)
//    public GlobalFilter jwtAuthGlobalFilter()
//    {
//        return (exchange, chain) -> {
//            ServerHttpRequest serverHttpRequest = exchange.getRequest();
//            ServerHttpResponse serverHttpResponse = exchange.getResponse();
//            String requestUrl = serverHttpRequest.getURI().getPath();
//
//
//            if(!requestUrl.equals("/auth")){
//
//                // 獲取 header 中的 token
//                String jwtToken = serverHttpRequest
//                        .getHeaders()
//                        .getFirst("jwt");
//
//                if(jwtToken == null){ //如果 JWT token 不合法
////                    return writeUnAuthorizedMessageAsJson(serverHttpResponse,"Please Sign In First !");
//                }
//
//                // 在 header 加上指定 資料
//                ServerHttpRequest mutableReq = serverHttpRequest
//                        .mutate()
//                        .header("userId", "Pass Jwt Token")
//                        .build();
//
//                ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
//                return chain.filter(mutableExchange);
//
//            }else{
//                return chain.filter(exchange);
//            }
//        };
//    }
//
//    // Jwt token 認證失敗
////    private Mono<Void> writeUnAuthorizedMessageAsJson(ServerHttpResponse serverHttpResponse, String message) {
////        serverHttpResponse.setStatusCode(HttpStatus.OK);
////        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
////
////        JsonResponse jsonResponse = JsonResponse.responseAll();
////        jsonResponse.setMessage(message);
////
////        DataBuffer dataBuffer = serverHttpResponse.bufferFactory()
////                .wrap(JSON.toJSONStringWithDateFormat(jsonResponse,JSON.DEFFAULT_DATE_FORMAT)
////                        .getBytes(StandardCharsets.UTF_8));
////
////        return serverHttpResponse.writeWith(Flux.just(dataBuffer));
////    }
//
//}
