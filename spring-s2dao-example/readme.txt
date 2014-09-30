【本アーカイブの内容】
　SpringでS2Daoを利用するためのプログラムと動作サンプルです。
　S2Daoのs2-dao-examplesが基本動作することを確認しています。(一部を除く)

【セットアップ】
　(1)Eclipseで ｢ファイル→インポート→既存のプロジェクトをワークスペースへ｣で
     インポートしてください。
　(2)hsql\binのrunHsqldb.batを実行し、HSQLDBを起動して下さい。
　(3)src\test\java\examples\dao以下にテストクラスがあるので、JUnitで起動して
　   下さい。

【解説】
　SpringでS2Daoを利用するために、S2Dao内のS2依存部分の修正とインタフェースの
　Bean登録(おまけで自動登録も)をサポートする機能を作成しました。

　対象となるプログラムは、下記となります。
　・S2Dao関連
　 　SpringValueTypeFactoryImpl.java
　　 　-> S2コンテナからのコンポーネント取得箇所をSpringから取得するように修正
　・Bean登録関連
　 　AbstractAutoRegister.java
　　 AbstractBeanAutoRegister.java
　　 FileSystemBeanAutoRegister.java
　　 　-> S2本体のAutoRegisterのソースをベースに、SpringでBeanの自動登録をサポート
　　 　   するクラスを作成(インタフェースのインスタンス化も行います。)
　　　　　BeanFactoryPostProcessorの実装クラスとなっているため、Bean登録時に実行
　　　　　されます。

　Bean登録は、src\main\resources以下のXMLで行っています。
　Daoの登録は、beans.xml内の下記の設定で行っています。
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

　このようにS2同様のイメージでBeanの自動登録が可能です。
　propertyとして、他にautowire,scope,ignorePackageName,ignoreClassNamesを
　サポートしています。

【制限事項】
　(1)Employee2DaoClientTestが動作しません。
     下記のエラーが発生します。(原因不明)
       [ESSR0049]examples.dao.Employee2DaoImplに適用可能なメソッド(getEmployees())が見つかりません
　(2)S2DaoTestCaseは利用できません。
　(3)S2Dao Tiger/S2Dao Backport175の動作確認はしていません。
　