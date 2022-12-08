package util;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ METHOD })
@Inherited
public @interface Jira
{
    /**
     * @return The test issue id associated with the test case, example...
     *         PAY-26947
     */
    String id();

    boolean disableAutoOpenBrowser() default false;
}