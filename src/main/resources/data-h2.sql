INSERT INTO ITEM (BARCODE, NAME, UNIT, CATEGORY, SUB_CATEGORY, PRICE) VALUES ('ITEM000001', '可口可乐', '瓶', '', '', 3.00);
INSERT INTO ITEM (BARCODE, NAME, UNIT, CATEGORY, SUB_CATEGORY, PRICE) VALUES ('ITEM000003', '羽毛球', '个', '', '', 1.00);
INSERT INTO ITEM (BARCODE, NAME, UNIT, CATEGORY, SUB_CATEGORY, PRICE) VALUES ('ITEM000005', '苹果', '斤', '', '', 5.50);


INSERT INTO PROMOTION (PROMOTIONNAME, BARCODES) VALUES ('BUY_TWO_GET_ONE_FREE', 'ITEM000001,ITEM000003');
INSERT INTO PROMOTION (PROMOTIONNAME, BARCODES) VALUES ('SELL_BY_95', 'ITEM000005');