/*
 * Copyright 2009 Joachim Ansorg, mail@ansorg-it.com
 * File: BashArithmeticCommand.java, Class: BashArithmeticCommand
 * Last modified: 2009-12-04
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

package com.ansorgit.plugins.bash.lang.psi.api.arithmetic;

import com.ansorgit.plugins.bash.lang.psi.api.BashPsiElement;

/**
 * Models an arithmetic expression.
 * An arithmetic expression contains zero or more arithmetic subexpressions.
 * These subexpressions can be assignments, variable changes, variable reads, comparisions, etc.
 * <p/>
 * User: jansorg
 * Date: 24.07.2009
 * Time: 22:18:47
 */
public interface BashArithmeticCommand extends BashPsiElement {
}