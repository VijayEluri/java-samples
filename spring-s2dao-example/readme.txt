�y�{�A�[�J�C�u�̓��e�z
�@Spring��S2Dao�𗘗p���邽�߂̃v���O�����Ɠ���T���v���ł��B
�@S2Dao��s2-dao-examples����{���삷�邱�Ƃ��m�F���Ă��܂��B(�ꕔ������)

�y�Z�b�g�A�b�v�z
�@(1)Eclipse�� ��t�@�C�����C���|�[�g�������̃v���W�F�N�g�����[�N�X�y�[�X�֣��
     �C���|�[�g���Ă��������B
�@(2)hsql\bin��runHsqldb.bat�����s���AHSQLDB���N�����ĉ������B
�@(3)src\test\java\examples\dao�ȉ��Ƀe�X�g�N���X������̂ŁAJUnit�ŋN������
�@   �������B

�y����z
�@Spring��S2Dao�𗘗p���邽�߂ɁAS2Dao����S2�ˑ������̏C���ƃC���^�t�F�[�X��
�@Bean�o�^(���܂��Ŏ����o�^��)���T�|�[�g����@�\���쐬���܂����B

�@�ΏۂƂȂ�v���O�����́A���L�ƂȂ�܂��B
�@�ES2Dao�֘A
�@ �@SpringValueTypeFactoryImpl.java
�@�@ �@-> S2�R���e�i����̃R���|�[�l���g�擾�ӏ���Spring����擾����悤�ɏC��
�@�EBean�o�^�֘A
�@ �@AbstractAutoRegister.java
�@�@ AbstractBeanAutoRegister.java
�@�@ FileSystemBeanAutoRegister.java
�@�@ �@-> S2�{�̂�AutoRegister�̃\�[�X���x�[�X�ɁASpring��Bean�̎����o�^���T�|�[�g
�@�@ �@   ����N���X���쐬(�C���^�t�F�[�X�̃C���X�^���X�����s���܂��B)
�@�@�@�@�@BeanFactoryPostProcessor�̎����N���X�ƂȂ��Ă��邽�߁ABean�o�^���Ɏ��s
�@�@�@�@�@����܂��B

�@Bean�o�^�́Asrc\main\resources�ȉ���XML�ōs���Ă��܂��B
�@Dao�̓o�^�́Abeans.xml���̉��L�̐ݒ�ōs���Ă��܂��B
    <bean class="framework.autoregister.FileSystemBeanAutoRegister">
        <property name="addPackageName">
            <value>examples.dao</value>
        </property>
        <property name="addClassNames">
            <value>.*Dao,.*Manager</value>
        </property>
    </bean>
    <bean class="org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator">
        <property name="beanNames">
            <value>*Dao,*Manager</value>
        </property>
        <property name="interceptorNames">
            <list>
                <value>s2DaoInterceptor</value>
                <value>traceInterceptor</value>
            </list>
        </property>
    </bean>

�@���̂悤��S2���l�̃C���[�W��Bean�̎����o�^���\�ł��B
�@property�Ƃ��āA����autowire,scope,ignorePackageName,ignoreClassNames��
�@�T�|�[�g���Ă��܂��B

�y���������z
�@(1)Employee2DaoClientTest�����삵�܂���B
     ���L�̃G���[���������܂��B(�����s��)
       [ESSR0049]examples.dao.Employee2DaoImpl�ɓK�p�\�ȃ��\�b�h(getEmployees())��������܂���
�@(2)S2DaoTestCase�͗��p�ł��܂���B
�@(3)S2Dao Tiger/S2Dao Backport175�̓���m�F�͂��Ă��܂���B
�@