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

package shardingsphere.workshop.parser.engine;

import org.junit.Test;
import shardingsphere.workshop.parser.statement.statement.InsertStatement;
import shardingsphere.workshop.parser.statement.statement.UseStatement;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public final class ParseEngineTest {

    @Test
    public void testParse() {
        String sql = "use sharding_db";
        UseStatement useStatement = (UseStatement) ParseEngine.parse(sql);
        assertThat(useStatement.getSchemeName().getIdentifier().getValue(), is("sharding_db"));
    }

    @Test
    public void testParseInsert() {
        String sql = "INSERT INTO `t_order` (`order_id`, `user_id`, `status`)\n" +
                "VALUE\n" +
                "\t(458220151033036800, 100, 'good');\n";
        InsertStatement insertStatement = (InsertStatement) ParseEngine.parse(sql);
        assertThat(insertStatement.getTableName().getIdentifier().getValue(), is("`t_order`"));
        assertThat(insertStatement.getColumnNames().get(0).getIdentifier().getValue(), is("`order_id`"));
        assertThat(insertStatement.getColumnNames().get(1).getIdentifier().getValue(), is("`user_id`"));
        assertThat(insertStatement.getColumnNames().get(2).getIdentifier().getValue(), is("`status`"));
        assertThat(insertStatement.getAssignmentValues().get(0).getIdentifier().getValue(), is("458220151033036800"));
        assertThat(insertStatement.getAssignmentValues().get(1).getIdentifier().getValue(), is("100"));
        assertThat(insertStatement.getAssignmentValues().get(2).getIdentifier().getValue(), is("'good'"));
    }
}
