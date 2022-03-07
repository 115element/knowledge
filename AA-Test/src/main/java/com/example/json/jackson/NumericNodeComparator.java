package com.example.json.jackson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NumericNode;

import java.util.Comparator;

/*
 * 在输入的 JSON 元素值不完全相同但我们仍希望将它们视为相等时，在比较两个 JSON 对象时使用自定义比较器对象非常有用。
 */
public class NumericNodeComparator implements Comparator<JsonNode> {
    @Override
    public int compare(JsonNode o1, JsonNode o2) {
        if (o1.equals(o2)) {
            return 0;
        }

        if ((o1 instanceof NumericNode) && (o2 instanceof NumericNode)) {
            Double d1 = o1.asDouble();
            Double d2 = o2.asDouble();
            if (d1.compareTo(d2) == 0) {
                return 0;
            }
        }

        return 1;
    }
}
