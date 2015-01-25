package bigbluej;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.commons.lang.Validate;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Michael Lieshoff
 */
public class ModuleCommand {

    private final String name;
    private final Set<DocumentCommand> documents;

    private ModuleCommand(String name, Set<DocumentCommand> documents) {
        Validate.notEmpty(name, "name");
        this.name = name;
        this.documents = documents;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public Set<DocumentCommand> getDocuments() {
        return documents;
    }

    public static class Builder {

        private String name;
        private Set<DocumentCommand> documents = new HashSet<>();

        private Builder() {
        }

        public ModuleCommand build() {
            return new ModuleCommand(name, documents);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder document(DocumentCommand documentCommand) {
            Validate.notNull(documentCommand);
            documents.add(documentCommand);
            return this;
        }

    }

}
