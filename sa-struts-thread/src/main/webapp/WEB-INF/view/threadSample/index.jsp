<%@page pageEncoding="UTF-8"%>
<html>
<head>
<title>Threadを起こして処理するサンプル</title>
</head>
<body>
<p>Threadを新規に起こして処理するサンプル</p>
60カウント数えて終了します
<br/>
<html:link href="./">リロード</html:link>
<html:errors/>
<br/>
現在のカウント：<bean:write name="sampleStatus" property="processCount" /><br/>
起動中か？：<bean:write name="sampleStatus" property="active" /><br/>
処理の名前：<bean:write name="sampleStatus" property="name" /><br/>
開始時刻:<bean:write name="sampleStatus" property="startDate"/><br/>
<bean:write name="sampleStatus" />
<br/>
<s:form>
<input type="submit" name="start" value="Threadスタート"/>
</s:form>
</body>
</html>