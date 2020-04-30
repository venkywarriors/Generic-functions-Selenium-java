@ECHO ON

J:
cd "J:\test automation\selenium_project\project"
mvn compile test-Dsurefire.suiteXmlFiles=src/main/resources/lightRegrssion.xml
