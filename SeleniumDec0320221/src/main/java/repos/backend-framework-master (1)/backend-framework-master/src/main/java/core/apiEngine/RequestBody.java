package core.apiEngine;

import core.utils.TestHelper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class RequestBody<T> {
    private T objectInstance;

    public RequestBody(T objectInstance) {
        this.objectInstance = objectInstance;
    }

    public String getBodyString() {
        if (objectInstance.getClass() == String.class) return objectInstance.toString();
        return TestHelper.getJsonString(objectInstance);
    }

}

