package jp.canetrash.sample.ibatis3.util;

import java.util.ArrayList;
import java.util.List;

import jp.canetrash.sample.ibatis3.autodetector.SqlMapperClassAutoDetector;

import org.seasar.framework.container.ComponentDef;
import org.seasar.framework.container.ComponentNotFoundRuntimeException;
import org.seasar.framework.container.S2Container;
import org.seasar.framework.container.util.SmartDeployUtil;
import org.seasar.framework.container.util.Traversal;
import org.seasar.framework.util.ClassTraversal;
import org.seasar.framework.util.ClassUtil;
import org.seasar.framework.util.tiger.ReflectionUtil;

public class MapperRegister {

    private SqlMapperClassAutoDetector mapperClassAutoDetector;

    private S2Container s2Container;

    private final List<ComponentDef> targetComponentDefList = new ArrayList<ComponentDef>();

    private void registerS2Component(S2Container s2Container) {
        Traversal.forEachComponent(s2Container,
                new Traversal.ComponentDefHandler() {
                    public Object processComponent(ComponentDef componentDef) {
                        Class<?> clazz = componentDef.getComponentClass();
                        if (clazz != null) {
                            if (!targetComponentDefList.contains(componentDef)) {
                                targetComponentDefList.add(componentDef);
                            }
                        }
                        return null;
                    }
                });
    }

    private void registerSmartDepolyComponent(final S2Container s2Container) {
        if (SmartDeployUtil.isSmartdeployMode(s2Container)) {
            mapperClassAutoDetector.detect(new ClassTraversal.ClassHandler() {
                public void processClass(String packageName,
                        String shortClassName) {
                    String name = ClassUtil.concatName(packageName,
                            shortClassName);
                    Class<?> clazz = ReflectionUtil.forNameNoException(name);
                    if (clazz != null) {
                        try {
                            ComponentDef componentDef = s2Container
                                    .getComponentDef(clazz);
                            if (!targetComponentDefList.contains(componentDef)) {
                                targetComponentDefList.add(componentDef);
                            }
                        } catch (ComponentNotFoundRuntimeException e) {
                            ;
                        }
                    }
                }
            });
        }
    }

    public void register() {
        registerSmartDepolyComponent(s2Container.getRoot());
        registerS2Component(s2Container.getRoot());
    }

    /**
     * @param container
     *            the s2Container to set
     */
    public void setS2Container(S2Container container) {
        s2Container = container;
    }

}
