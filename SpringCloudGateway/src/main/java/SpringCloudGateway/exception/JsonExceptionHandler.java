//package SpringCloudGateway.exception;
//
//import SpringCloudGateway.responseMapper.JsonResponse;
//import com.alibaba.fastjson.JSON;
//import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
//import org.springframework.cloud.gateway.support.NotFoundException;
//import org.springframework.core.annotation.Order;
//import org.springframework.core.io.buffer.DataBufferFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.NotAcceptableStatusException;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import java.net.URI;
//
//@Order(-1)
//@Component
//public class JsonExceptionHandler implements ErrorWebExceptionHandler {
//
//    public JsonExceptionHandler() {
//    }
//
//    @Override
//    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
//
//        ServerHttpResponse response = exchange.getResponse();
//        if (response.isCommitted()) {
//            // 對於已經committed(提交)的response，就不能再使用這個response向緩衝區寫任何東西
//            return Mono.error(ex);
//        }
//
//        // header set 響應JSON類型數據，統一響應數據結構
//        response.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//
//        // 按照異常類型進行翻譯處理，翻譯的結果易於前端理解
//        String message;
//        if (ex instanceof NotFoundException) {
//            response.setStatusCode(HttpStatus.NOT_FOUND);
//            message = "您請求的服務不存在";
//        } else if (ex instanceof ResponseStatusException) {
//            ResponseStatusException responseStatusException = (ResponseStatusException) ex;
//            response.setStatusCode(responseStatusException.getStatus());
//            message = responseStatusException.getMessage();
//        } else if (ex instanceof NotAcceptableStatusException) {
//            response.setStatusCode(HttpStatus.FORBIDDEN);
//            message = ex.getMessage();
//        } else {
//            response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
//            message = "服務器內部錯誤";
//        }
//
//        // 全局通用響應數據結構，可以自定義。通常包含請求結果code、message、data
//        JsonResponse result = JsonResponse.responseAll();
//        result.setMessage(message);
//
//        writeLog(exchange, ex);
//
//        return response.writeWith(Mono.fromSupplier(() -> {
//
//            DataBufferFactory bufferFactory = response.bufferFactory();
//            return bufferFactory.wrap(JSON.toJSONBytes(result));
//
//        }));
//
//    }
//
//    // 將錯誤信息以日誌的形式記錄下來 暫時先sout
//    private void writeLog(ServerWebExchange exchange, Throwable ex) {
//        ServerHttpRequest request = exchange.getRequest();
//        URI uri = request.getURI();
//        String host = uri.getHost();
//        int port = uri.getPort();
//        System.out.println("[gateway]-" + host  + ":{} , " + port + ":{}，" + uri + ":{},  errormessage:" + ex.getLocalizedMessage());
//    }
//}
