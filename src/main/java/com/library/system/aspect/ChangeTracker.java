package com.library.system.aspect;
import com.library.system.annotation.TrackChange;
import java.lang.reflect.Method;
public class ChangeTracker {
    //Тут используем рефлексию чтобы во время компиляции поймать изменения
    public static void trackChanges(Object obj, String methodName, Class<?>... parameterTypes) throws Exception {
        Method method = obj.getClass().getMethod(methodName, parameterTypes);
        if (method.isAnnotationPresent(TrackChange.class)) {
            TrackChange annotation = method.getAnnotation(TrackChange.class);
            System.out.println("Annotation Triggered: " + annotation.message());
        }
    }
}