
package shardingsphere.workshop.parser.statement.statement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.AssignmentValueSegment;
import shardingsphere.workshop.parser.statement.segment.ColumnNameSegment;
import shardingsphere.workshop.parser.statement.segment.TableNameSegment;

import java.util.List;

/**
 * Insert statement.
 *
 * @author luxin60
 */
@RequiredArgsConstructor
@Getter
public final class InsertStatement implements ASTNode {

    private final TableNameSegment tableName;

    private final List<ColumnNameSegment> columnNames;

    private final List<AssignmentValueSegment> assignmentValues;
}
