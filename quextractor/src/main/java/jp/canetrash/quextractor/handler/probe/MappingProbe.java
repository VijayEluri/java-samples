package jp.canetrash.quextractor.handler.probe;

public class MappingProbe {
    private Probe[] probes;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Probe[] getProbes() {
        return probes;
    }

    public void setProbes(Probe[] probes) {
        this.probes = probes;
    }
}
