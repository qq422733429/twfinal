package com.tw.service.ouput.outputImpl;

import com.tw.model.OutputItem;
import com.tw.model.PromotedItem;
import com.tw.service.ouput.OutputEachItem;

import java.util.List;


public class OutputBuyTwoGiveOne implements OutputEachItem {
    public final int THREE = 3;

    /**
     * 根据不同的优惠方式，生成不同的输出，输出分为前半段和后半段
     *
     * @param promotedItems
     * @return OutputItem
     */
    @Override
    public OutputItem getEachItem(List<PromotedItem> promotedItems) {

        StringBuilder front = new StringBuilder();
        StringBuilder last = new StringBuilder();
        transferToStringBuilder(promotedItems, front, last);
        OutputItem outputItem = new OutputItem();
        outputItem.setFrontPart(front);
        outputItem.setLastPart(last);
        return outputItem;
    }

    private void transferToStringBuilder(List<PromotedItem> promotedItems, StringBuilder front, StringBuilder last) {
        if(promotedItems.size()!=0) {
            last.append("买二赠一商品：\n");
        }
        for (PromotedItem item : promotedItems) {
            front.append("名称："+item.getName()+"，");
            front.append("数量："+item.getCount()+item.getUnit()+"，");
            front.append("单价："+String.format("%.2f", item.getPrice())+"(元)，");
            front.append("小计："+String.format("%.2f", item.getSubtotal())+"(元)\n");
            last.append("名称："+item.getName()+"，数量："+item.getCount()/THREE+item.getUnit()+"\n");

        }
    }
}
