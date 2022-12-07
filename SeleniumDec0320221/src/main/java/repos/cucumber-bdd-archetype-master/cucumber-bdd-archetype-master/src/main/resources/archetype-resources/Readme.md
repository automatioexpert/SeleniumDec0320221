# Template parallel testing Junit-Cucumber-Selenium

This code is provided on an "AS-IS” basis without warranty of any kind, either express or implied, including without limitation any implied warranties of condition, uninterrupted use, merchantability, fitness for a particular purpose, or non-infringement. Your tests and testing environments may require you to modify this framework. 
this template allows you run testing with bdd aproach and selenium for automation, in parallel and diferent browser

### Environment Setup

- Install [JDK 8](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html) 
- Install [Maven](https://maven.apache.org/install.html) 
- Install [Chrome](https://www.google.com/intl/es-419/chrome/) / [firefox](https://www.mozilla.org/es-CL/firefox/new/)

### Running the tests
```
$ mvn clean install
```

By default the browser is Chrome, also you can add arguments `-Dbrowser=firefox` to run test on firefox

 ```
 $ mvn clean install -Dbrowser=firefox
 ```


### Resources
##### [Cucumber Docs](https://cucumber.io/docs)

##### [Cucumber School Lessons](https://cucumber.io/school#lessons)

##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [Junit Documentation](http://junit.org/javadoc/latest/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)

##### [Stack Overflow](http://stackoverflow.com/)
* A great resource to search for issues not explicitly covered by documentation.