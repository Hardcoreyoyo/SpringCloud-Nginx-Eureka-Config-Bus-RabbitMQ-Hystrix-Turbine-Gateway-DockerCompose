package SpringCloudGateway.filter;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component // 自定義全局過濾器方法二
public class ApiGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public int getOrder() {
        return -100;
    }

    @Override
    @HystrixCommand
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //請求前時間
        Long startTime = System.currentTimeMillis();

        //處理完成之後
        return chain.filter(exchange).then().then(Mono.fromRunnable(() -> {

            //處理之後的時間
            Long endTime = System.currentTimeMillis();

            System.out.println(
                    exchange.getRequest().getURI().getRawPath()
                            + "ApiGlobalFilter -100 cost time : "
                            + (endTime - startTime) + "ms");
        }));
    }
}
