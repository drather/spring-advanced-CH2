package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderRepositoryV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderServiceConcreteProxy extends OrderServiceV2 {
    private final LogTrace logTrace;
    private final OrderServiceV2 target;


    public OrderServiceConcreteProxy(LogTrace logTrace, OrderServiceV2 target) {
        super(null);
        this.logTrace = logTrace;
        this.target = target;
    }


    @Override
    public void orderItem(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderServicec.orderItem()" );

            target.orderItem(itemId);
            logTrace.end(status);

        } catch (Exception e) {
            logTrace.exception (status, e);
            throw e;
        }
    }
}
