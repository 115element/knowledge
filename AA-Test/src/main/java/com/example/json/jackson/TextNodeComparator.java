package com.example.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;

import java.util.Comparator;

/*
 * 在输入的 JSON 元素值不完全相同但我们仍希望将它们视为相等时，在比较两个 JSON 对象时使用自定义比较器对象非常有用。
 */
public class TextNodeComparator implements Comparator<JsonNode> {

    @Override
    public int compare(JsonNode o1, JsonNode o2) {
        if (o1.equals(o2)) {
            return 0;
        }
        if ((o1 instanceof TextNode) && (o2 instanceof TextNode)) {
            String s1 = ((TextNode) o1).asText();
            String s2 = ((TextNode) o2).asText();
            if (s1.equalsIgnoreCase(s2)) {
                return 0;
            }
        }
        return 1;
    }
}
