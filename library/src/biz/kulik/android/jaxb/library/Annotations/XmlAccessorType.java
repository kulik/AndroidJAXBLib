package biz.kulik.android.jaxb.library.Annotations;

import java.lang.annotation.*;

/**
 * User: kulik
 * Date: 2/15/13
 * Time: 3:57 PM
 */
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.PACKAGE, ElementType.TYPE})
public @interface XmlAccessorType {

   public static enum AccessType {

       FIELD,
       NONE ,
       PROPERTY,
       PUBLIC_MEMBER
   }
}
