
package shardingsphere.workshop.parser.statement.segment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import shardingsphere.workshop.parser.statement.ASTNode;

import java.util.List;

/**
 * Assignment values segment.
 *
 * @author luxin60
 */
@RequiredArgsConstructor
@Getter
public final class AssignmentValuesSegment implements ASTNode {

    private final List<AssignmentValueSegment> assignmentValues;

}
