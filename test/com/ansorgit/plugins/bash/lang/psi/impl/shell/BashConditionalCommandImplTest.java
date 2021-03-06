/*
 * Copyright (c) Joachim Ansorg, mail@ansorg-it.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ansorgit.plugins.bash.lang.psi.impl.shell;

import com.ansorgit.plugins.bash.lang.psi.api.shell.BashConditionalCommand;
import com.intellij.psi.PsiElement;

public class BashConditionalCommandImplTest extends AbstractShellCommandTest {

    public void testConditionalCommandLeft() throws Exception {

        assertCommand();

    }

    public void testConditionalCommandRight() throws Exception {

        assertCommand();

    }

    private void assertCommand() throws Exception {
        PsiElement command = configureCommand();
        BashConditionalCommand conditionalCommand = (BashConditionalCommandImpl) command.getParent();

        String commandText = conditionalCommand.getCommandText();

        assertEquals(" -z \"$var\" -a -n \"$var2\" ", commandText);
    }

}