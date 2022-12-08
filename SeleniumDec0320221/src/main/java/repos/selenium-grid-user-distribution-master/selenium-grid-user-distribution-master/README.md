# selenium-grid-user-distribution
web-automation framework for cross browser automation with percentage wise user distribution.

#### Command to run test form cli :

```shell script
mvn clean test -DthreadsName=remotechrome:100 -DtotalThreads=1 -DappiumUrl=<appium server url>  -DseleniumGridUrl=<selenium grid url> -DretryCount=2
```

****Note: <br />****
Default value for some variables are <br />
seleniumGridUrl =  http://127.0.0.1:4723/wd/hub <br />
appiumUrl = http://127.0.0.1:4723/wd/hub <br/>
retryCount = 1

#### Command to run test form IDE :
1: go to : [localConfigRunner.xml](./src/main/resources/config/localConfigRunner.xml) <br/>
2: change values for parameters accordingly & run testNG file. <br/>

### Command to run selenium-grid on docker:
```shell script
docker-compose up -d
```
link for [docker compose file](./docker-compose.yml) <br/>


### Command to run appium server :
```shell script
./runAppiumServer.sh
```
link for [runAppiumServer.sh](./runAppiumServer.sh) <br/>
##### make sure selenium-grid is already running. 

### ****Note:**** ###
For user distribution give config in threadsName variable with the format <browsername>:<percentage> & you can give the multiple browsers with the comma separated.<br/>
for example :
```
        <parameter name="threadsName" value="remotechrome:100,remoteFirefox:0,mobilechrome:0"/>\
```



