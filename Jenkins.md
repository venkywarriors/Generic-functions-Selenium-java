### :dart:Integration Of Jenkins With Selenium: <br> 
1. Go to the Jenkins dashboard, create a new job in Jenkins
2. Click on a new item and enter the item name and check the freestyle project radio button
3. Click Advanced options
4. Click on use custom workspace and give your Selenium script project workspace path: “E:\Automation_workspace\Demo-testNG”
5. Then go to Build and Select an option from the drop-down box, execute your build through Windows batch command
6. And give your batch file name here – “run.bat”
7. select apply and save & finally select build now
#### build using maven ####
1. Add a build step, which in above point 5
2. Select **“Invoke top-level Maven targets”**
3. In goals **"mvn clean test -Dsurefire.suiteXmlFiles=mytestng.xml"**
#### Post-build Actions ####
1. Click the ‘Add post-build action’ drop-down
2. select the ‘Editable Email Notification’ value
3. Project Recipient List : email_id@gmail.com
4. Content  Type : **both html and plan text**
5. Default subject : Jenkins project | $BUILD_STATUS | # $BUILD_NUMBER build
6. Default Content :
```
<style>
a:link{
  color:blue;
  background-color:transparent;
  text-decoration: underline;
body{
 background-color: #f5f5f5;}
 }
 </style>
 <pre style='line-height: 10px; display: block; color: #333; font-family: Monaco,Menio,Consolas,"Courier New",monospace; padding: 10.5px;margin: 0 0 11px; font-size: 13 px; word-break: break-all; word-wrap: break-word; white-space: pre-wrap; background-color: #f5f5f5; '>
 Application Name - <a href="${JOB_URL}">$PROJECT_NAME</a>
 Build Number - <a href="${BUILD_URL}">#$BUILD_NUMBER</a>
 Build status - $BUILD_STATUS
 BUILD cause - ${BUILD_CAUSE}
 BUILD ON - ${NODE_NAME} 
 ${FILE,path="J:\test.html"}
 To view details of the log, open the build.log file.
 Executed $PROJECT_NAME jenkins job on the machine -> ${ENV,var="COMPUTERNAME"}.
 CHECK CONSOLE OUTPUT <a href=${BUILD_URL}/console>here</a> to view.
 
 ${JELLY_SCRIPT,templete="text"}
 </pre>
```
7. Advanced setting ->Trigger
8. Add trigger -> always 
9. send to receipt list
