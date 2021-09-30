package booking.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;

import feign.Feign;
import feign.hystrix.HystrixFeign;
import feign.hystrix.SetterFactory;

import java.util.Date;

//@FeignClient(name="payment", url="http://payment:8080")
//http://a6f9288606f334c0db97a9935ae1bf2a-1991515766.ca-central-1.elb.amazonaws.com:8080
//${prop.aprv.url}
@FeignClient(name="payment", url="${prop.aprv.url}") //, configuration=PaymentService.PaymentServiceConfiguration.class, fallback=PaymentServiceFallback.class)
public interface PaymentService {
    @RequestMapping(method= RequestMethod.POST, path="/payments")
    public void approvePay(@RequestBody Payment payment);

/*
    @Component
    class PaymentServiceConfiguration {
        Feign.Builder feignBuilder(){
            SetterFactory setterFactory = (target, method) -> HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(target.name()))
                    .andCommandKey(HystrixCommandKey.Factory.asKey(Feign.configKey(target.type(), method)))
                    // 위는 groupKey와 commandKey 설정
                    // 아래는 properties 설정
                    .andCommandPropertiesDefaults(HystrixCommandProperties.defaultSetter()
                            .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                            .withMetricsRollingStatisticalWindowInMilliseconds(10000) // 기준시간
                            .withCircuitBreakerSleepWindowInMilliseconds(3000) // 서킷 열려있는 시간
                            .withCircuitBreakerErrorThresholdPercentage(50)) // 에러 비율 기준 퍼센트
                    ; // 최소 호출 횟수
            return HystrixFeign.builder().setterFactory(setterFactory);
        }
    }
*/
}

