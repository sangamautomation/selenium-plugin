package hudson.plugins.selenium.callables;

import hudson.plugins.selenium.RemoteRunningStatus;
import jenkins.security.MasterToSlaveCallable;

/**
 * Callable that returns a property set on the channel
 *
 * @author Richard Lavoie
 */
public class RunningRemoteSetterCallable extends MasterToSlaveCallable<Void, Exception> {

    /**
	 *
	 */
    private static final long serialVersionUID = -3519905249359789575L;

    private String config;

    private String status;

    public RunningRemoteSetterCallable(String conf, String status) {
        config = conf;
        this.status = status;
    }

    public Void call() throws Exception {
        ((RemoteRunningStatus) PropertyUtils.getMapProperty(SeleniumConstants.PROPERTY_STATUS, config)).setStatus(status);
        return null;
    }

}
