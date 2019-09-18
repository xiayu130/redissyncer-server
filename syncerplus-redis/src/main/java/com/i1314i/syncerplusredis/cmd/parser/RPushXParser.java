/*
 * Copyright 2016-2018 Leon Chen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.i1314i.syncerplusredis.cmd.parser;

import com.i1314i.syncerplusredis.cmd.CommandParser;
import com.i1314i.syncerplusredis.cmd.impl.RPushXCommand;

import static com.i1314i.syncerplusredis.cmd.CommandParsers.toBytes;

/**
 * @author Leon Chen
 * @version 2.1.1
 * @since 2.1.0
 */
public class RPushXParser implements CommandParser<RPushXCommand> {

    @Override
    public RPushXCommand parse(Object[] command) {
        int idx = 1, newIdx = 0;
        byte[] key = toBytes(command[idx]);
        idx++;
        byte[][] values = new byte[command.length - 2][];
        while (idx < command.length) {
            values[newIdx] = toBytes(command[idx]);
            newIdx++;
            idx++;
        }
        return new RPushXCommand(key, values);
    }

}