package jp.canetrash.sample.yaml.model;

public class Entry {

	private String application;
	private int version;
	private String runtime;
	private String api_version;

	private Handler[] handlers;

	public String getApi_version() {
		return api_version;
	}

	public void setApi_version(String api_version) {
		this.api_version = api_version;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Handler[] getHandlers() {
		return handlers;
	}

	public void setHandlers(Handler[] handlers) {
		this.handlers = handlers;
	}

}
