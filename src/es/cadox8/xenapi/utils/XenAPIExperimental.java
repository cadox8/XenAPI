package es.cadox8.xenapi.utils;

import org.apache.hc.core5.annotation.Internal;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
@Internal
public @interface XenAPIExperimental {
    Status value() default Status.UNTESTED;

    @Internal
    enum Status {
        UNTESTED,
        PROVISIONAL,
        NEEDS_REFACTOR,
        TO_BE_DONE
    }
}
