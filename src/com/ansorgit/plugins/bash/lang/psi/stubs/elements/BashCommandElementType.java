/*
 * Copyright 2013 Joachim Ansorg, mail@ansorg-it.com
 * File: BashIncludeCommandElementType.java, Class: BashIncludeCommandElementType
 * Last modified: 2013-05-12
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.stubs.elements;

import com.ansorgit.plugins.bash.lang.parser.BashElementTypes;
import com.ansorgit.plugins.bash.lang.psi.BashStubElementType;
import com.ansorgit.plugins.bash.lang.psi.api.command.BashCommand;
import com.ansorgit.plugins.bash.lang.psi.impl.command.BashSimpleCommandImpl;
import com.ansorgit.plugins.bash.lang.psi.stubs.api.BashCommandStub;
import com.ansorgit.plugins.bash.lang.psi.stubs.impl.BashCommandStubImpl;
import com.ansorgit.plugins.bash.lang.psi.stubs.index.BashCommandNameIndex;
import com.intellij.psi.stubs.IndexSink;
import com.intellij.psi.stubs.StubElement;
import com.intellij.psi.stubs.StubInputStream;
import com.intellij.psi.stubs.StubOutputStream;
import com.intellij.util.PathUtilRt;
import com.intellij.util.io.StringRef;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * @author jansorg
 */
public class BashCommandElementType extends BashStubElementType<BashCommandStub, BashCommand> {
    public BashCommandElementType() {
        super("simple command");
    }

    public void serialize(@NotNull BashCommandStub stub, @NotNull StubOutputStream dataStream) throws IOException {
        dataStream.writeName(stub.getBashCommandFilename());
    }

    @NotNull
    public BashCommandStub deserialize(@NotNull StubInputStream dataStream, StubElement parentStub) throws IOException {
        StringRef bashCommandFilename = dataStream.readName();
        return new BashCommandStubImpl(parentStub, bashCommandFilename, this);
    }

    public BashCommand createPsi(@NotNull BashCommandStub stub) {
        return new BashSimpleCommandImpl(stub, BashElementTypes.SIMPLE_COMMAND_ELEMENT, null);
    }

    public BashCommandStub createStub(@NotNull BashCommand psi, StubElement parentStub) {
        String filename = null;

        if (psi.isExternalCommand()) {
            String commandName = psi.getReferencedCommandName();
            if (commandName != null) {
                filename = PathUtilRt.getFileName(commandName);
            }
        }

        return new BashCommandStubImpl(parentStub, StringRef.fromString(filename), BashElementTypes.SIMPLE_COMMAND_ELEMENT);
    }

    @Override
    public void indexStub(@NotNull BashCommandStub stub, @NotNull IndexSink sink) {
        final String filenamef = stub.getBashCommandFilename();
        if (filenamef != null) {
            sink.occurrence(BashCommandNameIndex.KEY, filenamef);
        }
    }
}