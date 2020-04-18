
package shardingsphere.workshop.parser.engine.visitor;

import autogen.MySQLStatementBaseVisitor;
import autogen.MySQLStatementParser;
import autogen.MySQLStatementParser.IdentifierContext;
import autogen.MySQLStatementParser.SchemaNameContext;
import autogen.MySQLStatementParser.UseContext;
import shardingsphere.workshop.parser.statement.ASTNode;
import shardingsphere.workshop.parser.statement.segment.*;
import shardingsphere.workshop.parser.statement.statement.InsertStatement;
import shardingsphere.workshop.parser.statement.statement.UseStatement;

import java.util.ArrayList;
import java.util.List;

/**
 * MySQL visitor.
 */
public final class SQLVisitor extends MySQLStatementBaseVisitor<ASTNode> {
    
    @Override
    public ASTNode visitUse(final UseContext ctx) {
        SchemeNameSegment schemeName = (SchemeNameSegment) visit(ctx.schemaName());
        return new UseStatement(schemeName);
    }
    
    @Override
    public ASTNode visitSchemaName(final SchemaNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new SchemeNameSegment(identifier);
    }
    
    @Override
    public ASTNode visitIdentifier(final IdentifierContext ctx) {
        return new IdentifierSegment(ctx.getText());
    }

    @Override
    public ASTNode visitInsert(MySQLStatementParser.InsertContext ctx) {
        TableNameSegment tableName = (TableNameSegment) visit(ctx.tableName());
        ColumnNamesSegment columnNamesSegment = (ColumnNamesSegment) visit(ctx.columnNames());
        AssignmentValuesSegment assignmentValuesSegment = (AssignmentValuesSegment) visit(ctx.assignmentValues());
        return new InsertStatement(tableName, columnNamesSegment.getColumnNames(), assignmentValuesSegment.getAssignmentValues());
    }

    @Override
    public ASTNode visitTableName(MySQLStatementParser.TableNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new TableNameSegment(identifier);
    }

    @Override
    public ASTNode visitColumnNames(MySQLStatementParser.ColumnNamesContext ctx) {
        List<ColumnNameSegment> columnNames = new ArrayList<>();
        for (MySQLStatementParser.ColumnNameContext ctxColumnName : ctx.columnName()) {
            ColumnNameSegment columnName = (ColumnNameSegment) visit(ctxColumnName);
            columnNames.add(columnName);
        }
        return new ColumnNamesSegment(columnNames);
    }

    @Override
    public ASTNode visitColumnName(MySQLStatementParser.ColumnNameContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new ColumnNameSegment(identifier);
    }

    @Override
    public ASTNode visitAssignmentValues(MySQLStatementParser.AssignmentValuesContext ctx) {
        List<AssignmentValueSegment> assignmentNames = new ArrayList<>();
        for (MySQLStatementParser.AssignmentValueContext ctxAssignmentValue : ctx.assignmentValue()) {
            AssignmentValueSegment assignmentName = (AssignmentValueSegment) visit(ctxAssignmentValue);
            assignmentNames.add(assignmentName);
        }
        return new AssignmentValuesSegment(assignmentNames);
    }

    @Override
    public ASTNode visitAssignmentValue(MySQLStatementParser.AssignmentValueContext ctx) {
        IdentifierSegment identifier = (IdentifierSegment) visit(ctx.identifier());
        return new AssignmentValueSegment(identifier);
    }
}
