package io.niceseason.spring.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        if (serviceInstances==null) return null;
        int index = getAndIncrease(serviceInstances.size());
        return serviceInstances.get(index);
    }

    public final int getAndIncrease(int modulo) {
        for (; ; ) {
            int current = atomicInteger.get();
            int next = (current+1)%modulo;
            if (atomicInteger.compareAndSet(current, next)) {
                return next;
            }
        }
    }
}
