package SpringCloudGateway.filter;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration // 自定義全局過濾器方法一
public class GlobalGatewayFilterConfig
{
    @Bean
    @Order(-101)
    public GlobalFilter GatewayGlobalFilter()
    {
        return (exchange, chain) -> {
            //請求前時間
            Long startTime = System.currentTimeMillis();

            //處理完成之後
            return chain.filter(exchange).then().then(Mono.fromRunnable(() -> {

                Long endTime = System.currentTimeMillis();
                System.out.println(
                        exchange.getRequest().getURI().getRawPath()
                                + "GatewayGlobalFilter -101 cost time : "
                                + (endTime - startTime) + "ms");
            }));
        };
    }
}
