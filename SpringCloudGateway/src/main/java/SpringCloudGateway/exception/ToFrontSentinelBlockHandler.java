//package SpringCloudGateway.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.reactive.function.server.ServerResponse;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.web.reactive.function.BodyInserters.fromObject;
//
//public class ToFrontSentinelBlockHandler implements BlockRequestHandler {
//
//    @Override
//    public Mono<ServerResponse> handleRequest(ServerWebExchange exchange, Throwable t) {
//        ErrorResult errorResult = new ToFrontSentinelBlockHandler.ErrorResult(
//                HttpStatus.TOO_MANY_REQUESTS.value(),
//                "Please Request Later!");
//        // JSON result by default.
//        return ServerResponse.status(HttpStatus.TOO_MANY_REQUESTS)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .body(fromObject(errorResult));
//    }
//
//    private static class ErrorResult {
//        private final int code;
//        private final String message;
//
//        ErrorResult(int code, String message) {
//            this.code = code;
//            this.message = message;
//        }
//
//        public int getCode() {
//            return code;
//        }
//
//        public String getMessage() {
//            return message;
//        }
//    }
//}