package jp.canetrash.sample.ibatis3.autodetector;

import org.seasar.framework.autodetector.impl.AbstractClassAutoDetector;
import org.seasar.framework.container.annotation.tiger.Binding;
import org.seasar.framework.container.annotation.tiger.BindingType;
import org.seasar.framework.container.annotation.tiger.InitMethod;
import org.seasar.framework.convention.NamingConvention;
import org.seasar.framework.util.ClassUtil;
import org.seasar.framework.util.ResourcesUtil;
import org.seasar.framework.util.ClassTraversal.ClassHandler;
import org.seasar.framework.util.ResourcesUtil.Resources;

public class SqlMapperClassAutoDetector extends AbstractClassAutoDetector {

    private static final String MAPPER_PACKAGE_NAME = "mappper";

    private NamingConvention namingConvention;

    private ClassLoader classLoader;

    public void detect(final ClassHandler handler) {

        for (int i = 0; i < getTargetPackageNameSize(); i++) {
            final String packageName = getTargetPackageName(i);
            for (final Resources resources : ResourcesUtil
                .getResourcesTypes(packageName)) {
                try {
                    resources.forEach(new ClassHandler() {
                        public void processClass(final String packageName,
                                final String shortClassName) {
                            if (packageName.startsWith(packageName) ) {
                                handler.processClass(
                                    packageName,
                                    shortClassName);
                            }
                        }
                    });
                } finally {
                    resources.close();
                }
            }
        }
    }

    @Binding(bindingType = BindingType.MAY)
    public void setNamingConvention(final NamingConvention namingConvention) {
        this.namingConvention = namingConvention;
    }
    
    @Binding(bindingType = BindingType.MAY)
    public void setClassLoader(final ClassLoader classLoader) {
        this.classLoader = classLoader;
    }
    
    /**
     * 認識するサブパッケージ名を追加します。
     * 
     * @param packageSubName
     *            サブパッケージ名
     */
    private void addTargetSubPackageName(String subPackageName) {
        for (final String rootPackageName : namingConvention
            .getRootPackageNames()) {
            final String packageName =
                ClassUtil.concatName(rootPackageName, subPackageName);
            addTargetPackageName(packageName);
        }
    }
    /**
     * コンポーネントの初期化処理です。
     */
    @InitMethod
    public void init() {
        if (namingConvention != null) {
            addTargetSubPackageName(MAPPER_PACKAGE_NAME);
        }
    }

}
