/*
        Copyright 2014 Yevgen Kulik

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package com.kulik.android.jaxb.library.adapters;

public final class Criteria {

    private Package mPackaze;
    private Class mClazz;
    private Class<?> mMarshalType;
    private Class<?> mUnMarshalType;

    public Criteria() {
    }

    public Criteria(Package packaze, Class clazz, Class<?> marsalType, Class<?> unmarsalType) {
        mPackaze = packaze;
        mClazz = clazz;
        mMarshalType = marsalType;
        mUnMarshalType = unmarsalType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Criteria criteria = (Criteria) o;

        if (mClazz != null && !mClazz.equals(criteria.mClazz)) return false;
        if (mUnMarshalType != null && !mUnMarshalType.equals(criteria.mUnMarshalType)) return false;
        if (mMarshalType != null && !mMarshalType.equals(criteria.mMarshalType)) return false;
        if ((mPackaze == null) ? criteria.mPackaze != null : !mPackaze.equals(criteria.mPackaze))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mPackaze != null ? mPackaze.hashCode() : 0;
        result = 31 * result + ((mClazz != null) ? mClazz.hashCode() : 0);
        result = 31 * result + (mUnMarshalType != null ? mUnMarshalType.hashCode() : 0);
        result = 31 * result + (mMarshalType != null ? mMarshalType.hashCode() : 0);
        return result;
    }

    public Criteria set(Package p, Class<?> clazz, Class<?> marshalType, Class<?> unMarshalType) {
        mPackaze = p;
        mClazz = clazz;
        mMarshalType = marshalType;
        mUnMarshalType = unMarshalType;
        return this;
    }

}