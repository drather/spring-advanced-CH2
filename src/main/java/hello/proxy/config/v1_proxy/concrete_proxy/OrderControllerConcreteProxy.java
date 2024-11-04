package hello.proxy.config.v1_proxy.concrete_proxy;

import hello.proxy.app.v2.OrderControllerV2;
import hello.proxy.app.v2.OrderServiceV2;
import hello.proxy.trace.TraceStatus;
import hello.proxy.trace.logtrace.LogTrace;

public class OrderControllerConcreteProxy extends OrderControllerV2 {

    private final LogTrace logTrace;
    private final OrderControllerV2 target;

    public OrderControllerConcreteProxy(LogTrace logTrace, OrderControllerV2 target) {
        super(null);
        this.logTrace = logTrace;
        this.target = target;
    }


    @Override
    public String request(String itemId) {
        TraceStatus status = null;

        try {
            status = logTrace.begin("OrderController.request()");

            String result = target.request(itemId);
            logTrace.end(status);
            return result;

        } catch (Exception e ) {
            logTrace.exception(status, e);
            throw e;
        }
    }

    @Override
    public String noLog() {
        return super.noLog();
    }
}
