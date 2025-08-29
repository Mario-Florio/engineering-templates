package shared.__utils__;

import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import core.entities.Document;
import core.entities.Response;

public class Console {
    private int nestDepth = 0;
    private final String TAB = "  ";

    public void log(Object obj) {

        if (obj instanceof List<?> list) parse(list);
        else if (obj instanceof Map<?, ?> map) parse(map);
        else if (obj instanceof Document doc) parse(doc);
        else if (obj instanceof Response res) parse(res);
        else System.out.println(obj);

    }
    private void parse(Object obj) {

        if (obj == null) printNull();
        else if (obj instanceof List<?> list) printList(list);
        else if (obj instanceof Map<?, ?> map) printMap(map);
        else if (obj instanceof Document doc) printDocument(doc);
        else if (obj instanceof Response res) printResponse(res);
        else System.out.print(obj);

    }
    private void printNull() {
        parse("null");
    }
    private void printList(List<?> list) {
        String indentation = getIndentation();

        System.out.println(" [");
        nestDepth++;

        list.stream().forEach(item -> {
            parse(item);
        });

        nestDepth--;
        System.out.println(indentation+"]");
    }
    private void printMap(Map<?, ?> map) {
        String indentation = getIndentation();

        System.out.println("{");
        nestDepth++;

        String innerIdent = getIndentation();

        map.entrySet().forEach(entry -> {
            parse(innerIdent+entry.getKey()+": ");
            parse(entry.getValue());
            parse(",\n");
        });

        nestDepth--;
        System.out.println(indentation+"}");

    }
    private void printDocument(Document doc) {
        String indentation = getIndentation();

        System.out.println(indentation+doc.getClass().getSimpleName()+" {");
        nestDepth++;

        String innerIndent = getIndentation();
        parse(innerIndent+"properties: ");
        parse(doc.getAll());

        nestDepth--;
        System.out.println(indentation+"},");
    }
    private void printResponse(Response<?> res) {
        String indentation = getIndentation();

        System.out.println(indentation+res.getClass().getSimpleName()+" {");
        nestDepth++;

        printFields(res);

        nestDepth--;
        System.out.println(indentation+"}");
    }
    private void printFields(Object instance) {
        String indentation = getIndentation();

        Field[] fields = instance.getClass().getFields();
        for (Field f : fields) {
            parse(indentation+f.getName()+": ");
            try {
                parse(f.get(instance));
                parse("\n");
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    private String getIndentation() {
        String indentation = "";
        for (int i = 0; i < nestDepth; i++) indentation += TAB;

        return indentation;
    }
}
