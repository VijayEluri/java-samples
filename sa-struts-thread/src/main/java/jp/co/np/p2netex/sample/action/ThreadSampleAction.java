package jp.co.np.p2netex.sample.action;

import jp.co.np.p2netex.sample.thread.Processor;
import jp.co.np.p2netex.sample.thread.ThreadStatus;
import jp.co.np.p2netex.sample.thread.worker.ThreadWorkerInvoker;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.struts.annotation.Execute;


public class ThreadSampleAction {
    private static Log log = LogFactory.getLog(ThreadSampleAction.class);

    @Binding(value="sampleStatus", bindingType=BindingType.MUST)
    public ThreadStatus sampleStatus;
    
    @Binding(bindingType = BindingType.MUST, value="threadWorkerInvoker")
    protected ThreadWorkerInvoker threadWorkerInvoker;
    
    @Binding(bindingType = BindingType.MUST, value="sampleProcessor")
    protected Processor sampleProcessor;

    @Execute(validator = false)
    public String index() {
        log.debug("ThreadStatus:" + this.sampleStatus); 
        return "index.jsp";
    }

    @Execute(validator = false)
    public String start() {
        threadWorkerInvoker.execute(sampleProcessor);
        return "index.jsp";
    }
}
