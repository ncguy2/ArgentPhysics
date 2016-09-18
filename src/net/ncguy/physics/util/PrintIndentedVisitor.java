package net.ncguy.physics.util;

/**
 * Created by Guy on 18/09/2016.
 */
public class PrintIndentedVisitor implements IVisitor {

    public final int indent;

    public PrintIndentedVisitor(int indent) {
        this.indent = indent;
    }

    @Override
    public IVisitor visit(IVisitable visitable) {
        return new PrintIndentedVisitor(indent + 2);
    }

    @Override
    public void visitData(IVisitable visitable, Object data) {
        for (int i = 0; i < indent; i++)
            System.out.print(" ");
        System.out.println(data.toString());
    }
}
