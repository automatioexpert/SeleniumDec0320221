package util;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ TYPE })
@Inherited
public @interface JiraServer
{
    /**
     * @return the jira domain, example... http://jira.agilysys.local/
     */
    String domain();

    /**
     * @return the jira port, example... 8080, default is an empty string.
     */
    String port() default "";

    /**
     * @return true for ssl, false otherwise, default is false.
     */
    boolean ssl() default false;
    boolean disableAutoOpenBrowser() default false;
}