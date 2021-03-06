
package shardingsphere.workshop.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;

/**
 * Table name segment.
 *
 * @author luxin60
 */
@RequiredArgsConstructor
@Getter
public final class TableNameSegment implements ASTNode {

    private final IdentifierSegment identifier;
}
