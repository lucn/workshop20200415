
package shardingsphere.workshop.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;

import java.util.List;

/**
 * column names segment.
 *
 * @author luxin60
 */
@RequiredArgsConstructor
@Getter
public final class ColumnNamesSegment implements ASTNode {

    private final List<ColumnNameSegment> columnNames;

}
