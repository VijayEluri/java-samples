package qdox.sample;

/**
 * @author testUser
 */
public class SampleBean {
    /**
     * nameのコメント
     */
    String name;
    /**
     * valueのコメント
     */
    String value;

    /**
     * @return
     */
    public final String getName() {
        return name;
    }

    /**
     * @return
     */
    public final String getValue() {
        return value;
    }

    /**
     * @param name
     */
    public final void setName(String name) {
        this.name = name;
    }

    /**
     * @param value
     */
    public final void setValue(String value) {
        this.value = value;
    }
}
