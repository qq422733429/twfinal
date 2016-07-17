package com.tw.InputService;

import com.tw.entity.Item;
import com.tw.model.PayItem;
import com.tw.service.ItemService;
import com.tw.service.input.Inputs;
import com.tw.service.input.inputImplement.InputImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by qq422 on 2016/7/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InputTest.class)
public class InputTest {
    @Mock
    ItemService itemService;
    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }
    @Test
    public void testGenerateReceiptFromBarcodes() {
        String barcodes = "['ITEM000000','ITEM000000','ITEM000000','ITEM000000',"
                + "'ITEM000000','ITEM000001','ITEM000001', 'ITEM000004' ]";
        HashMap<String,Item> itemMap = new HashMap<>();
        itemMap.put("ITEM000000", new Item("ITEM000000", "可口可乐", "瓶", "", "", 3.00));
        itemMap.put("ITEM000001", new Item("ITEM000001", "雪碧", "瓶", "", "", 3.00));
        itemMap.put("ITEM000004", new Item("ITEM000004", "电池", "个", "", "", 2.00));
        Inputs inputs = new InputImpl();
        when(itemService.getItemMap()).thenReturn(itemMap);
        ((InputImpl)inputs).itemService = itemService;
        ArrayList<PayItem> result = inputs.getPayItems(barcodes);
        assertEquals(result.size(),3);
    }
}
