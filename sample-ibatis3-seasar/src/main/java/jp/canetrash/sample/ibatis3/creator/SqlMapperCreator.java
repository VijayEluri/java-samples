package jp.canetrash.sample.ibatis3.creator;

import org.seasar.framework.container.ComponentCustomizer;
import org.seasar.framework.container.ComponentDef;
import org.seasar.framework.container.creator.ComponentCreatorImpl;
import org.seasar.framework.container.deployer.InstanceDefFactory;
import org.seasar.framework.container.factory.AnnotationHandler;
import org.seasar.framework.container.factory.AnnotationHandlerFactory;
import org.seasar.framework.convention.NamingConvention;

public class SqlMapperCreator extends ComponentCreatorImpl {

    /*
     * Suffix
     */
    private static final String NAME_SUFFIX_PROCESSOR = "Mapper";

    public SqlMapperCreator(NamingConvention namingConvention) {
        super(namingConvention);
        this.setNameSuffix(NAME_SUFFIX_PROCESSOR);
        this.setInstanceDef(InstanceDefFactory.SINGLETON);
        this.setExternalBinding(false);
        this.setEnableAbstract(false);
        this.setEnableInterface(true);
    }

    /**
     * @return ComponentCustomizer
     */
    public ComponentCustomizer getMapperCustomizer() {
        return super.getCustomizer();
    }

    /**
     * @param customizer
     *            customizer
     */
    public void setMapperCustomizer(ComponentCustomizer customizer) {
        super.setCustomizer(customizer);
    }

}
