package com.kulik.android.jaxb.library.composer;

import com.kulik.android.jaxb.library.adapters.AdapterException;

/**
 * User: nata
 * Date: 9/21/12
 * Time: 3:29 PM
 */
public interface Composer {
    public Object compose(Object data) throws AdapterException;
}
