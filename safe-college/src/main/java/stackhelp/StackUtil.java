package stackhelp;

import java.util.ArrayList;
import java.util.List;

public class StackUtil {

    public static String getCallTrace(String basePackage, Throwable throwable) {

        List<StackTraceElement> stackList = new ArrayList<>();

        //1.获取所有栈元素，并把符合条件的栈元素添加到集合中
        StackTraceElement[] stElement = throwable.getStackTrace();
        for (StackTraceElement element : stElement) {
            if (element.getClassName().trim().startsWith(basePackage)) {
                stackList.add(element);
            }
        }

        //2.重组栈元素的打印格式
        StringBuilder callTraceString = new StringBuilder();
        int listSize = stackList.size();
        for (int i = 0; i < listSize; i++) {
            StackTraceElement element = stackList.get(i);
            callTraceString.append(element.getClassName()).append(".").append(element.getMethodName()).append("(").append(element.getLineNumber()).append(")");
            if ((i + 1) != listSize) {
                callTraceString.append(" <-- ");
            }
        }
        return callTraceString.toString();
    }
}
