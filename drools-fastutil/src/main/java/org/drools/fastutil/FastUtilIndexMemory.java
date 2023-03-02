/*
 * Copyright 2023 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.fastutil;

import org.drools.core.reteoo.TupleMemory;
import org.drools.core.util.index.IndexMemory;
import org.drools.core.util.index.IndexSpec;

public class FastUtilIndexMemory {

    public static class FastUtilEqualityMemoryFactory implements IndexMemory.Factory {

        @Override
        public TupleMemory createMemory(IndexSpec indexSpec, boolean isLeft) {
            return new FastUtilHashTupleMemory(indexSpec.getIndexes(), isLeft);
        }
    }

    public static class FastUtilComparisonMemoryFactory implements IndexMemory.Factory {

        @Override
        public TupleMemory createMemory(IndexSpec indexSpec, boolean isLeft) {
            return new FastUtilTreeMemory(indexSpec.getConstraintType(), indexSpec.getIndex(0), isLeft);
        }
    }
}
