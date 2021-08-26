package com.skx.epublib.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Span {
    private int curId = 0;
    private List<SpanNode> child = new ArrayList<>();
    private Map<String, SpanNode> titleMap = new HashMap<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SpanNode extends Span {
        private int id = 0;
        private String name;
        private int insert = 0;
    }

    public int addChapter(String title) {
        if (child == null) {
            child = new ArrayList<>();
        }
        if(titleMap.containsKey(title)) {
            return -1;
        }
        SpanNode newChapter = new SpanNode(10 * (curId + 1), title, 0);
        boolean isok = child.add(newChapter);
        if (!isok) {
            return -1;
        }
        else {
            titleMap.put(title, newChapter);
            return ++curId;
        }
    }

    public int addChapter(int ind, String title) throws IndexOutOfBoundsException {
        SpanNode spanNode = child.get(ind);

        return spanNode.addChapter(title);
    }

    public int addChapter(String parent, String title) throws IndexOutOfBoundsException {
        SpanNode spanNode = titleMap.get(parent);

        return spanNode.addChapter(title);
    }

    public boolean insertChapter(int ind, String title) throws IndexOutOfBoundsException {
        SpanNode spanNode = child.get(ind);

        if(titleMap.containsKey(title) || spanNode.getInsert() >= 9) {
            return false;
        }

        spanNode.setInsert(spanNode.getInsert() + 1);

        int iInd = spanNode.getId() + spanNode.getInsert();

        SpanNode newChapter = new SpanNode(iInd, title, 0);
        titleMap.put(title, newChapter);
        child.add(ind, newChapter);

        return true;
    }

}
