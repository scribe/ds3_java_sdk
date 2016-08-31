/*
 * ******************************************************************************
 *   Copyright 2014-2015 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */

package com.spectralogic.ds3client.utils.collections;

import com.spectralogic.ds3client.utils.Guard;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Produces an Iterator that will lazily load content.
 * Our definition of lazy for this class, is that the Iterator is returned right
 * away with no data.  Data is only then loaded, as needed, in pieces as defined by the LazyIterableLoader.
 */
public class LazyIterable<T> implements Iterable<T> {

    private LazyIterableLoader<T> iterableLoader;

    public LazyIterable(final LazyIterableLoader<T> iterableLoader) {
        this.iterableLoader = iterableLoader;
    }

    @Override
    public Iterator<T> iterator() {
        return new LazyObjectIterator<>(iterableLoader);
    }

    public interface LazyIterableLoader<T> {
        List<T> getNextValues();
    }

    private class LazyObjectIterator<T> implements Iterator<T> {

        private final LazyIterableLoader<T> iterableLoader;

        private List<T> cache = null;
        private int cachePointer;
        private boolean endOfContent = false;

        private LazyObjectIterator(final LazyIterableLoader<T> iterableLoader) {
            this.iterableLoader = iterableLoader;
        }

        @Override
        public boolean hasNext() {
            if (endOfContent) {
                return false;
            }

            if (cache == null || cachePointer == cache.size()) {
                loadCache();
            }
            return !endOfContent;
        }

        @Override
        public T next() {
            if (endOfContent) {
                throw new NoSuchElementException("No more content");
            }
            if (cache == null || cachePointer >= cache.size()) {
                loadCache();
            }
            final T contents = cache.get(cachePointer);
            this.cachePointer++;
            return contents;
        }

        private void loadCache() {
            this.cache = iterableLoader.getNextValues();
            if (Guard.isNullOrEmpty(this.cache)) {
                endOfContent = true;
            } else {
                this.cachePointer = 0;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("The remove method on the LazyObjectIterator is not supported");
        }

    }
}
