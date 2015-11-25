[1mdiff --git a/Config.properties b/Config.properties[m
[1mindex cd97f01..dea4f8a 100644[m
[1m--- a/Config.properties[m
[1m+++ b/Config.properties[m
[36m@@ -7,10 +7,10 @@[m [mtier=QAD[m
 browser=firefox[m
 [m
 # Selenium Server: this could be local or remote depending on target execution machine[m
[31m-seleniumserver=local[m
[32m+[m[32mseleniumserver=remote[m
 [m
 # Selenium Hub URL: if Selenium Server is remote, hub URL point to complete hub path[m
[31m-seleniumserverhost=http://172.18.1.193:4444/wd/hub[m
[32m+[m[32mseleniumserverhost=http://10.161.126.91:4444/wd/hub[m
 [m
 # Appium server and Mobile Device info - need to provide if browser above is mobile[m
 appiumServer = http://127.0.0.1:4723/wd/hub[m
[1mdiff --git a/src/test/java/com/qait/mindtap/automation/WebDriverFactory.java b/src/test/java/com/qait/mindtap/automation/WebDriverFactory.java[m
[1mindex 286c448..9a1221a 100644[m
[1m--- a/src/test/java/com/qait/mindtap/automation/WebDriverFactory.java[m
[1m+++ b/src/test/java/com/qait/mindtap/automation/WebDriverFactory.java[m
[36m@@ -40,7 +40,7 @@[m [mpublic class WebDriverFactory {[m
 		}[m
 		Reporter.log("[INFO]: The test Browser is " + browser.toUpperCase()[m
 				+ " !!!", true);[m
[31m-[m
[32m+[m[41m                [m
 		if (seleniumconfig.get("seleniumserver").equalsIgnoreCase("local")) {[m
 			if (browser.equalsIgnoreCase("firefox")) {[m
 				return getFirefoxDriver();[m
[1mdiff --git a/src/test/resources/testdata/Data.properties b/src/test/resources/testdata/Data.properties[m
[1mindex 0d4c67f..e69de29 100644[m
[1m--- a/src/test/resources/testdata/Data.properties[m
[1m+++ b/src/test/resources/testdata/Data.properties[m
[36m@@ -1,3 +0,0 @@[m
[31m-#Tue Sep 29 12:22:01 IST 2015[m
[31m-courseKey=MTPN-7FNP-PD3G[m
[31m-courseName=Mayank Test Book-Automated[m
[1mdiff --git a/target/failsafe-reports/TEST-com.qait.mindtap.automation.report.ResultsIT.xml b/target/failsafe-reports/TEST-com.qait.mindtap.automation.report.ResultsIT.xml[m
[1mdeleted file mode 100644[m
[1mindex dbc206a..0000000[m
[1m--- a/target/failsafe-reports/TEST-com.qait.mindtap.automation.report.ResultsIT.xml[m
[1m+++ /dev/null[m
[36m@@ -1,118 +0,0 @@[m
[31m-<?xml version="1.0" encoding="UTF-8" ?>[m
[31m-<testsuite tests="1" failures="1" name="com.qait.mindtap.automation.report.ResultsIT" time="0.622" errors="0" skipped="0">[m
[31m-  <properties>[m
[31m-    <property name="java.runtime.name" value="Java(TM) SE Runtime Environment"/>[m
[31m-    <property name="sun.boot.library.path" value="C:\Program Files\Java\jdk1.8.0_51\jre\bin"/>[m
[31m-    <property name="java.vm.version" value="25.51-b03"/>[m
[31m-    <property name="java.vm.vendor" value="Oracle Corporation"/>[m
[31m-    <property name="java.vendor.url" value="http://java.oracle.com/"/>[m
[31m-    <property name="path.separator" value=";"/>[m
[31m-    <property name="guice.disable.misplaced.annotation.check" value="true"/>[m
[31m-    <property name="java.vm.name" value="Java HotSpot(TM) Client VM"/>[m
[31m-    <property name="file.encoding.pkg" value="sun.io"/>[m
[31m-    <property name="user.script" value=""/>[m
[31m-    <property name="user.country" value="US"/>[m
[31m-    <property name="sun.java.launcher" value="SUN_STANDARD"/>[m
[31m-    <property name="sun.os.patch.level" value="Service Pack 1"/>[m
[31m-    <property name="java.vm.specification.name" value="Java Virtual Machine Specification"/>[m
[31m-    <property name="user.dir" value="C:\Users\ayushgaur\Desktop\New folder (2)\MT_Automation_V8"/>[m
[31m-    <property name="java.runtime.version" value="1.8.0_51-b16"/>[m
[31m-    <property name="java.awt.graphicsenv" value="sun.awt.Win32GraphicsEnvironment"/>[m
[31m-    <property name="java.endorsed.dirs" value="C:\Program Files\Java\jdk1.8.0_51\jre\lib\endorsed"/>[m
[31m-    <property name="os.arch" value="x86"/>[m
[31m-    <property name="java.io.tmpdir" value="C:\Users\AYUSHG~1\AppData\Local\Temp\"/>[m
[31m-    <property name="line.separator" value="[m
[31m-"/>[m
[31m-    <property name="java.vm.specification.vendor" value="Oracle Corporation"/>[m
[31m-    <property name="user.variant" value=""/>[m
[31m-    <property name="os.name" value="Windows 7"/>[m
[31m-    <property name="classworlds.conf" value="C:\Program Files\apache-maven-3.1.1\bin\m2.conf"/>[m
[31m-    <property name="sun.jnu.encoding" value="Cp1252"/>[m
[31m-    <property name="java.library.path" value="C:\Program Files\Java\jdk1.8.0_51\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;C:\ProgramData\Oracle\Java\javapath;C:\Program Files\nodejs;C:\Users\ayushgaur\AppData\Roaming\npm;C:\Program Files\Java\jre1.8.0_51\bin;C:\Program Files\apache-maven-3.1.1\bin\\;C:\Program Files\Java\jdk1.8.0_51\bin;C:\Program Files\Java\jdk1.8.0_51\lib;C:\Web Driver;C:\Program Files\Skype\Phone\;C:\Ruby22\bin;C:\Users\ayushgaur\AppData\Roaming\npm;."/>[m
[31m-    <property name="java.specification.name" value="Java Platform API Specification"/>[m
[31m-    <property name="java.class.version" value="52.0"/>[m
[31m-    <property name="sun.management.compiler" value="HotSpot Client Compiler"/>[m
[31m-    <property name="os.version" value="6.1"/>[m
[31m-    <property name="user.home" value="C:\Users\ayushgaur"/>[m
[31m-    <property name="user.timezone" value="Asia/Calcutta"/>[m
[31m-    <property name="java.awt.printerjob" value="sun.awt.windows.WPrinterJob"/>[m
[31m-    <property name="java.specification.version" value="1.8"/>[m
[31m-    <property name="file.encoding" value="Cp1252"/>[m
[31m-    <property name="user.name" value="ayushgaur"/>[m
[31m-    <property name="java.class.path" value="C:\Program Files\apache-maven-3.1.1\boot\plexus-classworlds-2.5.1.jar"/>[m
[31m-    <property name="org.slf4j.simpleLogger.defaultLogLevel" value="info"/>[m
[31m-    <property name="java.vm.specification.version" value="1.8"/>[m
[31m-    <property name="sun.arch.data.model" value="32"/>[m
[31m-    <property name="java.home" value="C:\Program Files\Java\jdk1.8.0_51\jre"/>[m
[31m-    <property name="sun.java.command" value="org.codehaus.plexus.classworlds.launcher.Launcher clean install"/>[m
[31m-    <property name="java.specification.vendor" value="Oracle Corporation"/>[m
[31m-    <property name="user.language" value="en"/>[m
[31m-    <property name="awt.toolkit" value="sun.awt.windows.WToolkit"/>[m
[31m-    <property name="java.vm.info" value="mixed mode, sharing"/>[m
[31m-    <property name="java.version" value="1.8.0_51"/>[m
[31m-    <property name="java.ext.dirs" value="C:\Program Files\Java\jdk1.8.0_51\jre\lib\ext;C:\Windows\Sun\Java\lib\ext"/>[m
[31m-    <property name="sun.boot.class.path" value="C:\Program Files\Java\jdk1.8.0_51\jre\lib\resources.jar;C:\Program Files\Java\jdk1.8.0_51\jre\lib\rt.jar;C:\Program Files\Java\jdk1.8.0_51\jre\lib\sunrsasign.jar;C:\Program Files\Java\jdk1.8.0_51\jre\lib\jsse.jar;C:\Program Files\Java\jdk1.8.0_51\jre\lib\jce.jar;C:\Program Files\Java\jdk1.8.0_51\jre\lib\charsets.jar;C:\Program Files\Java\jdk1.8.0_51\jre\lib\jfr.jar;C:\Program Files\Java\jdk1.8.0_51\jre\classes"/>[m
[31m-    <property name="sun.stderr.encoding" value="cp437"/>[m
[31m-    <property name="java.vendor" value="Oracle Corporation"/>[m
[31m-    <property name="maven.home" value="C:\Program Files\apache-maven-3.1.1"/>[m
[31m-    <property name="file.separator" value="\"/>[m
[31m-    <property name="java.vendor.url.bug" value="http://bugreport.sun.com/bugreport/"/>[m
[31m-    <property name="sun.cpu.endian" value="little"/>[m
[31m-    <property name="sun.io.unicode.encoding" value="UnicodeLittle"/>[m
[31m-    <property name="sun.stdout.encoding" value="cp437"/>[m
[31m-    <property name="sun.desktop" value="windows"/>[m
[31m-    <property name="sun.cpu.isalist" value="pentium_pro+mmx pentium_pro pentium+mmx pentium i486 i386 i86"/>[m
[31m-  </properties>[m
[31m-  <testcase classname="com.qait.mindtap.automation.report.ResultsIT" name="sendResultsMail" time="0.071">[m
[31m-    <failure type="java.lang.NullPointerException">java.lang.NullPointerException[m
[31m-	at com.qait.mindtap.automation.report.ResultsIT.setMailRecipient(ResultsIT.java:150)[m
[31m-	at com.qait.mindtap.automation.report.ResultsIT.sendResultsMail(ResultsIT.java:69)[m
[31m-</failure>[m
[31m-    <system-out>src\test\resources\testdata\XXX_TestData.yml (The system cannot find the file specified)[m
[31m-File not valid or missing!!![m
[31m-</system-out>[m
[31m-    <system-err>java.io.FileNotFoundException: src\test\resources\testdata\XXX_TestData.yml (The system cannot find the file specified)[m
[31m-	at java.io.FileInputStream.open0(Native Method)[m
[31m-	at java.io.FileInputStream.open(FileInputStream.java:195)[m
[31m-	at java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:138)[m
[31m-	at java.io.FileInputStream.&lt;init&gt;(FileInputStream.java:93)[m
[31m-	at java.io.FileReader.&lt;init&gt;(FileReader.java:58)[m
[31m-	at com.qait.mindtap.automation.utils.YamlReader.getYamlValues(YamlReader.java:42)[m
[31m-	at com.qait.mindtap.automation.report.ResultsIT.setMailRecipient(ResultsIT.java:149)[m
[31m-	at com.qait.mindtap.automation.report.ResultsIT.sendResultsMail(ResultsIT.java:69)[m
[31m-	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)[m
[31m-	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)[m
[31m-	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)[m
[31m-	at java.lang.reflect.Method.invoke(Method.java:497)[m
[31m-	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:85)[m
[31m-	at org.testng.internal.Invoker.invokeMethod(Invoker.java:659)[m
[31m-	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:845)[m
[31m-	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1153)[m
[31m-	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:125)[m
[31m-	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:108)[m
[31m-	at org.testng.TestRunner.privateRun(TestRunner.java:771)[m
[31m-	at org.testng.TestRunner.run(TestRunner.java:621)[m
[31m-	at org.testng.SuiteRunner.runTest(SuiteRunner.java:357)[m
[31m-	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:352)[m
[31m-	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:310)[m
[31m-	at org.testng.SuiteRunner.run(SuiteRunner.java:259)[m
[31m-	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)[m
[31m-	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)[m
[31m-	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1199)[m
[31m-	at org.testng.TestNG.runSuitesLocally(TestNG.java:1124)[m
[31m-	at org.testng.TestNG.run(TestNG.java:1032)[m
[31m-	at org.apache.maven.surefire.testng.TestNGExecutor.run(TestNGExecutor.java:70)[m
[31m-	at org.apache.maven.surefire.testng.TestNGDirectoryTestSuite.execute(TestNGDirectoryTestSuite.java:109)[m
[31m-	at org.apache.maven.surefire.testng.TestNGProvider.invoke(TestNGProvider.java:111)[m
[31m-	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)[m
[31m-	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)[m
[31m-	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)[m
[31m-	at java.lang.reflect.Method.invoke(Method.java:497)[m
[31m-	at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:164)[m
[31m-	at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:110)[m
[31m-	at org.apache.maven.surefire.booter.SurefireStarter.invokeProvider(SurefireStarter.java:175)[m
[31m-	at org.apache.maven.surefire.booter.SurefireStarter.runSuitesInProcessWhenForked(SurefireStarter.java:107)[m
[31m-	at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:68)[m
[31m-</system-err>[m
[31m-  </testcase>[m
[31m-</testsuite>[m
\ No newline at end of file[m
[1mdiff --git a/target/failsafe-reports/bullet_point.png b/target/failsafe-reports/bullet_point.png[m
[1mdeleted file mode 100644[m
[1mindex 176e6d5..0000000[m
Binary files a/target/failsafe-reports/bullet_point.png and /dev/null differ
[1mdiff --git a/target/failsafe-reports/collapseall.gif b/target/failsafe-reports/collapseall.gif[m
[1mdeleted file mode 100644[m
[1mindex a2d80a9..0000000[m
Binary files a/target/failsafe-reports/collapseall.gif and /dev/null differ
[1mdiff --git a/target/failsafe-reports/com.qait.mindtap.automation.report.ResultsIT.txt b/target/failsafe-reports/com.qait.mindtap.automation.report.ResultsIT.txt[m
[1mdeleted file mode 100644[m
[1mindex 51c5b71..0000000[m
[1m--- a/target/failsafe-reports/com.qait.mindtap.automation.report.ResultsIT.txt[m
[1m+++ /dev/null[m
[36m@@ -1,8 +0,0 @@[m
[31m--------------------------------------------------------------------------------[m
[31m-Test set: com.qait.mindtap.automation.report.ResultsIT[m
[31m--------------------------------------------------------------------------------[m
[31m-Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 0.622 sec <<< FAILURE![m
[31m-sendResultsMail(com.qait.mindtap.automation.report.ResultsIT)  Time elapsed: 0.071 sec  <<< FAILURE![m
[31m-java.lang.NullPointerException[m
[31m-	at com.qait.mindtap.automation.report.ResultsIT.setMailRecipient(ResultsIT.java:150)[m
[31m-	at com.qait.mindtap.automation.report.ResultsIT.sendResultsMail(ResultsIT.java:69)[m
[1mdiff --git a/target/failsafe-reports/com.qait.mindtap.automation.report.ResultsIT/Command line test.html b/target/failsafe-reports/com.qait.mindtap.automation.report.ResultsIT/Command line test.html[m
[1mdeleted file mode 100644[m
[1mindex 262beaf..0000000[m
[1m--- a/target/failsafe-reports/com.qait.mindtap.automation.report.ResultsIT/Command line test.html[m	
[1m+++ /dev/null[m
[36m@@ -1,124 +0,0 @@[m
[31m-<html>[m
[31m-<head>[m
[31m-<title>TestNG:  Command line test</title>[m
[31m-<link href="../testng.css" rel="stylesheet" type="text/css" />[m
[31m-<link href="../my-testng.css" rel="stylesheet" type="text/css" />[m
[31m-[m
[31m-<style type="text/css">[m
[31m-.log { display: none;} [m
[31m-.stack-trace { display: none;} [m
[31m-</style>[m
[31m-<script type="text/javascript">[m
[31m-<!--[m
[31m-function flip(e) {[m
[31m-  current = e.style.display;[m
[31m-  if (current == 'block') {[m
[31m-    e.style.display = 'none';[m
[31m-    return 0;[m
[31m-  }[m
[31m-  else {[m
[31m-    e.style.display = 'block';[m
[31m-    return 1;[m
[31m-  }[m
[31m-}[m
[31m-[m
[31m-function toggleBox(szDivId, elem, msg1, msg2)[m
[31m-{[m
[31m-  var res = -1;  if (document.getElementById) {[m
[31m-    res = flip(document.getElementById(szDivId));[m
[31m-  }[m
[31m-  else if (document.all) {[m
[31m-    // this is the way old msie versions work[m
[31m-    res = flip(document.all[szDivId]);[m
[31m-  }[m
[31m-  if(elem) {[m
[31m-    if(res == 0) elem.innerHTML = msg1; else elem.innerHTML = msg2;[m
[31m-  }[m
[31m-[m
[31m-}[m
[31m-[m
[31m-function toggleAllBoxes() {[m
[31m-  if (document.getElementsByTagName) {[m
[31m-    d = document.getElementsByTagName('div');[m
[31m-    for (i = 0; i < d.length; i++) {[m
[31m-      if (d[i].className == 'log') {[m
[31m-        flip(d[i]);[m
[31m-      }[m
[31m-    }[m
[31m-  }[m
[31m-}[m
[31m-[m
[31m-// -->[m
[31m-</script>[m
[31m-[m
[31m-</head>[m
[31m-<body>[m
[31m-<h2 align='center'>Command line test</h2><table border='1' align="center">[m
[31m-<tr>[m
[31m-<td>Tests passed/Failed/Skipped:</td><td>0/1/0</td>[m
[31m-</tr><tr>[m
[31m-<td>Started on:</td><td>Thu Oct 01 13:48:05 IST 2015</td>[m
[31m-</tr>[m
[31m-<tr><td>Total time:</td><td>0 seconds (82 ms)</td>[m
[31m-</tr><tr>[m
[31m-<td>Included groups:</td><td></td>[m
[31m-</tr><tr>[m
[31m-<td>Excluded groups:</td><td></td>[m
[31m-</tr>[m
[31m-</table><p/>[m
[31m-<small><i>(Hover the method name to see the test class name)</i></small><p/>[m
[31m-<table width='100%' border='1' class='invocation-failed'>[m
[31m-<tr><td colspan='4' align='c