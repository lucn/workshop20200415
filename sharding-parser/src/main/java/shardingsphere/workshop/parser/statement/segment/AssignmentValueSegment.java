
package shardingsphere.workshop.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;

/**
 * Assignment value segment.
 *
 * @author luxin60
 */
@RequiredArgsConstructor
@Getter
public final class AssignmentValueSegment implements ASTNode {

    private final IdentifierSegment identifier;
}
